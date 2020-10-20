package dk.sds.nsp.maternity.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * ChronicDiseasesSection
 */
public class ChronicDiseasesSection extends VersionedSection {
    @JsonProperty("circulatorySystem")
    private YesNoEnum circulatorySystem = null;

    @JsonProperty("respitorySystem")
    private YesNoEnum respitorySystem = null;

    @JsonProperty("thyroid")
    private YesNoEnum thyroid = null;

    @JsonProperty("diabetes")
    private YesNoEnum diabetes = null;

    public ChronicDiseasesSection circulatorySystem(YesNoEnum circulatorySystem) {
        this.circulatorySystem = circulatorySystem;
        return this;
    }

    /**
     * Get circulatorySystem
     *
     * @return circulatorySystem
     **/
    public YesNoEnum getCirculatorySystem() {
        return circulatorySystem;
    }

    public void setCirculatorySystem(YesNoEnum circulatorySystem) {
        this.circulatorySystem = circulatorySystem;
    }

    public ChronicDiseasesSection respitorySystem(YesNoEnum respitorySystem) {
        this.respitorySystem = respitorySystem;
        return this;
    }

    /**
     * Get respitorySystem
     *
     * @return respitorySystem
     **/
    public YesNoEnum getRespitorySystem() {
        return respitorySystem;
    }

    public void setRespitorySystem(YesNoEnum respitorySystem) {
        this.respitorySystem = respitorySystem;
    }

    public ChronicDiseasesSection thyroid(YesNoEnum thyroid) {
        this.thyroid = thyroid;
        return this;
    }

    /**
     * Get thyroid
     *
     * @return thyroid
     **/
    public YesNoEnum getThyroid() {
        return thyroid;
    }

    public void setThyroid(YesNoEnum thyroid) {
        this.thyroid = thyroid;
    }

    public ChronicDiseasesSection diabetes(YesNoEnum diabetes) {
        this.diabetes = diabetes;
        return this;
    }

    /**
     * Get diabetes
     *
     * @return diabetes
     **/
    public YesNoEnum getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(YesNoEnum diabetes) {
        this.diabetes = diabetes;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChronicDiseasesSection chronicDiseasesSection = (ChronicDiseasesSection) o;
        return Objects.equals(this.circulatorySystem, chronicDiseasesSection.circulatorySystem) &&
                Objects.equals(this.respitorySystem, chronicDiseasesSection.respitorySystem) &&
                Objects.equals(this.thyroid, chronicDiseasesSection.thyroid) &&
                Objects.equals(this.diabetes, chronicDiseasesSection.diabetes) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(circulatorySystem, respitorySystem, thyroid, diabetes, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ChronicDiseasesSection {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    circulatorySystem: ").append(toIndentedString(circulatorySystem)).append("\n");
        sb.append("    respitorySystem: ").append(toIndentedString(respitorySystem)).append("\n");
        sb.append("    thyroid: ").append(toIndentedString(thyroid)).append("\n");
        sb.append("    diabetes: ").append(toIndentedString(diabetes)).append("\n");
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
