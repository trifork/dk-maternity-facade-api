package dk.sds.nsp.maternity.data.data_card.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Objects;

/**
 * HealthInsuranceSection
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "insuranceGroup", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Group1HealthInsurance.class, name = "1"),
        @JsonSubTypes.Type(value = OtherThanGroup1HealthInsurance.class, name = "2"),
        @JsonSubTypes.Type(value = OtherThanGroup1HealthInsurance.class, name = "4"),
        @JsonSubTypes.Type(value = OtherThanGroup1HealthInsurance.class, name = "6"),
        @JsonSubTypes.Type(value = OtherThanGroup1HealthInsurance.class, name = "7"),
        @JsonSubTypes.Type(value = OtherThanGroup1HealthInsurance.class, name = "8"),
})


public class HealthInsuranceSection implements OneOfHealthInsuranceSection {

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class HealthInsuranceSection {\n");

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
