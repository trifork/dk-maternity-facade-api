package dk.sds.maternity.saml.auth.restresources;

import dk.itst.oiosaml.sp.UserAssertion;
import dk.itst.oiosaml.sp.UserAssertionHolder;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("usercontext")
@Produces(MediaType.APPLICATION_JSON)
public class UserContext {
    private static final Logger LOGGER = Logger.getLogger(UserContext.class);
    @GET
    public Response getSessionDetails(@Context HttpServletRequest request){
        final UserAssertion userAssertion = UserAssertionHolder.get();

        if(userAssertion == null) return Response.ok().build();

        dk.sds.maternity.saml.auth.model.UserContext userContext = new dk.sds.maternity.saml.auth.model.UserContext()
            .setCommonName(userAssertion.getCommonName())
            .setOrganizationName(userAssertion.getOrganizationName())
            .setEligibleRoles(null);
        LOGGER.debug(userContext);
        return Response.ok().entity(userContext).build();
    }
}
