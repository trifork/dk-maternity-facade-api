package dk.sds.nsp.maternity.facade.maternity.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Objects;

/**
 * LanguageSection
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "translationRequired", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = TranslationRequirements.class, name = "yes"),
        @JsonSubTypes.Type(value = NoTranslationRequirements.class, name = "no"),
})


public class LanguageSection extends VersionedSection implements OneOfLanguageSection {
    @JsonProperty("nationality")
    private String nationality = null;

    public LanguageSection nationality(String nationality) {
        this.nationality = nationality;
        return this;
    }

    /**
     * Get nationality
     *
     * @return nationality
     **/
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LanguageSection languageSection = (LanguageSection) o;
        return Objects.equals(this.nationality, languageSection.nationality) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nationality, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LanguageSection {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    nationality: ").append(toIndentedString(nationality)).append("\n");
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
}
