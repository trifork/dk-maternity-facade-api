package dk.sds.nsp.maternity.facade.maternity.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * AllergiesSection
 */
public class AllergiesSection extends VersionedSection {
    @JsonProperty("allergiesOfMother")
    private List<String> allergiesOfMother = null;
    @JsonProperty("allergicPredispositionOfChild")
    private AllergicPredispositionOfChildEnum allergicPredispositionOfChild = null;

    public AllergiesSection allergiesOfMother(List<String> allergiesOfMother) {
        this.allergiesOfMother = allergiesOfMother;
        return this;
    }

    public AllergiesSection addAllergiesOfMotherItem(String allergiesOfMotherItem) {
        if (this.allergiesOfMother == null) {
            this.allergiesOfMother = new ArrayList<String>();
        }
        this.allergiesOfMother.add(allergiesOfMotherItem);
        return this;
    }

    /**
     * Get allergiesOfMother
     *
     * @return allergiesOfMother
     **/
    public List<String> getAllergiesOfMother() {
        return allergiesOfMother;
    }

    public void setAllergiesOfMother(List<String> allergiesOfMother) {
        this.allergiesOfMother = allergiesOfMother;
    }

    public AllergiesSection allergicPredispositionOfChild(AllergicPredispositionOfChildEnum allergicPredispositionOfChild) {
        this.allergicPredispositionOfChild = allergicPredispositionOfChild;
        return this;
    }

    /**
     * Get allergicPredispositionOfChild
     *
     * @return allergicPredispositionOfChild
     **/
    public AllergicPredispositionOfChildEnum getAllergicPredispositionOfChild() {
        return allergicPredispositionOfChild;
    }

    public void setAllergicPredispositionOfChild(AllergicPredispositionOfChildEnum allergicPredispositionOfChild) {
        this.allergicPredispositionOfChild = allergicPredispositionOfChild;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AllergiesSection allergiesSection = (AllergiesSection) o;
        return Objects.equals(this.allergiesOfMother, allergiesSection.allergiesOfMother) &&
                Objects.equals(this.allergicPredispositionOfChild, allergiesSection.allergicPredispositionOfChild) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allergiesOfMother, allergicPredispositionOfChild, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AllergiesSection {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    allergiesOfMother: ").append(toIndentedString(allergiesOfMother)).append("\n");
        sb.append("    allergicPredispositionOfChild: ").append(toIndentedString(allergicPredispositionOfChild)).append("\n");
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

    /**
     * Gets or Sets allergicPredispositionOfChild
     */
    public enum AllergicPredispositionOfChildEnum {
        NOPREDISPOSITION("noPredisposition"),

        PARENTALPREDISPOSITION("parentalPredisposition"),

        SIBLINGPREDISPOSITION("siblingPredisposition"),

        DOUBLEPREDISPOSITION("doublePredisposition");

        private String value;

        AllergicPredispositionOfChildEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static AllergicPredispositionOfChildEnum fromValue(String text) {
            for (AllergicPredispositionOfChildEnum b : AllergicPredispositionOfChildEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }
    }
}
