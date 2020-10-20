package dk.sds.maternity.saml.auth;

import dk.itst.oiosaml.sp.service.DispatcherServlet;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

@WebListener
public class SPFilterRegistrator implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        final ServletContext servletContext = sce.getServletContext();
        ServletRegistration servletRegistration = servletContext.addServlet("SAMLDispatcherServlet", DispatcherServlet.class);
        servletRegistration.addMapping("/saml/*");
        FilterRegistration.Dynamic filterRegistration = servletContext.addFilter("LoginFilter", CustomSPFilter.class);
        filterRegistration.addMappingForUrlPatterns(null, false, "/*");
        filterRegistration.addMappingForUrlPatterns(null, false, "/saml/*");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
