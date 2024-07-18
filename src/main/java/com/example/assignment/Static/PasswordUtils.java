package com.example.assignment.Static;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtils {
    private static final int LOG_ROUNDS = 10;


    public static String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt(LOG_ROUNDS));
    }

    public static boolean checkPassword(String plainTextPassword, String hashedPassword) {
        return BCrypt.checkpw(plainTextPassword, hashedPassword);
    }
}
