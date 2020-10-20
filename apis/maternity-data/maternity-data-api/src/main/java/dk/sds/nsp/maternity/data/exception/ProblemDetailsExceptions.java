package dk.sds.nsp.maternity.data.exception;

import dk.sds.nsp.maternity.facade.common.exception.ProblemDetailsException;
import dk.sds.nsp.maternity.facade.common.model.ProblemDetails;
import dk.sds.nsp.maternity.facade.common.model.ProblemDetailsInvalidparams;

import static dk.sds.nsp.maternity.facade.common.util.Problems.typeFor;

public final class ProblemDetailsExceptions {

    private ProblemDetailsExceptions() {}

    public static ProblemDetailsException signatureCheckFailed(final Throwable cause) {
        return new ProblemDetailsException(
                new ProblemDetails()
                    .badRequest()
                    .type(typeFor("signature-check-failed.html"))
                    .detail("The session context JWT cookie has an invalid signature")
                    .addInvalidParamsItem(new ProblemDetailsInvalidparams()
                            .name("context")
                            .path("header:Cookie")
                            .reason("the signature does not match the header and body of the JWT")),
                cause);
    }
}
