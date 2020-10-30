package dk.sds.nsp.maternity.data.observation.service;

import dk.sds.nsp.maternity.data.exceptions.DataBlockedException;
import dk.sds.nsp.maternity.data.exceptions.MergeConflictException;
import dk.sds.nsp.maternity.data.exceptions.ResourceNotFoundException;
import dk.sds.nsp.maternity.data.observation.model.*;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import java.util.*;

public class ObservationServiceStub implements ObservationService {
    MultivaluedMap<String, Observation> database = new MultivaluedHashMap<>();

    public ObservationServiceStub() {
        database.put("9949653695", Arrays.asList(
            randomObservation(ObservationType.WEIGHT, Collections.singletonList(new EditableObservationValues().unit("kg").value("65"))),
            randomObservation(ObservationType.BLOOD_PREASSURE, Arrays.asList(
                    new EditableObservationValues().name("Systolisk")
                            .value("120")
                            .unit("mm Hg"),
                    new EditableObservationValues().name("Diastolisk")
                            .value("75")
                            .unit("mm Hg")
            )),
            randomObservation(ObservationType.URINE, Collections.singletonList(new EditableObservationValues().unit("A+")))
        ));
    }

    @Override
    public List<Observation> list(String patientIdentifier, boolean breakTheGlass) throws ResourceNotFoundException, DataBlockedException {
        if (!database.containsKey(patientIdentifier)) {
            return Collections.emptyList();
        }
        return database.get(patientIdentifier);
    }

    @Override
    public Observation get(String id) throws ResourceNotFoundException, DataBlockedException {
        return database.values().stream()
                .flatMap(List::stream)
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("No such observation exists"));
    }

    @Override
    public Observation create(String patientIdentifier, CreateObservation request) {
        Observation observation = new Observation()
                .id(UUID.randomUUID().toString());
        observation.completed(request.isCompleted())
                .dateOfMeasurement(request.getDateOfMeasurement())
                .enteredBy(request.getEnteredBy())
                .measuredBy(request.getMeasuredBy())
                .values(request.getValues());
        observation.type(request.getType());
        database.add(patientIdentifier, observation);

        return observation;
    }

    @Override
    public Observation update(String id, EditableObservation request) throws ResourceNotFoundException, DataBlockedException, MergeConflictException {
        Observation toUpdate = get(id);
        toUpdate.completed(request.isCompleted())
                .dateOfMeasurement(request.getDateOfMeasurement())
                .enteredBy(request.getEnteredBy())
                .measuredBy(request.getMeasuredBy())
                .values(request.getValues());
        return toUpdate;
    }

    @Override
    public List<CreateObservation> getTypes() {
        return Arrays.asList(
                ObservationTemplates.EDEMA,
                ObservationTemplates.AMNIOTIC_FLUID,
                ObservationTemplates.BLOOD_PREASSURE,
                ObservationTemplates.FETUS_ACTIVITY,
                ObservationTemplates.FETUS_WEIGHT_ESTIMATE,
                ObservationTemplates.FETUS_PRESENTATION,
                ObservationTemplates.FLOW,
                ObservationTemplates.GA_U_D,
                ObservationTemplates.PUBIS_MEASURUEMENTS,
                ObservationTemplates.URINE,
                ObservationTemplates.WEIGHT,
                ObservationTemplates.WEIGHT_DEVIATION
        );
    }

    private static Observation randomObservation(ObservationType type, List<EditableObservationValues> values) {
        Observation result = new Observation().id(UUID.randomUUID().toString());
        result.type(type)
                .values(values)
                .measuredBy("Borger selv")
                .enteredBy("Gutte U. Danielsen")
                .completed(true)
                .dateOfMeasurement(new Date());
        return result;
    }
}
