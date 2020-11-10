/*
 * DK Maternity Lexicon Api
 * This is the specification of the DK Maternity Lexicon API.
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package dk.sds.nsp.maternity.lexicon.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * PostContent
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-11-03T16:15:42.700046+01:00[Europe/Copenhagen]")
public class PostContent {

  @JsonProperty("title")
  private String title = null;

  @JsonProperty("content")
  private String content = null;
  public PostContent title(String title) {
    this.title = title;
    return this;
  }

  

  /**
  * Get title
  * @return title
  **/
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public PostContent content(String content) {
    this.content = content;
    return this;
  }

  

  /**
  * Get content
  * @return content
  **/
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PostContent postContent = (PostContent) o;
    return Objects.equals(this.title, postContent.title) &&
        Objects.equals(this.content, postContent.content);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, content);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostContent {\n");
    
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
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