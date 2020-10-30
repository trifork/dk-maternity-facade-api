package dk.sds.nsp.maternity.data.care_plan.service;

import dk.sds.nsp.maternity.data.appointment.service.AppointmentService;
import dk.sds.nsp.maternity.data.exceptions.DataBlockedException;
import dk.sds.nsp.maternity.data.exceptions.MergeConflictException;
import dk.sds.nsp.maternity.data.exceptions.ResourceNotFoundException;
import dk.sds.nsp.maternity.data.care_plan.model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CarePlanServiceStub implements CarePlanService {
    private AppointmentService appointmentService;
    List<CarePlan> database = new ArrayList();

    public CarePlanServiceStub(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
        create(getTemplate("9949653695"));// Put some test-data in db to get us started :-)
    }

    @Override
    public List<CarePlan> list(String patientIdentifier, boolean breakTheGlass) throws ResourceNotFoundException, DataBlockedException {
        return database.stream()
                .filter(x -> x.getPatient().equals(patientIdentifier))
                .map(x -> {
                    try {
                        List<Activity> activities = appointmentService.list(x.getPatient(), breakTheGlass);
                        return x.withActivities(activities);
                    } catch (Exception ignored) { }
                    return x;
                })
                .collect(Collectors.toList());
    }

    @Override
    public CarePlan get(String id) throws ResourceNotFoundException, DataBlockedException {
        if ("blocked".equals(id)) {
            throw new DataBlockedException("Patient has blocked data");
        }
        CarePlan carePlan = database.stream()
                .filter( x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Care plan with id " + id + " does not exist"));
        carePlan.withActivities(appointmentService.list(carePlan.getPatient(), false));
        return carePlan;
    }

    @Override
    public CarePlan create(EditableCarePlan request) {
        CarePlan result = new CarePlan()
                .id(UUID.randomUUID().toString())
                .version(new BigDecimal(1))
                .description(request.getDescription())
                .patient(request.getPatient())
                .title(request.getTitle())
                .responsibleOrganization(request.getResponsibleOrganization());

        request.getActivities().stream()
                .map(x -> new Activity()
                        .id(UUID.randomUUID().toString())
                        .code(x.getCode())
                        .title(x.getTitle())
                        .description(x.getDescription())
                        .gestationWeek(x.getGestationWeek())
                        .kind(x.getKind())
                        .plannedTime(x.getPlannedTime())
                        .practitioner(x.getPractitioner())
                        .location(x.getLocation())
                        .status(x.getStatus())
                ).forEach( x -> appointmentService.create(request.getPatient(), x)
        );


        database.add(result);

        return result;
    }

    @Override
    public CarePlan update(String id, EditableCarePlan request) throws ResourceNotFoundException, DataBlockedException, MergeConflictException {
        CarePlan toUpdate = get(id);
        toUpdate.id(UUID.randomUUID().toString())
                .version(toUpdate.getVersion().add(new BigDecimal(1)))
                .description(request.getDescription())
                .patient(request.getPatient())
                .title(request.getTitle())
                .responsibleOrganization(request.getResponsibleOrganization());

        return toUpdate;
    }

    @Override
    public CarePlan extend(String id, EditableCarePlan request) throws ResourceNotFoundException, DataBlockedException, MergeConflictException {
        CarePlan toUpdate = get(id);
        request.getActivities()
                .forEach(x -> appointmentService.create(toUpdate.getPatient(), x));
        return toUpdate;
    }

    @Override
    public EditableCarePlan getTemplate(String patientIdentifier) {
        return new EditableCarePlan()
                .description("Sample description")
                .patient(patientIdentifier)
                .title("Sample title")
                .responsibleOrganization(
                        new ResponsibleOrganization()
                            .id("some-organization-id")
                            .source("SOR")
                )
                .activities(Arrays.asList(
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
                                                .code("burth")
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
                ));
    }
}
