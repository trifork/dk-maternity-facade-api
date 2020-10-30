package dk.sds.nsp.maternity.data.appointment.service;

import dk.sds.nsp.maternity.data.exceptions.DataBlockedException;
import dk.sds.nsp.maternity.data.exceptions.MergeConflictException;
import dk.sds.nsp.maternity.data.exceptions.ResourceNotFoundException;
import dk.sds.nsp.maternity.data.appointment.model.*;
import dk.sds.nsp.maternity.data.appointment.service.AppointmentService;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import java.util.*;

public class AppointmentServiceStub implements AppointmentService {
    MultivaluedMap<String, Appointment> database = new MultivaluedHashMap<>();

    public AppointmentServiceStub() {
        EditableAppointment nonExactMeeting = baseAppointment(120, 8, "Andet møde");
        nonExactMeeting.getPeriod().setType(AppointmentPeriod.TypeEnum.GUIDE);

        EditableAppointment openEndedMeeting = baseAppointment(120, 35, "Fællesspisning");
        openEndedMeeting.getPeriod().setEnd(null);

        EditableAppointment interval = baseAppointment(440, 60, "Måske noget med ultralyd?");
        interval.getPeriod().setType(AppointmentPeriod.TypeEnum.INTERVAL);

        EditableAppointment repeated = baseAppointment(120, 100, "Checkup hver 2. måned")
                .repeated(true);

        create("9949653695", baseAppointment(30, 0, "Første Møde"));
        create("9949653695", nonExactMeeting);
        create("9949653695", openEndedMeeting);
        create("9949653695", interval);
        create("9949653695", repeated);
    }

    @Override
    public List<Appointment> list(String patientIdentifier, boolean breakTheGlass) throws ResourceNotFoundException, DataBlockedException {
        if (!database.containsKey(patientIdentifier)) {
            return Collections.emptyList();
        }
        return database.get(patientIdentifier);
    }

    @Override
    public Appointment get(String id) throws ResourceNotFoundException, DataBlockedException {
        return database.values().stream()
                .flatMap(List::stream)
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("No such appointment exists"));
    }

    @Override
    public Appointment create(String patientIdentifier, EditableAppointment request) {
        Appointment appointment = new Appointment()
                .id(UUID.randomUUID().toString());
       appointment.location(request.getLocation())
               .performer(request.getPerformer())
               .reason(request.getReason())
               .title(request.getTitle())
               .period(request.getPeriod())
               .repeated(request.isRepeated())
               .responsible(request.getResponsible());
        database.add(patientIdentifier, appointment);

        return appointment;
    }

    @Override
    public Appointment update(String id, EditableAppointment request) throws ResourceNotFoundException, DataBlockedException, MergeConflictException {
        Appointment toUpdate = get(id);
        toUpdate.location(request.getLocation())
                .performer(request.getPerformer())
                .reason(request.getReason())
                .title(request.getTitle())
                .period(request.getPeriod())
                .responsible(request.getResponsible());
        return toUpdate;
    }


    private static EditableAppointment baseAppointment(int lengthInMinutes, int daysFromNow, String title) {
        AppointmentLocation theOffice = new AppointmentLocation()
                .address(
                        new AppointmentLocationAddress()
                                .city("Aarhus C")
                                .postalCode("8000")
                                .street("Europaplads 2")
                )
                .description("Praktiserende læges kontor")
                .name("Kontoret")
                .phone("+4574537295");

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, daysFromNow);
        Date startDate = calendar.getTime();
        calendar.add(Calendar.MINUTE, lengthInMinutes);
        Date endDate = calendar.getTime();

        EditableAppointment result = new EditableAppointment()
                .title(title)
                .reason("Vi skal lige snakke om noget")
                .period(
                        new AppointmentPeriod()
                                .start(startDate)
                                .end(endDate)
                                .type(AppointmentPeriod.TypeEnum.FIXED)
                )
                .repeated(false)
                .location(theOffice)
                .responsible(
                        new AppointmentResponsible()
                            .id("some-id")
                            .name("Hank the Tank")
                            .type(AppointmentResponsible.TypeEnum.PRACTITIONER)
                )
                .performer(
                        new AppointmentPerformer()
                                .id("some-id")
                                .name("Hank the Tank")
                                .type(AppointmentPerformer.TypeEnum.PRACTITIONER)
                );
        return result;
    }
}
