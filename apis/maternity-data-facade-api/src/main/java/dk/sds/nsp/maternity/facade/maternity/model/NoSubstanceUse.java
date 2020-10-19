package dk.sds.nsp.maternity.facade.maternity.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

/**
 * NoSubstanceUse
 */
public class NoSubstanceUse implements OneOfSubstanceUseObservation {
    @JsonProperty("substanceUse")
    private SubstanceUseEnum substanceUse = null;

    public NoSubstanceUse substanceUse(SubstanceUseEnum substanceUse) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NoSubstanceUse noSubstanceUse = (NoSubstanceUse) o;
        return Objects.equals(this.substanceUse, noSubstanceUse.substanceUse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(substanceUse);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NoSubstanceUse {\n");

        sb.append("    substanceUse: ").append(toIndentedString(substanceUse)).append("\n");
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
        NO("no");

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
