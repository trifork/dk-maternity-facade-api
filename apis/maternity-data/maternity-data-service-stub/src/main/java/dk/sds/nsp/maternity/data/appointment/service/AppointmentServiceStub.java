package dk.sds.nsp.maternity.data.appointment.service;

import dk.sds.nsp.maternity.data.care_plan.model.*;
import dk.sds.nsp.maternity.data.exceptions.DataBlockedException;
import dk.sds.nsp.maternity.data.exceptions.MergeConflictException;
import dk.sds.nsp.maternity.data.exceptions.ResourceNotFoundException;
import dk.sds.nsp.maternity.data.appointment.service.AppointmentService;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import java.util.*;

public class AppointmentServiceStub implements AppointmentService {
    MultivaluedMap<String, Activity> database = new MultivaluedHashMap<>();

    public AppointmentServiceStub() {
        Arrays.asList(
                new EditableActivity()
                        .code(
                                new Code()
                                        .code("screening")
                                        .codeSystem("http://whatever.fhir.com")
                                        .display("First Screening")
                        )
                        .title("Some screening or whatever")
                        .description("We'll just look around and stuff. Listen I'm not qualified for this")
                        .gestationWeek("11+1")
                        .kind("Some kind")
                        .practitioner(
                                new Practitioner()
                                        .email("practitioner@totally-a-legit-hospital.com")
                                        .firstName("Hank the")
                                        .lastName("Tank")
                                        .healthCareActorsIdentification("547296382")
                                        .organizationName("Some Awesome Organization")
                                        .phone("+4588888888")
                        )
                        .location(
                                new Location()
                                        .organizationName("Some Awesome Organization")
                                        .email("whatever@none-of-your-business.com")
                                        .healthCareActorsIdentification("1234567890")
                        )
                        .status(EditableActivity.StatusEnum.EXPECTED),
                new EditableActivity()
                        .code(
                                new Code()
                                        .code("birth")
                                        .codeSystem("http://whatever.fhir.com")
                                        .display("Literally give birth")
                        )
                        .title("Birth")
                        .description("That baby-thingy needs to get out now - we'll take care of it")
                        .gestationWeek("42+6")
                        .kind("Some other kind")
                        .practitioner(
                                new Practitioner()
                                        .email("practitioner@totally-a-legit-hospital.com")
                                        .firstName("Kurt the")
                                        .lastName("Bird")
                                        .healthCareActorsIdentification("547296382")
                                        .organizationName("Some Awesome Organization")
                                        .phone("+4588888888")
                        )
                        .location(
                                new Location()
                                        .organizationName("Some Awesome Organization")
                                        .email("whatever@none-of-your-business.com")
                                        .healthCareActorsIdentification("1234567890")
                        )
                        .status(EditableActivity.StatusEnum.EXPECTED)
        ).forEach( x-> create("9949653695", x));
    }

    @Override
    public List<Activity> list(String patientIdentifier, boolean breakTheGlass) throws ResourceNotFoundException, DataBlockedException {
        if (!database.containsKey(patientIdentifier)) {
            return Collections.emptyList();
        }
        return database.get(patientIdentifier);
    }

    @Override
    public Activity get(String id) throws ResourceNotFoundException, DataBlockedException {
        return database.values().stream()
                .flatMap(List::stream)
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("No such activity exists"));
    }

    @Override
    public Activity create(String patientIdentifier, EditableActivity request) {
        Activity activity = new Activity()
                .id(UUID.randomUUID().toString());
       activity.code(request.getCode())
               .description(request.getDescription())
               .gestationWeek(request.getGestationWeek())
               .kind(request.getKind())
               .reference(request.getReference())
               .goal(request.getGoal())
               .status(request.getStatus())
               .location(request.getLocation())
               .plannedTime(request.getPlannedTime())
               .practitioner(request.getPractitioner())
               .title(request.getTitle());
        database.add(patientIdentifier, activity);

        return activity;
    }

    @Override
    public Activity update(String id, EditableActivity request) throws ResourceNotFoundException, DataBlockedException, MergeConflictException {
        Activity toUpdate = get(id);
        toUpdate.code(request.getCode())
                .description(request.getDescription())
                .gestationWeek(request.getGestationWeek())
                .kind(request.getKind())
                .reference(request.getReference())
                .goal(request.getGoal())
                .status(request.getStatus())
                .location(request.getLocation())
                .plannedTime(request.getPlannedTime())
                .practitioner(request.getPractitioner())
                .title(request.getTitle());
        return toUpdate;
    }
}
