package dk.sds.nsp.maternity.facade.maternity.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * WorkEnvironmentImpactSection
 */
public class WorkEnvironmentImpactSection extends VersionedSection {
    @JsonProperty("mother")
    private WorkEnvironmentImpactSectionMother mother = null;

    @JsonProperty("partner")
    private WorkEnvironmentImpactSectionPartner partner = null;

    public WorkEnvironmentImpactSection mother(WorkEnvironmentImpactSectionMother mother) {
        this.mother = mother;
        return this;
    }

    /**
     * Get mother
     *
     * @return mother
     **/
    public WorkEnvironmentImpactSectionMother getMother() {
        return mother;
    }

    public void setMother(WorkEnvironmentImpactSectionMother mother) {
        this.mother = mother;
    }

    public WorkEnvironmentImpactSection partner(WorkEnvironmentImpactSectionPartner partner) {
        this.partner = partner;
        return this;
    }

    /**
     * Get partner
     *
     * @return partner
     **/
    public WorkEnvironmentImpactSectionPartner getPartner() {
        return partner;
    }

    public void setPartner(WorkEnvironmentImpactSectionPartner partner) {
        this.partner = partner;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WorkEnvironmentImpactSection workEnvironmentImpactSection = (WorkEnvironmentImpactSection) o;
        return Objects.equals(this.mother, workEnvironmentImpactSection.mother) &&
                Objects.equals(this.partner, workEnvironmentImpactSection.partner) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, partner, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class WorkEnvironmentImpactSection {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    mother: ").append(toIndentedString(mother)).append("\n");
        sb.append("    partner: ").append(toIndentedString(partner)).append("\n");
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
