package dk.sds.nsp.maternity.data.spring;

import dk.sds.nsp.maternity.data.care_plan.service.CarePlanService;
import dk.sds.nsp.maternity.data.data_card.service.DataCardService;
import dk.sds.nsp.maternity.data.observation.service.ObservationService;

public final class DependencyResolver {
    static DataCardService dataCardService;
    static CarePlanService carePlanService;
    static ObservationService observationService;

    public static DataCardService dataCardService() {
        return dataCardService;
    }

    public static CarePlanService carePlanService() {
        return carePlanService;
    }

    public static ObservationService observationService() {
        return observationService;
    }

    private DependencyResolver(){}
}
