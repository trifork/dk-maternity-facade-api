/*
 * Appointment Domain Model
 * Appointment Domain Model for Maternity Facade API
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package dk.sds.nsp.maternity.data.appointment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * EditableAppointmentLocation
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-10-29T11:02:03.592754+01:00[Europe/Copenhagen]")
public class AppointmentLocation {

  @JsonProperty("address")
  private AppointmentLocationAddress address = null;

  @JsonProperty("phone")
  private String phone = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;
  public AppointmentLocation address(AppointmentLocationAddress address) {
    this.address = address;
    return this;
  }

  

  /**
  * Get address
  * @return address
  **/
  public AppointmentLocationAddress getAddress() {
    return address;
  }
  public void setAddress(AppointmentLocationAddress address) {
    this.address = address;
  }
  public AppointmentLocation phone(String phone) {
    this.phone = phone;
    return this;
  }

  

  /**
  * Get phone
  * @return phone
  **/
  public String getPhone() {
    return phone;
  }
  public void setPhone(String phone) {
    this.phone = phone;
  }
  public AppointmentLocation name(String name) {
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
  public AppointmentLocation description(String description) {
    this.description = description;
    return this;
  }

  

  /**
  * Get description
  * @return description
  **/
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AppointmentLocation appointmentLocation = (AppointmentLocation) o;
    return Objects.equals(this.address, appointmentLocation.address) &&
        Objects.equals(this.phone, appointmentLocation.phone) &&
        Objects.equals(this.name, appointmentLocation.name) &&
        Objects.equals(this.description, appointmentLocation.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, phone, name, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EditableAppointmentLocation {\n");
    
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
