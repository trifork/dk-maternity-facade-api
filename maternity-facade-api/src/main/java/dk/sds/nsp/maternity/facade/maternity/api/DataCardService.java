package dk.sds.nsp.maternity.facade.maternity.api;

import dk.sds.nsp.maternity.facade.common.security.SessionContext;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("data-card")
@Produces(MediaType.APPLICATION_JSON)
public class DataCardService {

    @GET
    public Response getDataCards(@CookieParam("context") final SessionContext context) {
        return Response.ok().entity(context).build();
    }

    @GET
    @Path("{identifier}")
    public Response getDataCard(@PathParam("identifier") UUID id) {
        return Response.ok().entity("identifier = " + id).build();
    }
}