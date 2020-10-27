package dk.sds.nsp.maternity.data.data_card.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

/**
 * HealthCareProfessional
 */
public class HealthCareProfessional extends Person implements HealthCareActor {
    @JsonProperty("objectType")
    private ObjectTypeEnum objectType = null;

    public HealthCareProfessional objectType(ObjectTypeEnum objectType) {
        this.objectType = objectType;
        return this;
    }

    /**
     * Get objectType
     *
     * @return objectType
     **/
    public ObjectTypeEnum getObjectType() {
        return objectType;
    }

    public void setObjectType(ObjectTypeEnum objectType) {
        this.objectType = objectType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HealthCareProfessional healthCareProfessional = (HealthCareProfessional) o;
        return Objects.equals(this.objectType, healthCareProfessional.objectType) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(objectType, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class HealthCareProfessional {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    objectType: ").append(toIndentedString(objectType)).append("\n");
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
     * Gets or Sets objectType
     */
    public enum ObjectTypeEnum {
        HEALTHCAREPROFESSIONAL("healthCareProfessional");

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
