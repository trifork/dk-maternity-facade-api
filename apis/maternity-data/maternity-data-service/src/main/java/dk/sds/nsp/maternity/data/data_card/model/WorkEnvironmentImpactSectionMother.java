package dk.sds.nsp.maternity.data.data_card.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

/**
 * WorkEnvironmentImpactSectionMother
 */
public class WorkEnvironmentImpactSectionMother {
    @JsonProperty("jobType")
    private String jobType = null;

    @JsonProperty("hoursOfWorkPerWeek")
    private WorkEnvironmentImpactSectionMotherHoursOfWorkPerWeek hoursOfWorkPerWeek = null;

    @JsonProperty("ergonomicalWorkEnvironmentalImpact")
    private AllOfWorkEnvironmentImpactSectionMotherErgonomicalWorkEnvironmentalImpact ergonomicalWorkEnvironmentalImpact = null;

    @JsonProperty("chemicalWorkEnvironmentalImpact")
    private AllOfWorkEnvironmentImpactSectionMotherChemicalWorkEnvironmentalImpact chemicalWorkEnvironmentalImpact = null;

    @JsonProperty("biologicalWorkEnvironmentalImpact")
    private AllOfWorkEnvironmentImpactSectionMotherBiologicalWorkEnvironmentalImpact biologicalWorkEnvironmentalImpact = null;

    @JsonProperty("otherWorkEnvironmentalImpact")
    private AllOfWorkEnvironmentImpactSectionMotherOtherWorkEnvironmentalImpact otherWorkEnvironmentalImpact = null;

    @JsonProperty("referredToOccupationalHealthDepartmentForRiskAssessment")
    private Boolean referredToOccupationalHealthDepartmentForRiskAssessment = null;
    @JsonProperty("prenatalSickLeave")
    private PrenatalSickLeaveEnum prenatalSickLeave = null;

    public WorkEnvironmentImpactSectionMother jobType(String jobType) {
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

    public WorkEnvironmentImpactSectionMother hoursOfWorkPerWeek(WorkEnvironmentImpactSectionMotherHoursOfWorkPerWeek hoursOfWorkPerWeek) {
        this.hoursOfWorkPerWeek = hoursOfWorkPerWeek;
        return this;
    }

    /**
     * Get hoursOfWorkPerWeek
     *
     * @return hoursOfWorkPerWeek
     **/
public WorkEnvironmentImpactSectionMotherHoursOfWorkPerWeek getHoursOfWorkPerWeek() {
        return hoursOfWorkPerWeek;
    }

    public void setHoursOfWorkPerWeek(WorkEnvironmentImpactSectionMotherHoursOfWorkPerWeek hoursOfWorkPerWeek) {
        this.hoursOfWorkPerWeek = hoursOfWorkPerWeek;
    }

    public WorkEnvironmentImpactSectionMother ergonomicalWorkEnvironmentalImpact(AllOfWorkEnvironmentImpactSectionMotherErgonomicalWorkEnvironmentalImpact ergonomicalWorkEnvironmentalImpact) {
        this.ergonomicalWorkEnvironmentalImpact = ergonomicalWorkEnvironmentalImpact;
        return this;
    }

    /**
     * Get ergonomicalWorkEnvironmentalImpact
     *
     * @return ergonomicalWorkEnvironmentalImpact
     **/
    public AllOfWorkEnvironmentImpactSectionMotherErgonomicalWorkEnvironmentalImpact getErgonomicalWorkEnvironmentalImpact() {
        return ergonomicalWorkEnvironmentalImpact;
    }

    public void setErgonomicalWorkEnvironmentalImpact(AllOfWorkEnvironmentImpactSectionMotherErgonomicalWorkEnvironmentalImpact ergonomicalWorkEnvironmentalImpact) {
        this.ergonomicalWorkEnvironmentalImpact = ergonomicalWorkEnvironmentalImpact;
    }

    public WorkEnvironmentImpactSectionMother chemicalWorkEnvironmentalImpact(AllOfWorkEnvironmentImpactSectionMotherChemicalWorkEnvironmentalImpact chemicalWorkEnvironmentalImpact) {
        this.chemicalWorkEnvironmentalImpact = chemicalWorkEnvironmentalImpact;
        return this;
    }

    /**
     * Get chemicalWorkEnvironmentalImpact
     *
     * @return chemicalWorkEnvironmentalImpact
     **/
    public AllOfWorkEnvironmentImpactSectionMotherChemicalWorkEnvironmentalImpact getChemicalWorkEnvironmentalImpact() {
        return chemicalWorkEnvironmentalImpact;
    }

    public void setChemicalWorkEnvironmentalImpact(AllOfWorkEnvironmentImpactSectionMotherChemicalWorkEnvironmentalImpact chemicalWorkEnvironmentalImpact) {
        this.chemicalWorkEnvironmentalImpact = chemicalWorkEnvironmentalImpact;
    }

    public WorkEnvironmentImpactSectionMother biologicalWorkEnvironmentalImpact(AllOfWorkEnvironmentImpactSectionMotherBiologicalWorkEnvironmentalImpact biologicalWorkEnvironmentalImpact) {
        this.biologicalWorkEnvironmentalImpact = biologicalWorkEnvironmentalImpact;
        return this;
    }

    /**
     * Get biologicalWorkEnvironmentalImpact
     *
     * @return biologicalWorkEnvironmentalImpact
     **/
    public AllOfWorkEnvironmentImpactSectionMotherBiologicalWorkEnvironmentalImpact getBiologicalWorkEnvironmentalImpact() {
        return biologicalWorkEnvironmentalImpact;
    }

    public void setBiologicalWorkEnvironmentalImpact(AllOfWorkEnvironmentImpactSectionMotherBiologicalWorkEnvironmentalImpact biologicalWorkEnvironmentalImpact) {
        this.biologicalWorkEnvironmentalImpact = biologicalWorkEnvironmentalImpact;
    }

    public WorkEnvironmentImpactSectionMother otherWorkEnvironmentalImpact(AllOfWorkEnvironmentImpactSectionMotherOtherWorkEnvironmentalImpact otherWorkEnvironmentalImpact) {
        this.otherWorkEnvironmentalImpact = otherWorkEnvironmentalImpact;
        return this;
    }

    /**
     * Get otherWorkEnvironmentalImpact
     *
     * @return otherWorkEnvironmentalImpact
     **/
    public AllOfWorkEnvironmentImpactSectionMotherOtherWorkEnvironmentalImpact getOtherWorkEnvironmentalImpact() {
        return otherWorkEnvironmentalImpact;
    }

    public void setOtherWorkEnvironmentalImpact(AllOfWorkEnvironmentImpactSectionMotherOtherWorkEnvironmentalImpact otherWorkEnvironmentalImpact) {
        this.otherWorkEnvironmentalImpact = otherWorkEnvironmentalImpact;
    }

    public WorkEnvironmentImpactSectionMother referredToOccupationalHealthDepartmentForRiskAssessment(Boolean referredToOccupationalHealthDepartmentForRiskAssessment) {
        this.referredToOccupationalHealthDepartmentForRiskAssessment = referredToOccupationalHealthDepartmentForRiskAssessment;
        return this;
    }

    /**
     * Get referredToOccupationalHealthDepartmentForRiskAssessment
     *
     * @return referredToOccupationalHealthDepartmentForRiskAssessment
     **/
    public Boolean isReferredToOccupationalHealthDepartmentForRiskAssessment() {
        return referredToOccupationalHealthDepartmentForRiskAssessment;
    }

    public void setReferredToOccupationalHealthDepartmentForRiskAssessment(Boolean referredToOccupationalHealthDepartmentForRiskAssessment) {
        this.referredToOccupationalHealthDepartmentForRiskAssessment = referredToOccupationalHealthDepartmentForRiskAssessment;
    }

    public WorkEnvironmentImpactSectionMother prenatalSickLeave(PrenatalSickLeaveEnum prenatalSickLeave) {
        this.prenatalSickLeave = prenatalSickLeave;
        return this;
    }

    /**
     * Get prenatalSickLeave
     *
     * @return prenatalSickLeave
     **/
    public PrenatalSickLeaveEnum getPrenatalSickLeave() {
        return prenatalSickLeave;
    }

    public void setPrenatalSickLeave(PrenatalSickLeaveEnum prenatalSickLeave) {
        this.prenatalSickLeave = prenatalSickLeave;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WorkEnvironmentImpactSectionMother workEnvironmentImpactSectionMother = (WorkEnvironmentImpactSectionMother) o;
        return Objects.equals(this.jobType, workEnvironmentImpactSectionMother.jobType) &&
                Objects.equals(this.hoursOfWorkPerWeek, workEnvironmentImpactSectionMother.hoursOfWorkPerWeek) &&
                Objects.equals(this.ergonomicalWorkEnvironmentalImpact, workEnvironmentImpactSectionMother.ergonomicalWorkEnvironmentalImpact) &&
                Objects.equals(this.chemicalWorkEnvironmentalImpact, workEnvironmentImpactSectionMother.chemicalWorkEnvironmentalImpact) &&
                Objects.equals(this.biologicalWorkEnvironmentalImpact, workEnvironmentImpactSectionMother.biologicalWorkEnvironmentalImpact) &&
                Objects.equals(this.otherWorkEnvironmentalImpact, workEnvironmentImpactSectionMother.otherWorkEnvironmentalImpact) &&
                Objects.equals(this.referredToOccupationalHealthDepartmentForRiskAssessment, workEnvironmentImpactSectionMother.referredToOccupationalHealthDepartmentForRiskAssessment) &&
                Objects.equals(this.prenatalSickLeave, workEnvironmentImpactSectionMother.prenatalSickLeave);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobType, hoursOfWorkPerWeek, ergonomicalWorkEnvironmentalImpact, chemicalWorkEnvironmentalImpact, biologicalWorkEnvironmentalImpact, otherWorkEnvironmentalImpact, referredToOccupationalHealthDepartmentForRiskAssessment, prenatalSickLeave);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class WorkEnvironmentImpactSectionMother {\n");

        sb.append("    jobType: ").append(toIndentedString(jobType)).append("\n");
        sb.append("    hoursOfWorkPerWeek: ").append(toIndentedString(hoursOfWorkPerWeek)).append("\n");
        sb.append("    ergonomicalWorkEnvironmentalImpact: ").append(toIndentedString(ergonomicalWorkEnvironmentalImpact)).append("\n");
        sb.append("    chemicalWorkEnvironmentalImpact: ").append(toIndentedString(chemicalWorkEnvironmentalImpact)).append("\n");
        sb.append("    biologicalWorkEnvironmentalImpact: ").append(toIndentedString(biologicalWorkEnvironmentalImpact)).append("\n");
        sb.append("    otherWorkEnvironmentalImpact: ").append(toIndentedString(otherWorkEnvironmentalImpact)).append("\n");
        sb.append("    referredToOccupationalHealthDepartmentForRiskAssessment: ").append(toIndentedString(referredToOccupationalHealthDepartmentForRiskAssessment)).append("\n");
        sb.append("    prenatalSickLeave: ").append(toIndentedString(prenatalSickLeave)).append("\n");
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

    /**
     * Gets or Sets prenatalSickLeave
     */
    public enum PrenatalSickLeaveEnum {
        NONE("none"),

        PARTIAL("partial"),

        FULL("full");

        private String value;

        PrenatalSickLeaveEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static PrenatalSickLeaveEnum fromValue(String text) {
            for (PrenatalSickLeaveEnum b : PrenatalSickLeaveEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }
    }
}
