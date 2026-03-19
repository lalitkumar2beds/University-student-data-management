package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Enrollment implements Serializable {

    private String studentId;
    private String courseId;
    private LocalDate enrollmentDate;
    private String status;

    public Enrollment(String studentId, String courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = LocalDate.now();
        this.status = "ENROLLED";
    }

    public String getStudentId() {
        return studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}