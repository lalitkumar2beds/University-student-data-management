package model;

public class Administrator extends User {

    public Administrator(String userId, String name, String email, String password) {
        super(userId, name, email, password, "ADMIN");
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Administrator");
    }

}