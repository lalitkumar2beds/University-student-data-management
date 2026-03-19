package utils;

import java.util.UUID;

public class IDGenerator {

    public static String generateUserId() {

        return "U-" + UUID.randomUUID()
                .toString()
                .substring(0, 8)
                .toUpperCase();
    }

    public static String generateStudentId() {

        return "S-" + UUID.randomUUID()
                .toString()
                .substring(0, 8)
                .toUpperCase();
    }

    public static String generateCourseId() {

        return "C-" + UUID.randomUUID()
                .toString()
                .substring(0, 8)
                .toUpperCase();
    }

    public static String generateAssessmentId() {

        return "A-" + UUID.randomUUID()
                .toString()
                .substring(0, 8)
                .toUpperCase();
    }

}