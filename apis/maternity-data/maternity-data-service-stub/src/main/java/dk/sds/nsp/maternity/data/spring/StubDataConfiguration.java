package dk.sds.nsp.maternity.data.spring;

import dk.sds.nsp.maternity.data.service.DataCardService;
import dk.sds.nsp.maternity.data.service.DataCardServiceStub;
import dk.sds.nsp.maternity.facade.common.spring.CommonConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CommonConfiguration.class)
public class StubDataConfiguration {

    @Bean
    public DataCardService dataCardService(){
        return new DataCardServiceStub();
    }
}
