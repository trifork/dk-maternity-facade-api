package dk.sds.nsp.maternity.facade.maternity.test;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Random;

public final class RandomService {

    private static final Random RANDOM = new Random("NSP ...".hashCode());
    private static final int LEFT_STRING_LIMIT = 'a';
    private static final int RIGHT_STRING_LIMIT = 'z';

    private RandomService() {}

    public static <T> T choose(T... options) {
        return options[RANDOM.nextInt(options.length)];
    }

    public static <T> T chooseOrNull(T... options) {
        final int selected = RANDOM.nextInt(options.length + 1);
        return selected == options.length ? null :options[selected];
    }

    public static String numerify(String value) {
        final char[] chars = value.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == '#') chars[i] = (char) (48 + RANDOM.nextInt(10));
        }
        return String.valueOf(chars);
    }

    public static LocalDateTime localDateTime() {
        return LocalDateTime.ofEpochSecond(RANDOM.nextInt(), RANDOM.nextInt(1000000000), ZoneOffset.UTC);
    }

    public static String randomString(int length) {
        return RANDOM.ints(LEFT_STRING_LIMIT, RIGHT_STRING_LIMIT + 1)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static byte[] randomBytes(int length) {
        final byte[] bytes = new byte[length];
        RANDOM.nextBytes(bytes);
        return bytes;
    }
}
