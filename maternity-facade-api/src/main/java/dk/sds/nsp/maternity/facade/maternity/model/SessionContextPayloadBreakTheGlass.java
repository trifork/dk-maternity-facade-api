package dk.sds.nsp.maternity.facade.maternity.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * If present access controls will be bypassed \&quot;breaking the glass\&quot;.
 */
public class SessionContextPayloadBreakTheGlass {
    @JsonProperty("expires")
    private LocalDateTime expires = null;

    public SessionContextPayloadBreakTheGlass expires(LocalDateTime expires) {
        this.expires = expires;
        return this;
    }

    /**
     * After this time the session will return to normal mode.
     *
     * @return expires
     **/
    public LocalDateTime getExpires() {
        return expires;
    }

    public void setExpires(LocalDateTime expires) {
        this.expires = expires;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SessionContextPayloadBreakTheGlass sessionContextPayloadBreakTheGlass = (SessionContextPayloadBreakTheGlass) o;
        return Objects.equals(this.expires, sessionContextPayloadBreakTheGlass.expires);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expires);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SessionContextPayloadBreakTheGlass {\n");

        sb.append("    expires: ").append(toIndentedString(expires)).append("\n");
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
