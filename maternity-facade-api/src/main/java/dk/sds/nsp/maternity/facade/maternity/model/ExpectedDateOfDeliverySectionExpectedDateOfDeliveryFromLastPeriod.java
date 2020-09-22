package dk.sds.nsp.maternity.facade.maternity.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.time.LocalDate;
import java.util.Objects;

/**
 * ExpectedDateOfDeliverySectionExpectedDateOfDeliveryFromLastPeriod
 */
public class ExpectedDateOfDeliverySectionExpectedDateOfDeliveryFromLastPeriod {
    @JsonProperty("lastPeriod")
    private LocalDate lastPeriod = null;

    @JsonProperty("menstrualCycle")
    private OneOfExpectedDateOfDeliverySectionExpectedDateOfDeliveryFromLastPeriodMenstrualCycle menstrualCycle = null;

    @JsonProperty("expectedDateOfDelivery")
    private LocalDate expectedDateOfDelivery = null;
    @JsonProperty("certainty")
    private CertaintyEnum certainty = null;

    public ExpectedDateOfDeliverySectionExpectedDateOfDeliveryFromLastPeriod lastPeriod(LocalDate lastPeriod) {
        this.lastPeriod = lastPeriod;
        return this;
    }

    /**
     * Get lastPeriod
     *
     * @return lastPeriod
     **/
    public LocalDate getLastPeriod() {
        return lastPeriod;
    }

    public void setLastPeriod(LocalDate lastPeriod) {
        this.lastPeriod = lastPeriod;
    }

    public ExpectedDateOfDeliverySectionExpectedDateOfDeliveryFromLastPeriod menstrualCycle(OneOfExpectedDateOfDeliverySectionExpectedDateOfDeliveryFromLastPeriodMenstrualCycle menstrualCycle) {
        this.menstrualCycle = menstrualCycle;
        return this;
    }

    /**
     * Get menstrualCycle
     *
     * @return menstrualCycle
     **/
    public OneOfExpectedDateOfDeliverySectionExpectedDateOfDeliveryFromLastPeriodMenstrualCycle getMenstrualCycle() {
        return menstrualCycle;
    }

    public void setMenstrualCycle(OneOfExpectedDateOfDeliverySectionExpectedDateOfDeliveryFromLastPeriodMenstrualCycle menstrualCycle) {
        this.menstrualCycle = menstrualCycle;
    }

    public ExpectedDateOfDeliverySectionExpectedDateOfDeliveryFromLastPeriod expectedDateOfDelivery(LocalDate expectedDateOfDelivery) {
        this.expectedDateOfDelivery = expectedDateOfDelivery;
        return this;
    }

    /**
     * Get expectedDateOfDelivery
     *
     * @return expectedDateOfDelivery
     **/
    public LocalDate getExpectedDateOfDelivery() {
        return expectedDateOfDelivery;
    }

    public void setExpectedDateOfDelivery(LocalDate expectedDateOfDelivery) {
        this.expectedDateOfDelivery = expectedDateOfDelivery;
    }

    public ExpectedDateOfDeliverySectionExpectedDateOfDeliveryFromLastPeriod certainty(CertaintyEnum certainty) {
        this.certainty = certainty;
        return this;
    }

    /**
     * Get certainty
     *
     * @return certainty
     **/
    public CertaintyEnum getCertainty() {
        return certainty;
    }

    public void setCertainty(CertaintyEnum certainty) {
        this.certainty = certainty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExpectedDateOfDeliverySectionExpectedDateOfDeliveryFromLastPeriod expectedDateOfDeliverySectionExpectedDateOfDeliveryFromLastPeriod = (ExpectedDateOfDeliverySectionExpectedDateOfDeliveryFromLastPeriod) o;
        return Objects.equals(this.lastPeriod, expectedDateOfDeliverySectionExpectedDateOfDeliveryFromLastPeriod.lastPeriod) &&
                Objects.equals(this.menstrualCycle, expectedDateOfDeliverySectionExpectedDateOfDeliveryFromLastPeriod.menstrualCycle) &&
                Objects.equals(this.expectedDateOfDelivery, expectedDateOfDeliverySectionExpectedDateOfDeliveryFromLastPeriod.expectedDateOfDelivery) &&
                Objects.equals(this.certainty, expectedDateOfDeliverySectionExpectedDateOfDeliveryFromLastPeriod.certainty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastPeriod, menstrualCycle, expectedDateOfDelivery, certainty);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ExpectedDateOfDeliverySectionExpectedDateOfDeliveryFromLastPeriod {\n");

        sb.append("    lastPeriod: ").append(toIndentedString(lastPeriod)).append("\n");
        sb.append("    menstrualCycle: ").append(toIndentedString(menstrualCycle)).append("\n");
        sb.append("    expectedDateOfDelivery: ").append(toIndentedString(expectedDateOfDelivery)).append("\n");
        sb.append("    certainty: ").append(toIndentedString(certainty)).append("\n");
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
     * Gets or Sets certainty
     */
    public enum CertaintyEnum {
        CERTAIN("certain"),

        EQUIVOCAL("equivocal");

        private String value;

        CertaintyEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static CertaintyEnum fromValue(String text) {
            for (CertaintyEnum b : CertaintyEnum.values()) {
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
