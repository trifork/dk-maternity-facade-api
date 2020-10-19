package dk.sds.nsp.maternity.feedback.api;

import dk.sds.nsp.maternity.facade.common.jaxrs.RequestContext;
import dk.sds.nsp.maternity.feedback.model.Feedback;
import dk.sds.nsp.maternity.feedback.model.FeedbackResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.UUID;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class FeedbackService {



    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDataCard(
            final Feedback feedback) {
        final FeedbackResponse response = new FeedbackResponse().id(UUID.randomUUID()).rating(feedback.getRating()).comment(feedback.getComment());
        return Response
                .created(getLocation(response))
                .entity(response)
                .build();
    }

    private static URI getLocation(final FeedbackResponse created) {
        return URI.create(RequestContext.get().getUriInfo().getAbsolutePath() + "/" + created.getId().toString());
    }
}
