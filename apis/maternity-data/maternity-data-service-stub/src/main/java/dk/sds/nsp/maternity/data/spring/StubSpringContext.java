package dk.sds.nsp.maternity.data.spring;

import dk.sds.nsp.maternity.data.appointment.service.AppointmentService;
import dk.sds.nsp.maternity.data.care_plan.service.CarePlanService;
import dk.sds.nsp.maternity.data.data_card.service.DataCardService;
import dk.sds.nsp.maternity.data.note.service.NoteService;
import dk.sds.nsp.maternity.data.observation.service.ObservationService;
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
        springContext.register(StubDataConfiguration.class);
        springContext.refresh();
        final ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute(ANNOTATION_CONFIG_CONTEXT, springContext);
        DependencyResolver.appointmentService = springContext.getBean(AppointmentService.class);
        DependencyResolver.dataCardService = springContext.getBean(DataCardService.class);
        DependencyResolver.carePlanService = springContext.getBean(CarePlanService.class);
        DependencyResolver.noteService = springContext.getBean(NoteService.class);
        DependencyResolver.observationService = springContext.getBean(ObservationService.class);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        Object ctx = servletContextEvent.getServletContext().getAttribute(ANNOTATION_CONFIG_CONTEXT);
        if (ctx instanceof AnnotationConfigApplicationContext) {
            ((AnnotationConfigApplicationContext) ctx).close();
        }
    }
}
