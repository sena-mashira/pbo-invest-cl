package ui;

import util.Util;

import java.util.Scanner;

public class PortofolioMenu {
    SahamMenu sahamMenu = new SahamMenu();
    SBNMenu sbnMenu = new SBNMenu();
    Scanner sc = new Scanner(System.in);

    public void mainMenu() {
        System.out.println(
                "╒════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╕\n" +
                "│                              INVEST - CUSTOMER - PORTOFOLIO SAHAM DAN SURAT BERHARGA NEGARA                            |\n" +
                "├────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤\n" +
                "| SAHAM                                                                                                                  |");

        sahamMenu.portofolioSaham();
        System.out.println("| SBN                                                                                                                    |");
        sbnMenu.portofolioSBN();

        System.out.println("╘════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╛");
        Util.pressToContinue(sc);
    }
}
