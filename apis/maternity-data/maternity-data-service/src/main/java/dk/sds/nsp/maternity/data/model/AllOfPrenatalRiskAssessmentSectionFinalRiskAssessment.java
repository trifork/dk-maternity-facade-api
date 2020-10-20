package dk.sds.nsp.maternity.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * AllOfPrenatalRiskAssessmentSectionFinalRiskAssessment
 */
public class AllOfPrenatalRiskAssessmentSectionFinalRiskAssessment extends VersionedSection {
    @JsonProperty("doubleTestCompleted")
    private Boolean doubleTestCompleted = null;

    @JsonProperty("firstTrimesterUltrasoundScanOfFetusCompleted")
    private Boolean firstTrimesterUltrasoundScanOfFetusCompleted = null;

    @JsonProperty("secondTrimesterUltrasoundScanOfFetusCompleted")
    private Boolean secondTrimesterUltrasoundScanOfFetusCompleted = null;

    @JsonProperty("downsScreeningProbabilityAssessment")
    private String downsScreeningProbabilityAssessment = null;

    @JsonProperty("placentalBiopsiObservation")
    private Object placentalBiopsiObservation = null;

    @JsonProperty("prenatalAmniocentesisiObservation")
    private Object prenatalAmniocentesisiObservation = null;

    public AllOfPrenatalRiskAssessmentSectionFinalRiskAssessment doubleTestCompleted(Boolean doubleTestCompleted) {
        this.doubleTestCompleted = doubleTestCompleted;
        return this;
    }

    /**
     * Get doubleTestCompleted
     *
     * @return doubleTestCompleted
     **/
    public Boolean isDoubleTestCompleted() {
        return doubleTestCompleted;
    }

    public void setDoubleTestCompleted(Boolean doubleTestCompleted) {
        this.doubleTestCompleted = doubleTestCompleted;
    }

    public AllOfPrenatalRiskAssessmentSectionFinalRiskAssessment firstTrimesterUltrasoundScanOfFetusCompleted(Boolean firstTrimesterUltrasoundScanOfFetusCompleted) {
        this.firstTrimesterUltrasoundScanOfFetusCompleted = firstTrimesterUltrasoundScanOfFetusCompleted;
        return this;
    }

    /**
     * Get firstTrimesterUltrasoundScanOfFetusCompleted
     *
     * @return firstTrimesterUltrasoundScanOfFetusCompleted
     **/
    public Boolean isFirstTrimesterUltrasoundScanOfFetusCompleted() {
        return firstTrimesterUltrasoundScanOfFetusCompleted;
    }

    public void setFirstTrimesterUltrasoundScanOfFetusCompleted(Boolean firstTrimesterUltrasoundScanOfFetusCompleted) {
        this.firstTrimesterUltrasoundScanOfFetusCompleted = firstTrimesterUltrasoundScanOfFetusCompleted;
    }

    public AllOfPrenatalRiskAssessmentSectionFinalRiskAssessment secondTrimesterUltrasoundScanOfFetusCompleted(Boolean secondTrimesterUltrasoundScanOfFetusCompleted) {
        this.secondTrimesterUltrasoundScanOfFetusCompleted = secondTrimesterUltrasoundScanOfFetusCompleted;
        return this;
    }

    /**
     * Get secondTrimesterUltrasoundScanOfFetusCompleted
     *
     * @return secondTrimesterUltrasoundScanOfFetusCompleted
     **/
    public Boolean isSecondTrimesterUltrasoundScanOfFetusCompleted() {
        return secondTrimesterUltrasoundScanOfFetusCompleted;
    }

    public void setSecondTrimesterUltrasoundScanOfFetusCompleted(Boolean secondTrimesterUltrasoundScanOfFetusCompleted) {
        this.secondTrimesterUltrasoundScanOfFetusCompleted = secondTrimesterUltrasoundScanOfFetusCompleted;
    }

    public AllOfPrenatalRiskAssessmentSectionFinalRiskAssessment downsScreeningProbabilityAssessment(String downsScreeningProbabilityAssessment) {
        this.downsScreeningProbabilityAssessment = downsScreeningProbabilityAssessment;
        return this;
    }

    /**
     * Get downsScreeningProbabilityAssessment
     *
     * @return downsScreeningProbabilityAssessment
     **/
    public String getDownsScreeningProbabilityAssessment() {
        return downsScreeningProbabilityAssessment;
    }

    public void setDownsScreeningProbabilityAssessment(String downsScreeningProbabilityAssessment) {
        this.downsScreeningProbabilityAssessment = downsScreeningProbabilityAssessment;
    }

    public AllOfPrenatalRiskAssessmentSectionFinalRiskAssessment placentalBiopsiObservation(Object placentalBiopsiObservation) {
        this.placentalBiopsiObservation = placentalBiopsiObservation;
        return this;
    }

    /**
     * Get placentalBiopsiObservation
     *
     * @return placentalBiopsiObservation
     **/
    public Object getPlacentalBiopsiObservation() {
        return placentalBiopsiObservation;
    }

    public void setPlacentalBiopsiObservation(Object placentalBiopsiObservation) {
        this.placentalBiopsiObservation = placentalBiopsiObservation;
    }

    public AllOfPrenatalRiskAssessmentSectionFinalRiskAssessment prenatalAmniocentesisiObservation(Object prenatalAmniocentesisiObservation) {
        this.prenatalAmniocentesisiObservation = prenatalAmniocentesisiObservation;
        return this;
    }

    /**
     * Get prenatalAmniocentesisiObservation
     *
     * @return prenatalAmniocentesisiObservation
     **/
    public Object getPrenatalAmniocentesisiObservation() {
        return prenatalAmniocentesisiObservation;
    }

    public void setPrenatalAmniocentesisiObservation(Object prenatalAmniocentesisiObservation) {
        this.prenatalAmniocentesisiObservation = prenatalAmniocentesisiObservation;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AllOfPrenatalRiskAssessmentSectionFinalRiskAssessment allOfPrenatalRiskAssessmentSectionFinalRiskAssessment = (AllOfPrenatalRiskAssessmentSectionFinalRiskAssessment) o;
        return Objects.equals(this.doubleTestCompleted, allOfPrenatalRiskAssessmentSectionFinalRiskAssessment.doubleTestCompleted) &&
                Objects.equals(this.firstTrimesterUltrasoundScanOfFetusCompleted, allOfPrenatalRiskAssessmentSectionFinalRiskAssessment.firstTrimesterUltrasoundScanOfFetusCompleted) &&
                Objects.equals(this.secondTrimesterUltrasoundScanOfFetusCompleted, allOfPrenatalRiskAssessmentSectionFinalRiskAssessment.secondTrimesterUltrasoundScanOfFetusCompleted) &&
                Objects.equals(this.downsScreeningProbabilityAssessment, allOfPrenatalRiskAssessmentSectionFinalRiskAssessment.downsScreeningProbabilityAssessment) &&
                Objects.equals(this.placentalBiopsiObservation, allOfPrenatalRiskAssessmentSectionFinalRiskAssessment.placentalBiopsiObservation) &&
                Objects.equals(this.prenatalAmniocentesisiObservation, allOfPrenatalRiskAssessmentSectionFinalRiskAssessment.prenatalAmniocentesisiObservation) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doubleTestCompleted, firstTrimesterUltrasoundScanOfFetusCompleted, secondTrimesterUltrasoundScanOfFetusCompleted, downsScreeningProbabilityAssessment, placentalBiopsiObservation, prenatalAmniocentesisiObservation, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AllOfPrenatalRiskAssessmentSectionFinalRiskAssessment {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    doubleTestCompleted: ").append(toIndentedString(doubleTestCompleted)).append("\n");
        sb.append("    firstTrimesterUltrasoundScanOfFetusCompleted: ").append(toIndentedString(firstTrimesterUltrasoundScanOfFetusCompleted)).append("\n");
        sb.append("    secondTrimesterUltrasoundScanOfFetusCompleted: ").append(toIndentedString(secondTrimesterUltrasoundScanOfFetusCompleted)).append("\n");
        sb.append("    downsScreeningProbabilityAssessment: ").append(toIndentedString(downsScreeningProbabilityAssessment)).append("\n");
        sb.append("    placentalBiopsiObservation: ").append(toIndentedString(placentalBiopsiObservation)).append("\n");
        sb.append("    prenatalAmniocentesisiObservation: ").append(toIndentedString(prenatalAmniocentesisiObservation)).append("\n");
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
