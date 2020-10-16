package dk.sds.nsp.maternity.facade.maternity.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * SubstanceUseSection
 */
public class SubstanceUseSection extends VersionedSection {
    @JsonProperty("substanceUseBeforePregnancy")
    private SubstanceUseObservation substanceUseBeforePregnancy = null;

    @JsonProperty("substanceUseDuringPregnancy")
    private SubstanceUseObservation substanceUseDuringPregnancy = null;

    public SubstanceUseSection substanceUseBeforePregnancy(SubstanceUseObservation substanceUseBeforePregnancy) {
        this.substanceUseBeforePregnancy = substanceUseBeforePregnancy;
        return this;
    }

    /**
     * Get substanceUseBeforePregnancy
     *
     * @return substanceUseBeforePregnancy
     **/
    public SubstanceUseObservation getSubstanceUseBeforePregnancy() {
        return substanceUseBeforePregnancy;
    }

    public void setSubstanceUseBeforePregnancy(SubstanceUseObservation substanceUseBeforePregnancy) {
        this.substanceUseBeforePregnancy = substanceUseBeforePregnancy;
    }

    public SubstanceUseSection substanceUseDuringPregnancy(SubstanceUseObservation substanceUseDuringPregnancy) {
        this.substanceUseDuringPregnancy = substanceUseDuringPregnancy;
        return this;
    }

    /**
     * Get substanceUseDuringPregnancy
     *
     * @return substanceUseDuringPregnancy
     **/
    public SubstanceUseObservation getSubstanceUseDuringPregnancy() {
        return substanceUseDuringPregnancy;
    }

    public void setSubstanceUseDuringPregnancy(SubstanceUseObservation substanceUseDuringPregnancy) {
        this.substanceUseDuringPregnancy = substanceUseDuringPregnancy;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SubstanceUseSection substanceUseSection = (SubstanceUseSection) o;
        return Objects.equals(this.substanceUseBeforePregnancy, substanceUseSection.substanceUseBeforePregnancy) &&
                Objects.equals(this.substanceUseDuringPregnancy, substanceUseSection.substanceUseDuringPregnancy) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(substanceUseBeforePregnancy, substanceUseDuringPregnancy, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SubstanceUseSection {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    substanceUseBeforePregnancy: ").append(toIndentedString(substanceUseBeforePregnancy)).append("\n");
        sb.append("    substanceUseDuringPregnancy: ").append(toIndentedString(substanceUseDuringPregnancy)).append("\n");
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
