package dk.sds.nsp.maternity.data.security;

import dk.sds.nsp.maternity.data.jaxrs.ApplicationContextConverter;
import dk.sds.nsp.maternity.facade.common.security.Cookies;
import dk.sds.nsp.maternity.facade.common.spring.SpringContext;

import javax.ws.rs.core.NewCookie;
import java.time.LocalDateTime;

public final class SecurityHandler {

    private static final ApplicationContextConverter CONVERTER = new ApplicationContextConverter(SpringContext.jwtHelper());

    private SecurityHandler() {}

    public static NewCookie updateContextCookie(final ApplicationContext context) {
        if(isBreakTheGlassExpired(context)) {
            final ApplicationContext updatedContext = ApplicationContext.clone(context).withBreakTheGlassExpiration(null).build();
            return cookie(updatedContext);
        }

        return cookie(context);
    }

    private static boolean isBreakTheGlassExpired(final ApplicationContext context) {
        return context.getBreakTheGlassExpiration() != null && LocalDateTime.now().isAfter(context.getBreakTheGlassExpiration());
    }

    private static NewCookie cookie(final ApplicationContext context) {
        return Cookies.cookie()
                .withName("context")
                .withValue(CONVERTER.toString(context))
                .secure()
                .build();
    }
}
