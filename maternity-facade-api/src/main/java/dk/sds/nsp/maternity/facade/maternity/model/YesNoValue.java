package dk.sds.nsp.maternity.facade.maternity.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * YesNoValue
 */
public class YesNoValue {
    @JsonProperty("value")
    private YesNoEnum value = null;

    public YesNoValue value(YesNoEnum value) {
        this.value = value;
        return this;
    }

    /**
     * Get value
     *
     * @return value
     **/
public YesNoEnum getValue() {
        return value;
    }

    public void setValue(YesNoEnum value) {
        this.value = value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        YesNoValue yesNoValue = (YesNoValue) o;
        return Objects.equals(this.value, yesNoValue.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class YesNoValue {\n");

        sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
