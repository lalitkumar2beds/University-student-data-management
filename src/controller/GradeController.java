package controller;

import database.DataStore;
import database.DataInitializer;
import model.Assessment;
import model.Course;

import java.util.List;

public class GradeController {

    public void addAssessment(Assessment assessment) {

        DataStore store = DataStore.getInstance();

        store.getAssessments().add(assessment);

        for (Course course : store.getCourses()) {

            if (course.getCourseId().equals(assessment.getCourseId())) {

                course.addAssessment(assessment);
                break;
            }
        }

        DataInitializer.saveAllData();
    }

    public List<Assessment> getAssessmentsForCourse(String courseId) {

        DataStore store = DataStore.getInstance();

        return store.getAssessments()
                .stream()
                .filter(a -> a.getCourseId().equals(courseId))
                .toList();
    }

}