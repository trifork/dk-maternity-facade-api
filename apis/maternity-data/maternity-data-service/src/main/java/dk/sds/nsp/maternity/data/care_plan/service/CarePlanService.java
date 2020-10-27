package dk.sds.nsp.maternity.data.care_plan.service;

import dk.sds.nsp.maternity.data.care_plan.exceptions.DataBlockedException;
import dk.sds.nsp.maternity.data.care_plan.exceptions.MergeConflictException;
import dk.sds.nsp.maternity.data.care_plan.exceptions.ResourceNotFoundException;
import dk.sds.nsp.maternity.data.care_plan.model.CarePlan;
import dk.sds.nsp.maternity.data.care_plan.model.EditableActivity;
import dk.sds.nsp.maternity.data.care_plan.model.EditableCarePlan;
import dk.sds.nsp.maternity.data.data_card.model.CreateDataCardRequest;
import dk.sds.nsp.maternity.data.data_card.model.DataCardResponse;
import dk.sds.nsp.maternity.data.data_card.model.UpdateDataCardRequest;

import java.util.List;
import java.util.UUID;

public interface CarePlanService {
    List<CarePlan> list(final String patientIdentifier, final boolean breakTheGlass) throws ResourceNotFoundException, DataBlockedException;
    CarePlan get(final String id) throws ResourceNotFoundException, DataBlockedException;
    CarePlan create(final EditableCarePlan request);
    CarePlan update(final String id, final EditableCarePlan request) throws ResourceNotFoundException, DataBlockedException, MergeConflictException;
    CarePlan extend(final String id, final EditableCarePlan request) throws ResourceNotFoundException, DataBlockedException, MergeConflictException;
    EditableCarePlan getTemplate(final String patientIdentifier);
}
