package dk.sds.maternity.saml.auth.restresources;

import dk.itst.oiosaml.sp.UserAssertion;
import dk.itst.oiosaml.sp.UserAssertionHolder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("session")
@Produces(MediaType.APPLICATION_JSON)
public class Session {

    @GET
    public Response getSessionDetails(){
        final UserAssertion userAssertion = UserAssertionHolder.get();
        if(userAssertion == null) return Response.status(Response.Status.UNAUTHORIZED).build();
        return Response.ok().entity(userAssertion).build();
    }
}
