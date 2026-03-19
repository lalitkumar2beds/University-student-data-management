package view;

import controller.EnrollmentController;
import database.DataStore;
import model.Enrollment;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class EnrollmentView extends JFrame {

    private JTextField studentField;
    private JTextField courseField;

    private JTable enrollmentTable;
    private DefaultTableModel tableModel;

    public EnrollmentView(){

        setTitle("Course Enrollment");
        setSize(700,400);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel title = new JLabel("Student Course Enrollment",SwingConstants.CENTER);
        title.setFont(new Font("Arial",Font.BOLD,18));
        title.setBorder(BorderFactory.createEmptyBorder(15,10,15,10));

        mainPanel.add(title,BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(3,2,10,10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));

        formPanel.add(new JLabel("Student ID"));
        studentField = new JTextField();
        formPanel.add(studentField);

        formPanel.add(new JLabel("Course ID"));
        courseField = new JTextField();
        formPanel.add(courseField);

        JButton enrollButton = new JButton("Enroll Student");

        formPanel.add(new JLabel());
        formPanel.add(enrollButton);

        mainPanel.add(formPanel,BorderLayout.WEST);

        tableModel = new DefaultTableModel(
                new String[]{"Student ID","Course ID","Enrollment Date","Status"},0
        );

        enrollmentTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(enrollmentTable);

        mainPanel.add(scrollPane,BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();

        JButton refreshButton = new JButton("Refresh List");

        bottomPanel.add(refreshButton);

        mainPanel.add(bottomPanel,BorderLayout.SOUTH);

        add(mainPanel);

        loadEnrollments();

        enrollButton.addActionListener(e -> enrollStudent());
        refreshButton.addActionListener(e -> loadEnrollments());

    }

    private void enrollStudent(){

        String studentId = studentField.getText();
        String courseId = courseField.getText();

        boolean success = new EnrollmentController()
                .enrollStudent(studentId,courseId);

        if(success){

            JOptionPane.showMessageDialog(
                    this,
                    "Student enrolled successfully"
            );

            studentField.setText("");
            courseField.setText("");

            loadEnrollments();

        }
        else{

            JOptionPane.showMessageDialog(
                    this,
                    "Enrollment failed (duplicate or invalid)"
            );

        }

    }

    private void loadEnrollments(){

        tableModel.setRowCount(0);

        List<Enrollment> enrollments =
                DataStore.getInstance().getEnrollments();

        for(Enrollment e : enrollments){

            tableModel.addRow(new Object[]{
                    e.getStudentId(),
                    e.getCourseId(),
                    e.getEnrollmentDate(),
                    e.getStatus()
            });

        }

    }

}