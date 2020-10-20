package dk.sds.nsp.maternity.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * DataCardScreeningsSection
 */
public class DataCardScreeningsSection {
    @JsonProperty("hepatitisB")
    private PositiveNegativeDeclinedScreeningWithDateSection hepatitisB = null;

    @JsonProperty("hiv")
    private PositiveNegativeDeclinedScreeningWithDateSection hiv = null;

    @JsonProperty("syphilis")
    private PositiveNegativeDeclinedScreeningWithDateSection syphilis = null;

    @JsonProperty("chlamydia")
    private PositiveNegativeScreeningWithDateSection chlamydia = null;

    @JsonProperty("gonorrhea")
    private PositiveNegativeScreeningWithDateSection gonorrhea = null;

    @JsonProperty("streptococcusGroupB")
    private PositiveNegativeScreeningWithDateSection streptococcusGroupB = null;

    @JsonProperty("hemoglobinopathy")
    private PositiveNegativeScreeningWithDateSection hemoglobinopathy = null;

    @JsonProperty("vitaminDConsumption")
    private DateValueUnitScreeningSection vitaminDConsumption = null;

    @JsonProperty("maternalRhDAntibody")
    private MaternalRhDAntibodyScreeningSection maternalRhDAntibody = null;

    @JsonProperty("fetalRhDAntibody")
    private FetalRhDAntibodyScreeningSection fetalRhDAntibody = null;

    @JsonProperty("diabetesWeek18To20")
    private DateValueUnitScreeningSection diabetesWeek18To20 = null;

    @JsonProperty("diabetesWeek28To30")
    private DateValueUnitScreeningSection diabetesWeek28To30 = null;

    @JsonProperty("diabetesGlycosuria")
    private DateValueUnitScreeningSection diabetesGlycosuria = null;

    @JsonProperty("antiDImmunoglobulinGiven")
    private YesNoDateScreeningSection antiDImmunoglobulinGiven = null;

    public DataCardScreeningsSection hepatitisB(PositiveNegativeDeclinedScreeningWithDateSection hepatitisB) {
        this.hepatitisB = hepatitisB;
        return this;
    }

    /**
     * Get hepatitisB
     *
     * @return hepatitisB
     **/
    public PositiveNegativeDeclinedScreeningWithDateSection getHepatitisB() {
        return hepatitisB;
    }

    public void setHepatitisB(PositiveNegativeDeclinedScreeningWithDateSection hepatitisB) {
        this.hepatitisB = hepatitisB;
    }

    public DataCardScreeningsSection hiv(PositiveNegativeDeclinedScreeningWithDateSection hiv) {
        this.hiv = hiv;
        return this;
    }

    /**
     * Get hiv
     *
     * @return hiv
     **/
    public PositiveNegativeDeclinedScreeningWithDateSection getHiv() {
        return hiv;
    }

    public void setHiv(PositiveNegativeDeclinedScreeningWithDateSection hiv) {
        this.hiv = hiv;
    }

    public DataCardScreeningsSection syphilis(PositiveNegativeDeclinedScreeningWithDateSection syphilis) {
        this.syphilis = syphilis;
        return this;
    }

    /**
     * Get syphilis
     *
     * @return syphilis
     **/
    public PositiveNegativeDeclinedScreeningWithDateSection getSyphilis() {
        return syphilis;
    }

    public void setSyphilis(PositiveNegativeDeclinedScreeningWithDateSection syphilis) {
        this.syphilis = syphilis;
    }

    public DataCardScreeningsSection chlamydia(PositiveNegativeScreeningWithDateSection chlamydia) {
        this.chlamydia = chlamydia;
        return this;
    }

    /**
     * Get chlamydia
     *
     * @return chlamydia
     **/
    public PositiveNegativeScreeningWithDateSection getChlamydia() {
        return chlamydia;
    }

    public void setChlamydia(PositiveNegativeScreeningWithDateSection chlamydia) {
        this.chlamydia = chlamydia;
    }

    public DataCardScreeningsSection gonorrhea(PositiveNegativeScreeningWithDateSection gonorrhea) {
        this.gonorrhea = gonorrhea;
        return this;
    }

    /**
     * Get gonorrhea
     *
     * @return gonorrhea
     **/
    public PositiveNegativeScreeningWithDateSection getGonorrhea() {
        return gonorrhea;
    }

    public void setGonorrhea(PositiveNegativeScreeningWithDateSection gonorrhea) {
        this.gonorrhea = gonorrhea;
    }

    public DataCardScreeningsSection streptococcusGroupB(PositiveNegativeScreeningWithDateSection streptococcusGroupB) {
        this.streptococcusGroupB = streptococcusGroupB;
        return this;
    }

    /**
     * Get streptococcusGroupB
     *
     * @return streptococcusGroupB
     **/
    public PositiveNegativeScreeningWithDateSection getStreptococcusGroupB() {
        return streptococcusGroupB;
    }

    public void setStreptococcusGroupB(PositiveNegativeScreeningWithDateSection streptococcusGroupB) {
        this.streptococcusGroupB = streptococcusGroupB;
    }

    public DataCardScreeningsSection hemoglobinopathy(PositiveNegativeScreeningWithDateSection hemoglobinopathy) {
        this.hemoglobinopathy = hemoglobinopathy;
        return this;
    }

    /**
     * Get hemoglobinopathy
     *
     * @return hemoglobinopathy
     **/
    public PositiveNegativeScreeningWithDateSection getHemoglobinopathy() {
        return hemoglobinopathy;
    }

    public void setHemoglobinopathy(PositiveNegativeScreeningWithDateSection hemoglobinopathy) {
        this.hemoglobinopathy = hemoglobinopathy;
    }

    public DataCardScreeningsSection vitaminDConsumption(DateValueUnitScreeningSection vitaminDConsumption) {
        this.vitaminDConsumption = vitaminDConsumption;
        return this;
    }

    /**
     * Get vitaminDConsumption
     *
     * @return vitaminDConsumption
     **/
    public DateValueUnitScreeningSection getVitaminDConsumption() {
        return vitaminDConsumption;
    }

    public void setVitaminDConsumption(DateValueUnitScreeningSection vitaminDConsumption) {
        this.vitaminDConsumption = vitaminDConsumption;
    }

    public DataCardScreeningsSection maternalRhDAntibody(MaternalRhDAntibodyScreeningSection maternalRhDAntibody) {
        this.maternalRhDAntibody = maternalRhDAntibody;
        return this;
    }

    /**
     * Get maternalRhDAntibody
     *
     * @return maternalRhDAntibody
     **/
    public MaternalRhDAntibodyScreeningSection getMaternalRhDAntibody() {
        return maternalRhDAntibody;
    }

    public void setMaternalRhDAntibody(MaternalRhDAntibodyScreeningSection maternalRhDAntibody) {
        this.maternalRhDAntibody = maternalRhDAntibody;
    }

    public DataCardScreeningsSection fetalRhDAntibody(FetalRhDAntibodyScreeningSection fetalRhDAntibody) {
        this.fetalRhDAntibody = fetalRhDAntibody;
        return this;
    }

    /**
     * Get fetalRhDAntibody
     *
     * @return fetalRhDAntibody
     **/
    public FetalRhDAntibodyScreeningSection getFetalRhDAntibody() {
        return fetalRhDAntibody;
    }

    public void setFetalRhDAntibody(FetalRhDAntibodyScreeningSection fetalRhDAntibody) {
        this.fetalRhDAntibody = fetalRhDAntibody;
    }

    public DataCardScreeningsSection diabetesWeek18To20(DateValueUnitScreeningSection diabetesWeek18To20) {
        this.diabetesWeek18To20 = diabetesWeek18To20;
        return this;
    }

    /**
     * Get diabetesWeek18To20
     *
     * @return diabetesWeek18To20
     **/
    public DateValueUnitScreeningSection getDiabetesWeek18To20() {
        return diabetesWeek18To20;
    }

    public void setDiabetesWeek18To20(DateValueUnitScreeningSection diabetesWeek18To20) {
        this.diabetesWeek18To20 = diabetesWeek18To20;
    }

    public DataCardScreeningsSection diabetesWeek28To30(DateValueUnitScreeningSection diabetesWeek28To30) {
        this.diabetesWeek28To30 = diabetesWeek28To30;
        return this;
    }

    /**
     * Get diabetesWeek28To30
     *
     * @return diabetesWeek28To30
     **/
    public DateValueUnitScreeningSection getDiabetesWeek28To30() {
        return diabetesWeek28To30;
    }

    public void setDiabetesWeek28To30(DateValueUnitScreeningSection diabetesWeek28To30) {
        this.diabetesWeek28To30 = diabetesWeek28To30;
    }

    public DataCardScreeningsSection diabetesGlycosuria(DateValueUnitScreeningSection diabetesGlycosuria) {
        this.diabetesGlycosuria = diabetesGlycosuria;
        return this;
    }

    /**
     * Get diabetesGlycosuria
     *
     * @return diabetesGlycosuria
     **/
    public DateValueUnitScreeningSection getDiabetesGlycosuria() {
        return diabetesGlycosuria;
    }

    public void setDiabetesGlycosuria(DateValueUnitScreeningSection diabetesGlycosuria) {
        this.diabetesGlycosuria = diabetesGlycosuria;
    }

    public DataCardScreeningsSection antiDImmunoglobulinGiven(YesNoDateScreeningSection antiDImmunoglobulinGiven) {
        this.antiDImmunoglobulinGiven = antiDImmunoglobulinGiven;
        return this;
    }

    /**
     * Get antiDImmunoglobulinGiven
     *
     * @return antiDImmunoglobulinGiven
     **/
    public YesNoDateScreeningSection getAntiDImmunoglobulinGiven() {
        return antiDImmunoglobulinGiven;
    }

    public void setAntiDImmunoglobulinGiven(YesNoDateScreeningSection antiDImmunoglobulinGiven) {
        this.antiDImmunoglobulinGiven = antiDImmunoglobulinGiven;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DataCardScreeningsSection dataCardScreeningsSection = (DataCardScreeningsSection) o;
        return Objects.equals(this.hepatitisB, dataCardScreeningsSection.hepatitisB) &&
                Objects.equals(this.hiv, dataCardScreeningsSection.hiv) &&
                Objects.equals(this.syphilis, dataCardScreeningsSection.syphilis) &&
                Objects.equals(this.chlamydia, dataCardScreeningsSection.chlamydia) &&
                Objects.equals(this.gonorrhea, dataCardScreeningsSection.gonorrhea) &&
                Objects.equals(this.streptococcusGroupB, dataCardScreeningsSection.streptococcusGroupB) &&
                Objects.equals(this.hemoglobinopathy, dataCardScreeningsSection.hemoglobinopathy) &&
                Objects.equals(this.vitaminDConsumption, dataCardScreeningsSection.vitaminDConsumption) &&
                Objects.equals(this.maternalRhDAntibody, dataCardScreeningsSection.maternalRhDAntibody) &&
                Objects.equals(this.fetalRhDAntibody, dataCardScreeningsSection.fetalRhDAntibody) &&
                Objects.equals(this.diabetesWeek18To20, dataCardScreeningsSection.diabetesWeek18To20) &&
                Objects.equals(this.diabetesWeek28To30, dataCardScreeningsSection.diabetesWeek28To30) &&
                Objects.equals(this.diabetesGlycosuria, dataCardScreeningsSection.diabetesGlycosuria) &&
                Objects.equals(this.antiDImmunoglobulinGiven, dataCardScreeningsSection.antiDImmunoglobulinGiven);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hepatitisB, hiv, syphilis, chlamydia, gonorrhea, streptococcusGroupB, hemoglobinopathy, vitaminDConsumption, maternalRhDAntibody, fetalRhDAntibody, diabetesWeek18To20, diabetesWeek28To30, diabetesGlycosuria, antiDImmunoglobulinGiven);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DataCardScreeningsSection {\n");

        sb.append("    hepatitisB: ").append(toIndentedString(hepatitisB)).append("\n");
        sb.append("    hiv: ").append(toIndentedString(hiv)).append("\n");
        sb.append("    syphilis: ").append(toIndentedString(syphilis)).append("\n");
        sb.append("    chlamydia: ").append(toIndentedString(chlamydia)).append("\n");
        sb.append("    gonorrhea: ").append(toIndentedString(gonorrhea)).append("\n");
        sb.append("    streptococcusGroupB: ").append(toIndentedString(streptococcusGroupB)).append("\n");
        sb.append("    hemoglobinopathy: ").append(toIndentedString(hemoglobinopathy)).append("\n");
        sb.append("    vitaminDConsumption: ").append(toIndentedString(vitaminDConsumption)).append("\n");
        sb.append("    maternalRhDAntibody: ").append(toIndentedString(maternalRhDAntibody)).append("\n");
        sb.append("    fetalRhDAntibody: ").append(toIndentedString(fetalRhDAntibody)).append("\n");
        sb.append("    diabetesWeek18To20: ").append(toIndentedString(diabetesWeek18To20)).append("\n");
        sb.append("    diabetesWeek28To30: ").append(toIndentedString(diabetesWeek28To30)).append("\n");
        sb.append("    diabetesGlycosuria: ").append(toIndentedString(diabetesGlycosuria)).append("\n");
        sb.append("    antiDImmunoglobulinGiven: ").append(toIndentedString(antiDImmunoglobulinGiven)).append("\n");
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
