package ui;

import model.Saham;
import service.SBNService;
import model.SBN;
import util.Util;

import java.time.LocalDate;
import java.util.Scanner;

public class SBNMenu {
    Scanner sc = new Scanner(System.in);
    SBNService sbnService = new SBNService();

    public void listSBN() {
        System.out.print(
                "╒════════════╤══════════════════════╤════════════╤═════════════════╤═══════╕\n" +
                "│ Kode       │ Nama                 │ Bunga      │ Jatuh Tempo     | Kuota |\n" +
                "├────────────┼──────────────────────┼────────────┼─────────────────┼───────┤\n");
        for (SBN sbn : sbnService.getSemuaSBN()) {
            System.out.printf("│ %-10s │ %-20s │ %-10.2f │ %-15s | %-5d |%n",
                    sbn.getKode(), sbn.getNama(), sbn.getBunga(), sbn.getTanggalJatuhTempo(), sbn.getKuotaNasional());
        }
        System.out.println("╘════════════╧══════════════════════╧════════════╧═════════════════╧═══════╛");

        System.out.println("Tekan \"ENTER\" untuk melanjutkan... ");
        sc.nextLine();
    }

    public void tambahSBNMenu() {
        System.out.println("╒════════════╤═══════════════════╕");
        System.out.print("  Kode       │ ");
        String kode = sc.nextLine();
        System.out.println("├────────────┼───────────────────┤");
        System.out.print("  Nama       │ ");
        String nama = sc.nextLine();
        System.out.println("├────────────┼───────────────────┤");
        System.out.print("  Bunga      │ ");
        double bunga = sc.nextDouble();
        System.out.println("├────────────┼───────────────────┤");
        System.out.print("  Tempo      │ ");
        String tanggal = sc.next();
        System.out.println("├────────────┼───────────────────┤");
        System.out.print("  Kuota      │ ");
        int kuota = sc.nextInt();
        System.out.println("╘═════════════╧══════════════════╛");

        SBN sbn = new SBN(kode, nama, bunga, LocalDate.parse(tanggal), kuota);

        if (sbnService.tambahSBN(sbn)) {
            Util.successMsg("╒════════════════════════════════╕");
            Util.successMsg("│ Saham berhasil ditambahkan !!! │");
            Util.successMsg("╘════════════════════════════════╛");
        } else {
            Util.errorMsg("╒════════════════════════════════╕");
            Util.errorMsg("│   Saham dengan kode tersebut   │");
            Util.errorMsg("│        sudah terdaftar !!!     │");
            Util.errorMsg("╘════════════════════════════════╛");
        }
    }
}
