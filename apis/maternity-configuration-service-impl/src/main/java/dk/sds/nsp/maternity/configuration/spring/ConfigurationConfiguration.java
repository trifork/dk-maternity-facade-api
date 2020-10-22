package dk.sds.nsp.maternity.configuration.spring;

import dk.sds.nsp.maternity.facade.common.spring.CommonConfiguration;
import dk.sds.nsp.maternity.configuration.service.ConfigurationService;
import dk.sds.nsp.maternity.configuration.service.ConfigurationServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CommonConfiguration.class)
public class ConfigurationConfiguration {

    @Bean
    public ConfigurationService configurationService(){
        return new ConfigurationServiceImpl();
    }
}
