package view;

import model.User;

import javax.swing.*;
import java.awt.*;

public class StudentDashboard extends JFrame {

    private User student;

    public StudentDashboard(User user) {

        this.student = user;

        setTitle("Student Dashboard");
        setSize(500,350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel title = new JLabel(
                "Student Dashboard - Welcome " + student.getName(),
                SwingConstants.CENTER
        );

        title.setFont(new Font("Arial",Font.BOLD,18));
        title.setBorder(BorderFactory.createEmptyBorder(20,10,20,10));

        mainPanel.add(title,BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(3,1,15,15));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(30,60,30,60));

        JButton enrollCourseBtn = new JButton("Enroll in Course");
        JButton viewRecordsBtn = new JButton("View Academic Records");
        JButton logoutBtn = new JButton("Logout");

        buttonPanel.add(enrollCourseBtn);
        buttonPanel.add(viewRecordsBtn);
        buttonPanel.add(logoutBtn);

        mainPanel.add(buttonPanel,BorderLayout.CENTER);

        add(mainPanel);

        enrollCourseBtn.addActionListener(
                e -> new EnrollmentView().setVisible(true)
        );

        viewRecordsBtn.addActionListener(
                e -> new AcademicRecordView(student).setVisible(true)
        );

        logoutBtn.addActionListener(e -> logout());

    }

    private void logout(){

        dispose();
        new LoginView().setVisible(true);

    }

}