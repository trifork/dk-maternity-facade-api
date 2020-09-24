package dk.sds.nsp.maternity.facade;

import com.auth0.jwt.algorithms.Algorithm;
import dk.sds.nsp.maternity.facade.test.RandomService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SpringTestConfiguration {

    @Bean
    public Algorithm algorithm() { return Algorithm.HMAC256(RandomService.randomString(100)); }
}
