package dk.sds.nsp.maternity.facade.maternity.spring;

import com.auth0.jwt.algorithms.Algorithm;
import dk.sds.nsp.maternity.cfg.AppConfiguration;
import dk.sds.nsp.maternity.facade.common.spring.CommonConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.io.UnsupportedEncodingException;

@Configuration
@Import(CommonConfiguration.class)
public class MaternityDataConfiguration {

    @Bean
    @SessionContextQualifier
    public Algorithm algorithm(AppConfiguration configuration) throws UnsupportedEncodingException {
        return Algorithm.HMAC256(configuration.getContextJwtSecret());
    }

}
