package dk.sds.nsp.maternity.facade.common.exception;

import org.jboss.resteasy.spi.BadRequestException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class BadRequestExceptionMapper implements ExceptionMapper<BadRequestException> {

    private final ProblemDetailsExceptionMapper problemDetailsExceptionMapper;

    public BadRequestExceptionMapper() {
        problemDetailsExceptionMapper = new ProblemDetailsExceptionMapper();
    }

    @Override
    public Response toResponse(BadRequestException exception) {
        final Throwable cause = exception.getCause();
        if (cause instanceof ProblemDetailsException) {
            return problemDetailsExceptionMapper.toResponse((ProblemDetailsException) cause);
        }
        return Response.status(500).build();
    }
}
