package dk.sds.nsp.maternity.data.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

/**
 * SubstanceUse
 */
public class SubstanceUse implements OneOfSubstanceUseObservation {
    @JsonProperty("substanceUse")
    private SubstanceUseEnum substanceUse = null;
    @JsonProperty("text")
    private String text = null;

    public SubstanceUse substanceUse(SubstanceUseEnum substanceUse) {
        this.substanceUse = substanceUse;
        return this;
    }

    /**
     * Get substanceUse
     *
     * @return substanceUse
     **/
    public SubstanceUseEnum getSubstanceUse() {
        return substanceUse;
    }

    public void setSubstanceUse(SubstanceUseEnum substanceUse) {
        this.substanceUse = substanceUse;
    }

    public SubstanceUse text(String text) {
        this.text = text;
        return this;
    }

    /**
     * Get text
     *
     * @return text
     **/
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SubstanceUse substanceUse = (SubstanceUse) o;
        return Objects.equals(this.substanceUse, substanceUse.substanceUse) &&
                Objects.equals(this.text, substanceUse.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(substanceUse, text);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SubstanceUse {\n");

        sb.append("    substanceUse: ").append(toIndentedString(substanceUse)).append("\n");
        sb.append("    text: ").append(toIndentedString(text)).append("\n");
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
     * Gets or Sets substanceUse
     */
    public enum SubstanceUseEnum {
        YES("yes");

        private String value;

        SubstanceUseEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static SubstanceUseEnum fromValue(String text) {
            for (SubstanceUseEnum b : SubstanceUseEnum.values()) {
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
