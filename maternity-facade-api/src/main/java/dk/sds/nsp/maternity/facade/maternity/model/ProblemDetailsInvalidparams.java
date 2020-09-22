package dk.sds.nsp.maternity.facade.maternity.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * The validation error descriptor.
 */
public class ProblemDetailsInvalidparams {
    @JsonProperty("path")
    private String path = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("reason")
    private String reason = null;

    public ProblemDetailsInvalidparams path(String path) {
        this.path = path;
        return this;
    }

    /**
     * Get path
     *
     * @return path
     **/
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ProblemDetailsInvalidparams name(String name) {
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

    public ProblemDetailsInvalidparams reason(String reason) {
        this.reason = reason;
        return this;
    }

    /**
     * Get reason
     *
     * @return reason
     **/
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProblemDetailsInvalidparams problemDetailsInvalidparams = (ProblemDetailsInvalidparams) o;
        return Objects.equals(this.path, problemDetailsInvalidparams.path) &&
                Objects.equals(this.name, problemDetailsInvalidparams.name) &&
                Objects.equals(this.reason, problemDetailsInvalidparams.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path, name, reason);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProblemDetailsInvalidparams {\n");

        sb.append("    path: ").append(toIndentedString(path)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
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
