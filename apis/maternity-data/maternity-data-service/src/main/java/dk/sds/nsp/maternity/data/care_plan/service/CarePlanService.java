package dk.sds.nsp.maternity.data.care_plan.service;

import dk.sds.nsp.maternity.data.exceptions.DataBlockedException;
import dk.sds.nsp.maternity.data.exceptions.MergeConflictException;
import dk.sds.nsp.maternity.data.exceptions.ResourceNotFoundException;
import dk.sds.nsp.maternity.data.care_plan.model.CarePlan;
import dk.sds.nsp.maternity.data.care_plan.model.EditableCarePlan;

import java.util.List;

public interface CarePlanService {
    List<CarePlan> list(final String patientIdentifier, final boolean breakTheGlass) throws ResourceNotFoundException, DataBlockedException;
    CarePlan get(final String id) throws ResourceNotFoundException, DataBlockedException;
    CarePlan create(final EditableCarePlan request);
    CarePlan update(final String id, final EditableCarePlan request) throws ResourceNotFoundException, DataBlockedException, MergeConflictException;
    CarePlan extend(final String id, final EditableCarePlan request) throws ResourceNotFoundException, DataBlockedException, MergeConflictException;
    EditableCarePlan getTemplate(final String patientIdentifier);
}
