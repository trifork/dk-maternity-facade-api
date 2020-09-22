package dk.sds.nsp.maternity.facade.maternity.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets ApplicationMode
 */
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
