package dk.sds.nsp.maternity.facade.common.jaxrs;

import javax.ws.rs.container.ContainerRequestContext;

public final class RequestContext {

    private static ThreadLocal<ContainerRequestContext> threadLocal = new ThreadLocal<>();

    static void init(final ContainerRequestContext info) {
        threadLocal.set(info);
    }

    public static ContainerRequestContext get() {
        return threadLocal.get();
    }

    static void remove() {
        threadLocal.remove();
    }
}
