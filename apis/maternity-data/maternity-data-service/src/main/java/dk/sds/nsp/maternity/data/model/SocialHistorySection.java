package dk.sds.nsp.maternity.data.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

/**
 * SocialHistorySection
 */
public class SocialHistorySection extends VersionedSection {
    @JsonProperty("maritalOrPartnershipStatus")
    private MaritalOrPartnershipStatusEnum maritalOrPartnershipStatus = null;
    @JsonProperty("livingConditions")
    private LivingConditionsEnum livingConditions = null;
    @JsonProperty("additionalInformations")
    private String additionalInformations = null;

    public SocialHistorySection maritalOrPartnershipStatus(MaritalOrPartnershipStatusEnum maritalOrPartnershipStatus) {
        this.maritalOrPartnershipStatus = maritalOrPartnershipStatus;
        return this;
    }

    /**
     * Get maritalOrPartnershipStatus
     *
     * @return maritalOrPartnershipStatus
     **/
    public MaritalOrPartnershipStatusEnum getMaritalOrPartnershipStatus() {
        return maritalOrPartnershipStatus;
    }

    public void setMaritalOrPartnershipStatus(MaritalOrPartnershipStatusEnum maritalOrPartnershipStatus) {
        this.maritalOrPartnershipStatus = maritalOrPartnershipStatus;
    }

    public SocialHistorySection livingConditions(LivingConditionsEnum livingConditions) {
        this.livingConditions = livingConditions;
        return this;
    }

    /**
     * Get livingConditions
     *
     * @return livingConditions
     **/
    public LivingConditionsEnum getLivingConditions() {
        return livingConditions;
    }

    public void setLivingConditions(LivingConditionsEnum livingConditions) {
        this.livingConditions = livingConditions;
    }

    public SocialHistorySection additionalInformations(String additionalInformations) {
        this.additionalInformations = additionalInformations;
        return this;
    }

    /**
     * Get additionalInformations
     *
     * @return additionalInformations
     **/
    public String getAdditionalInformations() {
        return additionalInformations;
    }

    public void setAdditionalInformations(String additionalInformations) {
        this.additionalInformations = additionalInformations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SocialHistorySection socialHistorySection = (SocialHistorySection) o;
        return Objects.equals(this.maritalOrPartnershipStatus, socialHistorySection.maritalOrPartnershipStatus) &&
                Objects.equals(this.livingConditions, socialHistorySection.livingConditions) &&
                Objects.equals(this.additionalInformations, socialHistorySection.additionalInformations) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maritalOrPartnershipStatus, livingConditions, additionalInformations, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SocialHistorySection {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    maritalOrPartnershipStatus: ").append(toIndentedString(maritalOrPartnershipStatus)).append("\n");
        sb.append("    livingConditions: ").append(toIndentedString(livingConditions)).append("\n");
        sb.append("    additionalInformations: ").append(toIndentedString(additionalInformations)).append("\n");
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
     * Gets or Sets maritalOrPartnershipStatus
     */
    public enum MaritalOrPartnershipStatusEnum {
        SINGLE("single"),

        MARRIED("married"),

        SEPARATED("separated"),

        DIVORCED("divorced"),

        WIDOWED("widowed");

        private String value;

        MaritalOrPartnershipStatusEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static MaritalOrPartnershipStatusEnum fromValue(String text) {
            for (MaritalOrPartnershipStatusEnum b : MaritalOrPartnershipStatusEnum.values()) {
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

    /**
     * Gets or Sets livingConditions
     */
    public enum LivingConditionsEnum {
        PARTNERSHIP("partnership"),

        SINGLE("single");

        private String value;

        LivingConditionsEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static LivingConditionsEnum fromValue(String text) {
            for (LivingConditionsEnum b : LivingConditionsEnum.values()) {
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
