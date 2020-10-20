package dk.sds.nsp.maternity.facade.common.spring;

import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import dk.sds.nsp.maternity.facade.common.jaxrs.SlaLoggingFilter;
import dk.sds.nsp.maternity.facade.common.security.JWTHelper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class SpringContext implements ServletContextListener {
    protected static final String ANNOTATION_CONFIG_CONTEXT = "ANNOTATION_CONFIG_APPLICATION_CONTEXT";

    /**
     * Initialize standalone spring context. Registers the spring configuration and finally register it at the servlet context
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        AnnotationConfigApplicationContext springContext = new AnnotationConfigApplicationContext();
        springContext.register(CommonConfiguration.class);
        springContext.refresh();
        final ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute(ANNOTATION_CONFIG_CONTEXT, springContext);
        Dynamic filterRegistration = servletContext.addFilter("SlaLogFilter", SlaLoggingFilter.class);
        filterRegistration.addMappingForUrlPatterns(null, false, "/*");
        final Algorithm algorithm = springContext.getBean(Algorithm.class);
        jwtHelper = new JWTHelper(algorithm);
        objectMapper = springContext.getBean(ObjectMapper.class);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        Object ctx = servletContextEvent.getServletContext().getAttribute(ANNOTATION_CONFIG_CONTEXT);
        if (ctx instanceof AnnotationConfigApplicationContext) {
            ((AnnotationConfigApplicationContext) ctx).close();
        }
    }

    private static JWTHelper jwtHelper;
    public static JWTHelper jwtHelper() { return jwtHelper; }

    private static ObjectMapper objectMapper;
    public static ObjectMapper objectMapper() { return objectMapper; }

}
