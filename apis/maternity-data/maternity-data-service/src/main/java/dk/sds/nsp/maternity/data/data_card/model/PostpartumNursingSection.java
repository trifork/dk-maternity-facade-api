package dk.sds.nsp.maternity.data.data_card.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * PostpartumNursingSection
 */
public class PostpartumNursingSection extends VersionedSection {
    @JsonProperty("organization")
    private HealthCareOrganization organization = null;

    @JsonProperty("postpartumNurse")
    private Object postpartumNurse = null;

    public PostpartumNursingSection organization(HealthCareOrganization organization) {
        this.organization = organization;
        return this;
    }

    /**
     * Get organization
     *
     * @return organization
     **/
public HealthCareOrganization getOrganization() {
        return organization;
    }

    public void setOrganization(HealthCareOrganization organization) {
        this.organization = organization;
    }

    public PostpartumNursingSection postpartumNurse(Object postpartumNurse) {
        this.postpartumNurse = postpartumNurse;
        return this;
    }

    /**
     * Get postpartumNurse
     *
     * @return postpartumNurse
     **/
    public Object getPostpartumNurse() {
        return postpartumNurse;
    }

    public void setPostpartumNurse(Object postpartumNurse) {
        this.postpartumNurse = postpartumNurse;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PostpartumNursingSection postpartumNursingSection = (PostpartumNursingSection) o;
        return Objects.equals(this.organization, postpartumNursingSection.organization) &&
                Objects.equals(this.postpartumNurse, postpartumNursingSection.postpartumNurse) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organization, postpartumNurse, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PostpartumNursingSection {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    organization: ").append(toIndentedString(organization)).append("\n");
        sb.append("    postpartumNurse: ").append(toIndentedString(postpartumNurse)).append("\n");
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
