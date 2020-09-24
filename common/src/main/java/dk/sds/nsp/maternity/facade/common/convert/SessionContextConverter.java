package dk.sds.nsp.maternity.facade.common.convert;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import dk.sds.nsp.maternity.facade.common.model.ApplicationMode;
import dk.sds.nsp.maternity.facade.common.security.JWTHelper;
import dk.sds.nsp.maternity.facade.common.security.SessionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.ext.ParamConverter;

import static dk.sds.nsp.maternity.facade.common.convert.LocalDateTimeConverter.convert;
import static dk.sds.nsp.maternity.facade.common.security.SessionContext.APPLICATION_MODE_CLAIM_NAME;
import static dk.sds.nsp.maternity.facade.common.security.SessionContext.BREAK_THE_GLASS_EXPIRATION_CLAIM_NAME;
import static dk.sds.nsp.maternity.facade.common.security.SessionContext.PATIENT_IDENTIFIER_CLAIM_NAME;

@Component
public class SessionContextConverter implements ParamConverter<SessionContext> {

    private final JWTHelper jwtHelper;

    @Autowired
    public SessionContextConverter(JWTHelper jwtHelper) {
        this.jwtHelper = jwtHelper;
    }

    @Override
    public SessionContext fromString(final String value) {
        final DecodedJWT jwt = jwtHelper.verify(value);
        return SessionContext
                .withApplicationMode(ApplicationMode.fromValue(jwt.getClaim(APPLICATION_MODE_CLAIM_NAME).asString()))
                .withPatientIdentifier(jwt.getClaim(PATIENT_IDENTIFIER_CLAIM_NAME).asString())
                .withBreakTheGlassExpiration(convert(jwt.getClaim(BREAK_THE_GLASS_EXPIRATION_CLAIM_NAME).asString()))
                .build();
    }

    @Override
    public String toString(final SessionContext sessionContext) {
        return jwtHelper.sign(JWT.create()
                .withClaim(APPLICATION_MODE_CLAIM_NAME, sessionContext.getApplicationMode().toString())
                .withClaim(PATIENT_IDENTIFIER_CLAIM_NAME, sessionContext.getPatientIdentifier())
                .withClaim(BREAK_THE_GLASS_EXPIRATION_CLAIM_NAME, convert(sessionContext.getBreakTheGlassExpiration())));
    }
}
