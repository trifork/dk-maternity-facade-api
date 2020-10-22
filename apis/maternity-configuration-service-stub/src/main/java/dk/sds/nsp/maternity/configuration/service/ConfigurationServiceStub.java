package dk.sds.nsp.maternity.configuration.service;

import dk.sds.nsp.maternity.configuration.exceptions.MergeConflictException;
import dk.sds.nsp.maternity.configuration.exceptions.ResourceNotFoundException;
import dk.sds.nsp.maternity.configuration.model.Configuration;
import dk.sds.nsp.maternity.configuration.model.EditableConfiguration;
import dk.sds.nsp.maternity.configuration.model.Topic;
import org.springframework.lang.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class ConfigurationServiceStub implements ConfigurationService {
    Map<String, Configuration> idIndex = new HashMap<>();

    @Override
    public Configuration create(EditableConfiguration configuration) {
        String id = UUID.randomUUID().toString();
        Configuration result = Configuration.fromEditable(id, configuration);
        idIndex.put(id, result);
        return result;
    }

    @Override
    public Configuration update(String id, EditableConfiguration configuration) throws MergeConflictException, ResourceNotFoundException {
        if (!idIndex.containsKey(id)) {
            throw new ResourceNotFoundException("Configuration with id '" + id + "' does not exist!");
        }
        Configuration toUpdate = idIndex.get(id);
        return toUpdate.setData(configuration.getData())
                .setTopic(configuration.getTopic())
                .setTarget(configuration.getTarget());
    }

    @Override
    public void delete(String id) throws MergeConflictException, ResourceNotFoundException {
        if (!idIndex.containsKey(id)) {
            throw new ResourceNotFoundException("Configuration with id '" + id + "' does not exist!");
        }
        idIndex.remove(id);
    }

    @Override
    public Configuration get(String id) throws ResourceNotFoundException {
        if (!idIndex.containsKey(id)) {
            throw new ResourceNotFoundException("Configuration with id '" + id + "' does not exist!");
        }
        return idIndex.get(id);
    }

    @Override
    public List<Configuration> search(Topic topic, @Nullable String target) {
        return idIndex.values().stream()
                .filter(x -> x.getTopic() == topic)
                .filter(x -> target == null || target.equals(x.getTarget().toString()))
                .collect(Collectors.toList());
    }
}
