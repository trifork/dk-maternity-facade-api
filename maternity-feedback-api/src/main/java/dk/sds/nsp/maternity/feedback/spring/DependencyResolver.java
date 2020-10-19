package dk.sds.nsp.maternity.feedback.spring;

import dk.sds.nsp.maternity.feedback.service.FeedbackService;

public final class DependencyResolver {
    static FeedbackService feedbackService;

    public static FeedbackService getFeedbackService() {
        return feedbackService;
    }

    private DependencyResolver(){}
}
