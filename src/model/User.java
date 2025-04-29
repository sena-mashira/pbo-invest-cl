package model;

// Parent class for Admin and Customer
public abstract class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

//    Check password
    public boolean checkPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }
}
