package dk.sds.nsp.maternity.facade.common.convert;

import dk.sds.nsp.maternity.facade.common.security.SessionContext;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.time.LocalDateTime;

import static dk.sds.nsp.maternity.facade.common.spring.SpringContext.jwtHelper;

@Provider
public class CommonConverterProvider implements ParamConverterProvider {

    @SuppressWarnings("unchecked")
    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
        if(rawType.equals(SessionContext.class)) return (ParamConverter<T>) new SessionContextConverter(jwtHelper());
        if(rawType.equals(LocalDateTime.class)) return (ParamConverter<T>) new LocalDateTimeConverter();

        return null;
    }
}
