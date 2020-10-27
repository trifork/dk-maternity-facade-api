package dk.sds.nsp.maternity.data.data_card.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * BodyMeasuresSection
 */
public class BodyMeasuresSection extends VersionedSection {
    @JsonProperty("prenatalBodyWeight")
    private BodyMeasuresSectionPrenatalBodyWeight prenatalBodyWeight = null;

    @JsonProperty("bodyHeight")
    private BodyMeasuresSectionBodyHeight bodyHeight = null;

    @JsonProperty("bodyMassIndex")
    private BodyMeasuresSectionBodyMassIndex bodyMassIndex = null;

    public BodyMeasuresSection prenatalBodyWeight(BodyMeasuresSectionPrenatalBodyWeight prenatalBodyWeight) {
        this.prenatalBodyWeight = prenatalBodyWeight;
        return this;
    }

    /**
     * Get prenatalBodyWeight
     *
     * @return prenatalBodyWeight
     **/
    public BodyMeasuresSectionPrenatalBodyWeight getPrenatalBodyWeight() {
        return prenatalBodyWeight;
    }

    public void setPrenatalBodyWeight(BodyMeasuresSectionPrenatalBodyWeight prenatalBodyWeight) {
        this.prenatalBodyWeight = prenatalBodyWeight;
    }

    public BodyMeasuresSection bodyHeight(BodyMeasuresSectionBodyHeight bodyHeight) {
        this.bodyHeight = bodyHeight;
        return this;
    }

    /**
     * Get bodyHeight
     *
     * @return bodyHeight
     **/
    public BodyMeasuresSectionBodyHeight getBodyHeight() {
        return bodyHeight;
    }

    public void setBodyHeight(BodyMeasuresSectionBodyHeight bodyHeight) {
        this.bodyHeight = bodyHeight;
    }

    public BodyMeasuresSection bodyMassIndex(BodyMeasuresSectionBodyMassIndex bodyMassIndex) {
        this.bodyMassIndex = bodyMassIndex;
        return this;
    }

    /**
     * Get bodyMassIndex
     *
     * @return bodyMassIndex
     **/
    public BodyMeasuresSectionBodyMassIndex getBodyMassIndex() {
        return bodyMassIndex;
    }

    public void setBodyMassIndex(BodyMeasuresSectionBodyMassIndex bodyMassIndex) {
        this.bodyMassIndex = bodyMassIndex;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BodyMeasuresSection bodyMeasuresSection = (BodyMeasuresSection) o;
        return Objects.equals(this.prenatalBodyWeight, bodyMeasuresSection.prenatalBodyWeight) &&
                Objects.equals(this.bodyHeight, bodyMeasuresSection.bodyHeight) &&
                Objects.equals(this.bodyMassIndex, bodyMeasuresSection.bodyMassIndex) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prenatalBodyWeight, bodyHeight, bodyMassIndex, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BodyMeasuresSection {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    prenatalBodyWeight: ").append(toIndentedString(prenatalBodyWeight)).append("\n");
        sb.append("    bodyHeight: ").append(toIndentedString(bodyHeight)).append("\n");
        sb.append("    bodyMassIndex: ").append(toIndentedString(bodyMassIndex)).append("\n");
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
