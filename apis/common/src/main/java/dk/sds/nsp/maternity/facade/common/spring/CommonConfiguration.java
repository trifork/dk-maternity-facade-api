package dk.sds.nsp.maternity.facade.common.spring;

import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import dk.sds.nsp.maternity.cfg.AppConfiguration;
import dk.sds.nsp.maternity.facade.common.jaxrs.LocalDateTimeConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;

@Configuration
public class CommonConfiguration {

    @Bean
    public Algorithm algorithm() throws UnsupportedEncodingException {
        return Algorithm.HMAC256("asdf");
    }

    @Bean
    public AppConfiguration configuration(){
        final AppConfiguration appConfiguration = new AppConfiguration();
        appConfiguration.init();
        return appConfiguration;
    }

    @Bean
    public ObjectMapper objectMapper() {
        final SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDateTime.class, new LocalDateTimeConverter.Serializer());
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeConverter.Deserializer());

        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(module);
        return  objectMapper;
    }
}
