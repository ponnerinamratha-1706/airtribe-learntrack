package com.airtribe.learntrack.util;

public class InputValidator {
    public static boolean isNotNullOrEmpty(String str) {
        return str != null && !str.trim().isEmpty();
    }
}
