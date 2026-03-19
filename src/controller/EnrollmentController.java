package controller;

import database.DataStore;
import database.DataInitializer;
import model.Course;
import model.Enrollment;
import model.Student;

import java.util.List;

public class EnrollmentController {

    public boolean enrollStudent(String studentId, String courseId) {

        DataStore store = DataStore.getInstance();

        Student student = null;
        Course course = null;

        for (Student s : store.getStudents()) {

            if (s.getUserId().equals(studentId)) {
                student = s;
                break;
            }
        }

        for (Course c : store.getCourses()) {

            if (c.getCourseId().equals(courseId)) {
                course = c;
                break;
            }
        }

        if (student == null || course == null) {
            return false;
        }

        for (Enrollment e : store.getEnrollments()) {

            if (e.getStudentId().equals(studentId)
                    && e.getCourseId().equals(courseId)) {

                return false;
            }
        }

        Enrollment enrollment = new Enrollment(studentId, courseId);

        store.getEnrollments().add(enrollment);

        student.enrollCourse(courseId);
        course.addStudent(studentId);

        DataInitializer.saveAllData();

        return true;
    }

    public List<Enrollment> getAllEnrollments() {

        DataStore store = DataStore.getInstance();
        return store.getEnrollments();
    }

}