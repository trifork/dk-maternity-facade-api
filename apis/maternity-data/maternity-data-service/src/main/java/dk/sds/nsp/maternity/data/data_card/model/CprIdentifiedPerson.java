package dk.sds.nsp.maternity.data.data_card.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * CprIdentifiedPerson
 */
public class CprIdentifiedPerson extends Person<CprIdentifiedPerson> {
    @JsonProperty("identifier")
    private String identifier = null;

    public CprIdentifiedPerson identifier(String identifier) {
        this.identifier = identifier;
        return this;
    }

    /**
     * Get identifier
     *
     * @return identifier
     **/
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CprIdentifiedPerson cprIdentifiedPerson = (CprIdentifiedPerson) o;
        return Objects.equals(this.identifier, cprIdentifiedPerson.identifier) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CprIdentifiedPerson {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
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
