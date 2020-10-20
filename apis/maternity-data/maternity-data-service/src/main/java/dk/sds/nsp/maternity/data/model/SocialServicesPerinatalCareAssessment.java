package dk.sds.nsp.maternity.data.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.time.LocalDate;
import java.util.Objects;

/**
 * SocialServicesPerinatalCareAssessment
 */
public class SocialServicesPerinatalCareAssessment {
    @JsonProperty("required")
    private RequiredEnum required = RequiredEnum.YES;
    @JsonProperty("reason")
    private String reason = null;
    @JsonProperty("assessmentDate")
    private LocalDate assessmentDate = null;

    public SocialServicesPerinatalCareAssessment required(RequiredEnum required) {
        this.required = required;
        return this;
    }

    /**
     * Get required
     *
     * @return required
     **/
    public RequiredEnum getRequired() {
        return required;
    }

    public void setRequired(RequiredEnum required) {
        this.required = required;
    }

    public SocialServicesPerinatalCareAssessment reason(String reason) {
        this.reason = reason;
        return this;
    }

    /**
     * Get reason
     *
     * @return reason
     **/
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public SocialServicesPerinatalCareAssessment assessmentDate(LocalDate assessmentDate) {
        this.assessmentDate = assessmentDate;
        return this;
    }

    /**
     * Get assessmentDate
     *
     * @return assessmentDate
     **/
    public LocalDate getAssessmentDate() {
        return assessmentDate;
    }

    public void setAssessmentDate(LocalDate assessmentDate) {
        this.assessmentDate = assessmentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SocialServicesPerinatalCareAssessment socialServicesPerinatalCareAssessment = (SocialServicesPerinatalCareAssessment) o;
        return Objects.equals(this.required, socialServicesPerinatalCareAssessment.required) &&
                Objects.equals(this.reason, socialServicesPerinatalCareAssessment.reason) &&
                Objects.equals(this.assessmentDate, socialServicesPerinatalCareAssessment.assessmentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(required, reason, assessmentDate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SocialServicesPerinatalCareAssessment {\n");

        sb.append("    required: ").append(toIndentedString(required)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    assessmentDate: ").append(toIndentedString(assessmentDate)).append("\n");
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
     * Gets or Sets required
     */
    public enum RequiredEnum {
        YES("yes");

        private String value;

        RequiredEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static RequiredEnum fromValue(String text) {
            for (RequiredEnum b : RequiredEnum.values()) {
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
