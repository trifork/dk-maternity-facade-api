package dk.sds.nsp.maternity.facade.common.exception;

import dk.sds.nsp.maternity.facade.common.model.ProblemDetails;

/**
 * Utility class for generation ProblemDetailsExceptions
 */
public final class ProblemDetailsExceptions {

    private ProblemDetailsExceptions() {}

    public static ProblemDetailsException forbidden(final Throwable cause) {
        return new ProblemDetailsException(
                new ProblemDetails()
                        .forbidden(),
                cause);
    }
}
