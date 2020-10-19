package dk.sds.nsp.maternity.facade.common.jaxrs;

import dk.sds.nsp.maternity.facade.common.exception.ProblemDetailsException;
import dk.sds.nsp.maternity.facade.common.model.ProblemDetails;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * An {@link ExceptionMapper} capable of mapping a {@link ProblemDetailsException} to a
 * <a href="https://tools.ietf.org/html/rfc7807">Problem Details for HTTP APIs</a> response
 */
@Provider
public class ProblemDetailsExceptionMapper implements ExceptionMapper<ProblemDetailsException> {

    @Override
    public Response toResponse(ProblemDetailsException exception) {
        final ProblemDetails details = exception.getDetails();

        return Response
                .status(details.getStatus())
                .type(MediaTypes.APPLICATION_JSON_PROBLEM)
                .entity(details)
                .build();
    }
}
