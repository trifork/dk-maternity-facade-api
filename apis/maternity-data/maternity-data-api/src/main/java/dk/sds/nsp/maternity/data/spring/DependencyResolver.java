package dk.sds.nsp.maternity.data.spring;

import dk.sds.nsp.maternity.data.service.DataCardService;

public final class DependencyResolver {
    static DataCardService dataCardService;

    public static DataCardService dataCardService() {
        return dataCardService;
    }

    private DependencyResolver(){}
}
