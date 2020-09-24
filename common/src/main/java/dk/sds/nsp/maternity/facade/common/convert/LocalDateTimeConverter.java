package dk.sds.nsp.maternity.facade.common.convert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class LocalDateTimeConverter {

    public static LocalDateTime convert(final String value) {
        return value == null ? null : LocalDateTime.parse(value, DateTimeFormatter.ISO_DATE_TIME);
    }

    public static String convert(final LocalDateTime value) {
        return value == null ? null : value.format(DateTimeFormatter.ISO_DATE_TIME);
    }
}
