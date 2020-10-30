package dk.sds.nsp.maternity.data.api;

import dk.sds.nsp.maternity.data.appointment.service.AppointmentService;
import dk.sds.nsp.maternity.data.care_plan.model.Activity;
import dk.sds.nsp.maternity.data.care_plan.model.EditableActivity;
import dk.sds.nsp.maternity.data.exceptions.DataBlockedException;
import dk.sds.nsp.maternity.data.exceptions.MergeConflictException;
import dk.sds.nsp.maternity.data.exceptions.ResourceNotFoundException;
import dk.sds.nsp.maternity.data.security.SessionContext;
import dk.sds.nsp.maternity.data.spring.DependencyResolver;
import dk.sds.nsp.maternity.facade.common.jaxrs.RequestContext;
import dk.sds.nsp.maternity.facade.common.model.ProblemDetails;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;
import java.util.UUID;

import static dk.sds.nsp.maternity.facade.common.util.Problems.typeFor;
import static javax.ws.rs.core.Response.Status.*;

@Path("/appointment")
@Produces(MediaType.APPLICATION_JSON)
public class AppointmentApi {

    private static final Logger LOGGER = Logger.getLogger(AppointmentApi.class);
    private final AppointmentService service = DependencyResolver.appointmentService();

    @GET
    public Response listAppointmentsForPatient(
            @CookieParam("context") final SessionContext context,
            @HeaderParam("X-Patient-Identifier") final String xPatientIdentifier,
            @HeaderParam("X-Break-The-Glass-Reason") final String xBreakTheGlassReason
    ) {
        final String patientIdentifier = xPatientIdentifier != null ? xPatientIdentifier : context.getPatientIdentifier();
        final boolean breakTheGlass = false;

        try {
            final List<Activity> response = service.list(patientIdentifier, breakTheGlass);
            return Response.ok(response)
                    .build();
        } catch (ResourceNotFoundException e) {
            String errorId = UUID.randomUUID().toString();
            LOGGER.warn(String.format("ERROR_ID=%s Failed to find appointments for the patient", errorId), e);
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
            LOGGER.info(String.format("ERROR_ID=%s Could not fetch appointments because patient has blocked data", errorId), e);
            return Response.status(FORBIDDEN)
                    .entity(
                            new ProblemDetails()
                                    .notFound()
                                    .title("Patienten har spærret adgang til data")
                                    .detail(String.format("Patienten har spærret for adgang til alle eller dele af aftalerne. Fejl-id'et er '%s'", errorId))
                                    .type(typeFor("some-data-was-blocked.html"))
                    )
                    .build();
        } catch (Exception e) {
            return internalError("unexpected error when reading appointments for patient", e);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createAppointment(
            @CookieParam("context") final SessionContext context,
            @HeaderParam("X-Patient-Identifier") final String xPatientIdentifier,
            final EditableActivity request
    ) {
        final String patientIdentifier = xPatientIdentifier != null ? xPatientIdentifier : context.getPatientIdentifier();
        try {
            final Activity response = service.create(patientIdentifier, request);
            return Response.created(getLocation(response))
                    .entity(response)
                    .build();

        } catch (Exception e) {
            return internalError("Failed to create a appointment", e);
        }
    }

    @GET
    @Path("/{identifier}")
    public Response getAppointment(
            @CookieParam("context") final SessionContext context,
            @PathParam("identifier") final String id
    ) {
        try {
            final Activity result = service.get(id);
            return Response.ok(result)
                    .build();
        } catch (ResourceNotFoundException e) {
            return notFound(id, e);
        } catch (DataBlockedException e) {
            return blocked(id, e);
        } catch (Exception e) {
            return internalError("Failed to read appointment by id " + id, e);
        }
    }

    @PUT
    @Path("/{identifier}")
    public Response update(
            @CookieParam("context") final SessionContext context,
            @PathParam("identifier") final String id,
            final EditableActivity request
    ) {
        try {
            Activity result = service.update(id, request);
            return Response.ok(result)
                    .build();
        } catch (ResourceNotFoundException e) {
            return notFound(id, e);
        } catch (MergeConflictException e) {
            return conflict(id, e);
        } catch (DataBlockedException e) {
            return blocked(id, e);
        } catch (Exception e) {
            return internalError("Could not update appointment with id " + id, e);
        }
    }

    private static URI getLocation(final Activity created) {
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
        LOGGER.warn(String.format("ERROR_ID=%s appointment plan with id '%s' exists", errorId, id), e);
        return Response.status(NOT_FOUND)
                .entity(
                        new ProblemDetails()
                                .notFound()
                                .title("Aftalen kunne ikke findes")
                                .detail(String.format("Vi kunne ikke finde en aftale for den valgte patient. Fejl-id'et er '%s'", errorId))
                                .type(typeFor("not-found.html"))
                )
                .build();
    }

    private static Response blocked(String id, Throwable e) {
        String errorId = UUID.randomUUID().toString();
        LOGGER.info(String.format("ERROR_ID=%s Could not fetch appointment with id '%s' because patient has blocked data", errorId, id), e);
        return Response.status(FORBIDDEN)
                .entity(
                        new ProblemDetails()
                                .forbidden()
                                .title("Patienten har spærret adgang til data")
                                .detail(String.format("Patienten har spærret for adgang til aftalen. Fejl-id'et er '%s'", errorId))
                                .type(typeFor("some-data-was-blocked.html"))
                )
                .build();
    }

    private static Response conflict(String id, Throwable e) {
        String errorId = UUID.randomUUID().toString();
        LOGGER.info(String.format("ERROR_ID=%s Could not modify appointment with id '%s' because of a merge conflict", errorId, id), e);
        return Response.status(CONFLICT)
                .entity(
                        new ProblemDetails()
                                .conflict()
                                .title("Andre har ændret data")
                                .detail(String.format("En anden har ændret aftalen samtidig med dig. Fejl-id'et er '%s'", errorId))
                                .type(typeFor("conflict-error.html"))
                )
                .build();
    }

}
