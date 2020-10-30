package dk.sds.nsp.maternity.data.spring;

import dk.sds.nsp.maternity.data.appointment.service.AppointmentService;
import dk.sds.nsp.maternity.data.appointment.service.AppointmentServiceStub;
import dk.sds.nsp.maternity.data.care_plan.service.CarePlanService;
import dk.sds.nsp.maternity.data.care_plan.service.CarePlanServiceStub;
import dk.sds.nsp.maternity.data.data_card.service.DataCardService;
import dk.sds.nsp.maternity.data.data_card.service.DataCardServiceStub;
import dk.sds.nsp.maternity.data.note.service.NoteService;
import dk.sds.nsp.maternity.data.note.service.NoteServiceStub;
import dk.sds.nsp.maternity.data.observation.service.ObservationService;
import dk.sds.nsp.maternity.data.observation.service.ObservationServiceStub;
import dk.sds.nsp.maternity.facade.common.spring.CommonConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CommonConfiguration.class)
public class StubDataConfiguration {

    @Bean
    public AppointmentService appointmentService(){
        return new AppointmentServiceStub();
    }

    @Bean
    public DataCardService dataCardService(){
        return new DataCardServiceStub();
    }

    @Bean
    public CarePlanService carePlanService(AppointmentService appointmentService){
        return new CarePlanServiceStub(appointmentService);
    }

    @Bean
    public NoteService noteService(){
        return new NoteServiceStub();
    }

    @Bean
    public ObservationService observationService(){
        return new ObservationServiceStub();
    }
}
