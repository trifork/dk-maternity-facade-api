package dk.sds.nsp.maternity.data.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

/**
 * MidwifeClinicSectionMidwifeConsultationWishes
 */
public class MidwifeClinicSectionMidwifeConsultationWishes {
    @JsonProperty("location")
    private String location = null;
    @JsonProperty("weekday")
    private WeekdayEnum weekday = null;
    @JsonProperty("midwife")
    private Person midwife = null;

    public MidwifeClinicSectionMidwifeConsultationWishes location(String location) {
        this.location = location;
        return this;
    }

    /**
     * Get location
     *
     * @return location
     **/
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public MidwifeClinicSectionMidwifeConsultationWishes weekday(WeekdayEnum weekday) {
        this.weekday = weekday;
        return this;
    }

    /**
     * Get weekday
     *
     * @return weekday
     **/
    public WeekdayEnum getWeekday() {
        return weekday;
    }

    public void setWeekday(WeekdayEnum weekday) {
        this.weekday = weekday;
    }

    public MidwifeClinicSectionMidwifeConsultationWishes midwife(Person midwife) {
        this.midwife = midwife;
        return this;
    }

    /**
     * Get midwife
     *
     * @return midwife
     **/
public Person getMidwife() {
        return midwife;
    }

    public void setMidwife(Person midwife) {
        this.midwife = midwife;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MidwifeClinicSectionMidwifeConsultationWishes midwifeClinicSectionMidwifeConsultationWishes = (MidwifeClinicSectionMidwifeConsultationWishes) o;
        return Objects.equals(this.location, midwifeClinicSectionMidwifeConsultationWishes.location) &&
                Objects.equals(this.weekday, midwifeClinicSectionMidwifeConsultationWishes.weekday) &&
                Objects.equals(this.midwife, midwifeClinicSectionMidwifeConsultationWishes.midwife);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, weekday, midwife);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MidwifeClinicSectionMidwifeConsultationWishes {\n");

        sb.append("    location: ").append(toIndentedString(location)).append("\n");
        sb.append("    weekday: ").append(toIndentedString(weekday)).append("\n");
        sb.append("    midwife: ").append(toIndentedString(midwife)).append("\n");
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
     * Gets or Sets weekday
     */
    public enum WeekdayEnum {
        MONDAY("monday"),

        TUESDAY("tuesday"),

        WEDNESDAY("wednesday"),

        THURSDAY("thursday"),

        FRIDAY("friday"),

        SATURDAY("saturday"),

        SUNDAY("sunday");

        private String value;

        WeekdayEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static WeekdayEnum fromValue(String text) {
            for (WeekdayEnum b : WeekdayEnum.values()) {
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
