package ui;

import model.User;
import service.UserService;
import util.Util;

import java.util.Scanner;

public class StartMenu {
    Scanner sc = new Scanner(System.in);
    UserService userService = new UserService();

    public void login() {
        User user = null;
        header();

        while (user == null) {

            System.out.println("╒════════════════════════════════╕");
            System.out.print("  Username │ ");
            String username = sc.nextLine();
            System.out.println("├──────────┼─────────────────────┤");
            System.out.print("  Password │ ");
            String password = sc.nextLine();
            System.out.printf("╘══════════╧═════════════════════╛%n");

            user = userService.login(username, password);

            if (user != null) {
                loginResult("berhasil");
                user.showMenu();
            } else {
                loginResult("gagal");
            }
        }

        sc.close();
    }

    public void header() {
        System.out.println("╒════════════════════════════════╕");
        System.out.println("│          INVEST - LOGIN        │");
        System.out.println("╘════════════════════════════════╛");
    }

    public void loginResult(String result) {
        Util.addDelay(1000);
        if (result.equals("berhasil")) {
            System.out.println(Util.ANSI_BLACK + Util.ANSI_GREEN_BACKGROUND + "╒════════════════════════════════╕" + Util.ANSI_RESET);
            System.out.println(Util.ANSI_BLACK + Util.ANSI_GREEN_BACKGROUND + "│        Login berhasil !!!      │" + Util.ANSI_RESET);
            System.out.println(Util.ANSI_BLACK + Util.ANSI_GREEN_BACKGROUND + "╘════════════════════════════════╛" + Util.ANSI_RESET );
        } else {
            System.out.println(Util.ANSI_BLACK + Util.ANSI_RED_BACKGROUND + "╒════════════════════════════════╕" + Util.ANSI_RESET);
            System.out.println(Util.ANSI_BLACK + Util.ANSI_RED_BACKGROUND + "│          Login gagal !!!       │" + Util.ANSI_RESET);
            System.out.println(Util.ANSI_BLACK + Util.ANSI_RED_BACKGROUND + "│       Kredensial bermasalah    │" + Util.ANSI_RESET);
            System.out.println(Util.ANSI_BLACK + Util.ANSI_RED_BACKGROUND + "╘════════════════════════════════╛" + Util.ANSI_RESET);
        }
    }
}
