package dk.sds.nsp.maternity.facade.common.convert;

import dk.sds.nsp.maternity.facade.SpringTestConfiguration;
import dk.sds.nsp.maternity.facade.common.security.SessionContext;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.Stream;

import static dk.sds.nsp.maternity.facade.common.model.ApplicationMode.EMBEDDED;
import static dk.sds.nsp.maternity.facade.common.model.ApplicationMode.STANDALONE;
import static dk.sds.nsp.maternity.facade.test.RandomService.choose;
import static dk.sds.nsp.maternity.facade.test.RandomService.localDateTime;
import static dk.sds.nsp.maternity.facade.test.RandomService.numerify;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringTestConfiguration.class)
class SessionContextConverterTest {

    @Autowired
    private SessionContextConverter converter;

    @ParameterizedTest
    @MethodSource("arguments")
    void encodeDecode(final SessionContext context) {
        final String serialized = converter.toString(context);
        final SessionContext deserialized = converter.fromString(serialized);

        assertEquals(context.getApplicationMode(), deserialized.getApplicationMode());
        assertEquals(context.getPatientIdentifier(), deserialized.getPatientIdentifier());
        assertEquals(context.getBreakTheGlassExpiration(), deserialized.getBreakTheGlassExpiration());
    }

    static Stream<Arguments> arguments() {
        return Stream.generate(() -> Arguments.of(randomContext())).limit(100);
    }

    private static SessionContext randomContext() {
        return SessionContext
                .withApplicationMode(choose(EMBEDDED, STANDALONE))
                .withPatientIdentifier(numerify("##########"))
                .withBreakTheGlassExpiration(localDateTime())
                .build();
    }

}