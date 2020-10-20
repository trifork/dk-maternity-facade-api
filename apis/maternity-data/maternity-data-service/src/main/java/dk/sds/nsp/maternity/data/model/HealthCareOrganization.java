package dk.sds.nsp.maternity.data.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

/**
 * HealthCareOrganization
 */
public class HealthCareOrganization implements HealthCareActor {
    @JsonProperty("name")
    private String name = null;

    public HealthCareOrganization name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     **/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HealthCareOrganization objectType(ObjectTypeEnum objectType) {
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HealthCareOrganization healthCareOrganization = (HealthCareOrganization) o;
        return Objects.equals(this.name, healthCareOrganization.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
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
     * Gets or Sets objectType
     */
    public enum ObjectTypeEnum {
        HEALTHCAREORGANIZATION("HealthCareOrganization");

        private String value;

        ObjectTypeEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static ObjectTypeEnum fromValue(String text) {
            for (ObjectTypeEnum b : ObjectTypeEnum.values()) {
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
