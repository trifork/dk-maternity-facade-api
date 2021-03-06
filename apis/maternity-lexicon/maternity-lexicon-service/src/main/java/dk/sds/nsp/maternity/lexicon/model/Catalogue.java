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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a list of posts along with some meta-information about paging
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-11-03T11:09:06.852462+01:00[Europe/Copenhagen]")
public class Catalogue {

  @JsonProperty("curretPage")
  private Integer curretPage = null;

  @JsonProperty("numberOfPages")
  private Integer numberOfPages = null; // Obtained using the X-WP-total header from wordpress response divided by page-size rounded up

  @JsonProperty("content")
  private List<Post> content = null;

  


  public Catalogue curretPage(Integer curretPage) {
    this.curretPage = curretPage;
    return this;
  }
  /**
   * Get curretPage
   * minimum: 0
   * @return curretPage
   **/
  public Integer getCurretPage() {
    return curretPage;
  }
  public void setCurretPage(Integer curretPage) {
    this.curretPage = curretPage;
  }

  public Catalogue numberOfPages(Integer numberOfPages) {
    this.numberOfPages = numberOfPages;
    return this;
  }
  /**
  * Get numberOfPages
  * minimum: 1
  * @return numberOfPages
  **/
  public Integer getNumberOfPages() {
    return numberOfPages;
  }
  public void setNumberOfPages(Integer numberOfPages) {
    this.numberOfPages = numberOfPages;
  }
  public Catalogue content(List<Post> content) {
    this.content = content;
    return this;
  }

  public Catalogue addContentItem(Post contentItem) {
    if (this.content == null) {
      this.content = new ArrayList<Post>();
    }
    this.content.add(contentItem);
    return this;
  }

  /**
  * Get content
  * @return content
  **/
  public List<Post> getContent() {
    return content;
  }
  public void setContent(List<Post> content) {
    this.content = content;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Catalogue catalogue = (Catalogue) o;
    return Objects.equals(this.curretPage, catalogue.curretPage) &&
        Objects.equals(this.numberOfPages, catalogue.numberOfPages) &&
        Objects.equals(this.content, catalogue.content);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(curretPage, numberOfPages, content);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Catalogue {\n");
    
    sb.append("    curretPage: ").append(toIndentedString(curretPage)).append("\n");
    sb.append("    numberOfPages: ").append(toIndentedString(numberOfPages)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
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
