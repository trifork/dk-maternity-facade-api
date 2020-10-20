package dk.sds.nsp.maternity.facade.common.jaxrs;

import dk.sds.nsp.maternity.facade.common.util.SlaLogger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Intercepts http calls and do Slaloggin
 */
public class SlaLoggingFilter implements Filter {
    private static final SlaLogger LOGGER = new SlaLogger("api");

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        final long nanos = System.nanoTime();
        final long millis = System.currentTimeMillis();

        try {
            chain.doFilter(request, response);
        } catch (IOException | ServletException e) {
            LOGGER.addSlaLog((HttpServletRequest) request,
                    nanos,
                    millis, e);
            throw e;
        }
        LOGGER.addSlaLog((HttpServletRequest) request,
                nanos,
                millis);
    }

    @Override
    public void destroy() {
    }
}
