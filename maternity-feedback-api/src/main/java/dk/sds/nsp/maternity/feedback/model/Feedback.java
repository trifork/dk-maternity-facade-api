package dk.sds.nsp.maternity.feedback.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


public class Feedback {

  @JsonProperty("rating")
  private Integer rating;
  @JsonProperty("comment")
  private String comment;

  public void setRating(Integer rating) {
    this.rating = rating;
  }

  public Integer getRating() {
    return rating;
  }

  public String getComment() {
    return comment;
  }
  public void setComment(String comment) {
    this.comment = comment;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Feedback feedback = (Feedback) o;
    return Objects.equals(rating, feedback.rating) &&
        Objects.equals(comment, feedback.comment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rating, comment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Feedback {\n");
    
    sb.append("    rating: ").append(toIndentedString(rating)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

