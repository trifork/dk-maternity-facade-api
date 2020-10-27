package dk.sds.nsp.maternity.data.data_card.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Objects;

/**
 * TobaccoUseAndExposureSection
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tobaccoUser", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ActiveTobaccoUser.class, name = "active"),
        @JsonSubTypes.Type(value = FormerTobaccoUser.class, name = "former"),
        @JsonSubTypes.Type(value = NeverUsedTobacco.class, name = "never"),
})


public class TobaccoUseAndExposureSection extends VersionedSection implements OneOfTobaccoUseAndExposureSection {
    @JsonProperty("exposureToEnvironmentalTobaccoSmoke")
    private YesNoEnum exposureToEnvironmentalTobaccoSmoke = null;

    public TobaccoUseAndExposureSection exposureToEnvironmentalTobaccoSmoke(YesNoEnum exposureToEnvironmentalTobaccoSmoke) {
        this.exposureToEnvironmentalTobaccoSmoke = exposureToEnvironmentalTobaccoSmoke;
        return this;
    }

    /**
     * Get exposureToEnvironmentalTobaccoSmoke
     *
     * @return exposureToEnvironmentalTobaccoSmoke
     **/
    public YesNoEnum getExposureToEnvironmentalTobaccoSmoke() {
        return exposureToEnvironmentalTobaccoSmoke;
    }

    public void setExposureToEnvironmentalTobaccoSmoke(YesNoEnum exposureToEnvironmentalTobaccoSmoke) {
        this.exposureToEnvironmentalTobaccoSmoke = exposureToEnvironmentalTobaccoSmoke;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TobaccoUseAndExposureSection tobaccoUseAndExposureSection = (TobaccoUseAndExposureSection) o;
        return Objects.equals(this.exposureToEnvironmentalTobaccoSmoke, tobaccoUseAndExposureSection.exposureToEnvironmentalTobaccoSmoke) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exposureToEnvironmentalTobaccoSmoke, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TobaccoUseAndExposureSection {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    exposureToEnvironmentalTobaccoSmoke: ").append(toIndentedString(exposureToEnvironmentalTobaccoSmoke)).append("\n");
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
