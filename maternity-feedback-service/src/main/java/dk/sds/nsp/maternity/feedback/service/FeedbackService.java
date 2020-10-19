package dk.sds.nsp.maternity.feedback.service;

import dk.sds.nsp.maternity.feedback.model.Feedback;
import dk.sds.nsp.maternity.feedback.model.FeedbackResponse;

public interface FeedbackService {
    FeedbackResponse create (Feedback feedback);
}
