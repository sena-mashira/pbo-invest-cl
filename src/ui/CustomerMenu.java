package ui;

import util.Util;

import java.util.Scanner;

public class CustomerMenu {
    Scanner sc = new Scanner(System.in);
    SahamMenu sahamMenu = new SahamMenu();
    SBNMenu sbnMenu = new SBNMenu();
    PortofolioMenu portofolioMenu = new PortofolioMenu();

    public void mainMenu() {
        System.out.print(
                "╒════════════════════════════════╕\n" +
                "│        INVEST - CUSTOMER       │\n" +
                "╘════════════════════════════════╛\n");

        int choice = 0;

        while (true) {
            System.out.print(
                    "╒══════╤═════════════════════════╕\n" +
                    "│  1.  │ Beli Saham              │\n" +
                    "├──────┼─────────────────────────┤\n" +
                    "│  2.  │ Jual Saham              │\n" +
                    "├──────┼─────────────────────────┤\n" +
                    "│  3.  │ Beli SBN                │\n" +
                    "├──────┼─────────────────────────┤\n" +
                    "│  4.  │ Simulasi SBN            │\n" +
                    "├──────┼─────────────────────────┤\n" +
                    "│  5.  │ Portofolio              │\n" +
                    "├──────┼─────────────────────────┤\n" +
                    "│  6.  │ Logout                  │\n" +
                    "╘══════╧═════════════════════════╛\n");

            System.out.print("╘═> ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    sahamMenu.beliSahamMenu();
                    break;
                case 2:
                    sahamMenu.jualSahamMenu();
                    break;
                case 3:
                    sbnMenu.beliSBNMenu();
                    break;
                case 4:
                    sbnMenu.portofolioSBN();
                    Util.pressToContinue(sc);
                    break;
                case 5:
                    portofolioMenu.mainMenu();
                    break;
                case 6:
                    Util.successMsg("╒════════════════════════════════╕");
                    Util.successMsg("│       Logout berhasil !!!      │");
                    Util.successMsg("╘════════════════════════════════╛");
                    return;
                default:
                    Util.errorMsg("╒════════════════════════════════╕");
                    Util.errorMsg("│      Input tidak valid !!!     │");
                    Util.errorMsg("│       Pilih | 1 | 2 | 3 |      │");
                    Util.errorMsg("╘════════════════════════════════╛");
            }
        }
    }
}
