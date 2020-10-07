package dk.sds.nsp.maternity.facade.common.jaxrs;

import javax.ws.rs.ext.ParamConverter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class LocalDateTimeConverter implements ParamConverter<LocalDateTime> {

    public static LocalDateTime convert(final String value) {
        return value == null ? null : LocalDateTime.parse(value, DateTimeFormatter.ISO_DATE_TIME);
    }

    public static String convert(final LocalDateTime value) {
        return value == null ? null : value.format(DateTimeFormatter.ISO_DATE_TIME);
    }

    @Override
    public LocalDateTime fromString(String value) {
        return convert(value);
    }

    @Override
    public String toString(LocalDateTime value) {
        return convert(value);
    }
}
