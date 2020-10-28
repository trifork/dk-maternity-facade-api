/*
 * Observation Domain Model
 * Observation (measurement) Domain Model for Maternity Facade API
 *
 * OpenAPI spec version: 1.0.0
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package dk.sds.nsp.maternity.data.observation.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * EditableObservationValues
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-10-28T14:44:24.658344+01:00[Europe/Copenhagen]")
public class EditableObservationValues {

  @JsonProperty("value")
  private String value = null;

  @JsonProperty("unit")
  private String unit = null;

  @JsonProperty("name")
  private String name = null;
  public EditableObservationValues value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
   **/
  public String getValue() {
    return value;
  }
  public void setValue(String value) {
    this.value = value;
  }
  public EditableObservationValues unit(String unit) {
    this.unit = unit;
    return this;
  }



  /**
   * Get unit
   * @return unit
   **/
  public String getUnit() {
    return unit;
  }
  public void setUnit(String unit) {
    this.unit = unit;
  }
  public EditableObservationValues name(String name) {
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
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EditableObservationValues editableObservationValues = (EditableObservationValues) o;
    return Objects.equals(this.value, editableObservationValues.value) &&
            Objects.equals(this.unit, editableObservationValues.unit) &&
            Objects.equals(this.name, editableObservationValues.name);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(value, unit, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EditableObservationValues {\n");

    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
