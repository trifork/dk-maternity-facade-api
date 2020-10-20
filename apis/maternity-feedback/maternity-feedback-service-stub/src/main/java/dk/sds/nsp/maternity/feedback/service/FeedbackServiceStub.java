package dk.sds.nsp.maternity.feedback.service;

import dk.sds.nsp.maternity.feedback.model.Feedback;
import dk.sds.nsp.maternity.feedback.model.FeedbackResponse;

import java.util.UUID;

public class FeedbackServiceStub implements FeedbackService {

    @Override
    public FeedbackResponse create(final Feedback feedback) {
        return new FeedbackResponse().id(UUID.randomUUID()).rating(feedback.getRating()).comment(feedback.getComment());
    }
}
