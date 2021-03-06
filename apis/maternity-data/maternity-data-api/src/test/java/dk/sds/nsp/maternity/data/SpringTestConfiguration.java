package dk.sds.nsp.maternity.data;

import com.auth0.jwt.algorithms.Algorithm;
import dk.sds.nsp.maternity.data.spring.ApplicationContextQualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.UnsupportedEncodingException;

@Configuration
@ComponentScan
public class SpringTestConfiguration {

    @Bean
    @ApplicationContextQualifier
    public Algorithm algorithm() throws UnsupportedEncodingException { return Algorithm.HMAC256("fds"); }
}
