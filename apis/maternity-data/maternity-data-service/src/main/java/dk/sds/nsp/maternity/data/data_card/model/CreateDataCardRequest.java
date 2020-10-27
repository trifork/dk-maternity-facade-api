package dk.sds.nsp.maternity.data.data_card.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.UUID;

/**
 * CreateDataCardRequest
 */
public class CreateDataCardRequest extends DataCardRequest {
    @JsonProperty("episodeOfCareIdentifier")
    private UUID episodeOfCareIdentifier = null;

    public CreateDataCardRequest episodeOfCareIdentifier(UUID episodeOfCareIdentifier) {
        this.episodeOfCareIdentifier = episodeOfCareIdentifier;
        return this;
    }

    /**
     * Get episodeOfCareIdentifier
     *
     * @return episodeOfCareIdentifier
     **/
    public UUID getEpisodeOfCareIdentifier() {
        return episodeOfCareIdentifier;
    }

    public void setEpisodeOfCareIdentifier(UUID episodeOfCareIdentifier) {
        this.episodeOfCareIdentifier = episodeOfCareIdentifier;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateDataCardRequest createDataCardRequest = (CreateDataCardRequest) o;
        return Objects.equals(this.episodeOfCareIdentifier, createDataCardRequest.episodeOfCareIdentifier) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(episodeOfCareIdentifier, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateDataCardRequest {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    episodeOfCareIdentifier: ").append(toIndentedString(episodeOfCareIdentifier)).append("\n");
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
