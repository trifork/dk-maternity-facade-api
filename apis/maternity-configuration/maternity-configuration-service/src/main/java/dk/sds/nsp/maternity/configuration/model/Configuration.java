package dk.sds.nsp.maternity.configuration.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Configuration extends EditableConfiguration{
  @JsonProperty("id")
  private String id;

  public Configuration withId(final String id) {
    this.id = id;
    return this;
  }

  public String getId() {
    return id;
  }

  @Override
  public Configuration setData(String data) {
    super.setData(data);
    return this;
  }

  @Override
  public Configuration setTopic(Topic topic) {
    super.setTopic(topic);
    return this;
  }

  @Override
  public Configuration setTarget(UUID target) {
    super.setTarget(target);
    return this;
  }

  public static Configuration fromEditable(String id, EditableConfiguration editableConfiguration) {
    Configuration configuration =  new Configuration()
            .withId(id);
    configuration.setData(editableConfiguration.getData())
            .setTarget(editableConfiguration.getTarget())
            .setTopic(editableConfiguration.getTopic());
    return configuration;
  }

}

