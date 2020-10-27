package dk.sds.nsp.maternity.feedback.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class FeedbackResponse extends Feedback{
  @JsonProperty("identifier")
  private UUID identifier;

  public UUID getId() {
    return identifier;
  }

  public void setId(UUID id) {
    this.identifier = id;
  }

  public FeedbackResponse rating(final Integer rating) {
    super.setRating(rating);
    return this;
  }

  public FeedbackResponse comment(final String comment) {
    super.setComment(comment);
    return this;
  }
  public FeedbackResponse id(final UUID id) {
    this.identifier = id;
    return this;
  }

}

