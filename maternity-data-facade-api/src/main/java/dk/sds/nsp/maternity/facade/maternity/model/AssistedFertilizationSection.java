package dk.sds.nsp.maternity.facade.maternity.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * AssistedFertilizationSection
 */
public class AssistedFertilizationSection extends VersionedSection {
    @JsonProperty("receivesFertilizationAssitance")
    private Boolean receivesFertilizationAssitance = null;

    @JsonProperty("remarks")
    private String remarks = null;

    public AssistedFertilizationSection receivesFertilizationAssitance(Boolean receivesFertilizationAssitance) {
        this.receivesFertilizationAssitance = receivesFertilizationAssitance;
        return this;
    }

    /**
     * Get receivesFertilizationAssitance
     *
     * @return receivesFertilizationAssitance
     **/
    public Boolean isReceivesFertilizationAssitance() {
        return receivesFertilizationAssitance;
    }

    public void setReceivesFertilizationAssitance(Boolean receivesFertilizationAssitance) {
        this.receivesFertilizationAssitance = receivesFertilizationAssitance;
    }

    public AssistedFertilizationSection remarks(String remarks) {
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
        AssistedFertilizationSection assistedFertilizationSection = (AssistedFertilizationSection) o;
        return Objects.equals(this.receivesFertilizationAssitance, assistedFertilizationSection.receivesFertilizationAssitance) &&
                Objects.equals(this.remarks, assistedFertilizationSection.remarks) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(receivesFertilizationAssitance, remarks, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AssistedFertilizationSection {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    receivesFertilizationAssitance: ").append(toIndentedString(receivesFertilizationAssitance)).append("\n");
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
