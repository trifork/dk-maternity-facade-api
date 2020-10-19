package dk.sds.nsp.maternity.cfg;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ConfigurationInitializer implements ServletContextListener {

    /**
     * Initialize standalone spring context. Registers the spring configuration and finally register it at the servlet context
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        new Log4JConfigurator().configure();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }

}