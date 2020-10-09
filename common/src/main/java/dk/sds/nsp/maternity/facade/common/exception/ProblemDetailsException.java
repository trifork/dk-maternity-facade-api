package dk.sds.nsp.maternity.facade.common.exception;

import dk.sds.nsp.maternity.facade.common.model.ProblemDetails;

/**
 * A {@link ProblemDetailsException} is a {@link RuntimeException} that can be thrown
 * during normal operation of the Java Virtual Machine. It carries with it a
 * {@link ProblemDetails} instance, that contains information to produce a
 * <a href="https://tools.ietf.org/html/rfc7807">Problem Details for HTTP APIs</a>
 * response.
 */
public class ProblemDetailsException extends RuntimeException {

    private final ProblemDetails details;

    /**
     * Creates a new instance of {@link ProblemDetailsException}
     * @param details The {@link ProblemDetails} instance
     */
    public ProblemDetailsException(final ProblemDetails details) { this(details, null); }

    /**
     * Creates a new instance of {@link ProblemDetailsException}
     * @param details The {@link ProblemDetails} instance
     * @param cause The throwable that triggered this exception.
     */
    public ProblemDetailsException(final ProblemDetails details, final Throwable cause) {
        super(cause);
        this.details = details;
    }

    /**
     * Get the {@link ProblemDetails} for this {@link ProblemDetailsException} instance
     * @return The {@link ProblemDetails} of this {@link ProblemDetailsException} instance
     */
    public ProblemDetails getDetails() { return details; }

}
