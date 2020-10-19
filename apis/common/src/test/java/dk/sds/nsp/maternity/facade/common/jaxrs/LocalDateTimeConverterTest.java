package dk.sds.nsp.maternity.facade.common.jaxrs;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import dk.sds.nsp.maternity.facade.common.jaxrs.LocalDateTimeConverter.Deserializer;
import dk.sds.nsp.maternity.facade.common.jaxrs.LocalDateTimeConverter.Serializer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.stream.Stream;

import static dk.sds.nsp.maternity.facade.test.RandomService.localDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

class LocalDateTimeConverterTest {

    private static LocalDateTimeConverter converter;
    private static Serializer serializer;
    private static Deserializer deserializer;
    private static JsonGenerator generator;
    private static JsonParser parser;
    private static String serialized;

    @BeforeAll
    static void initialize() throws IOException {
        converter = new LocalDateTimeConverter();
        serializer = new Serializer();
        deserializer = new Deserializer();

        generator = Mockito.mock(JsonGenerator.class);
        doAnswer((x) -> serialized = x.getArgument(0))
                .when(generator).writeString(anyString());

        parser = Mockito.mock(JsonParser.class);
        when(parser.getValueAsString())
                .thenAnswer((x) -> serialized);
    }

    @BeforeEach
    void reset() {
        serialized = null;
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void encodeDecode(final LocalDateTime localDateTime) {
        final String serialized = converter.toString(localDateTime);
        final LocalDateTime deserialized = converter.fromString(serialized);

        assertEquals(localDateTime, deserialized);
    }

    @Test
    void encodeDecodeNull() {
        final String serialized = converter.toString(null);
        final LocalDateTime deserialized = converter.fromString(serialized);

        assertNull(serialized);
        assertNull(deserialized);
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void serializeDeserialize(final LocalDateTime localDateTime) throws IOException {
        serializer.serialize(localDateTime, generator, null);
        final LocalDateTime deserialized = deserializer.deserialize(parser, null);

        assertEquals(localDateTime, deserialized);
    }

    @Test
    void serializeDeserializeNull() throws IOException {
        serializer.serialize(null, generator, null);
        final LocalDateTime deserialized = deserializer.deserialize(parser, null);

        assertNull(serialized);
        assertNull(deserialized);
    }

    static Stream<Arguments> arguments() {
        return Stream.generate(() -> Arguments.of(localDateTime())).limit(100);
    }

}