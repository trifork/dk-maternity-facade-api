package dk.sds.nsp.maternity.facade.common.jaxrs;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.ext.Provider;

import static dk.sds.nsp.maternity.facade.common.spring.SpringContext.objectMapper;

@Provider
@Produces({ MediaTypes.APPLICATION_JSON, MediaTypes.APPLICATION_JSON_PROBLEM})
@Consumes({ MediaTypes.APPLICATION_JSON })
public class JsonProvider extends JacksonJsonProvider {

    public JsonProvider() {
        super(objectMapper());
    }

}
