package utils;

import net.bytebuddy.utility.RandomString;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class StringUtils {

    private static final Random random = new Random();
    private static final String[] illegalCharacters = {"~", "!", "@", "#","$", "%", "^", "&", "*", "(", ")", "-", "="};
    private static final String[] phonePrefixes = {"050", "052", "053", "054"};

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

    public static String generateInvalidEmailAtVersion() {
        String randomStr = new RandomString(10).nextString();
        String beforeStr = randomStr.substring(0, randomStr.length() / 2);
        String afterStr = randomStr.substring(randomStr.length() / 2);
        return beforeStr + "@" + afterStr;
    }

    public static String generateInvalidEmailSuffixVersion() {
        return new RandomString(10).nextString() + ".com";
    }

    public static String generateRandomName() {
        String randomStr = new RandomString(10).nextString();
        String beforeStr = randomStr.substring(0, randomStr.length() / 2);
        String afterStr = randomStr.substring(randomStr.length() / 2);
        return beforeStr + " " + afterStr;
    }

    public static String generateRandomEmail() {
        String randomStr = new RandomString(6).nextString();
        return randomStr + "@gmail.com";
    }

    public static String generateRandomPhone() {
        return phonePrefixes[random.nextInt(phonePrefixes.length)] + generateRandomNumberInLength(7);
    }
}
