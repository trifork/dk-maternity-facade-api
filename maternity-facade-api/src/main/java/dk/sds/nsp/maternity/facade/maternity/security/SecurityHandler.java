package dk.sds.nsp.maternity.facade.maternity.security;

import dk.sds.nsp.maternity.facade.common.convert.SessionContextConverter;
import dk.sds.nsp.maternity.facade.common.security.SessionContext;
import dk.sds.nsp.maternity.facade.common.spring.SpringContext;

import javax.ws.rs.core.NewCookie;
import java.time.LocalDateTime;

public final class SecurityHandler {

    private static final SessionContextConverter CONVERTER = new SessionContextConverter(SpringContext.jwtHelper());

    private SecurityHandler() {}

    public static NewCookie updateContextCookie(final SessionContext context) {
        if(isBreakTheGlassExpired(context)) {
            return new NewCookie("context", CONVERTER.toString(SessionContext.clone(context).withBreakTheGlassExpiration(null).build()));
        }
        return new NewCookie("context", CONVERTER.toString(context));
    }

    private static boolean isBreakTheGlassExpired(final SessionContext context) {
        return context.getBreakTheGlassExpiration() != null && LocalDateTime.now().isAfter(context.getBreakTheGlassExpiration());
    }
}
