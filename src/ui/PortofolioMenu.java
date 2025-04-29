package ui;

import service.SBNService;
import service.SahamService;
import util.Util;

import java.util.Scanner;

// View class that show Portofolio Menu
public class PortofolioMenu {
    SahamMenu sahamMenu = new SahamMenu();
    SBNMenu sbnMenu = new SBNMenu();
    SahamService sahamService = new SahamService();
    SBNService sbnService = new SBNService();
    Scanner sc = new Scanner(System.in);

//    Function to show all owned Saham and SBN
    public void mainMenu() {
//        Check if Saham and SBN is not empty
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
