package dk.sds.nsp.maternity.feedback.api;

import dk.sds.nsp.maternity.cfg.SlaLogger;
import dk.sds.nsp.maternity.facade.common.jaxrs.RequestContext;
import dk.sds.nsp.maternity.feedback.model.Feedback;
import dk.sds.nsp.maternity.feedback.model.FeedbackResponse;
import dk.sds.nsp.maternity.feedback.service.FeedbackService;
import dk.sds.nsp.maternity.feedback.spring.DependencyResolver;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class FeedbackApi {

    private final FeedbackService service;
    private final SlaLogger slalogger;
    private static final Logger LOGGER = Logger.getLogger(FeedbackApi.class);

    public FeedbackApi() {
        service = DependencyResolver.getFeedbackService();
        slalogger = new SlaLogger("FeedbackAPI_PostFeedback");
    }

    @Context private HttpServletRequest httpServletRequest;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createFeedback(
            final Feedback feedback) {

        Long startTimeNano = System.nanoTime();
        Long startTimeMillis = System.currentTimeMillis();
        try{
            final FeedbackResponse response = service.create(feedback);
            slalogger.addSlaLog(httpServletRequest, startTimeNano, startTimeMillis, null);
            return Response
                    .created(getLocation(response))
                    .entity(response)
                    .build();

        } catch (Exception e) {
            LOGGER.error("Could not post feedback", e);
            slalogger.addSlaLog(httpServletRequest, startTimeNano, startTimeMillis, e.getMessage());
            return Response.status(HttpStatus.SC_BAD_GATEWAY).build();
        }
    }

    private static URI getLocation(final FeedbackResponse created) {
        return URI.create(RequestContext.get().getUriInfo().getAbsolutePath() + "/" + created.getId().toString());
    }
}
