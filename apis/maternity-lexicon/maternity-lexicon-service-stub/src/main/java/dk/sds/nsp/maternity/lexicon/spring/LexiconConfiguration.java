package dk.sds.nsp.maternity.lexicon.spring;

import dk.sds.nsp.maternity.facade.common.spring.CommonConfiguration;
import dk.sds.nsp.maternity.lexicon.service.LexiconService;
import dk.sds.nsp.maternity.lexicon.service.LexiconServiceStub;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CommonConfiguration.class)
public class LexiconConfiguration {

    @Bean
    public LexiconService lexiconService(){
        return new LexiconServiceStub();
    }
}
