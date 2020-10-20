package dk.sds.nsp.maternity.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.UUID;

/**
 * DataCardResponse
 */
public class DataCardResponse extends DataCard<DataCardResponse> {
    @JsonProperty("episodeOfCareIdentifier")
    private UUID episodeOfCareIdentifier = null;

    @JsonProperty("identifier")
    private UUID identifier = null;

    public DataCardResponse episodeOfCareIdentifier(UUID episodeOfCareIdentifier) {
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

    public DataCardResponse identifier(UUID identifier) {
        this.identifier = identifier;
        return this;
    }

    /**
     * Get identifier
     *
     * @return identifier
     **/
    public UUID getIdentifier() {
        return identifier;
    }

    public void setIdentifier(UUID identifier) {
        this.identifier = identifier;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DataCardResponse dataCardResponse = (DataCardResponse) o;
        return Objects.equals(this.episodeOfCareIdentifier, dataCardResponse.episodeOfCareIdentifier) &&
                Objects.equals(this.identifier, dataCardResponse.identifier) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(episodeOfCareIdentifier, identifier, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DataCardResponse {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    episodeOfCareIdentifier: ").append(toIndentedString(episodeOfCareIdentifier)).append("\n");
        sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
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
