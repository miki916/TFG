package com.example.Chyl.Security;

import java.security.SecureRandom;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHash {
    
    public static final int STRENGTH = 10;
    private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder(PasswordHash.STRENGTH,new SecureRandom());

    public static boolean decrypt(String passwordEncode, String password) {

        return ENCODER.matches(password, passwordEncode);
    }

    public static String hash(String rawPassword) {
        return ENCODER.encode(rawPassword);
    }

}