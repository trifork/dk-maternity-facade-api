package dk.sds.nsp.maternity.data.observation.service;

import dk.sds.nsp.maternity.data.exceptions.DataBlockedException;
import dk.sds.nsp.maternity.data.exceptions.MergeConflictException;
import dk.sds.nsp.maternity.data.exceptions.ResourceNotFoundException;
import dk.sds.nsp.maternity.data.observation.model.CreateObservation;
import dk.sds.nsp.maternity.data.observation.model.EditableObservation;
import dk.sds.nsp.maternity.data.observation.model.Observation;
import dk.sds.nsp.maternity.data.observation.model.ObservationType;

import java.util.List;

public interface ObservationService {
    List<Observation> list(final String patientIdentifier, final boolean breakTheGlass) throws ResourceNotFoundException, DataBlockedException;
    Observation get(final String id) throws ResourceNotFoundException, DataBlockedException;
    Observation create(String patientIdentifier, final CreateObservation request);
    Observation update(final String id, final EditableObservation request) throws ResourceNotFoundException, DataBlockedException, MergeConflictException;
    List<CreateObservation> getTypes();
}
