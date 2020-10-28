package dk.sds.maternity.saml.auth;

import dk.itst.oiosaml.sp.service.SPFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CustomSPFilter extends SPFilter {
    private final List<String> skipSPFilterPaths = Arrays.asList(
            "/youAreLoggedOut",
            "/isAlive",
            "/session"
    );

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = ((HttpServletRequest) request);
//        final String header = httpServletRequest.getHeader("X-Requested-With");
//        if("javascript".equals(header) && UserAssertionHolder.get() != null){
//        }
        // bypass the SPFilter
        if(skipSPFilterPaths.stream().anyMatch(path -> httpServletRequest.getRequestURI().startsWith(path))){
            chain.doFilter(request, response);
            return;
        }
        super.doFilter(request, response, chain);
    }
}
