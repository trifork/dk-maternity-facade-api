package dk.sds.nsp.maternity.data.appointment.service;

import dk.sds.nsp.maternity.data.care_plan.model.Activity;
import dk.sds.nsp.maternity.data.care_plan.model.EditableActivity;
import dk.sds.nsp.maternity.data.exceptions.DataBlockedException;
import dk.sds.nsp.maternity.data.exceptions.MergeConflictException;
import dk.sds.nsp.maternity.data.exceptions.ResourceNotFoundException;

import java.util.List;

public interface AppointmentService {
    List<Activity> list(final String patientIdentifier, final boolean breakTheGlass) throws ResourceNotFoundException, DataBlockedException;
    Activity get(final String id) throws ResourceNotFoundException, DataBlockedException;
    Activity create(String patientIdentifier, final EditableActivity request);
    Activity update(final String id, final EditableActivity request) throws ResourceNotFoundException, DataBlockedException, MergeConflictException;
}
