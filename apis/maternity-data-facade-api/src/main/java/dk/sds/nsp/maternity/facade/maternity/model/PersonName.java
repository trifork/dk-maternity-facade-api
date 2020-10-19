package dk.sds.nsp.maternity.facade.maternity.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * PersonName
 */
public class PersonName {
    @JsonProperty("firstNames")
private List<String> firstNames = new ArrayList<String>();

    @JsonProperty("middleNames")
private List<String> middleNames = new ArrayList<String>();

    @JsonProperty("lastName")
    private String lastName = null;

    public PersonName firstNames(List<String> firstNames) {
        this.firstNames = firstNames;
        return this;
    }

    public PersonName addFirstNamesItem(String firstNamesItem) {
        this.firstNames.add(firstNamesItem);
        return this;
    }

    /**
     * Get firstNames
     *
     * @return firstNames
     **/
    public List<String> getFirstNames() {
        return firstNames;
    }

    public void setFirstNames(List<String> firstNames) {
        this.firstNames = firstNames;
    }

    public PersonName middleNames(List<String> middleNames) {
        this.middleNames = middleNames;
        return this;
    }

    public PersonName addMiddleNamesItem(String middleNamesItem) {
        this.middleNames.add(middleNamesItem);
        return this;
    }

    /**
     * Get middleNames
     *
     * @return middleNames
     **/
    public List<String> getMiddleNames() {
        return middleNames;
    }

    public void setMiddleNames(List<String> middleNames) {
        this.middleNames = middleNames;
    }

    public PersonName lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Get lastName
     *
     * @return lastName
     **/
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PersonName personName = (PersonName) o;
        return Objects.equals(this.firstNames, personName.firstNames) &&
                Objects.equals(this.middleNames, personName.middleNames) &&
                Objects.equals(this.lastName, personName.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstNames, middleNames, lastName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PersonName {\n");

        sb.append("    firstNames: ").append(toIndentedString(firstNames)).append("\n");
        sb.append("    middleNames: ").append(toIndentedString(middleNames)).append("\n");
        sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
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
