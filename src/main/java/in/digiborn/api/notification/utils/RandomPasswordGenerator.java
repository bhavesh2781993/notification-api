package in.digiborn.api.notification.utils;

import static lombok.AccessLevel.PRIVATE;

import lombok.NoArgsConstructor;

import java.security.SecureRandom;
import java.util.Random;

@NoArgsConstructor(access = PRIVATE)
public class RandomPasswordGenerator {

    private static final Random RANDOM = new SecureRandom();
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String generatePassword(final int length) {
        final StringBuilder returnValue = new StringBuilder(length);
        // Iterate through password length and append random characters from character set
        for (int i = 0; i < length; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        // Convert StringBuilder to String and return
        return new String(returnValue);
    }

}
