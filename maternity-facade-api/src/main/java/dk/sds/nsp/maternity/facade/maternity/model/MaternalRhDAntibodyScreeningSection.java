package dk.sds.nsp.maternity.facade.maternity.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * MaternalRhDAntibodyScreeningSection
 */
public class MaternalRhDAntibodyScreeningSection extends VersionedSection {
    @JsonProperty("bloodSampleTaken")
    private YesNoEnum bloodSampleTaken = null;

    @JsonProperty("rhesusType")
    private PosNegEnum rhesusType = null;

    @JsonProperty("irregularBloodGroupAntibodyOresent")
    private PosNegEnum irregularBloodGroupAntibodyOresent = null;

    public MaternalRhDAntibodyScreeningSection bloodSampleTaken(YesNoEnum bloodSampleTaken) {
        this.bloodSampleTaken = bloodSampleTaken;
        return this;
    }

    /**
     * Get bloodSampleTaken
     *
     * @return bloodSampleTaken
     **/
public YesNoEnum getBloodSampleTaken() {
        return bloodSampleTaken;
    }

    public void setBloodSampleTaken(YesNoEnum bloodSampleTaken) {
        this.bloodSampleTaken = bloodSampleTaken;
    }

    public MaternalRhDAntibodyScreeningSection rhesusType(PosNegEnum rhesusType) {
        this.rhesusType = rhesusType;
        return this;
    }

    /**
     * Get rhesusType
     *
     * @return rhesusType
     **/
public PosNegEnum getRhesusType() {
        return rhesusType;
    }

    public void setRhesusType(PosNegEnum rhesusType) {
        this.rhesusType = rhesusType;
    }

    public MaternalRhDAntibodyScreeningSection irregularBloodGroupAntibodyOresent(PosNegEnum irregularBloodGroupAntibodyOresent) {
        this.irregularBloodGroupAntibodyOresent = irregularBloodGroupAntibodyOresent;
        return this;
    }

    /**
     * Get irregularBloodGroupAntibodyOresent
     *
     * @return irregularBloodGroupAntibodyOresent
     **/
public PosNegEnum getIrregularBloodGroupAntibodyOresent() {
        return irregularBloodGroupAntibodyOresent;
    }

    public void setIrregularBloodGroupAntibodyOresent(PosNegEnum irregularBloodGroupAntibodyOresent) {
        this.irregularBloodGroupAntibodyOresent = irregularBloodGroupAntibodyOresent;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MaternalRhDAntibodyScreeningSection maternalRhDAntibodyScreeningSection = (MaternalRhDAntibodyScreeningSection) o;
        return Objects.equals(this.bloodSampleTaken, maternalRhDAntibodyScreeningSection.bloodSampleTaken) &&
                Objects.equals(this.rhesusType, maternalRhDAntibodyScreeningSection.rhesusType) &&
                Objects.equals(this.irregularBloodGroupAntibodyOresent, maternalRhDAntibodyScreeningSection.irregularBloodGroupAntibodyOresent) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bloodSampleTaken, rhesusType, irregularBloodGroupAntibodyOresent, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MaternalRhDAntibodyScreeningSection {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    bloodSampleTaken: ").append(toIndentedString(bloodSampleTaken)).append("\n");
        sb.append("    rhesusType: ").append(toIndentedString(rhesusType)).append("\n");
        sb.append("    irregularBloodGroupAntibodyOresent: ").append(toIndentedString(irregularBloodGroupAntibodyOresent)).append("\n");
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
