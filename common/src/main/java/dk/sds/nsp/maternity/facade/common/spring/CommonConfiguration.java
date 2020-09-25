package dk.sds.nsp.maternity.facade.common.spring;

import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.UnsupportedEncodingException;

@Configuration
public class CommonConfiguration {

    @Bean
    public Algorithm algorithm() throws UnsupportedEncodingException {
        return Algorithm.HMAC256("fds");
    }
}
