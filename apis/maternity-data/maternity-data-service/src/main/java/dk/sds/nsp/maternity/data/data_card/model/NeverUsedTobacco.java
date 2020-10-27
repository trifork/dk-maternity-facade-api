package dk.sds.nsp.maternity.data.data_card.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

/**
 * NeverUsedTobacco
 */
public class NeverUsedTobacco implements OneOfTobaccoUseAndExposureSection {
    @JsonProperty("tobaccoUser")
    private TobaccoUserEnum tobaccoUser = null;

    public NeverUsedTobacco tobaccoUser(TobaccoUserEnum tobaccoUser) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NeverUsedTobacco neverUsedTobacco = (NeverUsedTobacco) o;
        return Objects.equals(this.tobaccoUser, neverUsedTobacco.tobaccoUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tobaccoUser);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NeverUsedTobacco {\n");

        sb.append("    tobaccoUser: ").append(toIndentedString(tobaccoUser)).append("\n");
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
        NEVER("never");

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
