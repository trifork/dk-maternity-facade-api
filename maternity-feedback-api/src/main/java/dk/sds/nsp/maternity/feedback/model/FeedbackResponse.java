package dk.sds.nsp.maternity.feedback.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.UUID;

public class FeedbackResponse extends Feedback{
  @JsonProperty("id")
  private UUID id;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
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
    this.id = id;
    return this;
  }

}

