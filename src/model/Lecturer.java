package model;

import java.util.ArrayList;
import java.util.List;

public class Lecturer extends User {

    private List<String> coursesTaught;

    public Lecturer(String userId, String name, String email, String password) {
        super(userId, name, email, password, "LECTURER");
        this.coursesTaught = new ArrayList<>();
    }

    public List<String> getCoursesTaught() {
        return coursesTaught;
    }

    public void assignCourse(String courseId) {
        if (!coursesTaught.contains(courseId)) {
            coursesTaught.add(courseId);
        }
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Lecturer");
    }

}