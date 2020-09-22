package dk.sds.nsp.maternity.facade.maternity.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.Objects;

/**
 * ExpectedDateOfDeliverySection
 */
public class ExpectedDateOfDeliverySection extends VersionedSection {
    @JsonProperty("expectedDateOfDeliveryFromLastPeriod")
    private ExpectedDateOfDeliverySectionExpectedDateOfDeliveryFromLastPeriod expectedDateOfDeliveryFromLastPeriod = null;

    @JsonProperty("expectedDateOfDeliveryFromPrenatalUtrasoundScan")
    private LocalDate expectedDateOfDeliveryFromPrenatalUtrasoundScan = null;

    @JsonProperty("remarks")
    private String remarks = null;

    public ExpectedDateOfDeliverySection expectedDateOfDeliveryFromLastPeriod(ExpectedDateOfDeliverySectionExpectedDateOfDeliveryFromLastPeriod expectedDateOfDeliveryFromLastPeriod) {
        this.expectedDateOfDeliveryFromLastPeriod = expectedDateOfDeliveryFromLastPeriod;
        return this;
    }

    /**
     * Get expectedDateOfDeliveryFromLastPeriod
     *
     * @return expectedDateOfDeliveryFromLastPeriod
     **/
    public ExpectedDateOfDeliverySectionExpectedDateOfDeliveryFromLastPeriod getExpectedDateOfDeliveryFromLastPeriod() {
        return expectedDateOfDeliveryFromLastPeriod;
    }

    public void setExpectedDateOfDeliveryFromLastPeriod(ExpectedDateOfDeliverySectionExpectedDateOfDeliveryFromLastPeriod expectedDateOfDeliveryFromLastPeriod) {
        this.expectedDateOfDeliveryFromLastPeriod = expectedDateOfDeliveryFromLastPeriod;
    }

    public ExpectedDateOfDeliverySection expectedDateOfDeliveryFromPrenatalUtrasoundScan(LocalDate expectedDateOfDeliveryFromPrenatalUtrasoundScan) {
        this.expectedDateOfDeliveryFromPrenatalUtrasoundScan = expectedDateOfDeliveryFromPrenatalUtrasoundScan;
        return this;
    }

    /**
     * Get expectedDateOfDeliveryFromPrenatalUtrasoundScan
     *
     * @return expectedDateOfDeliveryFromPrenatalUtrasoundScan
     **/
    public LocalDate getExpectedDateOfDeliveryFromPrenatalUtrasoundScan() {
        return expectedDateOfDeliveryFromPrenatalUtrasoundScan;
    }

    public void setExpectedDateOfDeliveryFromPrenatalUtrasoundScan(LocalDate expectedDateOfDeliveryFromPrenatalUtrasoundScan) {
        this.expectedDateOfDeliveryFromPrenatalUtrasoundScan = expectedDateOfDeliveryFromPrenatalUtrasoundScan;
    }

    public ExpectedDateOfDeliverySection remarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    /**
     * Get remarks
     *
     * @return remarks
     **/
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExpectedDateOfDeliverySection expectedDateOfDeliverySection = (ExpectedDateOfDeliverySection) o;
        return Objects.equals(this.expectedDateOfDeliveryFromLastPeriod, expectedDateOfDeliverySection.expectedDateOfDeliveryFromLastPeriod) &&
                Objects.equals(this.expectedDateOfDeliveryFromPrenatalUtrasoundScan, expectedDateOfDeliverySection.expectedDateOfDeliveryFromPrenatalUtrasoundScan) &&
                Objects.equals(this.remarks, expectedDateOfDeliverySection.remarks) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expectedDateOfDeliveryFromLastPeriod, expectedDateOfDeliveryFromPrenatalUtrasoundScan, remarks, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ExpectedDateOfDeliverySection {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    expectedDateOfDeliveryFromLastPeriod: ").append(toIndentedString(expectedDateOfDeliveryFromLastPeriod)).append("\n");
        sb.append("    expectedDateOfDeliveryFromPrenatalUtrasoundScan: ").append(toIndentedString(expectedDateOfDeliveryFromPrenatalUtrasoundScan)).append("\n");
        sb.append("    remarks: ").append(toIndentedString(remarks)).append("\n");
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
