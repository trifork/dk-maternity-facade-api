package dk.sds.nsp.maternity.facade.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.stream.Stream;

import static java.lang.String.format;
import static java.util.regex.Pattern.matches;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class RandomServiceTest {

    private static final int MAX_TRIES = 1000;
    private static final int N_CHARACTERS = 100;
    private static final Random RANDOM = new Random("Trifork".hashCode());

    @Test
    void choose() {
        int maxTries = MAX_TRIES;
        int hits = 0;
        while(maxTries-- > 0 && hits != 0b1111) {
            hits = hits | RandomService.choose(0b0001, 0b0010, 0b0100, 0b1000);
        }
        assertTrue(maxTries > 0, format("Did not choose all possible options within %d tries",  MAX_TRIES));
    }

    @Test
    void chooseOrNull() {
        int maxTries = MAX_TRIES;
        int hits = 0;
        while(maxTries-- > 0 && hits != 0b11111) {
            final Integer value = RandomService.chooseOrNull(0b00001, 0b00010, 0b00100, 0b01000);
            hits = hits | (value == null ? 0b10000 : value);
        }
        assertTrue(maxTries > 0, format("Did not choose all possible options within %d tries",  MAX_TRIES));
    }

    @ParameterizedTest
    @MethodSource("numerifyArguments")
    void numerify(final String value, final String regex) {
        final String numerified = RandomService.numerify(value);
        assertTrue(matches(regex, numerified));
    }

    @Test
    void numerifyNull() {
        assertThrows(NullPointerException.class, () -> RandomService.numerify(null));
    }

    static Stream<Arguments> numerifyArguments() {
        return Stream.generate(RandomServiceTest::numerifyString).limit(100).map(s -> Arguments.of(s, s.replace("#", "\\d")));
    }

    private static String numerifyString() {
        final byte[] bytes = RandomService.randomString(RANDOM.nextInt(N_CHARACTERS)).getBytes();
        for (int i = 0; i < bytes.length; i++) {
            if (RANDOM.nextBoolean()) bytes[i] = '#';
        }
        return new String(bytes);
    }

    @Test
    void localDateTime() {
        for(int i = 0; i < MAX_TRIES; i++) {
            try {
                assertNotNull(RandomService.localDateTime());
            } catch (DateTimeException e) {
                fail(format("Failed to produce %s", LocalDateTime.class.getSimpleName()), e);
            }
        }
    }

    @Test
    void randomString() {
        for(int i = 0; i < MAX_TRIES; i++) {
            try {
                final int length = RANDOM.nextInt(N_CHARACTERS);
                final String string = RandomService.randomString(length);
                assertNotNull(string);
                assertEquals(length, string.length());
            } catch (Exception e) {
                fail(format("Failed to produce %s", String.class.getSimpleName()), e);
            }
        }
    }

    @Test
    void randomStringNegativeLength() {
        assertThrows(IllegalArgumentException.class, () -> RandomService.randomString(-1));
    }

    @Test
    void randomBytes() {
        for(int i = 0; i < MAX_TRIES; i++) {
            try {
                final int length = RANDOM.nextInt(N_CHARACTERS);
                final byte[] bytes = RandomService.randomBytes(length);
                assertNotNull(bytes);
                assertEquals(length, bytes.length);
            } catch (Exception e) {
                fail("Failed to produce byte[]", e);
            }
        }
    }

    @Test
    void randomBytesNegativeLength() {
        assertThrows(IllegalArgumentException.class, () -> RandomService.randomBytes(-1));
    }
}