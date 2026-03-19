package view;

import model.User;

import javax.swing.*;
import java.awt.*;

public class AdminDashboard extends JFrame {

    private User adminUser;

    public AdminDashboard(User user) {

        this.adminUser = user;

        setTitle("Administrator Dashboard");
        setSize(600,450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel title = new JLabel(
                "Administrator Dashboard - Welcome " + adminUser.getName(),
                SwingConstants.CENTER
        );

        title.setFont(new Font("Arial",Font.BOLD,18));
        title.setBorder(BorderFactory.createEmptyBorder(20,10,20,10));

        mainPanel.add(title,BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(3,2,20,20));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(30,40,30,40));

        JButton createUserBtn = new JButton("Create User");
        JButton manageCoursesBtn = new JButton("Manage Courses");
        JButton manageEnrollmentsBtn = new JButton("Manage Enrollments");
        JButton manageAssessmentsBtn = new JButton("Manage Assessments");
        JButton viewStudentsBtn = new JButton("View Students");
        JButton logoutBtn = new JButton("Logout");

        buttonPanel.add(createUserBtn);
        buttonPanel.add(manageCoursesBtn);
        buttonPanel.add(manageEnrollmentsBtn);
        buttonPanel.add(manageAssessmentsBtn);
        buttonPanel.add(viewStudentsBtn);
        buttonPanel.add(logoutBtn);

        mainPanel.add(buttonPanel,BorderLayout.CENTER);

        add(mainPanel);

        createUserBtn.addActionListener(e -> openCreateUser());
        manageCoursesBtn.addActionListener(e -> new CourseManagementView().setVisible(true));
        manageEnrollmentsBtn.addActionListener(e -> new EnrollmentView().setVisible(true));
        manageAssessmentsBtn.addActionListener(e -> new GradeManagementView().setVisible(true));
        viewStudentsBtn.addActionListener(e -> openStudentList());
        logoutBtn.addActionListener(e -> logout());

    }

    private void openCreateUser(){

        new CreateUserView().setVisible(true);

    }

    private void openStudentList(){

        new StudentListView().setVisible(true);

    }

    private void logout(){

        dispose();
        new LoginView().setVisible(true);

    }

}