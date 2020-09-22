package dk.sds.nsp.maternity.facade.maternity.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * YesNoDateScreeningSection
 */
public class YesNoDateScreeningSection extends DateScreeningSection {
    @JsonProperty("value")
    private YesNoEnum value = null;

    public YesNoDateScreeningSection value(YesNoEnum value) {
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
        YesNoDateScreeningSection yesNoDateScreeningSection = (YesNoDateScreeningSection) o;
        return Objects.equals(this.value, yesNoDateScreeningSection.value) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class YesNoDateScreeningSection {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
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
