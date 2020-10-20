package dk.sds.nsp.maternity.data.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets YesNoEnum
 */
public enum YesNoEnum {
    YES("yes"),
    NO("no");

    private final String value;

    YesNoEnum(String value) {
        this.value = value;
    }

    @JsonCreator
    public static YesNoEnum fromValue(String text) {
        for (YesNoEnum b : YesNoEnum.values()) {
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
