package dk.sds.maternity.saml.auth.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2020-10-28T15:23:54.952839+01:00[Europe/Copenhagen]")
public class UserContext   {
  
  private String commonName;
  private String organizationName;
  private List<String> eligibleRoles;

  @JsonProperty("commonName")
  public String getCommonName() {
    return commonName;
  }
  public UserContext setCommonName(String commonName) {
    this.commonName = commonName;
    return this;
  }

  @JsonProperty("organizationName")
  public String getOrganizationName() {
    return organizationName;
  }
  public UserContext setOrganizationName(String organizationName) {
    this.organizationName = organizationName;
    return this;
  }
  
  @JsonProperty("eligibleRoles")
  public List<String> getEligibleRoles() {
    return eligibleRoles;
  }
  public UserContext setEligibleRoles(List<String> role) {
    this.eligibleRoles = role;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserContext userContext = (UserContext) o;
    return Objects.equals(commonName, userContext.commonName) &&
        Objects.equals(organizationName, userContext.organizationName) &&
        Objects.equals(eligibleRoles, userContext.eligibleRoles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(commonName, organizationName, eligibleRoles);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserContext {\n");
    sb.append("    commonName: ").append(toIndentedString(commonName)).append("\n");
    sb.append("    organizationName: ").append(toIndentedString(organizationName)).append("\n");
    sb.append("    role: ").append(toIndentedString(eligibleRoles)).append("\n");
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

