package database;

import model.*;
import java.util.ArrayList;
import java.util.List;

public class DataStore {

    private static DataStore instance;

    private List<User> users;
    private List<Student> students;
    private List<Course> courses;
    private List<Enrollment> enrollments;
    private List<Assessment> assessments;

    private DataStore() {
        users = new ArrayList<>();
        students = new ArrayList<>();
        courses = new ArrayList<>();
        enrollments = new ArrayList<>();
        assessments = new ArrayList<>();
    }

    public static DataStore getInstance() {

        if (instance == null) {
            instance = new DataStore();
        }

        return instance;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public List<Assessment> getAssessments() {
        return assessments;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public void setAssessments(List<Assessment> assessments) {
        this.assessments = assessments;
    }

}