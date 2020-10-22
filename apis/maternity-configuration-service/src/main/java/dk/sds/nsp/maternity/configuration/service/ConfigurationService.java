package dk.sds.nsp.maternity.configuration.service;

import dk.sds.nsp.maternity.configuration.exceptions.MergeConflictException;
import dk.sds.nsp.maternity.configuration.exceptions.ResourceNotFoundException;
import dk.sds.nsp.maternity.configuration.model.Configuration;
import dk.sds.nsp.maternity.configuration.model.EditableConfiguration;
import dk.sds.nsp.maternity.configuration.model.Topic;
import org.springframework.lang.Nullable;

import java.util.List;

public interface ConfigurationService {
    Configuration create (EditableConfiguration configuration);

    Configuration update(String id, EditableConfiguration configuration) throws MergeConflictException, ResourceNotFoundException;

    void delete(String id) throws MergeConflictException, ResourceNotFoundException;

    Configuration get(String id) throws ResourceNotFoundException;

    List<Configuration> search(Topic topic, @Nullable String target);
}
