package dk.sds.nsp.maternity.facade.maternity.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * DataCard
 */
public class DataCard<T extends DataCard<?>> extends VersionedSection<T> {
    @JsonProperty("recordTarget")
    private CprIdentifiedPerson recordTarget = null;

    @JsonProperty("childPartnerSection")
    private ChildPartnerSection childPartnerSection = null;

    @JsonProperty("languageSection")
    private LanguageSection languageSection = null;

    @JsonProperty("bodyMeasuresSection")
    private BodyMeasuresSection bodyMeasuresSection = null;

    @JsonProperty("socialHistorySection")
    private SocialHistorySection socialHistorySection = null;

    @JsonProperty("previousBirthsSection")
    private PreviousBirthsSection previousBirthsSection = null;

    @JsonProperty("previousAbortionsSection")
    private PreviousAbortionsSection previousAbortionsSection = null;

    @JsonProperty("expectedDateOfDeliverySection")
    private ExpectedDateOfDeliverySection expectedDateOfDeliverySection = null;

    @JsonProperty("prenatalRiskAssessmentSection")
    private PrenatalRiskAssessmentSection prenatalRiskAssessmentSection = null;

    @JsonProperty("workEnvironmentImpactSection")
    private WorkEnvironmentImpactSection workEnvironmentImpactSection = null;

    @JsonProperty("allergiesSection")
    private AllergiesSection allergiesSection = null;

    @JsonProperty("screeningsSection")
    private DataCardScreeningsSection screeningsSection = null;

    @JsonProperty("chronicalDiseasesSection")
    private ChronicDiseasesSection chronicalDiseasesSection = null;

    @JsonProperty("medicineSection")
    private Object medicineSection = null;

    @JsonProperty("mmrVacinationSection")
    private Object mmrVacinationSection = null;

    @JsonProperty("historyOfPreviousTreatmentWithImpactOnPregnancySection")
    private Object historyOfPreviousTreatmentWithImpactOnPregnancySection = null;

    @JsonProperty("tobaccoUseAndExposureSection")
    private TobaccoUseAndExposureSection tobaccoUseAndExposureSection = null;

    @JsonProperty("alcoholDrinkingBehaviorSection")
    private AlcoholDrinkingBehaviorSection alcoholDrinkingBehaviorSection = null;

    @JsonProperty("substanceUseSection")
    private SubstanceUseSection substanceUseSection = null;

    @JsonProperty("dietaryAndExerciseSection")
    private DietaryAndExerciseSection dietaryAndExerciseSection = null;

    @JsonProperty("healthInsuranceSection")
    private HealthInsuranceSection healthInsuranceSection = null;

    @JsonProperty("birthPlaceSection")
    private BirthPlaceSection birthPlaceSection = null;

    @JsonProperty("midwifeClinicSection")
    private MidwifeClinicSection midwifeClinicSection = null;

    @JsonProperty("postpartumNursingSection")
    private PostpartumNursingSection postpartumNursingSection = null;

    @JsonProperty("overallAssessmentSection")
    private OverallAssessmentSection overallAssessmentSection = null;

    public T recordTarget(CprIdentifiedPerson recordTarget) {
        this.recordTarget = recordTarget;
        return (T) this;
    }

    /**
     * Get recordTarget
     *
     * @return recordTarget
     **/
    public CprIdentifiedPerson getRecordTarget() {
        return recordTarget;
    }

    public void setRecordTarget(CprIdentifiedPerson recordTarget) {
        this.recordTarget = recordTarget;
    }

    public DataCard childPartnerSection(ChildPartnerSection childPartnerSection) {
        this.childPartnerSection = childPartnerSection;
        return this;
    }

    /**
     * Get childPartnerSection
     *
     * @return childPartnerSection
     **/
    public ChildPartnerSection getChildPartnerSection() {
        return childPartnerSection;
    }

    public void setChildPartnerSection(ChildPartnerSection childPartnerSection) {
        this.childPartnerSection = childPartnerSection;
    }

    public DataCard languageSection(LanguageSection languageSection) {
        this.languageSection = languageSection;
        return this;
    }

    /**
     * Get languageSection
     *
     * @return languageSection
     **/
    public LanguageSection getLanguageSection() {
        return languageSection;
    }

    public void setLanguageSection(LanguageSection languageSection) {
        this.languageSection = languageSection;
    }

    public DataCard bodyMeasuresSection(BodyMeasuresSection bodyMeasuresSection) {
        this.bodyMeasuresSection = bodyMeasuresSection;
        return this;
    }

    /**
     * Get bodyMeasuresSection
     *
     * @return bodyMeasuresSection
     **/
    public BodyMeasuresSection getBodyMeasuresSection() {
        return bodyMeasuresSection;
    }

    public void setBodyMeasuresSection(BodyMeasuresSection bodyMeasuresSection) {
        this.bodyMeasuresSection = bodyMeasuresSection;
    }

    public DataCard socialHistorySection(SocialHistorySection socialHistorySection) {
        this.socialHistorySection = socialHistorySection;
        return this;
    }

    /**
     * Get socialHistorySection
     *
     * @return socialHistorySection
     **/
    public SocialHistorySection getSocialHistorySection() {
        return socialHistorySection;
    }

    public void setSocialHistorySection(SocialHistorySection socialHistorySection) {
        this.socialHistorySection = socialHistorySection;
    }

    public DataCard previousBirthsSection(PreviousBirthsSection previousBirthsSection) {
        this.previousBirthsSection = previousBirthsSection;
        return this;
    }

    /**
     * Get previousBirthsSection
     *
     * @return previousBirthsSection
     **/
    public PreviousBirthsSection getPreviousBirthsSection() {
        return previousBirthsSection;
    }

    public void setPreviousBirthsSection(PreviousBirthsSection previousBirthsSection) {
        this.previousBirthsSection = previousBirthsSection;
    }

    public DataCard previousAbortionsSection(PreviousAbortionsSection previousAbortionsSection) {
        this.previousAbortionsSection = previousAbortionsSection;
        return this;
    }

    /**
     * Get previousAbortionsSection
     *
     * @return previousAbortionsSection
     **/
    public PreviousAbortionsSection getPreviousAbortionsSection() {
        return previousAbortionsSection;
    }

    public void setPreviousAbortionsSection(PreviousAbortionsSection previousAbortionsSection) {
        this.previousAbortionsSection = previousAbortionsSection;
    }

    public DataCard expectedDateOfDeliverySection(ExpectedDateOfDeliverySection expectedDateOfDeliverySection) {
        this.expectedDateOfDeliverySection = expectedDateOfDeliverySection;
        return this;
    }

    /**
     * Get expectedDateOfDeliverySection
     *
     * @return expectedDateOfDeliverySection
     **/
    public ExpectedDateOfDeliverySection getExpectedDateOfDeliverySection() {
        return expectedDateOfDeliverySection;
    }

    public void setExpectedDateOfDeliverySection(ExpectedDateOfDeliverySection expectedDateOfDeliverySection) {
        this.expectedDateOfDeliverySection = expectedDateOfDeliverySection;
    }

    public DataCard prenatalRiskAssessmentSection(PrenatalRiskAssessmentSection prenatalRiskAssessmentSection) {
        this.prenatalRiskAssessmentSection = prenatalRiskAssessmentSection;
        return this;
    }

    /**
     * Get prenatalRiskAssessmentSection
     *
     * @return prenatalRiskAssessmentSection
     **/
    public PrenatalRiskAssessmentSection getPrenatalRiskAssessmentSection() {
        return prenatalRiskAssessmentSection;
    }

    public void setPrenatalRiskAssessmentSection(PrenatalRiskAssessmentSection prenatalRiskAssessmentSection) {
        this.prenatalRiskAssessmentSection = prenatalRiskAssessmentSection;
    }

    public DataCard workEnvironmentImpactSection(WorkEnvironmentImpactSection workEnvironmentImpactSection) {
        this.workEnvironmentImpactSection = workEnvironmentImpactSection;
        return this;
    }

    /**
     * Get workEnvironmentImpactSection
     *
     * @return workEnvironmentImpactSection
     **/
    public WorkEnvironmentImpactSection getWorkEnvironmentImpactSection() {
        return workEnvironmentImpactSection;
    }

    public void setWorkEnvironmentImpactSection(WorkEnvironmentImpactSection workEnvironmentImpactSection) {
        this.workEnvironmentImpactSection = workEnvironmentImpactSection;
    }

    public DataCard allergiesSection(AllergiesSection allergiesSection) {
        this.allergiesSection = allergiesSection;
        return this;
    }

    /**
     * Get allergiesSection
     *
     * @return allergiesSection
     **/
    public AllergiesSection getAllergiesSection() {
        return allergiesSection;
    }

    public void setAllergiesSection(AllergiesSection allergiesSection) {
        this.allergiesSection = allergiesSection;
    }

    public DataCard screeningsSection(DataCardScreeningsSection screeningsSection) {
        this.screeningsSection = screeningsSection;
        return this;
    }

    /**
     * Get screeningsSection
     *
     * @return screeningsSection
     **/
    public DataCardScreeningsSection getScreeningsSection() {
        return screeningsSection;
    }

    public void setScreeningsSection(DataCardScreeningsSection screeningsSection) {
        this.screeningsSection = screeningsSection;
    }

    public DataCard chronicalDiseasesSection(ChronicDiseasesSection chronicalDiseasesSection) {
        this.chronicalDiseasesSection = chronicalDiseasesSection;
        return this;
    }

    /**
     * Get chronicalDiseasesSection
     *
     * @return chronicalDiseasesSection
     **/
    public ChronicDiseasesSection getChronicalDiseasesSection() {
        return chronicalDiseasesSection;
    }

    public void setChronicalDiseasesSection(ChronicDiseasesSection chronicalDiseasesSection) {
        this.chronicalDiseasesSection = chronicalDiseasesSection;
    }

    public DataCard medicineSection(Object medicineSection) {
        this.medicineSection = medicineSection;
        return this;
    }

    /**
     * Get medicineSection
     *
     * @return medicineSection
     **/
    public Object getMedicineSection() {
        return medicineSection;
    }

    public void setMedicineSection(Object medicineSection) {
        this.medicineSection = medicineSection;
    }

    public DataCard mmrVacinationSection(Object mmrVacinationSection) {
        this.mmrVacinationSection = mmrVacinationSection;
        return this;
    }

    /**
     * Get mmrVacinationSection
     *
     * @return mmrVacinationSection
     **/
    public Object getMmrVacinationSection() {
        return mmrVacinationSection;
    }

    public void setMmrVacinationSection(Object mmrVacinationSection) {
        this.mmrVacinationSection = mmrVacinationSection;
    }

    public DataCard historyOfPreviousTreatmentWithImpactOnPregnancySection(Object historyOfPreviousTreatmentWithImpactOnPregnancySection) {
        this.historyOfPreviousTreatmentWithImpactOnPregnancySection = historyOfPreviousTreatmentWithImpactOnPregnancySection;
        return this;
    }

    /**
     * Get historyOfPreviousTreatmentWithImpactOnPregnancySection
     *
     * @return historyOfPreviousTreatmentWithImpactOnPregnancySection
     **/
    public Object getHistoryOfPreviousTreatmentWithImpactOnPregnancySection() {
        return historyOfPreviousTreatmentWithImpactOnPregnancySection;
    }

    public void setHistoryOfPreviousTreatmentWithImpactOnPregnancySection(Object historyOfPreviousTreatmentWithImpactOnPregnancySection) {
        this.historyOfPreviousTreatmentWithImpactOnPregnancySection = historyOfPreviousTreatmentWithImpactOnPregnancySection;
    }

    public DataCard tobaccoUseAndExposureSection(TobaccoUseAndExposureSection tobaccoUseAndExposureSection) {
        this.tobaccoUseAndExposureSection = tobaccoUseAndExposureSection;
        return this;
    }

    /**
     * Get tobaccoUseAndExposureSection
     *
     * @return tobaccoUseAndExposureSection
     **/
    public TobaccoUseAndExposureSection getTobaccoUseAndExposureSection() {
        return tobaccoUseAndExposureSection;
    }

    public void setTobaccoUseAndExposureSection(TobaccoUseAndExposureSection tobaccoUseAndExposureSection) {
        this.tobaccoUseAndExposureSection = tobaccoUseAndExposureSection;
    }

    public DataCard alcoholDrinkingBehaviorSection(AlcoholDrinkingBehaviorSection alcoholDrinkingBehaviorSection) {
        this.alcoholDrinkingBehaviorSection = alcoholDrinkingBehaviorSection;
        return this;
    }

    /**
     * Get alcoholDrinkingBehaviorSection
     *
     * @return alcoholDrinkingBehaviorSection
     **/
    public AlcoholDrinkingBehaviorSection getAlcoholDrinkingBehaviorSection() {
        return alcoholDrinkingBehaviorSection;
    }

    public void setAlcoholDrinkingBehaviorSection(AlcoholDrinkingBehaviorSection alcoholDrinkingBehaviorSection) {
        this.alcoholDrinkingBehaviorSection = alcoholDrinkingBehaviorSection;
    }

    public DataCard substanceUseSection(SubstanceUseSection substanceUseSection) {
        this.substanceUseSection = substanceUseSection;
        return this;
    }

    /**
     * Get substanceUseSection
     *
     * @return substanceUseSection
     **/
    public SubstanceUseSection getSubstanceUseSection() {
        return substanceUseSection;
    }

    public void setSubstanceUseSection(SubstanceUseSection substanceUseSection) {
        this.substanceUseSection = substanceUseSection;
    }

    public DataCard dietaryAndExerciseSection(DietaryAndExerciseSection dietaryAndExerciseSection) {
        this.dietaryAndExerciseSection = dietaryAndExerciseSection;
        return this;
    }

    /**
     * Get dietaryAndExerciseSection
     *
     * @return dietaryAndExerciseSection
     **/
    public DietaryAndExerciseSection getDietaryAndExerciseSection() {
        return dietaryAndExerciseSection;
    }

    public void setDietaryAndExerciseSection(DietaryAndExerciseSection dietaryAndExerciseSection) {
        this.dietaryAndExerciseSection = dietaryAndExerciseSection;
    }

    public DataCard healthInsuranceSection(HealthInsuranceSection healthInsuranceSection) {
        this.healthInsuranceSection = healthInsuranceSection;
        return this;
    }

    /**
     * Get healthInsuranceSection
     *
     * @return healthInsuranceSection
     **/
    public HealthInsuranceSection getHealthInsuranceSection() {
        return healthInsuranceSection;
    }

    public void setHealthInsuranceSection(HealthInsuranceSection healthInsuranceSection) {
        this.healthInsuranceSection = healthInsuranceSection;
    }

    public DataCard birthPlaceSection(BirthPlaceSection birthPlaceSection) {
        this.birthPlaceSection = birthPlaceSection;
        return this;
    }

    /**
     * Get birthPlaceSection
     *
     * @return birthPlaceSection
     **/
    public BirthPlaceSection getBirthPlaceSection() {
        return birthPlaceSection;
    }

    public void setBirthPlaceSection(BirthPlaceSection birthPlaceSection) {
        this.birthPlaceSection = birthPlaceSection;
    }

    public DataCard midwifeClinicSection(MidwifeClinicSection midwifeClinicSection) {
        this.midwifeClinicSection = midwifeClinicSection;
        return this;
    }

    /**
     * Get midwifeClinicSection
     *
     * @return midwifeClinicSection
     **/
    public MidwifeClinicSection getMidwifeClinicSection() {
        return midwifeClinicSection;
    }

    public void setMidwifeClinicSection(MidwifeClinicSection midwifeClinicSection) {
        this.midwifeClinicSection = midwifeClinicSection;
    }

    public DataCard postpartumNursingSection(PostpartumNursingSection postpartumNursingSection) {
        this.postpartumNursingSection = postpartumNursingSection;
        return this;
    }

    /**
     * Get postpartumNursingSection
     *
     * @return postpartumNursingSection
     **/
    public PostpartumNursingSection getPostpartumNursingSection() {
        return postpartumNursingSection;
    }

    public void setPostpartumNursingSection(PostpartumNursingSection postpartumNursingSection) {
        this.postpartumNursingSection = postpartumNursingSection;
    }

    public DataCard overallAssessmentSection(OverallAssessmentSection overallAssessmentSection) {
        this.overallAssessmentSection = overallAssessmentSection;
        return this;
    }

    /**
     * Get overallAssessmentSection
     *
     * @return overallAssessmentSection
     **/
    public OverallAssessmentSection getOverallAssessmentSection() {
        return overallAssessmentSection;
    }

    public void setOverallAssessmentSection(OverallAssessmentSection overallAssessmentSection) {
        this.overallAssessmentSection = overallAssessmentSection;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DataCard dataCard = (DataCard) o;
        return Objects.equals(this.recordTarget, dataCard.recordTarget) &&
                Objects.equals(this.childPartnerSection, dataCard.childPartnerSection) &&
                Objects.equals(this.languageSection, dataCard.languageSection) &&
                Objects.equals(this.bodyMeasuresSection, dataCard.bodyMeasuresSection) &&
                Objects.equals(this.socialHistorySection, dataCard.socialHistorySection) &&
                Objects.equals(this.previousBirthsSection, dataCard.previousBirthsSection) &&
                Objects.equals(this.previousAbortionsSection, dataCard.previousAbortionsSection) &&
                Objects.equals(this.expectedDateOfDeliverySection, dataCard.expectedDateOfDeliverySection) &&
                Objects.equals(this.prenatalRiskAssessmentSection, dataCard.prenatalRiskAssessmentSection) &&
                Objects.equals(this.workEnvironmentImpactSection, dataCard.workEnvironmentImpactSection) &&
                Objects.equals(this.allergiesSection, dataCard.allergiesSection) &&
                Objects.equals(this.screeningsSection, dataCard.screeningsSection) &&
                Objects.equals(this.chronicalDiseasesSection, dataCard.chronicalDiseasesSection) &&
                Objects.equals(this.medicineSection, dataCard.medicineSection) &&
                Objects.equals(this.mmrVacinationSection, dataCard.mmrVacinationSection) &&
                Objects.equals(this.historyOfPreviousTreatmentWithImpactOnPregnancySection, dataCard.historyOfPreviousTreatmentWithImpactOnPregnancySection) &&
                Objects.equals(this.tobaccoUseAndExposureSection, dataCard.tobaccoUseAndExposureSection) &&
                Objects.equals(this.alcoholDrinkingBehaviorSection, dataCard.alcoholDrinkingBehaviorSection) &&
                Objects.equals(this.substanceUseSection, dataCard.substanceUseSection) &&
                Objects.equals(this.dietaryAndExerciseSection, dataCard.dietaryAndExerciseSection) &&
                Objects.equals(this.healthInsuranceSection, dataCard.healthInsuranceSection) &&
                Objects.equals(this.birthPlaceSection, dataCard.birthPlaceSection) &&
                Objects.equals(this.midwifeClinicSection, dataCard.midwifeClinicSection) &&
                Objects.equals(this.postpartumNursingSection, dataCard.postpartumNursingSection) &&
                Objects.equals(this.overallAssessmentSection, dataCard.overallAssessmentSection) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recordTarget, childPartnerSection, languageSection, bodyMeasuresSection, socialHistorySection, previousBirthsSection, previousAbortionsSection, expectedDateOfDeliverySection, prenatalRiskAssessmentSection, workEnvironmentImpactSection, allergiesSection, screeningsSection, chronicalDiseasesSection, medicineSection, mmrVacinationSection, historyOfPreviousTreatmentWithImpactOnPregnancySection, tobaccoUseAndExposureSection, alcoholDrinkingBehaviorSection, substanceUseSection, dietaryAndExerciseSection, healthInsuranceSection, birthPlaceSection, midwifeClinicSection, postpartumNursingSection, overallAssessmentSection, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DataCard {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    recordTarget: ").append(toIndentedString(recordTarget)).append("\n");
        sb.append("    childPartnerSection: ").append(toIndentedString(childPartnerSection)).append("\n");
        sb.append("    languageSection: ").append(toIndentedString(languageSection)).append("\n");
        sb.append("    bodyMeasuresSection: ").append(toIndentedString(bodyMeasuresSection)).append("\n");
        sb.append("    socialHistorySection: ").append(toIndentedString(socialHistorySection)).append("\n");
        sb.append("    previousBirthsSection: ").append(toIndentedString(previousBirthsSection)).append("\n");
        sb.append("    previousAbortionsSection: ").append(toIndentedString(previousAbortionsSection)).append("\n");
        sb.append("    expectedDateOfDeliverySection: ").append(toIndentedString(expectedDateOfDeliverySection)).append("\n");
        sb.append("    prenatalRiskAssessmentSection: ").append(toIndentedString(prenatalRiskAssessmentSection)).append("\n");
        sb.append("    workEnvironmentImpactSection: ").append(toIndentedString(workEnvironmentImpactSection)).append("\n");
        sb.append("    allergiesSection: ").append(toIndentedString(allergiesSection)).append("\n");
        sb.append("    screeningsSection: ").append(toIndentedString(screeningsSection)).append("\n");
        sb.append("    chronicalDiseasesSection: ").append(toIndentedString(chronicalDiseasesSection)).append("\n");
        sb.append("    medicineSection: ").append(toIndentedString(medicineSection)).append("\n");
        sb.append("    mmrVacinationSection: ").append(toIndentedString(mmrVacinationSection)).append("\n");
        sb.append("    historyOfPreviousTreatmentWithImpactOnPregnancySection: ").append(toIndentedString(historyOfPreviousTreatmentWithImpactOnPregnancySection)).append("\n");
        sb.append("    tobaccoUseAndExposureSection: ").append(toIndentedString(tobaccoUseAndExposureSection)).append("\n");
        sb.append("    alcoholDrinkingBehaviorSection: ").append(toIndentedString(alcoholDrinkingBehaviorSection)).append("\n");
        sb.append("    substanceUseSection: ").append(toIndentedString(substanceUseSection)).append("\n");
        sb.append("    dietaryAndExerciseSection: ").append(toIndentedString(dietaryAndExerciseSection)).append("\n");
        sb.append("    healthInsuranceSection: ").append(toIndentedString(healthInsuranceSection)).append("\n");
        sb.append("    birthPlaceSection: ").append(toIndentedString(birthPlaceSection)).append("\n");
        sb.append("    midwifeClinicSection: ").append(toIndentedString(midwifeClinicSection)).append("\n");
        sb.append("    postpartumNursingSection: ").append(toIndentedString(postpartumNursingSection)).append("\n");
        sb.append("    overallAssessmentSection: ").append(toIndentedString(overallAssessmentSection)).append("\n");
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
