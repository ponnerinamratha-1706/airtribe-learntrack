package com.airtribe.learntrack.util;

public class IdGenerator {
    private static int studentIdCounter = 1;
    private static int courseIdCounter = 1;
    private static int enrollmentIdCounter = 1;

    public static String getNextStudentId() {
        return "S" + String.format("%03d", studentIdCounter++);
    }

    public static String getNextCourseId() {
        return "C" + String.format("%03d", courseIdCounter++);
    }

    public static String getNextEnrollmentId() {
        return "E" + String.format("%03d", enrollmentIdCounter++);
    }
}
