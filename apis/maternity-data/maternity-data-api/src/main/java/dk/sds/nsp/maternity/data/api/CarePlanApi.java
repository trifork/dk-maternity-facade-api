package dk.sds.nsp.maternity.data.api;

import dk.sds.nsp.maternity.data.care_plan.model.CarePlan;
import dk.sds.nsp.maternity.data.care_plan.model.EditableCarePlan;
import dk.sds.nsp.maternity.data.care_plan.service.CarePlanService;
import dk.sds.nsp.maternity.data.exceptions.DataBlockedException;
import dk.sds.nsp.maternity.data.exceptions.MergeConflictException;
import dk.sds.nsp.maternity.data.exceptions.ResourceNotFoundException;
import dk.sds.nsp.maternity.data.security.ApplicationContext;
import dk.sds.nsp.maternity.data.spring.DependencyResolver;
import dk.sds.nsp.maternity.facade.common.jaxrs.PATCH;
import dk.sds.nsp.maternity.facade.common.jaxrs.RequestContext;
import dk.sds.nsp.maternity.facade.common.model.ProblemDetails;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;
import java.util.UUID;

import static dk.sds.nsp.maternity.facade.common.util.Problems.typeFor;
import static javax.ws.rs.core.Response.Status.*;

@Path("/care-plan")
@Produces(MediaType.APPLICATION_JSON)
public class CarePlanApi {

    private static final Logger LOGGER = Logger.getLogger(CarePlanApi.class);
    private final CarePlanService service = DependencyResolver.carePlanService();

    @GET
    public Response listCarePlansForPatient(
            @Context HttpServletRequest httpServletRequest,
            @CookieParam("context") final ApplicationContext context,
            @HeaderParam("X-Break-The-Glass-Reason") final String xBreakTheGlassReason,
            @HeaderParam("X-Chosen-Role") final String xChosenRole
    ) {
        final boolean breakTheGlass = false;
        final HttpSession session = httpServletRequest.getSession();
        final String patientIdentifier = session != null ? (String) session.getAttribute("cpr") : "1234567890";
        try {
            final List<CarePlan> response = service.list(patientIdentifier, breakTheGlass);
            return Response.ok(response)
                    .build();
        } catch (ResourceNotFoundException e) {
            String errorId = UUID.randomUUID().toString();
            LOGGER.warn(String.format("ERROR_ID=%s Failed to find the care-plan for the patient", errorId), e);
            return Response.status(NOT_FOUND)
                    .entity(
                            new ProblemDetails()
                                    .notFound()
                                    .title("Forløbet kunne ikke findes")
                                    .detail(String.format("Vi kunne ikke finde et forløb for den valgte patient. Fejl-id'et er '%s'", errorId))
                                    .type(typeFor("not-found.html"))
                    )
                    .build();
        } catch (DataBlockedException e) {
            String errorId = UUID.randomUUID().toString();
            LOGGER.info(String.format("ERROR_ID=%s Could not fetch care-plan because patient has blocked data", errorId), e);
            return Response.status(FORBIDDEN)
                    .entity(
                            new ProblemDetails()
                                    .notFound()
                                    .title("Patienten har spærret adgang til data")
                                    .detail(String.format("Patienten har spærret for adgang til alt eller dele af forløbets data. Fejl-id'et er '%s'", errorId))
                                    .type(typeFor("some-data-was-blocked.html"))
                    )
                    .build();
        } catch (Exception e) {
            return internalError("unexpected error when reading care plans for patient", e);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCarePlan(
            @CookieParam("context") final ApplicationContext context,
            @HeaderParam("X-Chosen-Role") final String xChosenRole,
            final EditableCarePlan request
    ) {
        try {
            final CarePlan response = service.create(request);
            return Response.created(getLocation(response))
                    .entity(response)
                    .build();

        } catch (Exception e) {
            return internalError("Failed to create a care plan", e);
        }
    }

    @GET
    @Path("/{identifier}")
    public Response getCarePlan(
            @CookieParam("context") final ApplicationContext context,
            @PathParam("identifier") final String id,
            @HeaderParam("X-Chosen-Role") final String xChosenRole
    ) {
        try {
            final CarePlan result = service.get(id);
            return Response.ok(result)
                    .build();
        } catch (ResourceNotFoundException e) {
            return notFound(id, e);
        } catch (DataBlockedException e) {
            return blocked(id, e);
        } catch (Exception e) {
            return internalError("Failed to read care plan by id " + id, e);
        }
    }

    @PUT
    @Path("/{identifier}")
    public Response update(
            @CookieParam("context") final ApplicationContext context,
            @PathParam("identifier") final String id,
            @HeaderParam("X-Chosen-Role") final String xChosenRole,
            final EditableCarePlan request
    ) {
        try {
            CarePlan result = service.update(id, request);
            return Response.ok(result)
                    .build();
        } catch (ResourceNotFoundException e) {
            return notFound(id, e);
        } catch (MergeConflictException e) {
            return conflict(id, e);
        } catch (DataBlockedException e) {
            return blocked(id, e);
        } catch (Exception e) {
            return internalError("Could not update care plan with id " + id, e);
        }
    }
    @PATCH
    @Path("/{identifier}/extend")
    public Response extend(
            @CookieParam("context") final ApplicationContext context,
            @PathParam("identifier") final String id,
            @HeaderParam("X-Chosen-Role") final String xChosenRole,
            final EditableCarePlan request
    ) {
        try {
            CarePlan result = service.extend(id, request);
            return Response.ok(result)
                    .build();
        } catch (ResourceNotFoundException e) {
            return notFound(id, e);
        } catch (MergeConflictException e) {
            return conflict(id, e);
        } catch (DataBlockedException e) {
            return blocked(id, e);
        } catch (Exception e) {
            return internalError("Could not update care plan with id " + id, e);
        }
    }

    @GET
    @Path("/template")
    public Response getTemplate(
    @Context HttpServletRequest httpServletRequest,
    @CookieParam("context") final ApplicationContext context
    ) {
        final HttpSession session = httpServletRequest.getSession();
        final String patientIdentifier = session != null ? (String) session.getAttribute("cpr") : "1234567890";
        return Response.ok(service.getTemplate(patientIdentifier))
                .build();
    }



    private static URI getLocation(final CarePlan created) {
        return URI.create(RequestContext.get().getUriInfo().getAbsolutePath() + "/" + created.getId());
    }

    private static Response internalError(String log, Throwable e) {
        String errorId = UUID.randomUUID().toString();
        LOGGER.error(String.format("ERROR_ID=%s %s", errorId, log), e);
        return Response.status(INTERNAL_SERVER_ERROR)
                .entity(
                        new ProblemDetails()
                                .internalServerError()
                                .title("Noget gik galt")
                                .detail(String.format("Der skete desværre en fejl. Fejl-id'et er '%s'", errorId))
                                .type(typeFor("unknown-error.html"))
                )
                .build();
    }

    private static Response notFound(String id, Throwable e) {
        String errorId = UUID.randomUUID().toString();
        LOGGER.warn(String.format("ERROR_ID=%s no care plan with id '%s' exists", errorId, id), e);
        return Response.status(NOT_FOUND)
                .entity(
                        new ProblemDetails()
                                .notFound()
                                .title("Forløbet kunne ikke findes")
                                .detail(String.format("Vi kunne ikke finde et forløb for den valgte patient. Fejl-id'et er '%s'", errorId))
                                .type(typeFor("not-found.html"))
                )
                .build();
    }

    private static Response blocked(String id, Throwable e) {
        String errorId = UUID.randomUUID().toString();
        LOGGER.info(String.format("ERROR_ID=%s Could not fetch care-plan with id '%s' because patient has blocked data", errorId, id), e);
        return Response.status(FORBIDDEN)
                .entity(
                        new ProblemDetails()
                                .forbidden()
                                .title("Patienten har spærret adgang til data")
                                .detail(String.format("Patienten har spærret for adgang til alt eller dele af forløbets data. Fejl-id'et er '%s'", errorId))
                                .type(typeFor("some-data-was-blocked.html"))
                )
                .build();
    }

    private static Response conflict(String id, Throwable e) {
        String errorId = UUID.randomUUID().toString();
        LOGGER.info(String.format("ERROR_ID=%s Could not modify care-plan with id '%s' because of a merge conflict", errorId, id), e);
        return Response.status(CONFLICT)
                .entity(
                        new ProblemDetails()
                                .conflict()
                                .title("Andre har ændret data")
                                .detail(String.format("En anden har ændret data i forløbet samtidig med dig. Fejl-id'et er '%s'", errorId))
                                .type(typeFor("conflict-error.html"))
                )
                .build();
    }

}
