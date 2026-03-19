package model;

import java.io.Serializable;

public class Assessment implements Serializable {

    private String assessmentId;
    private String courseId;
    private String assessmentName;
    private double weight;
    private double maxMarks;

    public Assessment(String assessmentId, String courseId, String assessmentName, double weight, double maxMarks) {
        this.assessmentId = assessmentId;
        this.courseId = courseId;
        this.assessmentName = assessmentName;
        this.weight = weight;
        this.maxMarks = maxMarks;
    }

    public String getAssessmentId() {
        return assessmentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getAssessmentName() {
        return assessmentName;
    }

    public double getWeight() {
        return weight;
    }

    public double getMaxMarks() {
        return maxMarks;
    }

}