package dk.sds.nsp.maternity.data.observation.service;

import dk.sds.nsp.maternity.data.observation.model.CreateObservation;
import dk.sds.nsp.maternity.data.observation.model.EditableObservationValues;
import dk.sds.nsp.maternity.data.observation.model.Observation;
import dk.sds.nsp.maternity.data.observation.model.ObservationType;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

public class ObservationTemplates {
    public final static CreateObservation WEIGHT;
    static {
        WEIGHT = new CreateObservation().type(ObservationType.WEIGHT);
        WEIGHT.values(Collections.singletonList(
                new EditableObservationValues().unit("kg")
        )).dateOfMeasurement(new Date());
    }
    public final static CreateObservation BLOOD_PREASSURE;
    static {
        BLOOD_PREASSURE = new CreateObservation().type(ObservationType.BLOOD_PREASSURE);
        BLOOD_PREASSURE.values(Arrays.asList(
                new EditableObservationValues().name("Systolisk").unit("mm Hg"),
                new EditableObservationValues().name("Diastolisk").unit("mm Hg")
        )).dateOfMeasurement(new Date());
    }
    public final static CreateObservation URINE;
    static {
        URINE = new CreateObservation().type(ObservationType.URINE);
        URINE.values(Collections.singletonList(
                new EditableObservationValues()
        )).dateOfMeasurement(new Date());
    }
    public final static CreateObservation EDEMA;
    static {
        EDEMA = new CreateObservation().type(ObservationType.EDEMA);
        EDEMA.values(Collections.singletonList(
                new EditableObservationValues()
        )).dateOfMeasurement(new Date());
    }
    public final static CreateObservation PUBIS_MEASURUEMENTS;
    static {
        PUBIS_MEASURUEMENTS = new CreateObservation().type(ObservationType.PUBIS_MEASURUEMENTS);
        PUBIS_MEASURUEMENTS.values(Collections.singletonList(
                new EditableObservationValues().unit("cm")
        )).dateOfMeasurement(new Date());
    }
    public final static CreateObservation FETUS_ACTIVITY;
    static {
        FETUS_ACTIVITY = new CreateObservation().type(ObservationType.FETUS_ACTIVITY);
        FETUS_ACTIVITY.values(Collections.singletonList(
                new EditableObservationValues()
        )).dateOfMeasurement(new Date());
    }
    public final static CreateObservation FETUS_WEIGHT_ESTIMATE;
    static {
        FETUS_WEIGHT_ESTIMATE = new CreateObservation().type(ObservationType.FETUS_WEIGHT_ESTIMATE);
        FETUS_WEIGHT_ESTIMATE.values(Collections.singletonList(
                new EditableObservationValues().unit("g")
        )).dateOfMeasurement(new Date());
    }
    public final static CreateObservation FETUS_PRESENTATION;
    static {
        FETUS_PRESENTATION = new CreateObservation().type(ObservationType.FETUS_PRESENTATION);
        FETUS_PRESENTATION.values(Collections.singletonList(
                new EditableObservationValues()
        )).dateOfMeasurement(new Date());
    }
    public final static CreateObservation GA_U_D;
    static {
        GA_U_D = new CreateObservation().type(ObservationType.GA_U_D);
        GA_U_D.values(Collections.singletonList(
                new EditableObservationValues().unit("uger+dage")
        )).dateOfMeasurement(new Date());
    }
    public final static CreateObservation UL_WEIGHT;
    static {
        UL_WEIGHT = new CreateObservation().type(ObservationType.UL_WEIGHT);
        UL_WEIGHT.values(Collections.singletonList(
                new EditableObservationValues().unit("g")
        )).dateOfMeasurement(new Date());
    }
    public final static CreateObservation WEIGHT_DEVIATION;
    static {
        WEIGHT_DEVIATION = new CreateObservation().type(ObservationType.WEIGHT_DEVIATION);
        WEIGHT_DEVIATION.values(Collections.singletonList(
                new EditableObservationValues().unit("g")
        )).dateOfMeasurement(new Date());
    }
    public final static CreateObservation AMNIOTIC_FLUID;
    static {
        AMNIOTIC_FLUID = new CreateObservation().type(ObservationType.AMNIOTIC_FLUID);
        AMNIOTIC_FLUID.values(Arrays.asList(
                new EditableObservationValues().name("AFI"),
                new EditableObservationValues().name("DVP")
        )).dateOfMeasurement(new Date());
    }
    public final static CreateObservation FLOW;
    static {
        FLOW = new CreateObservation().type(ObservationType.FLOW);
        FLOW.values(Arrays.asList(
                new EditableObservationValues().name("Flow navlestreng"),
                new EditableObservationValues().name("Flow hjerne")
        )).dateOfMeasurement(new Date());
    }
}
