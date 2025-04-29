package service;
import model.User;
import ui.StartMenu;

import java.util.HashMap;

// Service class that handle all SBN business logic
public class UserService {
    static private HashMap<String, User> users = new HashMap<>();
// Function that start the application with login
    public void start() {
//        Call the StartMenu
        StartMenu startMenu = new StartMenu();
//        Loop login while its true
        while(true) {
            startMenu.login();
        }
    }

// Function that add User
    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

// Function that authenticate and authorize user
    public User login(String username, String password) {
        if (users.containsKey(username)) {
            User user = users.get(username);
            if (user.checkPassword(password)) {
                return user;
            }
        }
        return null;
    }
}
