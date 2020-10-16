package dk.sds.nsp.maternity.facade.maternity.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

/**
 * TranslationRequirements
 */
public class TranslationRequirements implements OneOfLanguageSection {
    @JsonProperty("language")
    private String language = null;
    @JsonProperty("translationRequired")
    private TranslationRequiredEnum translationRequired = null;

    public TranslationRequirements language(String language) {
        this.language = language;
        return this;
    }

    /**
     * Get language
     *
     * @return language
     **/
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public TranslationRequirements translationRequired(TranslationRequiredEnum translationRequired) {
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
        TranslationRequirements translationRequirements = (TranslationRequirements) o;
        return Objects.equals(this.language, translationRequirements.language) &&
                Objects.equals(this.translationRequired, translationRequirements.translationRequired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(language, translationRequired);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TranslationRequirements {\n");

        sb.append("    language: ").append(toIndentedString(language)).append("\n");
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
        YES("yes");

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
