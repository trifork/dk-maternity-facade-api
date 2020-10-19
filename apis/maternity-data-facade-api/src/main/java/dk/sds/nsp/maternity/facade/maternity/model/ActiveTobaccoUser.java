package dk.sds.nsp.maternity.facade.maternity.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

/**
 * ActiveTobaccoUser
 */
public class ActiveTobaccoUser implements OneOfTobaccoUseAndExposureSection {
    @JsonProperty("tobaccoUser")
    private TobaccoUserEnum tobaccoUser = null;
    @JsonProperty("referredToTobaccoCessationEducation")
    private YesNoEnum referredToTobaccoCessationEducation = null;

    public ActiveTobaccoUser tobaccoUser(TobaccoUserEnum tobaccoUser) {
        this.tobaccoUser = tobaccoUser;
        return this;
    }

    /**
     * Get tobaccoUser
     *
     * @return tobaccoUser
     **/
    public TobaccoUserEnum getTobaccoUser() {
        return tobaccoUser;
    }

    public void setTobaccoUser(TobaccoUserEnum tobaccoUser) {
        this.tobaccoUser = tobaccoUser;
    }

    public ActiveTobaccoUser referredToTobaccoCessationEducation(YesNoEnum referredToTobaccoCessationEducation) {
        this.referredToTobaccoCessationEducation = referredToTobaccoCessationEducation;
        return this;
    }

    /**
     * Get referredToTobaccoCessationEducation
     *
     * @return referredToTobaccoCessationEducation
     **/
    public YesNoEnum getReferredToTobaccoCessationEducation() {
        return referredToTobaccoCessationEducation;
    }

    public void setReferredToTobaccoCessationEducation(YesNoEnum referredToTobaccoCessationEducation) {
        this.referredToTobaccoCessationEducation = referredToTobaccoCessationEducation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ActiveTobaccoUser activeTobaccoUser = (ActiveTobaccoUser) o;
        return Objects.equals(this.tobaccoUser, activeTobaccoUser.tobaccoUser) &&
                Objects.equals(this.referredToTobaccoCessationEducation, activeTobaccoUser.referredToTobaccoCessationEducation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tobaccoUser, referredToTobaccoCessationEducation);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ActiveTobaccoUser {\n");

        sb.append("    tobaccoUser: ").append(toIndentedString(tobaccoUser)).append("\n");
        sb.append("    referredToTobaccoCessationEducation: ").append(toIndentedString(referredToTobaccoCessationEducation)).append("\n");
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
     * Gets or Sets tobaccoUser
     */
    public enum TobaccoUserEnum {
        ACTIVE("active");

        private String value;

        TobaccoUserEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static TobaccoUserEnum fromValue(String text) {
            for (TobaccoUserEnum b : TobaccoUserEnum.values()) {
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
