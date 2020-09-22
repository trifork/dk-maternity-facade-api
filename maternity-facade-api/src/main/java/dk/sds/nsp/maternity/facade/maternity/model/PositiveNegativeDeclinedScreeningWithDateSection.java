package dk.sds.nsp.maternity.facade.maternity.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

/**
 * PositiveNegativeDeclinedScreeningWithDateSection
 */
public class PositiveNegativeDeclinedScreeningWithDateSection extends DateScreeningSection {
    @JsonProperty("result")
    private ResultEnum result = null;

    public PositiveNegativeDeclinedScreeningWithDateSection result(ResultEnum result) {
        this.result = result;
        return this;
    }

    /**
     * Get result
     *
     * @return result
     **/
    public ResultEnum getResult() {
        return result;
    }

    public void setResult(ResultEnum result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PositiveNegativeDeclinedScreeningWithDateSection positiveNegativeDeclinedScreeningWithDateSection = (PositiveNegativeDeclinedScreeningWithDateSection) o;
        return Objects.equals(this.result, positiveNegativeDeclinedScreeningWithDateSection.result) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PositiveNegativeDeclinedScreeningWithDateSection {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    result: ").append(toIndentedString(result)).append("\n");
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
     * Gets or Sets result
     */
    public enum ResultEnum {
        POSITIVE("positive"),

        NEGATIVE("negative"),

        DECLINED("declined");

        private String value;

        ResultEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static ResultEnum fromValue(String text) {
            for (ResultEnum b : ResultEnum.values()) {
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
