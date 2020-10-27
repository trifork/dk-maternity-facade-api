package dk.sds.nsp.maternity.data.data_card.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * FetalRhDAntibodyScreeningSection
 */
public class FetalRhDAntibodyScreeningSection extends VersionedSection {
    @JsonProperty("rhesusType")
    private PosNegEnum rhesusType = null;

    @JsonProperty("antiDIsoimmunizationAffectingPregnancy")
    private PosNegEnum antiDIsoimmunizationAffectingPregnancy = null;

    public FetalRhDAntibodyScreeningSection rhesusType(PosNegEnum rhesusType) {
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

    public FetalRhDAntibodyScreeningSection antiDIsoimmunizationAffectingPregnancy(PosNegEnum antiDIsoimmunizationAffectingPregnancy) {
        this.antiDIsoimmunizationAffectingPregnancy = antiDIsoimmunizationAffectingPregnancy;
        return this;
    }

    /**
     * Get antiDIsoimmunizationAffectingPregnancy
     *
     * @return antiDIsoimmunizationAffectingPregnancy
     **/
public PosNegEnum getAntiDIsoimmunizationAffectingPregnancy() {
        return antiDIsoimmunizationAffectingPregnancy;
    }

    public void setAntiDIsoimmunizationAffectingPregnancy(PosNegEnum antiDIsoimmunizationAffectingPregnancy) {
        this.antiDIsoimmunizationAffectingPregnancy = antiDIsoimmunizationAffectingPregnancy;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FetalRhDAntibodyScreeningSection fetalRhDAntibodyScreeningSection = (FetalRhDAntibodyScreeningSection) o;
        return Objects.equals(this.rhesusType, fetalRhDAntibodyScreeningSection.rhesusType) &&
                Objects.equals(this.antiDIsoimmunizationAffectingPregnancy, fetalRhDAntibodyScreeningSection.antiDIsoimmunizationAffectingPregnancy) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rhesusType, antiDIsoimmunizationAffectingPregnancy, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FetalRhDAntibodyScreeningSection {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    rhesusType: ").append(toIndentedString(rhesusType)).append("\n");
        sb.append("    antiDIsoimmunizationAffectingPregnancy: ").append(toIndentedString(antiDIsoimmunizationAffectingPregnancy)).append("\n");
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
