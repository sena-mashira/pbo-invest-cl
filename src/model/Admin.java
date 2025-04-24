package model;

import ui.AdminMenu;

public class Admin extends User {

    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public void showMenu() {
        AdminMenu adminMenu = new AdminMenu();
        adminMenu.mainMenu();
    }
}
