package dk.sds.nsp.maternity.configuration.model;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum Topic {
    EGRAVIDITET("eGraviditet"),
    GRAVID_I_DK("gravid_i_dk"),
    ;

    private String value;

    Topic(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static Topic fromValue(String value) {
        return Arrays.stream(Topic.values())
                .filter(x -> x.getValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unexpected value '" + value + "'"));
    }
}

