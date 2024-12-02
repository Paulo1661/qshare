package dev.pleufang.quick_share;

import java.util.Random;

public class RandomString {
    private static final Integer DEFAULT_LENGTH = 4;
    public static String generate(int length) {
//        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String characters = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder randomString = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }

        return randomString.toString();
    }

    public static String generate() {
        return generate(DEFAULT_LENGTH);
    }
}
