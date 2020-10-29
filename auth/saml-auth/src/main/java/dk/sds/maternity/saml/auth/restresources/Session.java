package dk.sds.maternity.saml.auth.restresources;

import dk.itst.oiosaml.sp.UserAssertion;
import dk.itst.oiosaml.sp.UserAssertionHolder;
import dk.sds.maternity.saml.auth.model.UserContext;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("session")
@Produces(MediaType.APPLICATION_JSON)
public class Session {
    private static final Logger LOGGER = Logger.getLogger(Session.class);
    @GET
    public Response getSessionDetails(@Context HttpServletRequest request){
        final UserAssertion userAssertion = UserAssertionHolder.get();

        if(userAssertion == null) return Response.ok().build();

        UserContext userContext = new UserContext()
            .setCommonName(userAssertion.getCommonName())
            .setOrganizationName(userAssertion.getOrganizationName())
            .setRole(userAssertion.getTitle());
        LOGGER.debug(userContext);
        return Response.ok().entity(userContext).build();
    }
}
