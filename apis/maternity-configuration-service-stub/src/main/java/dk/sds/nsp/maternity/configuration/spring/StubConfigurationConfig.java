package dk.sds.nsp.maternity.configuration.spring;

import dk.sds.nsp.maternity.facade.common.spring.CommonConfiguration;
import dk.sds.nsp.maternity.configuration.service.ConfigurationService;
import dk.sds.nsp.maternity.configuration.service.ConfigurationServiceStub;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CommonConfiguration.class)
public class StubConfigurationConfig {

    @Bean
    public ConfigurationService configurationService(){
        return new ConfigurationServiceStub();
    }
}
