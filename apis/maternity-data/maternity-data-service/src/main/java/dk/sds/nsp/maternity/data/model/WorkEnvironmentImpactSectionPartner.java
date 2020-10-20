package dk.sds.nsp.maternity.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * WorkEnvironmentImpactSectionPartner
 */
public class WorkEnvironmentImpactSectionPartner {
    @JsonProperty("jobType")
    private String jobType = null;

    public WorkEnvironmentImpactSectionPartner jobType(String jobType) {
        this.jobType = jobType;
        return this;
    }

    /**
     * Get jobType
     *
     * @return jobType
     **/
    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WorkEnvironmentImpactSectionPartner workEnvironmentImpactSectionPartner = (WorkEnvironmentImpactSectionPartner) o;
        return Objects.equals(this.jobType, workEnvironmentImpactSectionPartner.jobType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class WorkEnvironmentImpactSectionPartner {\n");

        sb.append("    jobType: ").append(toIndentedString(jobType)).append("\n");
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
