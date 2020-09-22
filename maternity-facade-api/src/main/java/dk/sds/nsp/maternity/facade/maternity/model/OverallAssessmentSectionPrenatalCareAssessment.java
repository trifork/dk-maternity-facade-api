package dk.sds.nsp.maternity.facade.maternity.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

/**
 * OverallAssessmentSectionPrenatalCareAssessment
 */
public class OverallAssessmentSectionPrenatalCareAssessment {
    @JsonProperty("assessment")
    private String assessment = null;

    @JsonProperty("numberOfFetuses")
    private Integer numberOfFetuses = null;
    @JsonProperty("careLevel")
    private CareLevelEnum careLevel = null;

    public OverallAssessmentSectionPrenatalCareAssessment assessment(String assessment) {
        this.assessment = assessment;
        return this;
    }

    /**
     * Get assessment
     *
     * @return assessment
     **/
    public String getAssessment() {
        return assessment;
    }

    public void setAssessment(String assessment) {
        this.assessment = assessment;
    }

    public OverallAssessmentSectionPrenatalCareAssessment numberOfFetuses(Integer numberOfFetuses) {
        this.numberOfFetuses = numberOfFetuses;
        return this;
    }

    /**
     * Get numberOfFetuses
     * minimum: 0
     *
     * @return numberOfFetuses
     **/
    public Integer getNumberOfFetuses() {
        return numberOfFetuses;
    }

    public void setNumberOfFetuses(Integer numberOfFetuses) {
        this.numberOfFetuses = numberOfFetuses;
    }

    public OverallAssessmentSectionPrenatalCareAssessment careLevel(CareLevelEnum careLevel) {
        this.careLevel = careLevel;
        return this;
    }

    /**
     * Get careLevel
     *
     * @return careLevel
     **/
    public CareLevelEnum getCareLevel() {
        return careLevel;
    }

    public void setCareLevel(CareLevelEnum careLevel) {
        this.careLevel = careLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OverallAssessmentSectionPrenatalCareAssessment overallAssessmentSectionPrenatalCareAssessment = (OverallAssessmentSectionPrenatalCareAssessment) o;
        return Objects.equals(this.assessment, overallAssessmentSectionPrenatalCareAssessment.assessment) &&
                Objects.equals(this.numberOfFetuses, overallAssessmentSectionPrenatalCareAssessment.numberOfFetuses) &&
                Objects.equals(this.careLevel, overallAssessmentSectionPrenatalCareAssessment.careLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assessment, numberOfFetuses, careLevel);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OverallAssessmentSectionPrenatalCareAssessment {\n");

        sb.append("    assessment: ").append(toIndentedString(assessment)).append("\n");
        sb.append("    numberOfFetuses: ").append(toIndentedString(numberOfFetuses)).append("\n");
        sb.append("    careLevel: ").append(toIndentedString(careLevel)).append("\n");
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
     * Gets or Sets careLevel
     */
    public enum CareLevelEnum {
        BASIC("basic"),

        EXTENDED("extended"),

        SPECIALISTMULTIDISCIPLINARYTEAM("specialistMultidisciplinaryTeam"),

        HIGHRISKPREGNANCYCARE("highRiskPregnancyCare");

        private String value;

        CareLevelEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static CareLevelEnum fromValue(String text) {
            for (CareLevelEnum b : CareLevelEnum.values()) {
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
