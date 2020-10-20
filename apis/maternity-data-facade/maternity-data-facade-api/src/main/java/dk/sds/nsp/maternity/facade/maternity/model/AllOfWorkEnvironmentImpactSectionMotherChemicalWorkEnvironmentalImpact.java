package dk.sds.nsp.maternity.facade.maternity.model;

import java.util.Objects;

/**
 * AllOfWorkEnvironmentImpactSectionMotherChemicalWorkEnvironmentalImpact
 */
public class AllOfWorkEnvironmentImpactSectionMotherChemicalWorkEnvironmentalImpact extends ExposureToWorkEnvironmentRisk {

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AllOfWorkEnvironmentImpactSectionMotherChemicalWorkEnvironmentalImpact {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
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
