package ui;

import model.Admin;
import model.Customer;
import model.User;
import service.UserService;
import util.Util;

import java.util.Scanner;

// View class that show startup menu, when user first run the program
public class StartMenu {
    Scanner sc = new Scanner(System.in);
    UserService userService = new UserService();
    AdminMenu adminMenu = new AdminMenu();
    CustomerMenu customerMenu = new CustomerMenu();

// Function show the Login Menu
    public void login() {
        User user = null;
        header();

//        Check if user is logged in, if not run the code below
        while (user == null) {
            System.out.println("╒════════════════════════════════╕");
            System.out.print("  Username │ ");
            String username = sc.nextLine();
            System.out.println("├──────────┼─────────────────────┤");
            System.out.print("  Password │ ");
            String password = sc.nextLine();
            System.out.println("╘══════════╧═════════════════════╛");

//            Check the credential
            user = userService.login(username, password);

//            Check if it's an Admin or a Customer
            if (user != null) {
                loginResult("berhasil");
                if (user instanceof Admin) {
                    adminMenu.mainMenu();
                } else if (user instanceof Customer) {
                    customerMenu.mainMenu();
                }
            } else {
                loginResult("gagal");
            }
        }
    }

    public void header() {
        System.out.println("╒════════════════════════════════╕");
        System.out.println("│          INVEST - LOGIN        │");
        System.out.println("╘════════════════════════════════╛");
    }

    public void loginResult(String result) {
        if (result.equals("berhasil")) {
            Util.successMsg("╒════════════════════════════════╕");
            Util.successMsg("│        Login berhasil !!!      │");
            Util.successMsg("╘════════════════════════════════╛");
        } else {
            Util.errorMsg("╒════════════════════════════════╕");
            Util.errorMsg("│          Login gagal !!!       │");
            Util.errorMsg("│       Kredensial bermasalah    │");
            Util.errorMsg("╘════════════════════════════════╛");
        }
    }
}
