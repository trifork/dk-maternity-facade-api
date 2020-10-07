package dk.sds.nsp.maternity.facade.common.exception;

public final class ProblemDetails {

    private ProblemDetails() {}
    public static ProblemDetailsException unauthorized() {
        return new ProblemDetailsException(new dk.sds.nsp.maternity.facade.common.model.ProblemDetails().status(403), null); }
    public static ProblemDetailsException internalServerError() { return null; }
}
