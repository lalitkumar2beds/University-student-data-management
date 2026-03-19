package view;

import controller.AuthController;
import model.User;
import utils.Constants;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {

    private JTextField emailField;
    private JPasswordField passwordField;

    public LoginView() {

        setTitle("University Student Data Management System");
        setSize(450,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel title = new JLabel(
                "University Student Management System",
                SwingConstants.CENTER);

        title.setFont(new Font("Arial",Font.BOLD,18));
        title.setBorder(BorderFactory.createEmptyBorder(20,10,20,10));

        mainPanel.add(title,BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(2,2,10,10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));

        formPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        formPanel.add(emailField);

        formPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        formPanel.add(passwordField);

        mainPanel.add(formPanel,BorderLayout.CENTER);

        JButton loginButton = new JButton("Login");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loginButton);

        mainPanel.add(buttonPanel,BorderLayout.SOUTH);

        add(mainPanel);

        loginButton.addActionListener(e -> login());

    }

    private void login() {

        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        AuthController controller = new AuthController();

        User user = controller.login(email,password);

        if(user == null){

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid email or password",
                    "Login Failed",
                    JOptionPane.ERROR_MESSAGE);

            return;
        }

        if(user.getRole().equals(Constants.ROLE_ADMIN)){

            new AdminDashboard(user).setVisible(true);

        }
        else if(user.getRole().equals(Constants.ROLE_LECTURER)){

            new LecturerDashboard(user).setVisible(true);

        }
        else{

            new StudentDashboard(user).setVisible(true);

        }

        dispose();
    }

}