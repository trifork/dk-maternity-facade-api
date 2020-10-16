package dk.sds.nsp.maternity.facade.maternity.jaxrs;


import dk.sds.nsp.maternity.facade.maternity.security.SessionContext;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import static dk.sds.nsp.maternity.facade.maternity.spring.SpringContext.jwtHelper;

@Provider
public class ConverterProvider implements ParamConverterProvider {

    @SuppressWarnings("unchecked")
    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
        if(rawType.equals(SessionContext.class)) return (ParamConverter<T>) new SessionContextConverter(jwtHelper());

        return null;
    }
}
