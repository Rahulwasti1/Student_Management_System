package com.example.assignment.Static;

import java.time.LocalTime;
import java.util.Random;

public class RandomIDGenerator {
    public static String generateRandomEightDigits() {
        String randomID = LocalTime.now().toString().substring(11, 15);
        Random random = new Random(Long.parseLong(randomID));
        random.setSeed(Long.parseLong(randomID));
        int randInt = random.nextInt(1000, 9999);

        return randInt + randomID;
    }
}
