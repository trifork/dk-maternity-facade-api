package dk.sds.nsp.maternity.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * PrenatalRiskAssessmentSection
 */
public class PrenatalRiskAssessmentSection {
    @JsonProperty("preliminaryRiskAssessment")
    private AllOfPrenatalRiskAssessmentSectionPreliminaryRiskAssessment preliminaryRiskAssessment = null;

    @JsonProperty("finalRiskAssessment")
    private AllOfPrenatalRiskAssessmentSectionFinalRiskAssessment finalRiskAssessment = null;

    public PrenatalRiskAssessmentSection preliminaryRiskAssessment(AllOfPrenatalRiskAssessmentSectionPreliminaryRiskAssessment preliminaryRiskAssessment) {
        this.preliminaryRiskAssessment = preliminaryRiskAssessment;
        return this;
    }

    /**
     * Get preliminaryRiskAssessment
     *
     * @return preliminaryRiskAssessment
     **/
    public AllOfPrenatalRiskAssessmentSectionPreliminaryRiskAssessment getPreliminaryRiskAssessment() {
        return preliminaryRiskAssessment;
    }

    public void setPreliminaryRiskAssessment(AllOfPrenatalRiskAssessmentSectionPreliminaryRiskAssessment preliminaryRiskAssessment) {
        this.preliminaryRiskAssessment = preliminaryRiskAssessment;
    }

    public PrenatalRiskAssessmentSection finalRiskAssessment(AllOfPrenatalRiskAssessmentSectionFinalRiskAssessment finalRiskAssessment) {
        this.finalRiskAssessment = finalRiskAssessment;
        return this;
    }

    /**
     * Get finalRiskAssessment
     *
     * @return finalRiskAssessment
     **/
    public AllOfPrenatalRiskAssessmentSectionFinalRiskAssessment getFinalRiskAssessment() {
        return finalRiskAssessment;
    }

    public void setFinalRiskAssessment(AllOfPrenatalRiskAssessmentSectionFinalRiskAssessment finalRiskAssessment) {
        this.finalRiskAssessment = finalRiskAssessment;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PrenatalRiskAssessmentSection prenatalRiskAssessmentSection = (PrenatalRiskAssessmentSection) o;
        return Objects.equals(this.preliminaryRiskAssessment, prenatalRiskAssessmentSection.preliminaryRiskAssessment) &&
                Objects.equals(this.finalRiskAssessment, prenatalRiskAssessmentSection.finalRiskAssessment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(preliminaryRiskAssessment, finalRiskAssessment);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PrenatalRiskAssessmentSection {\n");

        sb.append("    preliminaryRiskAssessment: ").append(toIndentedString(preliminaryRiskAssessment)).append("\n");
        sb.append("    finalRiskAssessment: ").append(toIndentedString(finalRiskAssessment)).append("\n");
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
