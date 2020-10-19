package dk.sds.nsp.maternity.feedback.spring;

import dk.sds.nsp.maternity.facade.common.spring.CommonConfiguration;
import dk.sds.nsp.maternity.feedback.service.FeedbackService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class StubSpringContext implements ServletContextListener {
    protected static final String ANNOTATION_CONFIG_CONTEXT = "ANNOTATION_CONFIG_APPLICATION_CONTEXT";

    /**
     * Initialize standalone spring context. Registers the spring configuration and finally register it at the servlet context
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        AnnotationConfigApplicationContext springContext = new AnnotationConfigApplicationContext();
        springContext.register(StubFeedbackConfiguration.class);
        springContext.refresh();
        final ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute(ANNOTATION_CONFIG_CONTEXT, springContext);

        DependencyResolver.feedbackService = springContext.getBean(FeedbackService.class);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        Object ctx = servletContextEvent.getServletContext().getAttribute(ANNOTATION_CONFIG_CONTEXT);
        if (ctx instanceof AnnotationConfigApplicationContext) {
            ((AnnotationConfigApplicationContext) ctx).close();
        }
    }
}
