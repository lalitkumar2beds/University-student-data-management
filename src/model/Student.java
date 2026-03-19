package model;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {

    private String program;
    private List<String> enrolledCourses;
    private List<String> academicRecords;

    public Student(String userId, String name, String email, String password, String program) {
        super(userId, name, email, password, "STUDENT");
        this.program = program;
        this.enrolledCourses = new ArrayList<>();
        this.academicRecords = new ArrayList<>();
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public List<String> getEnrolledCourses() {
        return enrolledCourses;
    }

    public List<String> getAcademicRecords() {
        return academicRecords;
    }

    public void enrollCourse(String courseId) {
        if (!enrolledCourses.contains(courseId)) {
            enrolledCourses.add(courseId);
        }
    }

    public void addAcademicRecord(String record) {
        academicRecords.add(record);
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Student");
    }

}