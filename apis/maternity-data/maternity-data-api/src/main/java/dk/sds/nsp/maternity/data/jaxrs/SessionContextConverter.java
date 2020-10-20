package dk.sds.nsp.maternity.data.jaxrs;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import dk.sds.nsp.maternity.facade.common.model.ApplicationMode;
import dk.sds.nsp.maternity.facade.common.security.JWTHelper;
import dk.sds.nsp.maternity.data.security.SessionContext;
import dk.sds.nsp.maternity.data.spring.SessionContextQualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.ext.ParamConverter;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static dk.sds.nsp.maternity.facade.common.jaxrs.LocalDateTimeConverter.convert;

@Component
public class SessionContextConverter implements ParamConverter<SessionContext> {

    private static final Map<String, Object> JWT_HEADER_CLAIMS;

    static {
        JWT_HEADER_CLAIMS = Stream.of("typ").collect(Collectors.toMap(Function.identity(), e -> "JWT"));
    }

    private final JWTHelper jwtHelper;

    @Autowired
    public SessionContextConverter(@SessionContextQualifier JWTHelper jwtHelper) {
        this.jwtHelper = jwtHelper;
    }

    @Override
    public SessionContext fromString(final String value) {
        if(value == null) return null;

        final DecodedJWT jwt = jwtHelper.verify(value);
        return SessionContext
                .withApplicationMode(ApplicationMode.fromValue(jwt.getClaim(SessionContext.APPLICATION_MODE_CLAIM_NAME).asString()))
                .withPatientIdentifier(jwt.getClaim(SessionContext.PATIENT_IDENTIFIER_CLAIM_NAME).asString())
                .withBreakTheGlassExpiration(convert(jwt.getClaim(SessionContext.BREAK_THE_GLASS_EXPIRATION_CLAIM_NAME).asString()))
                .build();
    }

    @Override
    public String toString(final SessionContext sessionContext) {
        if(sessionContext == null) return null;

        if(sessionContext.getBreakTheGlassExpiration() == null) {
            return jwtHelper.sign(JWT.create()
                    .withHeader(JWT_HEADER_CLAIMS)
                    .withClaim(SessionContext.APPLICATION_MODE_CLAIM_NAME, sessionContext.getApplicationMode().toString())
                    .withClaim(SessionContext.PATIENT_IDENTIFIER_CLAIM_NAME, sessionContext.getPatientIdentifier()));
        }

        return jwtHelper.sign(JWT.create()
                .withHeader(JWT_HEADER_CLAIMS)
                .withClaim(SessionContext.APPLICATION_MODE_CLAIM_NAME, sessionContext.getApplicationMode().toString())
                .withClaim(SessionContext.PATIENT_IDENTIFIER_CLAIM_NAME, sessionContext.getPatientIdentifier())
                .withClaim(SessionContext.BREAK_THE_GLASS_EXPIRATION_CLAIM_NAME, convert(sessionContext.getBreakTheGlassExpiration())));
    }
}
