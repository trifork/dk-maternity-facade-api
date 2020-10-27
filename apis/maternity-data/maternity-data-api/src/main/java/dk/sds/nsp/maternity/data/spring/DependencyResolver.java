package dk.sds.nsp.maternity.data.spring;

import dk.sds.nsp.maternity.data.care_plan.service.CarePlanService;
import dk.sds.nsp.maternity.data.data_card.service.DataCardService;

public final class DependencyResolver {
    static DataCardService dataCardService;
    static CarePlanService carePlanService;

    public static DataCardService dataCardService() {
        return dataCardService;
    }

    public static CarePlanService carePlanService() {
        return carePlanService;
    }

    private DependencyResolver(){}
}
