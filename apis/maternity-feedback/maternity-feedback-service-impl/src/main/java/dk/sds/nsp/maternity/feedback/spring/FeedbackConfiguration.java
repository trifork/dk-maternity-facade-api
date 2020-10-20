package dk.sds.nsp.maternity.feedback.spring;

import dk.sds.nsp.maternity.facade.common.spring.CommonConfiguration;
import dk.sds.nsp.maternity.feedback.service.FeedbackService;
import dk.sds.nsp.maternity.feedback.service.FeedbackServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CommonConfiguration.class)
public class FeedbackConfiguration {

    @Bean
    public FeedbackService feedbackService(){
        return new FeedbackServiceImpl();
    }
}
