package dk.sds.nsp.maternity.configuration.spring;

import dk.sds.nsp.maternity.configuration.service.ConfigurationService;

public final class DependencyResolver {
    static ConfigurationService configurationService;

    public static ConfigurationService getConfigurationService() {
        return configurationService;
    }

    private DependencyResolver(){}
}
