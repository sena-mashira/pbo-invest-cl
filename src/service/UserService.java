package service;
import model.User;
import ui.StartMenu;

import java.util.HashMap;

public class UserService {
    static private HashMap<String, User> users = new HashMap<>();

    public void start() {
        StartMenu startMenu = new StartMenu();
        startMenu.login();
    }

    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

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
