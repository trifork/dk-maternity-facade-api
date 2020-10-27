package dk.sds.nsp.maternity.data.data_card.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * PositiveNegativeScreeningWithDateSection
 */
public class PositiveNegativeScreeningWithDateSection extends DateScreeningSection {
    @JsonProperty("result")
    private PosNegEnum result = null;

    public PositiveNegativeScreeningWithDateSection result(PosNegEnum result) {
        this.result = result;
        return this;
    }

    /**
     * Get result
     *
     * @return result
     **/
public PosNegEnum getResult() {
        return result;
    }

    public void setResult(PosNegEnum result) {
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
        PositiveNegativeScreeningWithDateSection positiveNegativeScreeningWithDateSection = (PositiveNegativeScreeningWithDateSection) o;
        return Objects.equals(this.result, positiveNegativeScreeningWithDateSection.result) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PositiveNegativeScreeningWithDateSection {\n");
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
}
