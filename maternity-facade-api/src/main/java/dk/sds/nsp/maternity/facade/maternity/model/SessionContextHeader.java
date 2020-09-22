package dk.sds.nsp.maternity.facade.maternity.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

/**
 * SessionContextHeader
 */
public class SessionContextHeader {
    @JsonProperty("alg")
    private AlgEnum alg = null;
    @JsonProperty("typ")
    private TypEnum typ = null;

    public SessionContextHeader alg(AlgEnum alg) {
        this.alg = alg;
        return this;
    }

    /**
     * Get alg
     *
     * @return alg
     **/
    public AlgEnum getAlg() {
        return alg;
    }

    public void setAlg(AlgEnum alg) {
        this.alg = alg;
    }

    public SessionContextHeader typ(TypEnum typ) {
        this.typ = typ;
        return this;
    }

    /**
     * Get typ
     *
     * @return typ
     **/
    public TypEnum getTyp() {
        return typ;
    }

    public void setTyp(TypEnum typ) {
        this.typ = typ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SessionContextHeader sessionContextHeader = (SessionContextHeader) o;
        return Objects.equals(this.alg, sessionContextHeader.alg) &&
                Objects.equals(this.typ, sessionContextHeader.typ);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alg, typ);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SessionContextHeader {\n");

        sb.append("    alg: ").append(toIndentedString(alg)).append("\n");
        sb.append("    typ: ").append(toIndentedString(typ)).append("\n");
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
     * Gets or Sets alg
     */
    public enum AlgEnum {
        HS256("HS256");

        private String value;

        AlgEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static AlgEnum fromValue(String text) {
            for (AlgEnum b : AlgEnum.values()) {
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
     * Gets or Sets typ
     */
    public enum TypEnum {
        JWT("JWT");

        private String value;

        TypEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static TypEnum fromValue(String text) {
            for (TypEnum b : TypEnum.values()) {
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
