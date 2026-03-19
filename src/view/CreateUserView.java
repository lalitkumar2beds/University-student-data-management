package view;

import database.DataInitializer;
import database.DataStore;
import factory.UserFactory;
import model.Student;
import model.User;
import utils.Constants;
import utils.IDGenerator;
import utils.ValidationUtils;

import javax.swing.*;
import java.awt.*;

public class CreateUserView extends JFrame {

    private JTextField nameField;
    private JTextField emailField;
    private JTextField programField;
    private JPasswordField passwordField;
    private JComboBox<String> roleCombo;

    public CreateUserView() {

        setTitle("Create New User");
        setSize(450,350);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel title = new JLabel("Create New System User",SwingConstants.CENTER);
        title.setFont(new Font("Arial",Font.BOLD,18));
        title.setBorder(BorderFactory.createEmptyBorder(15,10,15,10));

        mainPanel.add(title,BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(5,2,10,10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));

        formPanel.add(new JLabel("Name"));
        nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Email"));
        emailField = new JTextField();
        formPanel.add(emailField);

        formPanel.add(new JLabel("Password"));
        passwordField = new JPasswordField();
        formPanel.add(passwordField);

        formPanel.add(new JLabel("Role"));

        roleCombo = new JComboBox<>(new String[]{
                Constants.ROLE_STUDENT,
                Constants.ROLE_LECTURER,
                Constants.ROLE_ADMIN
        });

        formPanel.add(roleCombo);

        formPanel.add(new JLabel("Program (Students only)"));
        programField = new JTextField();
        formPanel.add(programField);

        mainPanel.add(formPanel,BorderLayout.CENTER);

        JButton createButton = new JButton("Create User");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(createButton);

        mainPanel.add(buttonPanel,BorderLayout.SOUTH);

        add(mainPanel);

        createButton.addActionListener(e -> createUser());

    }

    private void createUser(){

        String name = nameField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        String role = (String) roleCombo.getSelectedItem();
        String program = programField.getText();

        if(!ValidationUtils.isValidName(name)){
            JOptionPane.showMessageDialog(this,"Invalid name");
            return;
        }

        if(!ValidationUtils.isValidEmail(email)){
            JOptionPane.showMessageDialog(this,"Invalid email");
            return;
        }

        if(!ValidationUtils.isValidPassword(password)){
            JOptionPane.showMessageDialog(this,"Password must be at least 4 characters");
            return;
        }

        String id = IDGenerator.generateUserId();

        User user = UserFactory.createUser(
                role,
                id,
                name,
                email,
                password,
                program
        );

        DataStore store = DataStore.getInstance();

        store.getUsers().add(user);

        if(user instanceof Student){
            store.getStudents().add((Student) user);
        }

        DataInitializer.saveAllData();

        JOptionPane.showMessageDialog(this,"User created successfully");

        clearFields();
    }

    private void clearFields(){

        nameField.setText("");
        emailField.setText("");
        passwordField.setText("");
        programField.setText("");

    }

}