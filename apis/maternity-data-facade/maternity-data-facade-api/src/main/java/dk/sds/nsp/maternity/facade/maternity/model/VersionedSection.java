package dk.sds.nsp.maternity.facade.maternity.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * VersionedSection
 */
public class VersionedSection<T extends VersionedSection<?>> {
    @JsonProperty("modifiedTime")
    private LocalDateTime modifiedTime = null;

    @JsonProperty("author")
    private HealthCareActor author = null;

    public T modifiedTime(LocalDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
        return (T) this;
    }

    /**
     * Get modifiedTime
     *
     * @return modifiedTime
     **/
    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public T author(HealthCareActor author) {
        this.author = author;
        return (T) this;
    }

    /**
     * Get author
     *
     * @return author
     **/
    public HealthCareActor getAuthor() {
        return author;
    }

    public void setAuthor(HealthCareActor author) {
        this.author = author;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VersionedSection versionedSection = (VersionedSection) o;
        return Objects.equals(this.modifiedTime, versionedSection.modifiedTime) &&
                Objects.equals(this.author, versionedSection.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modifiedTime, author);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class VersionedSection {\n");

        sb.append("    modifiedTime: ").append(toIndentedString(modifiedTime)).append("\n");
        sb.append("    author: ").append(toIndentedString(author)).append("\n");
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
