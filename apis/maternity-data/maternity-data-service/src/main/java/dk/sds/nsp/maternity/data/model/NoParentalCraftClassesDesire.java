package dk.sds.nsp.maternity.data.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

/**
 * NoParentalCraftClassesDesire
 */
public class NoParentalCraftClassesDesire implements OneOfMidwifeClinicSection {
    @JsonProperty("parentalCraftClassDesired")
    private ParentalCraftClassDesiredEnum parentalCraftClassDesired = ParentalCraftClassDesiredEnum.NO;

    public NoParentalCraftClassesDesire parentalCraftClassDesired(ParentalCraftClassDesiredEnum parentalCraftClassDesired) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NoParentalCraftClassesDesire noParentalCraftClassesDesire = (NoParentalCraftClassesDesire) o;
        return Objects.equals(this.parentalCraftClassDesired, noParentalCraftClassesDesire.parentalCraftClassDesired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parentalCraftClassDesired);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NoParentalCraftClassesDesire {\n");

        sb.append("    parentalCraftClassDesired: ").append(toIndentedString(parentalCraftClassDesired)).append("\n");
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
        NO("no");

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
}
