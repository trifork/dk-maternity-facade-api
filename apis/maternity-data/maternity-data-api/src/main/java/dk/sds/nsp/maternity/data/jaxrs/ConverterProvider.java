package dk.sds.nsp.maternity.data.jaxrs;


import dk.sds.nsp.maternity.data.security.ApplicationContext;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import static dk.sds.nsp.maternity.data.spring.SpringContext.contextJwtHelper;

@Provider
public class ConverterProvider implements ParamConverterProvider {

    @SuppressWarnings("unchecked")
    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
        if(rawType.equals(ApplicationContext.class)) return (ParamConverter<T>) new ApplicationContextConverter(contextJwtHelper());

        return null;
    }
}
