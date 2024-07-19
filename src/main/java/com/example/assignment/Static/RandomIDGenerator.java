package com.example.assignment.Static;

import java.time.LocalTime;
import java.util.Random;

public class RandomIDGenerator {
    private final static String STUDENT_PREFIX = "stu";
    private final static String TEACHER_PREFIX = "tea";
    private final static String STAFF_PREFIX = "sta";

    public static String generateRandomEightDigits() {
        String randomID = LocalTime.now().toString().substring(11, 15);
        Random random = new Random(Long.parseLong(randomID));
        random.setSeed(Long.parseLong(randomID));
        int randInt = random.nextInt(1000, 9999);

        return randInt + randomID;
    }

    public static String generateRandomStudentId() {
        return STUDENT_PREFIX + generateRandomEightDigits();
    }

    public static String generateRandomTeacherId() {
        return TEACHER_PREFIX + generateRandomEightDigits();
    }

    public static String generateRandomStaffId() {
        return STAFF_PREFIX + generateRandomEightDigits();
    }
}
