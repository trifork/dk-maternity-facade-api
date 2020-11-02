package dk.sds.nsp.maternity.data.jaxrs;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import dk.sds.nsp.maternity.facade.common.model.ApplicationMode;
import dk.sds.nsp.maternity.facade.common.security.JWTHelper;
import dk.sds.nsp.maternity.data.security.ApplicationContext;
import dk.sds.nsp.maternity.data.spring.ApplicationContextQualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.ext.ParamConverter;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static dk.sds.nsp.maternity.facade.common.jaxrs.LocalDateTimeConverter.convert;

@Component
public class ApplicationContextConverter implements ParamConverter<ApplicationContext> {

    private static final Map<String, Object> JWT_HEADER_CLAIMS;

    static {
        JWT_HEADER_CLAIMS = Stream.of("typ").collect(Collectors.toMap(Function.identity(), e -> "JWT"));
    }

    private final JWTHelper jwtHelper;

    @Autowired
    public ApplicationContextConverter(@ApplicationContextQualifier JWTHelper jwtHelper) {
        this.jwtHelper = jwtHelper;
    }

    @Override
    public ApplicationContext fromString(final String value) {
        if(value == null) return null;

        final DecodedJWT jwt = jwtHelper.verify(value);
        return ApplicationContext
                .withApplicationMode(ApplicationMode.fromValue(jwt.getClaim(ApplicationContext.APPLICATION_MODE_CLAIM_NAME).asString()))
                .withBreakTheGlassExpiration(convert(jwt.getClaim(ApplicationContext.BREAK_THE_GLASS_EXPIRATION_CLAIM_NAME).asString()))
                .build();
    }

    @Override
    public String toString(final ApplicationContext applicationContext) {
        if(applicationContext == null) return null;

        if(applicationContext.getBreakTheGlassExpiration() == null) {
            return jwtHelper.sign(JWT.create()
                    .withHeader(JWT_HEADER_CLAIMS)
                    .withClaim(ApplicationContext.APPLICATION_MODE_CLAIM_NAME, applicationContext.getApplicationMode().toString()));
        }

        return jwtHelper.sign(JWT.create()
                .withHeader(JWT_HEADER_CLAIMS)
                .withClaim(ApplicationContext.APPLICATION_MODE_CLAIM_NAME, applicationContext.getApplicationMode().toString())
                .withClaim(ApplicationContext.BREAK_THE_GLASS_EXPIRATION_CLAIM_NAME, convert(applicationContext.getBreakTheGlassExpiration())));
    }
}
