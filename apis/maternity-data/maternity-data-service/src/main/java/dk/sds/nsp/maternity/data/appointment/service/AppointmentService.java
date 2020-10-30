package dk.sds.nsp.maternity.data.appointment.service;

import dk.sds.nsp.maternity.data.appointment.model.Appointment;
import dk.sds.nsp.maternity.data.appointment.model.EditableAppointment;
import dk.sds.nsp.maternity.data.exceptions.DataBlockedException;
import dk.sds.nsp.maternity.data.exceptions.MergeConflictException;
import dk.sds.nsp.maternity.data.exceptions.ResourceNotFoundException;

import java.util.List;

public interface AppointmentService {
    List<Appointment> list(final String patientIdentifier, final boolean breakTheGlass) throws ResourceNotFoundException, DataBlockedException;
    Appointment get(final String id) throws ResourceNotFoundException, DataBlockedException;
    Appointment create(String patientIdentifier, final EditableAppointment request);
    Appointment update(final String id, final EditableAppointment request) throws ResourceNotFoundException, DataBlockedException, MergeConflictException;
}
