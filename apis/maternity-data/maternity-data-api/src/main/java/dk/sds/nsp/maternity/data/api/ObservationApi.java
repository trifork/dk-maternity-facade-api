package dk.sds.nsp.maternity.data.api;

import dk.sds.nsp.maternity.data.exceptions.DataBlockedException;
import dk.sds.nsp.maternity.data.exceptions.MergeConflictException;
import dk.sds.nsp.maternity.data.exceptions.ResourceNotFoundException;
import dk.sds.nsp.maternity.data.observation.model.CreateObservation;
import dk.sds.nsp.maternity.data.observation.model.EditableObservation;
import dk.sds.nsp.maternity.data.observation.model.Observation;
import dk.sds.nsp.maternity.data.observation.service.ObservationService;
import dk.sds.nsp.maternity.data.security.ApplicationContext;
import dk.sds.nsp.maternity.data.spring.DependencyResolver;
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

import static dk.sds.nsp.maternity.data.utils.PatientContext.extractPatientIdentifierFromSession;
import static dk.sds.nsp.maternity.facade.common.util.Problems.typeFor;
import static javax.ws.rs.core.Response.Status.*;

@Path("/observation")
@Produces(MediaType.APPLICATION_JSON)
public class ObservationApi {

    private static final Logger LOGGER = Logger.getLogger(ObservationApi.class);
    private final ObservationService service = DependencyResolver.observationService();

    @GET
    public Response listObservationsForPatient(
            @Context HttpServletRequest httpServletRequest,
            @CookieParam("context") final ApplicationContext context,
            @HeaderParam("X-Break-The-Glass-Reason") final String xBreakTheGlassReason,
            @HeaderParam("X-Chosen-Role") final String xChosenRole
    ) {
        final boolean breakTheGlass = false;

        try {
            final String patientIdentifier = extractPatientIdentifierFromSession(httpServletRequest);
            final List<Observation> response = service.list(patientIdentifier, breakTheGlass);
            return Response.ok(response)
                    .build();
        } catch (ResourceNotFoundException e) {
            String errorId = UUID.randomUUID().toString();
            LOGGER.warn(String.format("ERROR_ID=%s Failed to find observations for the patient", errorId), e);
            return Response.status(NOT_FOUND)
                    .entity(
                            new ProblemDetails()
                                    .notFound()
                                    .title("Den valgte patient findes ikke")
                                    .detail(String.format("Vi kunne ikke finde den valgte patient. Fejl-id'et er '%s'", errorId))
                                    .type(typeFor("not-found.html"))
                    )
                    .build();
        } catch (DataBlockedException e) {
            String errorId = UUID.randomUUID().toString();
            LOGGER.info(String.format("ERROR_ID=%s Could not fetch observations because patient has blocked data", errorId), e);
            return Response.status(FORBIDDEN)
                    .entity(
                            new ProblemDetails()
                                    .notFound()
                                    .title("Patienten har spærret adgang til data")
                                    .detail(String.format("Patienten har spærret for adgang til alle eller dele af målingerne. Fejl-id'et er '%s'", errorId))
                                    .type(typeFor("some-data-was-blocked.html"))
                    )
                    .build();
        } catch (Exception e) {
            return internalError("unexpected error when reading observations for patient", e);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createObservation(
            @Context HttpServletRequest httpServletRequest,
            @CookieParam("context") final ApplicationContext context,
            @HeaderParam("X-Chosen-Role") final String xChosenRole,
            final CreateObservation request
    ) {
        try {
            final HttpSession session = httpServletRequest.getSession();
            final String patientIdentifier = session != null ? (String) session.getAttribute("cpr") : "1234567890";
            final Observation response = service.create(patientIdentifier, request);
            return Response.created(getLocation(response))
                    .entity(response)
                    .build();

        } catch (Exception e) {
            return internalError("Failed to create a observation", e);
        }
    }

    @GET
    @Path("/{identifier}")
    public Response getObservation(
            @CookieParam("context") final ApplicationContext context,
            @PathParam("identifier") final String id,
            @HeaderParam("X-Chosen-Role") final String xChosenRole
    ) {
        try {
            final Observation result = service.get(id);
            return Response.ok(result)
                    .build();
        } catch (ResourceNotFoundException e) {
            return notFound(id, e);
        } catch (DataBlockedException e) {
            return blocked(id, e);
        } catch (Exception e) {
            return internalError("Failed to read observation by id " + id, e);
        }
    }

    @PUT
    @Path("/{identifier}")
    public Response update(
            @CookieParam("context") final ApplicationContext context,
            @PathParam("identifier") final String id,
            @HeaderParam("X-Chosen-Role") final String xChosenRole,
            final EditableObservation request
    ) {
        try {
            Observation result = service.update(id, request);
            return Response.ok(result)
                    .build();
        } catch (ResourceNotFoundException e) {
            return notFound(id, e);
        } catch (MergeConflictException e) {
            return conflict(id, e);
        } catch (DataBlockedException e) {
            return blocked(id, e);
        } catch (Exception e) {
            return internalError("Could not update observation with id " + id, e);
        }
    }

    @GET
    @Path("/types")
    public Response getTemplate(@CookieParam("context") final ApplicationContext context) {
        return Response.ok(service.getTypes())
                .build();
    }

    private static URI getLocation(final Observation created) {
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
                                .title("Målingen kunne ikke findes")
                                .detail(String.format("Vi kunne ikke finde en måling for den valgte patient. Fejl-id'et er '%s'", errorId))
                                .type(typeFor("not-found.html"))
                )
                .build();
    }

    private static Response blocked(String id, Throwable e) {
        String errorId = UUID.randomUUID().toString();
        LOGGER.info(String.format("ERROR_ID=%s Could not fetch observation with id '%s' because patient has blocked data", errorId, id), e);
        return Response.status(FORBIDDEN)
                .entity(
                        new ProblemDetails()
                                .forbidden()
                                .title("Patienten har spærret adgang til data")
                                .detail(String.format("Patienten har spærret for adgang til målingen. Fejl-id'et er '%s'", errorId))
                                .type(typeFor("some-data-was-blocked.html"))
                )
                .build();
    }

    private static Response conflict(String id, Throwable e) {
        String errorId = UUID.randomUUID().toString();
        LOGGER.info(String.format("ERROR_ID=%s Could not modify observation with id '%s' because of a merge conflict", errorId, id), e);
        return Response.status(CONFLICT)
                .entity(
                        new ProblemDetails()
                                .conflict()
                                .title("Andre har ændret data")
                                .detail(String.format("En anden har ændret målingen samtidig med dig. Fejl-id'et er '%s'", errorId))
                                .type(typeFor("conflict-error.html"))
                )
                .build();
    }

}
