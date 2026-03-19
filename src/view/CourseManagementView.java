package view;

import controller.CourseController;
import database.DataStore;
import model.Course;
import utils.IDGenerator;
import utils.ValidationUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class CourseManagementView extends JFrame {

    private JTextField courseNameField;
    private JTextField creditsField;
    private JTextField lecturerField;

    private JTable courseTable;
    private DefaultTableModel tableModel;

    public CourseManagementView() {

        setTitle("Course Management");
        setSize(700,450);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel title = new JLabel("Course Management",SwingConstants.CENTER);
        title.setFont(new Font("Arial",Font.BOLD,18));
        title.setBorder(BorderFactory.createEmptyBorder(15,10,15,10));

        mainPanel.add(title,BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(4,2,10,10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));

        formPanel.add(new JLabel("Course Name"));
        courseNameField = new JTextField();
        formPanel.add(courseNameField);

        formPanel.add(new JLabel("Credits"));
        creditsField = new JTextField();
        formPanel.add(creditsField);

        formPanel.add(new JLabel("Lecturer ID"));
        lecturerField = new JTextField();
        formPanel.add(lecturerField);

        JButton createButton = new JButton("Create Course");
        formPanel.add(new JLabel());
        formPanel.add(createButton);

        mainPanel.add(formPanel,BorderLayout.WEST);

        tableModel = new DefaultTableModel(
                new String[]{"Course ID","Course Name","Credits","Lecturer"},0
        );

        courseTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(courseTable);

        mainPanel.add(scrollPane,BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();

        JButton refreshButton = new JButton("Refresh List");

        bottomPanel.add(refreshButton);

        mainPanel.add(bottomPanel,BorderLayout.SOUTH);

        add(mainPanel);

        loadCourses();

        createButton.addActionListener(e -> createCourse());
        refreshButton.addActionListener(e -> loadCourses());

    }

    private void createCourse(){

        String name = courseNameField.getText();
        String creditsText = creditsField.getText();
        String lecturerId = lecturerField.getText();

        if(!ValidationUtils.isValidName(name)){
            JOptionPane.showMessageDialog(this,"Invalid course name");
            return;
        }

        int credits;

        try{
            credits = Integer.parseInt(creditsText);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"Credits must be a number");
            return;
        }

        if(!ValidationUtils.isPositiveNumber(credits)){
            JOptionPane.showMessageDialog(this,"Credits must be positive");
            return;
        }

        String id = IDGenerator.generateCourseId();

        Course course = new Course(id,name,credits,lecturerId);

        new CourseController().createCourse(course);

        JOptionPane.showMessageDialog(this,"Course created successfully");

        courseNameField.setText("");
        creditsField.setText("");
        lecturerField.setText("");

        loadCourses();

    }

    private void loadCourses(){

        tableModel.setRowCount(0);

        List<Course> courses = DataStore.getInstance().getCourses();

        for(Course course : courses){

            tableModel.addRow(new Object[]{
                    course.getCourseId(),
                    course.getCourseName(),
                    course.getCredits(),
                    course.getLecturerId()
            });

        }

    }

}