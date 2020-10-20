package dk.sds.nsp.maternity.data.security;

import dk.sds.nsp.maternity.data.jaxrs.SessionContextConverter;
import dk.sds.nsp.maternity.facade.common.security.Cookies;
import dk.sds.nsp.maternity.facade.common.spring.SpringContext;

import javax.ws.rs.core.NewCookie;
import java.time.LocalDateTime;

public final class SecurityHandler {

    private static final SessionContextConverter CONVERTER = new SessionContextConverter(SpringContext.jwtHelper());

    private SecurityHandler() {}

    public static NewCookie updateContextCookie(final SessionContext context) {
        if(isBreakTheGlassExpired(context)) {
            final SessionContext updatedContext = SessionContext.clone(context).withBreakTheGlassExpiration(null).build();
            return cookie(updatedContext);
        }

        return cookie(context);
    }

    private static boolean isBreakTheGlassExpired(final SessionContext context) {
        return context.getBreakTheGlassExpiration() != null && LocalDateTime.now().isAfter(context.getBreakTheGlassExpiration());
    }

    private static NewCookie cookie(final SessionContext context) {
        return Cookies.cookie()
                .withName("context")
                .withValue(CONVERTER.toString(context))
                .secure()
                .build();
    }
}
