package dk.sds.nsp.maternity.facade.common.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.annotation.Generated;

/**
 * Gets or Sets ApplicationMode
 */
@Generated("openapi")
public enum ApplicationMode {
    STANDALONE("standalone"),
    EMBEDDED("embedded");

    private final String value;

    ApplicationMode(String value) {
        this.value = value;
    }

    @JsonCreator
    public static ApplicationMode fromValue(String text) {
        for (ApplicationMode b : ApplicationMode.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }
}
