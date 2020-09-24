package dk.sds.nsp.maternity.facade.common.exception;

public final class ProblemDetails {

    private ProblemDetails() {}
    public static ProblemDetailsException unauthorized() { return null; }
    public static ProblemDetailsException internalServerError() { return null; }
}
