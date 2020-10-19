package dk.sds.nsp.maternity.feedback.api;

import dk.sds.nsp.maternity.facade.common.jaxrs.RequestContext;
import dk.sds.nsp.maternity.feedback.model.Feedback;
import dk.sds.nsp.maternity.feedback.model.FeedbackResponse;
import dk.sds.nsp.maternity.feedback.service.FeedbackService;
import dk.sds.nsp.maternity.feedback.spring.DependencyResolver;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class FeedbackApi {

    private final FeedbackService service;

    public FeedbackApi() {
        service = DependencyResolver.getFeedbackService();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDataCard(
            final Feedback feedback) {

        final FeedbackResponse response = service.create(feedback);
        return Response
                .created(getLocation(response))
                .entity(response)
                .build();
    }

    private static URI getLocation(final FeedbackResponse created) {
        return URI.create(RequestContext.get().getUriInfo().getAbsolutePath() + "/" + created.getId().toString());
    }
}
