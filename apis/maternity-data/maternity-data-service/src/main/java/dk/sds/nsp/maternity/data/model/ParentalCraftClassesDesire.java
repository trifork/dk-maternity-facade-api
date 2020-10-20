package dk.sds.nsp.maternity.data.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

/**
 * ParentalCraftClassesDesire
 */
public class ParentalCraftClassesDesire implements OneOfMidwifeClinicSection {
    @JsonProperty("parentalCraftClassDesired")
    private ParentalCraftClassDesiredEnum parentalCraftClassDesired = ParentalCraftClassDesiredEnum.YES;
    @JsonProperty("consultationForm")
    private ConsultationFormEnum consultationForm = null;

    public ParentalCraftClassesDesire parentalCraftClassDesired(ParentalCraftClassDesiredEnum parentalCraftClassDesired) {
        this.parentalCraftClassDesired = parentalCraftClassDesired;
        return this;
    }

    /**
     * Get parentalCraftClassDesired
     *
     * @return parentalCraftClassDesired
     **/
    public ParentalCraftClassDesiredEnum getParentalCraftClassDesired() {
        return parentalCraftClassDesired;
    }

    public void setParentalCraftClassDesired(ParentalCraftClassDesiredEnum parentalCraftClassDesired) {
        this.parentalCraftClassDesired = parentalCraftClassDesired;
    }

    public ParentalCraftClassesDesire consultationForm(ConsultationFormEnum consultationForm) {
        this.consultationForm = consultationForm;
        return this;
    }

    /**
     * Get consultationForm
     *
     * @return consultationForm
     **/
    public ConsultationFormEnum getConsultationForm() {
        return consultationForm;
    }

    public void setConsultationForm(ConsultationFormEnum consultationForm) {
        this.consultationForm = consultationForm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ParentalCraftClassesDesire parentalCraftClassesDesire = (ParentalCraftClassesDesire) o;
        return Objects.equals(this.parentalCraftClassDesired, parentalCraftClassesDesire.parentalCraftClassDesired) &&
                Objects.equals(this.consultationForm, parentalCraftClassesDesire.consultationForm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parentalCraftClassDesired, consultationForm);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ParentalCraftClassesDesire {\n");

        sb.append("    parentalCraftClassDesired: ").append(toIndentedString(parentalCraftClassDesired)).append("\n");
        sb.append("    consultationForm: ").append(toIndentedString(consultationForm)).append("\n");
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
     * Gets or Sets parentalCraftClassDesired
     */
    public enum ParentalCraftClassDesiredEnum {
        YES("yes");

        private String value;

        ParentalCraftClassDesiredEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static ParentalCraftClassDesiredEnum fromValue(String text) {
            for (ParentalCraftClassDesiredEnum b : ParentalCraftClassDesiredEnum.values()) {
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

    /**
     * Gets or Sets consultationForm
     */
    public enum ConsultationFormEnum {
        INDIVIDUAL("individual"),

        GROUP("group");

        private String value;

        ConsultationFormEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static ConsultationFormEnum fromValue(String text) {
            for (ConsultationFormEnum b : ConsultationFormEnum.values()) {
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
