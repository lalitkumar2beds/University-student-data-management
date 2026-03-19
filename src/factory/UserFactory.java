package factory;

import model.User;
import model.Student;
import model.Lecturer;
import model.Administrator;

public class UserFactory {

    public static User createUser(
            String role,
            String userId,
            String name,
            String email,
            String password,
            String program
    ) {

        if (role == null) {
            return null;
        }

        switch (role.toUpperCase()) {

            case "STUDENT":
                return new Student(userId, name, email, password, program);

            case "LECTURER":
                return new Lecturer(userId, name, email, password);

            case "ADMIN":
            case "ADMINISTRATOR":
                return new Administrator(userId, name, email, password);

            default:
                throw new IllegalArgumentException("Invalid user role: " + role);
        }

    }

}