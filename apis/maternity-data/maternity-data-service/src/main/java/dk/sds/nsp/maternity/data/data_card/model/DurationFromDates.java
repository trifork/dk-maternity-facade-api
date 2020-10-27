package dk.sds.nsp.maternity.data.data_card.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.Objects;

/**
 * DurationFromDates
 */
public class DurationFromDates implements OneOfExpectedDateOfDeliverySectionExpectedDateOfDeliveryFromLastPeriodMenstrualCycle {
    @JsonProperty("start")
    private LocalDate start = null;

    @JsonProperty("end")
    private LocalDate end = null;

    @JsonProperty("calculated")
    private DurationInDays calculated = null;

    public DurationFromDates start(LocalDate start) {
        this.start = start;
        return this;
    }

    /**
     * Get start
     *
     * @return start
     **/
    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public DurationFromDates end(LocalDate end) {
        this.end = end;
        return this;
    }

    /**
     * Get end
     *
     * @return end
     **/
    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public DurationFromDates calculated(DurationInDays calculated) {
        this.calculated = calculated;
        return this;
    }

    /**
     * Get calculated
     *
     * @return calculated
     **/
    public DurationInDays getCalculated() {
        return calculated;
    }

    public void setCalculated(DurationInDays calculated) {
        this.calculated = calculated;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DurationFromDates durationFromDates = (DurationFromDates) o;
        return Objects.equals(this.start, durationFromDates.start) &&
                Objects.equals(this.end, durationFromDates.end) &&
                Objects.equals(this.calculated, durationFromDates.calculated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end, calculated);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DurationFromDates {\n");

        sb.append("    start: ").append(toIndentedString(start)).append("\n");
        sb.append("    end: ").append(toIndentedString(end)).append("\n");
        sb.append("    calculated: ").append(toIndentedString(calculated)).append("\n");
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
