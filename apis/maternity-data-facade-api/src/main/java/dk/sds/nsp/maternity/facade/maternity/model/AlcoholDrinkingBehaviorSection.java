package dk.sds.nsp.maternity.facade.maternity.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * AlcoholDrinkingBehaviorSection
 */
public class AlcoholDrinkingBehaviorSection extends VersionedSection {
    @JsonProperty("weeklyConsumptionBeforePregnancy")
    private WeeklyAlcoholUnitsConsumption weeklyConsumptionBeforePregnancy = null;

    @JsonProperty("weeklyConsumptionDuringPregnancy")
    private WeeklyAlcoholUnitsConsumption weeklyConsumptionDuringPregnancy = null;

    public AlcoholDrinkingBehaviorSection weeklyConsumptionBeforePregnancy(WeeklyAlcoholUnitsConsumption weeklyConsumptionBeforePregnancy) {
        this.weeklyConsumptionBeforePregnancy = weeklyConsumptionBeforePregnancy;
        return this;
    }

    /**
     * Get weeklyConsumptionBeforePregnancy
     *
     * @return weeklyConsumptionBeforePregnancy
     **/
    public WeeklyAlcoholUnitsConsumption getWeeklyConsumptionBeforePregnancy() {
        return weeklyConsumptionBeforePregnancy;
    }

    public void setWeeklyConsumptionBeforePregnancy(WeeklyAlcoholUnitsConsumption weeklyConsumptionBeforePregnancy) {
        this.weeklyConsumptionBeforePregnancy = weeklyConsumptionBeforePregnancy;
    }

    public AlcoholDrinkingBehaviorSection weeklyConsumptionDuringPregnancy(WeeklyAlcoholUnitsConsumption weeklyConsumptionDuringPregnancy) {
        this.weeklyConsumptionDuringPregnancy = weeklyConsumptionDuringPregnancy;
        return this;
    }

    /**
     * Get weeklyConsumptionDuringPregnancy
     *
     * @return weeklyConsumptionDuringPregnancy
     **/
    public WeeklyAlcoholUnitsConsumption getWeeklyConsumptionDuringPregnancy() {
        return weeklyConsumptionDuringPregnancy;
    }

    public void setWeeklyConsumptionDuringPregnancy(WeeklyAlcoholUnitsConsumption weeklyConsumptionDuringPregnancy) {
        this.weeklyConsumptionDuringPregnancy = weeklyConsumptionDuringPregnancy;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AlcoholDrinkingBehaviorSection alcoholDrinkingBehaviorSection = (AlcoholDrinkingBehaviorSection) o;
        return Objects.equals(this.weeklyConsumptionBeforePregnancy, alcoholDrinkingBehaviorSection.weeklyConsumptionBeforePregnancy) &&
                Objects.equals(this.weeklyConsumptionDuringPregnancy, alcoholDrinkingBehaviorSection.weeklyConsumptionDuringPregnancy) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weeklyConsumptionBeforePregnancy, weeklyConsumptionDuringPregnancy, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AlcoholDrinkingBehaviorSection {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    weeklyConsumptionBeforePregnancy: ").append(toIndentedString(weeklyConsumptionBeforePregnancy)).append("\n");
        sb.append("    weeklyConsumptionDuringPregnancy: ").append(toIndentedString(weeklyConsumptionDuringPregnancy)).append("\n");
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
