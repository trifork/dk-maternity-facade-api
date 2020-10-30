package dk.sds.nsp.maternity.data.note.service;

import dk.sds.nsp.maternity.data.exceptions.DataBlockedException;
import dk.sds.nsp.maternity.data.exceptions.MergeConflictException;
import dk.sds.nsp.maternity.data.exceptions.ResourceNotFoundException;
import dk.sds.nsp.maternity.data.note.model.EditableNote;
import dk.sds.nsp.maternity.data.note.model.Note;

import java.util.List;

public interface NoteService {
    List<Note> list(final String patientIdentifier, final boolean breakTheGlass) throws ResourceNotFoundException, DataBlockedException;
    Note get(final String id) throws ResourceNotFoundException, DataBlockedException;
    Note create(final String patientIdentifier, String author, final EditableNote request);
    Note update(final String id, String author, final EditableNote request) throws ResourceNotFoundException, DataBlockedException, MergeConflictException;
}
