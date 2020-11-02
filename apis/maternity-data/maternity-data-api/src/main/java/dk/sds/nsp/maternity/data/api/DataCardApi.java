package dk.sds.nsp.maternity.data.api;

import dk.sds.nsp.maternity.data.data_card.model.CreateDataCardRequest;
import dk.sds.nsp.maternity.data.data_card.model.DataCardResponse;
import dk.sds.nsp.maternity.data.data_card.model.UpdateDataCardRequest;
import dk.sds.nsp.maternity.data.data_card.service.DataCardService;
import dk.sds.nsp.maternity.data.data_card.service.DataCardService.ServiceResponse;
import dk.sds.nsp.maternity.data.security.ApplicationContext;
import dk.sds.nsp.maternity.data.spring.DependencyResolver;
import dk.sds.nsp.maternity.facade.common.jaxrs.RequestContext;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;
import java.util.UUID;

import static dk.sds.nsp.maternity.data.utils.PatientContext.extractPatientIdentifierFromSession;
import static javax.ws.rs.core.Response.Status.PARTIAL_CONTENT;

@Path("/data-card")
@Produces(MediaType.APPLICATION_JSON)
public class DataCardApi {

    private static final Logger LOGGER = Logger.getLogger(DataCardApi.class);
    private final DataCardService service = DependencyResolver.dataCardService();

    @GET
    public Response getDataCards(
            @Context HttpServletRequest httpServletRequest,
            @CookieParam("context") final ApplicationContext context,
            @HeaderParam("X-Break-The-Glass-Reason") final String xBreakTheGlassReason,
            @HeaderParam("X-Chosen-Role") final String xChosenRole) {

        final boolean breakTheGlass = false;
        final String patientIdentifier = extractPatientIdentifierFromSession(httpServletRequest);

        final ServiceResponse<List<DataCardResponse>> response = service.get(patientIdentifier, breakTheGlass);
        final List<DataCardResponse> entity = response.getEntity();

        if (response.isPartial()) return Response.status(PARTIAL_CONTENT).entity(entity).build();
        if (response.isOk()) return Response.ok().entity(entity).build();

        return null;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDataCard(
            @CookieParam("context") final ApplicationContext context,
            @HeaderParam("X-Chosen-Role") final String xPatientIdentifier,
            final CreateDataCardRequest request) {
        final ServiceResponse<DataCardResponse> response = service.create(request);
        final DataCardResponse entity = response.getEntity();

        if(response.isOk()) return Response.created(getLocation(entity)).entity(entity).build();

        return null;
    }

    @GET
    @Path("{identifier}")
    public Response getDataCard(
            @CookieParam("context") final ApplicationContext context,
            @HeaderParam("X-Chosen-Role") final String xPatientIdentifier,
            @PathParam("identifier") final UUID id) {
        final ServiceResponse<DataCardResponse> response = service.get(id);
        final DataCardResponse entity = response.getEntity();

        if(response.isOk()) return Response.ok().entity(entity).build();

        return null;
    }

    @PUT
    @Path("{identifier}")
    public Response updateDataCard(
            @CookieParam("context") final ApplicationContext context,
            @PathParam("identifier") final UUID id,
            @HeaderParam("X-Chosen-Role") final String xChosenRole,
            final UpdateDataCardRequest request) {
        final ServiceResponse<DataCardResponse> response = service.update(id, request);
        final DataCardResponse entity = response.getEntity();

        if(response.isOk()) return Response.ok().entity(entity).build();

        return null;
    }

    @DELETE
    @Path("{identifier}")
    public Response deleteDataCard(
            @CookieParam("context") final ApplicationContext context,
            @PathParam("identifier") final UUID id,
            @HeaderParam("X-Chosen-Role") final String xChosenRole) {
        final ServiceResponse<Void> response = service.delete(id);

        if(response.isOk()) return Response.ok().build();

        return null;
    }

    private static URI getLocation(final DataCardResponse created) {
        return URI.create(RequestContext.get().getUriInfo().getAbsolutePath() + "/" + created.getEpisodeOfCareIdentifier().toString());
    }

}
