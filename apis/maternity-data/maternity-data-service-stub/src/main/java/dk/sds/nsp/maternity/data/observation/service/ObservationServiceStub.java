package dk.sds.nsp.maternity.data.observation.service;

import dk.sds.nsp.maternity.data.exceptions.DataBlockedException;
import dk.sds.nsp.maternity.data.exceptions.MergeConflictException;
import dk.sds.nsp.maternity.data.exceptions.ResourceNotFoundException;
import dk.sds.nsp.maternity.data.observation.model.CreateObservation;
import dk.sds.nsp.maternity.data.observation.model.EditableObservation;
import dk.sds.nsp.maternity.data.observation.model.Observation;
import dk.sds.nsp.maternity.data.observation.model.ObservationType;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import java.util.*;

public class ObservationServiceStub implements ObservationService {
    MultivaluedMap<String, Observation> database = new MultivaluedHashMap<>();

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
        database.putSingle(patientIdentifier, observation);

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
    public List<ObservationType> getTypes() {
        return Arrays.asList(ObservationType.values());
    }
}
