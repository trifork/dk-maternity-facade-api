package dk.sds.nsp.maternity.facade.common.jaxrs;

import dk.sds.nsp.maternity.facade.common.model.ProblemDetails;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import static dk.sds.nsp.maternity.facade.common.spring.SpringContext.objectMapper;

/**
 * A {@link MessageBodyWriter} capable of writing {@link ProblemDetails} for MediaType {@link MediaTypes#APPLICATION_JSON}.
 */
@Provider
@Produces(MediaTypes.APPLICATION_JSON_PROBLEM)
public class ProblemDetailsMessageBodyWriter implements MessageBodyWriter<ProblemDetails> {

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return type == ProblemDetails.class;
    }

    @Override
    public long getSize(ProblemDetails problemDetails, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        // As of JAX-RS 2.0, the method has been deprecated and the value returned by the method is ignored
        // by a JAX-RS runtime. All MessageBodyWriter implementations are advised to return -1 from the
        // method. Responsibility to compute the actual Content-Length header value has been delegated to
        // JAX-RS runtime.
        return -1;
    }

    @Override
    public void writeTo(ProblemDetails problemDetails, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
       objectMapper().writeValue(entityStream, problemDetails);
    }
}
