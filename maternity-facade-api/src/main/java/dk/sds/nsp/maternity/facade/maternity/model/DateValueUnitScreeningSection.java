package dk.sds.nsp.maternity.facade.maternity.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * DateValueUnitScreeningSection
 */
public class DateValueUnitScreeningSection extends DateScreeningSection {
    @JsonProperty("value")
    private Integer value = null;

    @JsonProperty("unit")
    private String unit = null;

    public DateValueUnitScreeningSection value(Integer value) {
        this.value = value;
        return this;
    }

    /**
     * Get value
     *
     * @return value
     **/
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public DateValueUnitScreeningSection unit(String unit) {
        this.unit = unit;
        return this;
    }

    /**
     * Get unit
     *
     * @return unit
     **/
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
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
        DateValueUnitScreeningSection dateValueUnitScreeningSection = (DateValueUnitScreeningSection) o;
        return Objects.equals(this.value, dateValueUnitScreeningSection.value) &&
                Objects.equals(this.unit, dateValueUnitScreeningSection.unit) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DateValueUnitScreeningSection {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
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
}
