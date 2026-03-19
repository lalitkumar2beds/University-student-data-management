package utils;

import java.util.regex.Pattern;

public class ValidationUtils {

    private static final String EMAIL_REGEX =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public static boolean isValidEmail(String email) {

        if (email == null) {
            return false;
        }

        return Pattern.matches(EMAIL_REGEX, email);
    }

    public static boolean isValidPassword(String password) {

        if (password == null) {
            return false;
        }

        return password.length() >= 4;
    }

    public static boolean isValidName(String name) {

        if (name == null || name.trim().isEmpty()) {
            return false;
        }

        return name.length() >= 2;
    }

    public static boolean isPositiveNumber(int number) {

        return number > 0;
    }

    public static boolean isValidMarks(double marks, double maxMarks) {

        if (marks < 0) {
            return false;
        }

        return marks <= maxMarks;
    }

}