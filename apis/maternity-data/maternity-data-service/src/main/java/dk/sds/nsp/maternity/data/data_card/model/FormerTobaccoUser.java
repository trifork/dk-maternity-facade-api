package dk.sds.nsp.maternity.data.data_card.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.time.LocalDate;
import java.util.Objects;

/**
 * FormerTobaccoUser
 */
public class FormerTobaccoUser implements OneOfTobaccoUseAndExposureSection {
    @JsonProperty("tobaccoUser")
    private TobaccoUserEnum tobaccoUser = null;
    @JsonProperty("stoppedUsingTobacco")
    private LocalDate stoppedUsingTobacco = null;

    public FormerTobaccoUser tobaccoUser(TobaccoUserEnum tobaccoUser) {
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

    public FormerTobaccoUser stoppedUsingTobacco(LocalDate stoppedUsingTobacco) {
        this.stoppedUsingTobacco = stoppedUsingTobacco;
        return this;
    }

    /**
     * Get stoppedUsingTobacco
     *
     * @return stoppedUsingTobacco
     **/
    public LocalDate getStoppedUsingTobacco() {
        return stoppedUsingTobacco;
    }

    public void setStoppedUsingTobacco(LocalDate stoppedUsingTobacco) {
        this.stoppedUsingTobacco = stoppedUsingTobacco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FormerTobaccoUser formerTobaccoUser = (FormerTobaccoUser) o;
        return Objects.equals(this.tobaccoUser, formerTobaccoUser.tobaccoUser) &&
                Objects.equals(this.stoppedUsingTobacco, formerTobaccoUser.stoppedUsingTobacco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tobaccoUser, stoppedUsingTobacco);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FormerTobaccoUser {\n");

        sb.append("    tobaccoUser: ").append(toIndentedString(tobaccoUser)).append("\n");
        sb.append("    stoppedUsingTobacco: ").append(toIndentedString(stoppedUsingTobacco)).append("\n");
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
        FORMER("former");

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
