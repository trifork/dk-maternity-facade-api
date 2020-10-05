package dk.sds.nsp.maternity.facade.maternity.api;

import dk.sds.nsp.maternity.facade.common.security.SessionContext;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

import static dk.sds.nsp.maternity.facade.maternity.security.SecurityHandler.updateContextCookie;

@Path("data-card")
@Produces(MediaType.APPLICATION_JSON)
public class DataCardService {

    @GET
    public Response getDataCards(
            @CookieParam("context") final SessionContext context,
            @HeaderParam("X-Patient-Identifier") final String patientIdentifier,
            @HeaderParam("X-Break-The-Glass-Reason") final String breakTheGlassReason) {
        return Response
                .ok()
                .entity(context)
                .cookie(updateContextCookie(context))
                .build();
    }

    @GET
    @Path("{identifier}")
    public Response getDataCard(
            @CookieParam("context") final SessionContext context,
            @PathParam("identifier") final UUID id) {
        return Response
                .ok()
                .entity("identifier = " + id)
                .cookie(updateContextCookie(context))
                .build();
    }
}