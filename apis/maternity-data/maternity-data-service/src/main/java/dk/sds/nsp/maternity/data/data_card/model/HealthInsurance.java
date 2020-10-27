package dk.sds.nsp.maternity.data.data_card.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

/**
 * HealthInsurance
 */
public class HealthInsurance {
    @JsonProperty("generalPractitioner")
    private HealthCareProfessional generalPractitioner = null;
    @JsonProperty("insuranceGroup")
    private InsuranceGroupEnum insuranceGroup = null;

    public HealthInsurance generalPractitioner(HealthCareProfessional generalPractitioner) {
        this.generalPractitioner = generalPractitioner;
        return this;
    }

    /**
     * Get generalPractitioner
     *
     * @return generalPractitioner
     **/
    public HealthCareProfessional getGeneralPractitioner() {
        return generalPractitioner;
    }

    public void setGeneralPractitioner(HealthCareProfessional generalPractitioner) {
        this.generalPractitioner = generalPractitioner;
    }

    public HealthInsurance insuranceGroup(InsuranceGroupEnum insuranceGroup) {
        this.insuranceGroup = insuranceGroup;
        return this;
    }

    /**
     * Get insuranceGroup
     *
     * @return insuranceGroup
     **/
    public InsuranceGroupEnum getInsuranceGroup() {
        return insuranceGroup;
    }

    public void setInsuranceGroup(InsuranceGroupEnum insuranceGroup) {
        this.insuranceGroup = insuranceGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HealthInsurance healthInsurance = (HealthInsurance) o;
        return Objects.equals(this.generalPractitioner, healthInsurance.generalPractitioner) &&
                Objects.equals(this.insuranceGroup, healthInsurance.insuranceGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(generalPractitioner, insuranceGroup);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class HealthInsurance {\n");

        sb.append("    generalPractitioner: ").append(toIndentedString(generalPractitioner)).append("\n");
        sb.append("    insuranceGroup: ").append(toIndentedString(insuranceGroup)).append("\n");
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
     * Gets or Sets insuranceGroup
     */
    public enum InsuranceGroupEnum {
        _1("1"),

        _2("2"),

        _4("4"),

        _5("5"),

        _6("6"),

        _7("7"),

        _8("8"),

        _9("9");

        private String value;

        InsuranceGroupEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static InsuranceGroupEnum fromValue(String text) {
            for (InsuranceGroupEnum b : InsuranceGroupEnum.values()) {
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
