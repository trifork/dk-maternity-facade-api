package dk.sds.nsp.maternity.data.data_card.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

/**
 * WorkEnvironmentImpactSectionMotherHoursOfWorkPerWeek
 */
public class WorkEnvironmentImpactSectionMotherHoursOfWorkPerWeek {
    @JsonProperty("value")
    private Integer value = null;
    @JsonProperty("unit")
    private UnitEnum unit = null;

    public WorkEnvironmentImpactSectionMotherHoursOfWorkPerWeek value(Integer value) {
        this.value = value;
        return this;
    }

    /**
     * Get value
     * minimum: 0
     * maximum: 168
     *
     * @return value
     **/
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public WorkEnvironmentImpactSectionMotherHoursOfWorkPerWeek unit(UnitEnum unit) {
        this.unit = unit;
        return this;
    }

    /**
     * Get unit
     *
     * @return unit
     **/
    public UnitEnum getUnit() {
        return unit;
    }

    public void setUnit(UnitEnum unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WorkEnvironmentImpactSectionMotherHoursOfWorkPerWeek workEnvironmentImpactSectionMotherHoursOfWorkPerWeek = (WorkEnvironmentImpactSectionMotherHoursOfWorkPerWeek) o;
        return Objects.equals(this.value, workEnvironmentImpactSectionMotherHoursOfWorkPerWeek.value) &&
                Objects.equals(this.unit, workEnvironmentImpactSectionMotherHoursOfWorkPerWeek.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class WorkEnvironmentImpactSectionMotherHoursOfWorkPerWeek {\n");

        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
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
     * Gets or Sets unit
     */
    public enum UnitEnum {
        WK("h/wk");

        private String value;

        UnitEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static UnitEnum fromValue(String text) {
            for (UnitEnum b : UnitEnum.values()) {
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
