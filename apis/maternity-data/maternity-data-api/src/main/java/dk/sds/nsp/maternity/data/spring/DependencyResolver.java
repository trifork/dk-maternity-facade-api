package dk.sds.nsp.maternity.data.spring;

import dk.sds.nsp.maternity.data.appointment.service.AppointmentService;
import dk.sds.nsp.maternity.data.care_plan.service.CarePlanService;
import dk.sds.nsp.maternity.data.data_card.service.DataCardService;
import dk.sds.nsp.maternity.data.note.service.NoteService;
import dk.sds.nsp.maternity.data.observation.service.ObservationService;

public final class DependencyResolver {
    static AppointmentService appointmentService;
    static DataCardService dataCardService;
    static CarePlanService carePlanService;
    static NoteService noteService;
    static ObservationService observationService;

    public static AppointmentService appointmentService() {
        return appointmentService;
    }

    public static DataCardService dataCardService() {
        return dataCardService;
    }

    public static CarePlanService carePlanService() {
        return carePlanService;
    }

    public static NoteService noteService() {
        return noteService;
    }

    public static ObservationService observationService() {
        return observationService;
    }

    private DependencyResolver(){}
}
