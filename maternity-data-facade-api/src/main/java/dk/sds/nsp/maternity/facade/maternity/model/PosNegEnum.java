package dk.sds.nsp.maternity.facade.maternity.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets PosNegEnum
 */
public enum PosNegEnum {
    POSITIVE("positive"),
    NEGATIVE("negative");

    private final String value;

    PosNegEnum(String value) {
        this.value = value;
    }

    @JsonCreator
    public static PosNegEnum fromValue(String text) {
        for (PosNegEnum b : PosNegEnum.values()) {
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
