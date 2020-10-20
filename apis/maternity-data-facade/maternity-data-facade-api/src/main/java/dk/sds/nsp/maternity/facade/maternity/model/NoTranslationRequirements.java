package dk.sds.nsp.maternity.facade.maternity.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

/**
 * NoTranslationRequirements
 */
public class NoTranslationRequirements implements OneOfLanguageSection {
    @JsonProperty("translationRequired")
    private TranslationRequiredEnum translationRequired = null;

    public NoTranslationRequirements translationRequired(TranslationRequiredEnum translationRequired) {
        this.translationRequired = translationRequired;
        return this;
    }

    /**
     * Get translationRequired
     *
     * @return translationRequired
     **/
    public TranslationRequiredEnum getTranslationRequired() {
        return translationRequired;
    }

    public void setTranslationRequired(TranslationRequiredEnum translationRequired) {
        this.translationRequired = translationRequired;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NoTranslationRequirements noTranslationRequirements = (NoTranslationRequirements) o;
        return Objects.equals(this.translationRequired, noTranslationRequirements.translationRequired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(translationRequired);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NoTranslationRequirements {\n");

        sb.append("    translationRequired: ").append(toIndentedString(translationRequired)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    /**
     * Gets or Sets translationRequired
     */
    public enum TranslationRequiredEnum {
        NO("no");

        private String value;

        TranslationRequiredEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static TranslationRequiredEnum fromValue(String text) {
            for (TranslationRequiredEnum b : TranslationRequiredEnum.values()) {
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
}
