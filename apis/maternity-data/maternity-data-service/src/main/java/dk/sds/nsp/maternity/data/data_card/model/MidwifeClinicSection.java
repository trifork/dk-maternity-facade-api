package dk.sds.nsp.maternity.data.data_card.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Objects;

/**
 * MidwifeClinicSection
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "parentalCraftClassDesired", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ParentalCraftClassesDesire.class, name = "yes"),
        @JsonSubTypes.Type(value = NoParentalCraftClassesDesire.class, name = "no"),
})


public class MidwifeClinicSection extends VersionedSection implements OneOfMidwifeClinicSection {
    @JsonProperty("midwifeConsultationWishes")
    private MidwifeClinicSectionMidwifeConsultationWishes midwifeConsultationWishes = null;

    @JsonProperty("assignedMidwifeClinic")
    private HealthCareOrganization assignedMidwifeClinic = null;

    public MidwifeClinicSection midwifeConsultationWishes(MidwifeClinicSectionMidwifeConsultationWishes midwifeConsultationWishes) {
        this.midwifeConsultationWishes = midwifeConsultationWishes;
        return this;
    }

    /**
     * Get midwifeConsultationWishes
     *
     * @return midwifeConsultationWishes
     **/
    public MidwifeClinicSectionMidwifeConsultationWishes getMidwifeConsultationWishes() {
        return midwifeConsultationWishes;
    }

    public void setMidwifeConsultationWishes(MidwifeClinicSectionMidwifeConsultationWishes midwifeConsultationWishes) {
        this.midwifeConsultationWishes = midwifeConsultationWishes;
    }

    public MidwifeClinicSection assignedMidwifeClinic(HealthCareOrganization assignedMidwifeClinic) {
        this.assignedMidwifeClinic = assignedMidwifeClinic;
        return this;
    }

    /**
     * Get assignedMidwifeClinic
     *
     * @return assignedMidwifeClinic
     **/
    public HealthCareOrganization getAssignedMidwifeClinic() {
        return assignedMidwifeClinic;
    }

    public void setAssignedMidwifeClinic(HealthCareOrganization assignedMidwifeClinic) {
        this.assignedMidwifeClinic = assignedMidwifeClinic;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MidwifeClinicSection midwifeClinicSection = (MidwifeClinicSection) o;
        return Objects.equals(this.midwifeConsultationWishes, midwifeClinicSection.midwifeConsultationWishes) &&
                Objects.equals(this.assignedMidwifeClinic, midwifeClinicSection.assignedMidwifeClinic) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(midwifeConsultationWishes, assignedMidwifeClinic, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MidwifeClinicSection {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    midwifeConsultationWishes: ").append(toIndentedString(midwifeConsultationWishes)).append("\n");
        sb.append("    assignedMidwifeClinic: ").append(toIndentedString(assignedMidwifeClinic)).append("\n");
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
