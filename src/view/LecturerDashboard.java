package view;

import model.User;

import javax.swing.*;
import java.awt.*;

public class LecturerDashboard extends JFrame {

    private User lecturer;

    public LecturerDashboard(User user) {

        this.lecturer = user;

        setTitle("Lecturer Dashboard");
        setSize(500,350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel title = new JLabel(
                "Lecturer Dashboard - Welcome " + lecturer.getName(),
                SwingConstants.CENTER
        );

        title.setFont(new Font("Arial",Font.BOLD,18));
        title.setBorder(BorderFactory.createEmptyBorder(20,10,20,10));

        mainPanel.add(title,BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(3,1,15,15));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(30,60,30,60));

        JButton manageAssessmentsBtn = new JButton("Manage Assessments");
        JButton recordGradesBtn = new JButton("Record Student Grades");
        JButton logoutBtn = new JButton("Logout");

        buttonPanel.add(manageAssessmentsBtn);
        buttonPanel.add(recordGradesBtn);
        buttonPanel.add(logoutBtn);

        mainPanel.add(buttonPanel,BorderLayout.CENTER);

        add(mainPanel);

        manageAssessmentsBtn.addActionListener(
                e -> new GradeManagementView().setVisible(true)
        );

        recordGradesBtn.addActionListener(
                e -> new RecordGradeView().setVisible(true)
        );

        logoutBtn.addActionListener(e -> logout());

    }

    private void logout(){

        dispose();
        new LoginView().setVisible(true);

    }

}