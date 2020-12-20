package utils;

import net.bytebuddy.utility.RandomString;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class StringUtils {

    private static final Random random = new Random();
    private static final String[] illegalCharacters = {"~", "!", "@", "#","$", "%", "^", "&", "*", "(", ")", "-", "="};

    public static String generateRandomNumberInLength(int length) {
        int min = (int) Math.pow(10, length - 1);
        return String.valueOf(ThreadLocalRandom.current().nextInt(min, min * 10));
    }

    public static String generateRandomIllegalCharactersStringInLength(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        while (length != 0) {
            stringBuilder.append(illegalCharacters[random.nextInt(illegalCharacters.length)]);
            length--;
        }
        return stringBuilder.toString();
    }

    public static String generateRandomLong() {
        long longNum = random.nextLong();
        return longNum < 0 ? String.valueOf(longNum * (-1)) : String.valueOf(longNum);
    }

    public static String generateRandomStringInLength(int length) {
        return new RandomString(length).nextString();
    }
}
