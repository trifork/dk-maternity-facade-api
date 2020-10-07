package dk.sds.nsp.maternity.facade.common.jaxrs;

import dk.sds.nsp.maternity.facade.common.exception.ProblemDetailsException;
import dk.sds.nsp.maternity.facade.common.model.ProblemDetails;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ProblemDetailsExceptionMapper implements ExceptionMapper<ProblemDetailsException> {

    @Override
    public Response toResponse(ProblemDetailsException exception) {
        final ProblemDetails details = exception.getDetails();

        return Response
                .status(details.getStatus())
                .type(MediaType.APPLICATION_JSON_TYPE + "+problem")
                .entity(details)
                .build();
    }
}
