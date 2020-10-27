package dk.sds.nsp.maternity.data.data_card.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * ExposureToWorkEnvironmentRisk
 */
public class ExposureToWorkEnvironmentRisk extends DurationFromDates {
    @JsonProperty("remarks")
    private String remarks = null;

    public ExposureToWorkEnvironmentRisk remarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    /**
     * Get remarks
     *
     * @return remarks
     **/
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExposureToWorkEnvironmentRisk exposureToWorkEnvironmentRisk = (ExposureToWorkEnvironmentRisk) o;
        return Objects.equals(this.remarks, exposureToWorkEnvironmentRisk.remarks) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(remarks, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ExposureToWorkEnvironmentRisk {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    remarks: ").append(toIndentedString(remarks)).append("\n");
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
