package dk.sds.nsp.maternity.data.data_card.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

/**
 * WeeklyAlcoholUnitsConsumption
 */
public class WeeklyAlcoholUnitsConsumption {
    @JsonProperty("value")
    private Integer value = null;

    @JsonProperty("multiplier")
    private Integer multiplier = 12;
    @JsonProperty("unit")
    private UnitEnum unit = null;

    public WeeklyAlcoholUnitsConsumption value(Integer value) {
        this.value = value;
        return this;
    }

    /**
     * Get value
     * minimum: 0
     *
     * @return value
     **/
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public WeeklyAlcoholUnitsConsumption multiplier(Integer multiplier) {
        this.multiplier = multiplier;
        return this;
    }

    /**
     * Get multiplier
     * minimum: 12
     * maximum: 12
     *
     * @return multiplier
     **/
    public Integer getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(Integer multiplier) {
        this.multiplier = multiplier;
    }

    public WeeklyAlcoholUnitsConsumption unit(UnitEnum unit) {
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
        WeeklyAlcoholUnitsConsumption weeklyAlcoholUnitsConsumption = (WeeklyAlcoholUnitsConsumption) o;
        return Objects.equals(this.value, weeklyAlcoholUnitsConsumption.value) &&
                Objects.equals(this.multiplier, weeklyAlcoholUnitsConsumption.multiplier) &&
                Objects.equals(this.unit, weeklyAlcoholUnitsConsumption.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, multiplier, unit);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class WeeklyAlcoholUnitsConsumption {\n");

        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("    multiplier: ").append(toIndentedString(multiplier)).append("\n");
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
        WK("g/wk");

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
