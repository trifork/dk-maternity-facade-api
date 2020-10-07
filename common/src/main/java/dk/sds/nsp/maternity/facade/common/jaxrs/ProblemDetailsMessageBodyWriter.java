package dk.sds.nsp.maternity.facade.common.jaxrs;

import com.fasterxml.jackson.databind.ObjectMapper;
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

@Provider
@Produces(MediaTypes.APPLICATION_JSON_PROBLEM)
public class ProblemDetailsMessageBodyWriter implements MessageBodyWriter<ProblemDetails> {
    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return type == ProblemDetails.class;
    }

    @Override
    public long getSize(ProblemDetails problemDetails, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return 0;
    }

    @Override
    public void writeTo(ProblemDetails problemDetails, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
        new ObjectMapper().writeValue(entityStream, problemDetails);
    }
}
