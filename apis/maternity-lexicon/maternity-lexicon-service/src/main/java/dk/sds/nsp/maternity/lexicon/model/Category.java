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
 * Closely mirrors a wordpress category, enritched with an image to be displayed as a nice card :)
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-11-03T15:42:21.346158+01:00[Europe/Copenhagen]")
public class Category {

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("imageUrl")
  private String imageUrl = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("count")
  private Integer count = null;
  public Category id(String id) {
    this.id = id;
    return this;
  }

  

  /**
  * Get id
  * @return id
  **/
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public Category imageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
    return this;
  }

  

  /**
  * Get imageUrl
  * @return imageUrl
  **/
  public String getImageUrl() {
    return imageUrl;
  }
  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }
  public Category name(String name) {
    this.name = name;
    return this;
  }

  

  /**
  * Get name
  * @return name
  **/
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Category count(Integer count) {
    this.count = count;
    return this;
  }

  

  /**
  * Get count
  * @return count
  **/
  public Integer getCount() {
    return count;
  }
  public void setCount(Integer count) {
    this.count = count;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Category category = (Category) o;
    return Objects.equals(this.id, category.id) &&
        Objects.equals(this.imageUrl, category.imageUrl) &&
        Objects.equals(this.name, category.name) &&
        Objects.equals(this.count, category.count);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, imageUrl, name, count);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Category {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    imageUrl: ").append(toIndentedString(imageUrl)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
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
