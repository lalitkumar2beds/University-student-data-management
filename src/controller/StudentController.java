package controller;

import database.DataStore;
import database.DataInitializer;
import model.Student;

import java.util.List;

public class StudentController {

    public void addStudent(Student student) {

        DataStore store = DataStore.getInstance();
        store.getStudents().add(student);
        store.getUsers().add(student);

        DataInitializer.saveAllData();
    }

    public Student findStudentById(String studentId) {

        DataStore store = DataStore.getInstance();

        for (Student s : store.getStudents()) {

            if (s.getUserId().equals(studentId)) {
                return s;
            }
        }

        return null;
    }

    public List<Student> getAllStudents() {

        DataStore store = DataStore.getInstance();
        return store.getStudents();
    }

}