package dk.sds.nsp.maternity.facade.maternity.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * OverallAssessmentSection
 */
public class OverallAssessmentSection extends VersionedSection {
    @JsonProperty("prenatalCareAssessment")
    private OverallAssessmentSectionPrenatalCareAssessment prenatalCareAssessment = null;

    @JsonProperty("obstetricAssessment")
    private Object obstetricAssessment = null;

    @JsonProperty("socialServicesPerinatalCareAssessment")
    private Object socialServicesPerinatalCareAssessment = null;

    public OverallAssessmentSection prenatalCareAssessment(OverallAssessmentSectionPrenatalCareAssessment prenatalCareAssessment) {
        this.prenatalCareAssessment = prenatalCareAssessment;
        return this;
    }

    /**
     * Get prenatalCareAssessment
     *
     * @return prenatalCareAssessment
     **/
public OverallAssessmentSectionPrenatalCareAssessment getPrenatalCareAssessment() {
        return prenatalCareAssessment;
    }

    public void setPrenatalCareAssessment(OverallAssessmentSectionPrenatalCareAssessment prenatalCareAssessment) {
        this.prenatalCareAssessment = prenatalCareAssessment;
    }

    public OverallAssessmentSection obstetricAssessment(Object obstetricAssessment) {
        this.obstetricAssessment = obstetricAssessment;
        return this;
    }

    /**
     * Get obstetricAssessment
     *
     * @return obstetricAssessment
     **/
    public Object getObstetricAssessment() {
        return obstetricAssessment;
    }

    public void setObstetricAssessment(Object obstetricAssessment) {
        this.obstetricAssessment = obstetricAssessment;
    }

    public OverallAssessmentSection socialServicesPerinatalCareAssessment(Object socialServicesPerinatalCareAssessment) {
        this.socialServicesPerinatalCareAssessment = socialServicesPerinatalCareAssessment;
        return this;
    }

    /**
     * Get socialServicesPerinatalCareAssessment
     *
     * @return socialServicesPerinatalCareAssessment
     **/
    public Object getSocialServicesPerinatalCareAssessment() {
        return socialServicesPerinatalCareAssessment;
    }

    public void setSocialServicesPerinatalCareAssessment(Object socialServicesPerinatalCareAssessment) {
        this.socialServicesPerinatalCareAssessment = socialServicesPerinatalCareAssessment;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OverallAssessmentSection overallAssessmentSection = (OverallAssessmentSection) o;
        return Objects.equals(this.prenatalCareAssessment, overallAssessmentSection.prenatalCareAssessment) &&
                Objects.equals(this.obstetricAssessment, overallAssessmentSection.obstetricAssessment) &&
                Objects.equals(this.socialServicesPerinatalCareAssessment, overallAssessmentSection.socialServicesPerinatalCareAssessment) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prenatalCareAssessment, obstetricAssessment, socialServicesPerinatalCareAssessment, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OverallAssessmentSection {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    prenatalCareAssessment: ").append(toIndentedString(prenatalCareAssessment)).append("\n");
        sb.append("    obstetricAssessment: ").append(toIndentedString(obstetricAssessment)).append("\n");
        sb.append("    socialServicesPerinatalCareAssessment: ").append(toIndentedString(socialServicesPerinatalCareAssessment)).append("\n");
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
