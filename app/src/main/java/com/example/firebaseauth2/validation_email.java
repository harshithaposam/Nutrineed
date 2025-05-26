package com.example.firebaseauth2;

public class validation_email {
    public static boolean isValidEmail(String email) {
        return email.endsWith("@gmail.com");
    }
}