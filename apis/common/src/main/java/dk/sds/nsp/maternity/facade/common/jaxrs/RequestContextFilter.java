package dk.sds.nsp.maternity.facade.common.jaxrs;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class RequestContextFilter implements ContainerRequestFilter, ContainerResponseFilter {

    @Override
    public void filter(final ContainerRequestContext requestContext) {
        RequestContext.init(requestContext);
    }

    @Override
    public void filter(final ContainerRequestContext requestContext, final ContainerResponseContext responseContext) {
        RequestContext.remove();
    }
}
