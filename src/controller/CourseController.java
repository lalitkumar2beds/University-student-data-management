package controller;

import database.DataStore;
import database.DataInitializer;
import model.Course;

import java.util.List;

public class CourseController {

    public void createCourse(Course course) {

        DataStore store = DataStore.getInstance();
        store.getCourses().add(course);

        DataInitializer.saveAllData();
    }

    public Course findCourseById(String courseId) {

        DataStore store = DataStore.getInstance();

        for (Course course : store.getCourses()) {

            if (course.getCourseId().equals(courseId)) {
                return course;
            }
        }

        return null;
    }

    public List<Course> getAllCourses() {

        DataStore store = DataStore.getInstance();
        return store.getCourses();
    }

}