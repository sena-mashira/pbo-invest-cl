package ui;

import service.SBNService;
import service.SahamService;
import util.Util;

import java.util.Scanner;

public class PortofolioMenu {
    SahamMenu sahamMenu = new SahamMenu();
    SBNMenu sbnMenu = new SBNMenu();
    SahamService sahamService = new SahamService();
    SBNService sbnService = new SBNService();
    Scanner sc = new Scanner(System.in);

    public void mainMenu() {
        if (!sahamService.isSahamNull() && !sbnService.isSBNNull()) {
            System.out.println(
                    "╒════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╕\n" +
                    "│                              INVEST - CUSTOMER - PORTOFOLIO SAHAM DAN SURAT BERHARGA NEGARA                            |\n" +
                    "├────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤");
            if (!sahamService.isSahamNull()) {
                System.out.println("| SAHAM                                                                                                                  |");
                sahamMenu.portofolioSaham();
            }

            if (!sbnService.isSBNNull()) {
                System.out.println("| SBN                                                                                                                    |");
                sbnMenu.portofolioSBN();
            }

            System.out.println("╘════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╛");
            Util.pressToContinue(sc);
        } else {
            Util.errorMsg("╒════════════════════════════════╕");
            Util.errorMsg("│       Portofolio Kosong !!!    │");
            Util.errorMsg("╘════════════════════════════════╛");
        }
    }
}
