package dk.sds.nsp.maternity.facade.maternity.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * The patient, application mode and break the glass expiration encoded as a JWT
 */
public class SessionContext {
    @JsonProperty("header")
    private SessionContextHeader header = null;

    @JsonProperty("payload")
    private SessionContextPayload payload = null;

    @JsonProperty("signature")
    private String signature = null;

    public SessionContext header(SessionContextHeader header) {
        this.header = header;
        return this;
    }

    /**
     * Get header
     *
     * @return header
     **/
public SessionContextHeader getHeader() {
        return header;
    }

    public void setHeader(SessionContextHeader header) {
        this.header = header;
    }

    public SessionContext payload(SessionContextPayload payload) {
        this.payload = payload;
        return this;
    }

    /**
     * Get payload
     *
     * @return payload
     **/
public SessionContextPayload getPayload() {
        return payload;
    }

    public void setPayload(SessionContextPayload payload) {
        this.payload = payload;
    }

    public SessionContext signature(String signature) {
        this.signature = signature;
        return this;
    }

    /**
     * The signature of the JWT
     *
     * @return signature
     **/
    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SessionContext sessionContext = (SessionContext) o;
        return Objects.equals(this.header, sessionContext.header) &&
                Objects.equals(this.payload, sessionContext.payload) &&
                Objects.equals(this.signature, sessionContext.signature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(header, payload, signature);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SessionContext {\n");

        sb.append("    header: ").append(toIndentedString(header)).append("\n");
        sb.append("    payload: ").append(toIndentedString(payload)).append("\n");
        sb.append("    signature: ").append(toIndentedString(signature)).append("\n");
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
