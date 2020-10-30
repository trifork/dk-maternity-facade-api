package dk.sds.nsp.maternity.data.note.service;

import dk.sds.nsp.maternity.data.exceptions.DataBlockedException;
import dk.sds.nsp.maternity.data.exceptions.MergeConflictException;
import dk.sds.nsp.maternity.data.exceptions.ResourceNotFoundException;
import dk.sds.nsp.maternity.data.note.model.EditableNote;
import dk.sds.nsp.maternity.data.note.model.Note;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class NoteServiceStub implements NoteService{
    MultivaluedMap<String, Note> database = new MultivaluedHashMap<>();

    public NoteServiceStub() {
        create("9949653695", "Hank The Tank", new EditableNote().date(new Date()).title("Møde om ting").content("Vi havde et godt møde om alting og sådan. Meget spændende."));
    }

    @Override
    public List<Note> list(String patientIdentifier, boolean breakTheGlass) throws ResourceNotFoundException, DataBlockedException {
        if (!database.containsKey(patientIdentifier)) {
            return Collections.emptyList();
        }
        return database.get(patientIdentifier);
    }

    @Override
    public Note get(String id) throws ResourceNotFoundException, DataBlockedException {
        return database.values().stream()
                .flatMap(List::stream)
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("No such note exists"));
    }

    @Override
    public Note create(String patientIdentifier, String author, EditableNote request) {
        Note result = new Note().id(UUID.randomUUID().toString())
                .author(author);
        result.title(request.getTitle())
                .content(request.getContent())
                .date(request.getDate());
        database.add(patientIdentifier, result);

        return result;
    }

    @Override
    public Note update(String id, String author, EditableNote request) throws ResourceNotFoundException, DataBlockedException, MergeConflictException {
        Note toUpdate = get(id).author(author);
        toUpdate.title(request.getTitle())
                .content(request.getContent())
                .setDate(new Date());

        return toUpdate;
    }
}
