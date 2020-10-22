package dk.sds.nsp.maternity.configuration.service;

import dk.sds.nsp.maternity.configuration.exceptions.MergeConflictException;
import dk.sds.nsp.maternity.configuration.exceptions.ResourceNotFoundException;
import dk.sds.nsp.maternity.configuration.model.Configuration;
import dk.sds.nsp.maternity.configuration.model.EditableConfiguration;
import dk.sds.nsp.maternity.configuration.model.Topic;
import org.springframework.lang.Nullable;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class ConfigurationServiceImpl implements ConfigurationService {

    @Override
    public Configuration create(EditableConfiguration configuration) {
        throw new NotImplementedException();
    }

    @Override
    public Configuration update(String id, EditableConfiguration configuration) throws MergeConflictException, ResourceNotFoundException {
        throw new NotImplementedException();
    }

    @Override
    public void delete(String id) throws MergeConflictException, ResourceNotFoundException {
        throw new NotImplementedException();
    }

    @Override
    public Configuration get(String id) throws ResourceNotFoundException {
        throw new NotImplementedException();
    }

    @Override
    public List<Configuration> search(Topic topic, @Nullable String target) {
        throw new NotImplementedException();
    }
}
