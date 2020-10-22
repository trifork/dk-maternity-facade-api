package dk.sds.nsp.maternity.configuration.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;


public class EditableConfiguration {
    @JsonProperty("data") private String data;
    @JsonProperty("topic") private Topic topic;
    @JsonProperty("target") private UUID target;

    public String getData() {
        return data;
    }

    public Topic getTopic() {
        return topic;
    }

    public UUID getTarget() {
        return target;
    }

    public EditableConfiguration setData(String data) {
        this.data = data;
        return this;
    }

    public EditableConfiguration setTopic(Topic topic) {
        this.topic = topic;
        return this;
    }

    public EditableConfiguration setTarget(UUID target) {
        this.target = target;
        return this;
    }
}

