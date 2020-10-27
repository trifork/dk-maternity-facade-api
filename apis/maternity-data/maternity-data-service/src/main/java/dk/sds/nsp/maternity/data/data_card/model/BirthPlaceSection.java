package dk.sds.nsp.maternity.data.data_card.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * BirthPlaceSection
 */
public class BirthPlaceSection extends VersionedSection {
    @JsonProperty("desiredBirthPlace")
    private String desiredBirthPlace = null;

    @JsonProperty("primaryPlannedBirthPlace")
    private HealthCareOrganization primaryPlannedBirthPlace = null;

    @JsonProperty("revisedPlannedBirthPlace")
    private HealthCareOrganization revisedPlannedBirthPlace = null;

    public BirthPlaceSection desiredBirthPlace(String desiredBirthPlace) {
        this.desiredBirthPlace = desiredBirthPlace;
        return this;
    }

    /**
     * Get desiredBirthPlace
     *
     * @return desiredBirthPlace
     **/
    public String getDesiredBirthPlace() {
        return desiredBirthPlace;
    }

    public void setDesiredBirthPlace(String desiredBirthPlace) {
        this.desiredBirthPlace = desiredBirthPlace;
    }

    public BirthPlaceSection primaryPlannedBirthPlace(HealthCareOrganization primaryPlannedBirthPlace) {
        this.primaryPlannedBirthPlace = primaryPlannedBirthPlace;
        return this;
    }

    /**
     * Get primaryPlannedBirthPlace
     *
     * @return primaryPlannedBirthPlace
     **/
    public HealthCareOrganization getPrimaryPlannedBirthPlace() {
        return primaryPlannedBirthPlace;
    }

    public void setPrimaryPlannedBirthPlace(HealthCareOrganization primaryPlannedBirthPlace) {
        this.primaryPlannedBirthPlace = primaryPlannedBirthPlace;
    }

    public BirthPlaceSection revisedPlannedBirthPlace(HealthCareOrganization revisedPlannedBirthPlace) {
        this.revisedPlannedBirthPlace = revisedPlannedBirthPlace;
        return this;
    }

    /**
     * Get revisedPlannedBirthPlace
     *
     * @return revisedPlannedBirthPlace
     **/
    public HealthCareOrganization getRevisedPlannedBirthPlace() {
        return revisedPlannedBirthPlace;
    }

    public void setRevisedPlannedBirthPlace(HealthCareOrganization revisedPlannedBirthPlace) {
        this.revisedPlannedBirthPlace = revisedPlannedBirthPlace;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BirthPlaceSection birthPlaceSection = (BirthPlaceSection) o;
        return Objects.equals(this.desiredBirthPlace, birthPlaceSection.desiredBirthPlace) &&
                Objects.equals(this.primaryPlannedBirthPlace, birthPlaceSection.primaryPlannedBirthPlace) &&
                Objects.equals(this.revisedPlannedBirthPlace, birthPlaceSection.revisedPlannedBirthPlace) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(desiredBirthPlace, primaryPlannedBirthPlace, revisedPlannedBirthPlace, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BirthPlaceSection {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    desiredBirthPlace: ").append(toIndentedString(desiredBirthPlace)).append("\n");
        sb.append("    primaryPlannedBirthPlace: ").append(toIndentedString(primaryPlannedBirthPlace)).append("\n");
        sb.append("    revisedPlannedBirthPlace: ").append(toIndentedString(revisedPlannedBirthPlace)).append("\n");
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
