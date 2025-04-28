package ui;

import util.Util;

import java.util.Scanner;

public class AdminMenu {
    Scanner sc = new Scanner(System.in);

    SahamMenu sahamMenu = new SahamMenu();
    SBNMenu sbnMenu = new SBNMenu();

    public void mainMenu() {
        System.out.print(
                "╒════════════════════════════════╕\n" +
                "│          INVEST - ADMIN        │\n" +
                "╘════════════════════════════════╛\n");

        int choice = 0;

        while (true) {
            System.out.print(
                    "╒══════╤═════════════════════════╕\n" +
                    "│  1.  │ Saham                   │\n" +
                    "├──────┼─────────────────────────┤\n" +
                    "│  2.  │ SBN                     │\n" +
                    "├──────┼─────────────────────────┤\n" +
                    "│  3.  │ Logout                  │\n" +
                    "╘══════╧═════════════════════════╛\n");
            System.out.print("╘═> ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sahamMenu();
                    break;
                case 2:
                    sbnMenu();
                    break;
                case 3:
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

    public void sahamMenu() {
        System.out.print(
                "╒════════════════════════════════╕\n" +
                "│     INVEST - ADMIN - SAHAM     │\n" +
                "╘════════════════════════════════╛\n");

        int choice = 0;

        while (true) {
            System.out.print(
                    "╒══════╤═════════════════════════╕\n" +
                    "│  1.  │ Lihat Saham             │\n" +
                    "├──────┼─────────────────────────┤\n" +
                    "│  2.  │ Tambah Saham            │\n" +
                    "├──────┼─────────────────────────┤\n" +
                    "│  3.  │ Ubah Harga Saham        │\n" +
                    "├──────┼─────────────────────────┤\n" +
                    "│  4.  │ Kembali                 │\n" +
                    "╘══════╧═════════════════════════╛\n");

            System.out.print("╘═> ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sahamMenu.listSaham();
                    break;
                case 2:
                    sahamMenu.tambahSahamMenu();
                    break;
                case 3:
                    sahamMenu.ubahSahamMenu();
                    break;
                case 4:
                    return;
                default:
                    Util.errorMsg("╒════════════════════════════════╕");
                    Util.errorMsg("│      Input tidak valid !!!     │");
                    Util.errorMsg("│       Pilih | 1 | 2 | 3 |      │");
                    Util.errorMsg("╘════════════════════════════════╛");
                    break;
            }
        }
    }

    public void sbnMenu() {
        System.out.print(
                "╒════════════════════════════════╕\n" +
                "│      INVEST - ADMIN - SBN      │\n" +
                "╘════════════════════════════════╛\n");

        int choice = 0;

        while (true) {
            System.out.print(
                    "╒══════╤═════════════════════════╕\n" +
                    "│  1.  │ List SBN                │\n" +
                    "├──────┼─────────────────────────┤\n" +
                    "│  2.  │ Tambah SBN              │\n" +
                    "├──────┼─────────────────────────┤\n" +
                    "│  3.  │ Kembali                 │\n" +
                    "╘══════╧═════════════════════════╛\n");

            System.out.print("╘═> ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sbnMenu.listSBN();
                    break;
                case 2:
                    sbnMenu.tambahSBNMenu();
                    break;
                case 3:
                    return;
                default:
                    Util.errorMsg("╒════════════════════════════════╕");
                    Util.errorMsg("│      Input tidak valid !!!     │");
                    Util.errorMsg("│       Pilih | 1 | 2 | 3 |      │");
                    Util.errorMsg("╘════════════════════════════════╛");
                    break;
            }
        }
    }

}
