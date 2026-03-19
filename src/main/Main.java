package main;

import database.DataInitializer;
import database.DataStore;
import factory.UserFactory;
import model.User;
import utils.Constants;
import view.LoginView;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

    public static void main(String[] args) {

        System.out.println("Starting University Student Data Management System...");

        // Load data from files
        DataInitializer.initializeData();
        DataInitializer.createSampleData();

        // Ensure at least one admin user exists
        initializeDefaultAdmin();

        // Launch GUI on Swing thread
        SwingUtilities.invokeLater(() -> {

            LoginView loginView = new LoginView();

            // Save all data when application closes
            loginView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {

                    System.out.println("Saving system data...");
                    DataInitializer.saveAllData();

                }
            });

            loginView.setVisible(true);

        });

    }

    private static void initializeDefaultAdmin() {

        DataStore store = DataStore.getInstance();

        if (store.getUsers().isEmpty()) {

            System.out.println("No users found. Creating default admin user...");

            User admin = UserFactory.createUser(
                    Constants.ROLE_ADMIN,
                    "ADMIN001",
                    "System Administrator",
                    "admin@university.com",
                    "admin123",
                    null
            );

            store.getUsers().add(admin);

            DataInitializer.saveAllData();

            System.out.println("Default Admin Created:");
            System.out.println("Email: admin@university.com");
            System.out.println("Password: admin123");

        }

    }

}