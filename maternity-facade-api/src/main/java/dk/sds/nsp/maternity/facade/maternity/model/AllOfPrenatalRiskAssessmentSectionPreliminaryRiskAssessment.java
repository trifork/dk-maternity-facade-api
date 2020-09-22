package dk.sds.nsp.maternity.facade.maternity.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * AllOfPrenatalRiskAssessmentSectionPreliminaryRiskAssessment
 */
public class AllOfPrenatalRiskAssessmentSectionPreliminaryRiskAssessment extends VersionedSection {
    @JsonProperty("familyHistory")
    private String familyHistory = null;

    @JsonProperty("consanguinity")
    private Boolean consanguinity = null;

    @JsonProperty("firstTrimesterUltrasoundScanOfFetusRequested")
    private Boolean firstTrimesterUltrasoundScanOfFetusRequested = null;

    @JsonProperty("secondTrimesterUltrasoundScanOfFetusRequested")
    private Boolean secondTrimesterUltrasoundScanOfFetusRequested = null;

    @JsonProperty("prenatalRiskAssessmentRequested")
    private Boolean prenatalRiskAssessmentRequested = null;

    public AllOfPrenatalRiskAssessmentSectionPreliminaryRiskAssessment familyHistory(String familyHistory) {
        this.familyHistory = familyHistory;
        return this;
    }

    /**
     * Get familyHistory
     *
     * @return familyHistory
     **/
    public String getFamilyHistory() {
        return familyHistory;
    }

    public void setFamilyHistory(String familyHistory) {
        this.familyHistory = familyHistory;
    }

    public AllOfPrenatalRiskAssessmentSectionPreliminaryRiskAssessment consanguinity(Boolean consanguinity) {
        this.consanguinity = consanguinity;
        return this;
    }

    /**
     * Get consanguinity
     *
     * @return consanguinity
     **/
    public Boolean isConsanguinity() {
        return consanguinity;
    }

    public void setConsanguinity(Boolean consanguinity) {
        this.consanguinity = consanguinity;
    }

    public AllOfPrenatalRiskAssessmentSectionPreliminaryRiskAssessment firstTrimesterUltrasoundScanOfFetusRequested(Boolean firstTrimesterUltrasoundScanOfFetusRequested) {
        this.firstTrimesterUltrasoundScanOfFetusRequested = firstTrimesterUltrasoundScanOfFetusRequested;
        return this;
    }

    /**
     * Get firstTrimesterUltrasoundScanOfFetusRequested
     *
     * @return firstTrimesterUltrasoundScanOfFetusRequested
     **/
    public Boolean isFirstTrimesterUltrasoundScanOfFetusRequested() {
        return firstTrimesterUltrasoundScanOfFetusRequested;
    }

    public void setFirstTrimesterUltrasoundScanOfFetusRequested(Boolean firstTrimesterUltrasoundScanOfFetusRequested) {
        this.firstTrimesterUltrasoundScanOfFetusRequested = firstTrimesterUltrasoundScanOfFetusRequested;
    }

    public AllOfPrenatalRiskAssessmentSectionPreliminaryRiskAssessment secondTrimesterUltrasoundScanOfFetusRequested(Boolean secondTrimesterUltrasoundScanOfFetusRequested) {
        this.secondTrimesterUltrasoundScanOfFetusRequested = secondTrimesterUltrasoundScanOfFetusRequested;
        return this;
    }

    /**
     * Get secondTrimesterUltrasoundScanOfFetusRequested
     *
     * @return secondTrimesterUltrasoundScanOfFetusRequested
     **/
    public Boolean isSecondTrimesterUltrasoundScanOfFetusRequested() {
        return secondTrimesterUltrasoundScanOfFetusRequested;
    }

    public void setSecondTrimesterUltrasoundScanOfFetusRequested(Boolean secondTrimesterUltrasoundScanOfFetusRequested) {
        this.secondTrimesterUltrasoundScanOfFetusRequested = secondTrimesterUltrasoundScanOfFetusRequested;
    }

    public AllOfPrenatalRiskAssessmentSectionPreliminaryRiskAssessment prenatalRiskAssessmentRequested(Boolean prenatalRiskAssessmentRequested) {
        this.prenatalRiskAssessmentRequested = prenatalRiskAssessmentRequested;
        return this;
    }

    /**
     * Get prenatalRiskAssessmentRequested
     *
     * @return prenatalRiskAssessmentRequested
     **/
    public Boolean isPrenatalRiskAssessmentRequested() {
        return prenatalRiskAssessmentRequested;
    }

    public void setPrenatalRiskAssessmentRequested(Boolean prenatalRiskAssessmentRequested) {
        this.prenatalRiskAssessmentRequested = prenatalRiskAssessmentRequested;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AllOfPrenatalRiskAssessmentSectionPreliminaryRiskAssessment allOfPrenatalRiskAssessmentSectionPreliminaryRiskAssessment = (AllOfPrenatalRiskAssessmentSectionPreliminaryRiskAssessment) o;
        return Objects.equals(this.familyHistory, allOfPrenatalRiskAssessmentSectionPreliminaryRiskAssessment.familyHistory) &&
                Objects.equals(this.consanguinity, allOfPrenatalRiskAssessmentSectionPreliminaryRiskAssessment.consanguinity) &&
                Objects.equals(this.firstTrimesterUltrasoundScanOfFetusRequested, allOfPrenatalRiskAssessmentSectionPreliminaryRiskAssessment.firstTrimesterUltrasoundScanOfFetusRequested) &&
                Objects.equals(this.secondTrimesterUltrasoundScanOfFetusRequested, allOfPrenatalRiskAssessmentSectionPreliminaryRiskAssessment.secondTrimesterUltrasoundScanOfFetusRequested) &&
                Objects.equals(this.prenatalRiskAssessmentRequested, allOfPrenatalRiskAssessmentSectionPreliminaryRiskAssessment.prenatalRiskAssessmentRequested) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(familyHistory, consanguinity, firstTrimesterUltrasoundScanOfFetusRequested, secondTrimesterUltrasoundScanOfFetusRequested, prenatalRiskAssessmentRequested, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AllOfPrenatalRiskAssessmentSectionPreliminaryRiskAssessment {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    familyHistory: ").append(toIndentedString(familyHistory)).append("\n");
        sb.append("    consanguinity: ").append(toIndentedString(consanguinity)).append("\n");
        sb.append("    firstTrimesterUltrasoundScanOfFetusRequested: ").append(toIndentedString(firstTrimesterUltrasoundScanOfFetusRequested)).append("\n");
        sb.append("    secondTrimesterUltrasoundScanOfFetusRequested: ").append(toIndentedString(secondTrimesterUltrasoundScanOfFetusRequested)).append("\n");
        sb.append("    prenatalRiskAssessmentRequested: ").append(toIndentedString(prenatalRiskAssessmentRequested)).append("\n");
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
