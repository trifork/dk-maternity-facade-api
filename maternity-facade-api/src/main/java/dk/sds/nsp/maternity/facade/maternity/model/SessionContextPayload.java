package dk.sds.nsp.maternity.facade.maternity.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * SessionContextPayload
 */
public class SessionContextPayload {
    @JsonProperty("patientIdentifier")
    private String patientIdentifier = null;

    @JsonProperty("applicationMode")
    private ApplicationMode applicationMode = null;

    @JsonProperty("breakTheGlass")
    private SessionContextPayloadBreakTheGlass breakTheGlass = null;

    public SessionContextPayload patientIdentifier(String patientIdentifier) {
        this.patientIdentifier = patientIdentifier;
        return this;
    }

    /**
     * Get patientIdentifier
     *
     * @return patientIdentifier
     **/
    public String getPatientIdentifier() {
        return patientIdentifier;
    }

    public void setPatientIdentifier(String patientIdentifier) {
        this.patientIdentifier = patientIdentifier;
    }

    public SessionContextPayload applicationMode(ApplicationMode applicationMode) {
        this.applicationMode = applicationMode;
        return this;
    }

    /**
     * Get applicationMode
     *
     * @return applicationMode
     **/
public ApplicationMode getApplicationMode() {
        return applicationMode;
    }

    public void setApplicationMode(ApplicationMode applicationMode) {
        this.applicationMode = applicationMode;
    }

    public SessionContextPayload breakTheGlass(SessionContextPayloadBreakTheGlass breakTheGlass) {
        this.breakTheGlass = breakTheGlass;
        return this;
    }

    /**
     * Get breakTheGlass
     *
     * @return breakTheGlass
     **/
public SessionContextPayloadBreakTheGlass getBreakTheGlass() {
        return breakTheGlass;
    }

    public void setBreakTheGlass(SessionContextPayloadBreakTheGlass breakTheGlass) {
        this.breakTheGlass = breakTheGlass;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SessionContextPayload sessionContextPayload = (SessionContextPayload) o;
        return Objects.equals(this.patientIdentifier, sessionContextPayload.patientIdentifier) &&
                Objects.equals(this.applicationMode, sessionContextPayload.applicationMode) &&
                Objects.equals(this.breakTheGlass, sessionContextPayload.breakTheGlass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientIdentifier, applicationMode, breakTheGlass);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SessionContextPayload {\n");

        sb.append("    patientIdentifier: ").append(toIndentedString(patientIdentifier)).append("\n");
        sb.append("    applicationMode: ").append(toIndentedString(applicationMode)).append("\n");
        sb.append("    breakTheGlass: ").append(toIndentedString(breakTheGlass)).append("\n");
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
