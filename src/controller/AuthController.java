package controller;

import database.DataStore;
import model.User;

import java.util.List;

public class AuthController {

    public User login(String email, String password) {

        DataStore store = DataStore.getInstance();
        List<User> users = store.getUsers();

        for (User user : users) {

            if (user.getEmail().equalsIgnoreCase(email)
                    && user.getPassword().equals(password)) {

                return user;
            }
        }

        return null;
    }

}