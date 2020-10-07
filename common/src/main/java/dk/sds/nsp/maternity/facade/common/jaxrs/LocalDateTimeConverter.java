package dk.sds.nsp.maternity.facade.common.jaxrs;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import javax.ws.rs.ext.ParamConverter;
import java.io.IOException;
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
    public LocalDateTime fromString(final String value) {
        return convert(value);
    }

    @Override
    public String toString(final LocalDateTime value) {
        return convert(value);
    }

    public static final class Serializer extends JsonSerializer<LocalDateTime> {
        @Override
        public void serialize(final LocalDateTime value, final JsonGenerator jgen, final SerializerProvider provider) throws IOException {
            jgen.writeString(convert(value));
        }
    }

    public static final class Deserializer extends JsonDeserializer<LocalDateTime> {
        @Override
        public LocalDateTime deserialize(final JsonParser jp, final DeserializationContext ctxt) throws IOException {
            return convert(jp.getValueAsString());
        }
    }
}
