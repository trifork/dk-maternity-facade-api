package dk.sds.nsp.maternity.cfg;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Initializes configurations
 */
@WebListener
public class ConfigurationInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        new Log4JConfigurator().configure();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }

}