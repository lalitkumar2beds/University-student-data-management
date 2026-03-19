package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Course implements Serializable {

    private String courseId;
    private String courseName;
    private int credits;
    private String lecturerId;

    private List<String> enrolledStudents;
    private List<Assessment> assessments;

    public Course(String courseId, String courseName, int credits, String lecturerId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
        this.lecturerId = lecturerId;
        this.enrolledStudents = new ArrayList<>();
        this.assessments = new ArrayList<>();
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

    public String getLecturerId() {
        return lecturerId;
    }

    public List<String> getEnrolledStudents() {
        return enrolledStudents;
    }

    public List<Assessment> getAssessments() {
        return assessments;
    }

    public void addStudent(String studentId) {
        if (!enrolledStudents.contains(studentId)) {
            enrolledStudents.add(studentId);
        }
    }

    public void removeStudent(String studentId) {
        enrolledStudents.remove(studentId);
    }

    public void addAssessment(Assessment assessment) {
        assessments.add(assessment);
    }

}