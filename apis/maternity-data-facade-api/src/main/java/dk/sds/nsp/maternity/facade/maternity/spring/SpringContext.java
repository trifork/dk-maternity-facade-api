package dk.sds.nsp.maternity.facade.maternity.spring;

import com.auth0.jwt.algorithms.Algorithm;
import dk.sds.nsp.maternity.facade.common.security.JWTHelper;
import dk.sds.nsp.maternity.facade.maternity.security.SessionContextJWTHelper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
        springContext.register(MaternityDataConfiguration.class);
        springContext.refresh();
        final ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute(ANNOTATION_CONFIG_CONTEXT, springContext);

        final Algorithm algorithm = springContext.getBean(Algorithm.class, SessionContextQualifier.class);
        jwtHelper = new SessionContextJWTHelper(algorithm);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        Object ctx = servletContextEvent.getServletContext().getAttribute(ANNOTATION_CONFIG_CONTEXT);
        if (ctx instanceof AnnotationConfigApplicationContext) {
            ((AnnotationConfigApplicationContext) ctx).close();
        }
    }

    private static JWTHelper jwtHelper;
    public static JWTHelper contextJwtHelper() { return jwtHelper; }

}