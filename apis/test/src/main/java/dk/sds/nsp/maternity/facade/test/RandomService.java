package dk.sds.nsp.maternity.facade.test;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Random;

/**
 * Utility class that provides random data
 */
@SuppressWarnings("unused")
public final class RandomService {

    private static final Random RANDOM = new Random("NSP".hashCode());
    private static final int LEFT_STRING_LIMIT = 'a';
    private static final int RIGHT_STRING_LIMIT = 'z';
    private static final int TO_UPPER_CASE = 'A' - 'a';

    private RandomService() {}

    /**
     * Chooses at random an object amongst an array of objects
     * @param options The objects to choose from
     * @param <T> The type of the objects
     * @return The chosen object
     */
    @SafeVarargs
    public static <T> T choose(final T... options) {
        return options[RANDOM.nextInt(options.length)];
    }

    /**
     * Chooses at random an object amongst an array of objects or null
     * @param options The objects to choose from
     * @param <T> The type of the objects
     * @return The chosen object or null
     */
    @SafeVarargs
    public static <T> T chooseOrNull(final T... options) {
        final int selected = RANDOM.nextInt(options.length + 1);
        return selected == options.length ? null :options[selected];
    }

    /**
     * Numerifies a String by replacing occurrences of '#' with a randomly chosen digit. For example:
     * <ul>
     *     <li>numerify("Foo#Bar") can return "Foo4Bar"</li>
     *     <li>numerify("Foo##Bar#") can return "Foo83Bar1"</li>
     *     <li>numerify("#Foo2Bar") can return "3Foo2Bar"</li>
     *     <li>numerify("FooBar") returns "FooBar"</li>
     *     <li>numerify("##") can return "33"</li>
     *     <li>numerify("") returns ""</li>
     *     <li>numerify(null) throws NullPointerException</li>
     * </ul>
     * @param value The String to numerify
     * @return The numerified String
     * @throws NullPointerException when value is null
     */
    public static String numerify(final String value) {
        final char[] chars = value.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == '#') chars[i] = (char) ('0' + RANDOM.nextInt(10));
        }
        return String.valueOf(chars);
    }

    /**
     * Generates a new random LocalDateTime instance
     * @return The random LocalDateTime instance
     */
    public static LocalDateTime localDateTime() {
        return LocalDateTime.ofEpochSecond(((long)RANDOM.nextInt()) << 4 | RANDOM.nextInt(), RANDOM.nextInt(1000000000), ZoneOffset.UTC);
    }

    /**
     * Generates a new random String with characters in the range [a-zA-Z]
     * @param length The length of the String
     * @return The random String
     * @throws IllegalArgumentException when length < 0
     */
    public static String randomString(final int length) {
        return RANDOM.ints(LEFT_STRING_LIMIT, RIGHT_STRING_LIMIT + 1)
                .limit(length)
                .map(s -> RANDOM.nextBoolean() ? s : s + TO_UPPER_CASE)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    /**
     * Generates a new byte array with random bytes
     * @param length The length of the byte array
     * @return The random byte array
     * @throws IllegalArgumentException when length < 0
     */
    public static byte[] randomBytes(final int length) {
        final byte[] bytes;
        try {
            bytes = new byte[length];
        } catch (NegativeArraySizeException e) {
            throw new IllegalArgumentException("length < 0 provided");
        }
        RANDOM.nextBytes(bytes);
        return bytes;
    }
}
