package database;

import model.*;
import factory.UserFactory;
import utils.Constants;

import java.io.File;
import java.util.List;

public class DataInitializer {

    private static final String DATA_FOLDER = "data";

    private static final String USERS_FILE = "data/users.dat";
    private static final String STUDENTS_FILE = "data/students.dat";
    private static final String COURSES_FILE = "data/courses.dat";
    private static final String ENROLLMENTS_FILE = "data/enrollments.dat";
    private static final String ASSESSMENTS_FILE = "data/assessments.dat";

    public static void initializeData() {

        createDataFolder();

        DataStore store = DataStore.getInstance();

        List<User> users = FileManager.loadData(USERS_FILE);
        List<Student> students = FileManager.loadData(STUDENTS_FILE);
        List<Course> courses = FileManager.loadData(COURSES_FILE);
        List<Enrollment> enrollments = FileManager.loadData(ENROLLMENTS_FILE);
        List<Assessment> assessments = FileManager.loadData(ASSESSMENTS_FILE);

        store.setUsers(users);
        store.setStudents(students);
        store.setCourses(courses);
        store.setEnrollments(enrollments);
        store.setAssessments(assessments);

    }

    public static void saveAllData() {

        DataStore store = DataStore.getInstance();

        FileManager.saveData("data/users.dat", store.getUsers());
        FileManager.saveData("data/students.dat", store.getStudents());
        FileManager.saveData("data/courses.dat", store.getCourses());
        FileManager.saveData("data/enrollments.dat", store.getEnrollments());
        FileManager.saveData("data/assessments.dat", store.getAssessments());

    }

    private static void createDataFolder() {

        File folder = new File(DATA_FOLDER);

        if (!folder.exists()) {
            folder.mkdir();
        }

    }
    
    public static void createSampleData() {

        DataStore store = DataStore.getInstance();

        if (!store.getUsers().isEmpty()) {
            return;
        }

        System.out.println("Creating sample users and courses...");

        User admin = UserFactory.createUser(
                Constants.ROLE_ADMIN,
                "ADMIN001",
                "System Admin",
                "admin@university.com",
                "admin123",
                null
        );

        User lecturer1 = UserFactory.createUser(
                Constants.ROLE_LECTURER,
                "L001",
                "Dr Smith",
                "lecturer1@university.com",
                "pass123",
                null
        );

        User lecturer2 = UserFactory.createUser(
                Constants.ROLE_LECTURER,
                "L002",
                "Dr Brown",
                "lecturer2@university.com",
                "pass123",
                null
        );

        Student student1 = new Student(
                "S001",
                "Alice Johnson",
                "student1@university.com",
                "pass123",
                "Computer Science"
        );

        Student student2 = new Student(
                "S002",
                "Bob Williams",
                "student2@university.com",
                "pass123",
                "Software Engineering"
        );

        Student student3 = new Student(
                "S003",
                "Charlie Lee",
                "student3@university.com",
                "pass123",
                "Information Systems"
        );

        store.getUsers().add(admin);
        store.getUsers().add(lecturer1);
        store.getUsers().add(lecturer2);
        store.getUsers().add(student1);
        store.getUsers().add(student2);
        store.getUsers().add(student3);

        store.getStudents().add(student1);
        store.getStudents().add(student2);
        store.getStudents().add(student3);

        Course course1 = new Course("C001","Programming Fundamentals",3,"L001");
        Course course2 = new Course("C002","Data Structures",4,"L001");
        Course course3 = new Course("C003","Database Systems",3,"L002");

        store.getCourses().add(course1);
        store.getCourses().add(course2);
        store.getCourses().add(course3);

        saveAllData();

        System.out.println("Sample data created successfully.");
    }

}


