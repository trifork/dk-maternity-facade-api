package dk.sds.nsp.maternity.facade.common.exception;

import dk.sds.nsp.maternity.facade.common.model.ProblemDetails;

public class ProblemDetailsException extends RuntimeException {

    private final ProblemDetails details;

    ProblemDetailsException(final ProblemDetails details, final Throwable cause) {
        super(cause);
        this.details = details;
    }

    public ProblemDetails getDetails() { return details; }
}
