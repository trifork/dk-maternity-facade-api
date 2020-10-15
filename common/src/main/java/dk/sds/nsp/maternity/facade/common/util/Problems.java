package dk.sds.nsp.maternity.facade.common.util;

import dk.sds.nsp.maternity.facade.common.jaxrs.RequestContext;

import static dk.sds.nsp.maternity.facade.common.api.ProblemService.PATH;

public final class Problems {

    private Problems() {}

    /**
     * Returns the absolute path for a deferrable RFC 7807 problem type.
     * @param filename The filename of the deferred pr
     * @return The absolute path of the file
     */
    public static String typeFor(final String filename) {
        return RequestContext.get().getUriInfo().getBaseUri().getPath() + PATH + filename;
    }
}
