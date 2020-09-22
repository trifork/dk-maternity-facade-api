package dk.sds.nsp.maternity.facade.maternity.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * ChildPartnerSection
 */
public class ChildPartnerSection extends VersionedSection {
    @JsonProperty("identifier")
    private String identifier = null;

    public ChildPartnerSection identifier(String identifier) {
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
        ChildPartnerSection childPartnerSection = (ChildPartnerSection) o;
        return Objects.equals(this.identifier, childPartnerSection.identifier) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ChildPartnerSection {\n");
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
