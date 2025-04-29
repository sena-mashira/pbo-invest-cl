package ui;

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
                "╒════════════╤══════════════════════╤════════════╤═════════════════╤═════════════════╤════════════╕\n" +
                "│ Kode       │ Nama                 │ Bunga      │ Jatuh Tempo     | Nominal         | Kuota      |\n" +
                "├────────────┼──────────────────────┼────────────┼─────────────────┼─────────────────┼────────────┤\n");
        for (SBN sbn : sbnService.getSemuaSBN()) {
            System.out.printf("│ %-10s │ %-20s │ %-10.2f │ %-15s | Rp.%-12.2f | %-10d |%n",
                    sbn.getKode(), sbn.getNama(), sbn.getBunga(), sbn.getTanggalJatuhTempo(), sbn.getNominal(), sbn.getKuotaNasional());
        }
        System.out.println("╘════════════╧══════════════════════╧════════════╧═════════════════╧═════════════════╧════════════╛");
    }

    public void tambahSBNMenu() {
        System.out.println("╒════════════╤═══════════════════╕");
        System.out.print("  Kode       │ ");
        String kode = sc.next();
        sc.nextLine();
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
        System.out.print("  Nominal    │ ");
        double nominal = sc.nextDouble();
        System.out.println("├────────────┼───────────────────┤");
        System.out.print("  Kuota      │ ");
        int kuota = sc.nextInt();
        System.out.println("╘════════════╧═══════════════════╛");

        SBN sbn = new SBN(kode, nama, bunga, LocalDate.parse(tanggal), nominal, kuota);

        if (sbnService.tambahSBN(sbn)) {
            Util.successMsg("╒════════════════════════════════╕");
            Util.successMsg("│  SBN berhasil ditambahkan !!!  │");
            Util.successMsg("╘════════════════════════════════╛");
        } else {
            Util.errorMsg("╒════════════════════════════════╕");
            Util.errorMsg("│    SBN dengan kode tersebut    │");
            Util.errorMsg("│        sudah terdaftar !!!     │");
            Util.errorMsg("╘════════════════════════════════╛");
        }
    }

    public void portofolioSBN() {
        if (sbnService.isSBNNull()) {
            Util.errorMsg("╒════════════════════════════════╕");
            Util.errorMsg("│         Tidak ada SBN !!!      │");
            Util.errorMsg("╘════════════════════════════════╛");
            return;
        }

        System.out.print(
                "╒════════════╤══════════════════════╤════════════╤═════════════════╤═════════════════╤════════════╤══════════════════════╕\n" +
                "│ Kode       │ Nama                 │ Bunga      │ Jatuh Tempo     | Nominal         | Kuota      | Simulasi             |\n" +
                "├────────────┼──────────────────────┼────────────┼─────────────────┼─────────────────┼────────────┼──────────────────────┤\n");
        for (SBN sbn : sbnService.getSemuaSBNDimilki()) {
            System.out.printf("│ %-10s │ %-20s │ %-10.2f │ %-15s | Rp.%-12.2f | %-10d | Rp.%-17.2f |%n",
                    sbn.getKode(), sbn.getNama(), sbn.getBunga(), sbn.getTanggalJatuhTempo(), sbn.getNominal(), sbn.getKuotaNasional(), sbn.hitungKuponPerBulan());
        }
        System.out.println("╘════════════╧══════════════════════╧════════════╧═════════════════╧═════════════════╧════════════╧══════════════════════╛");
    }

    public void beliSBNMenu() {

        listSBN();

        Util.pressToContinue(sc);

        while (true) {
            System.out.println("╒════════════╤═══════════════════╕");
            System.out.print("  Kode       │ ");
            String kode = sc.next();
            System.out.println("├────────────┼───────────────────┤");
            System.out.print("  Jumlah     │ ");
            int jumlah = sc.nextInt();
            System.out.println("╘════════════╧═══════════════════╛");

            String result = sbnService.beliSBN(kode, jumlah);

            switch (result) {
                case "berhasil":
                    Util.successMsg("╒════════════════════════════════╕");
                    Util.successMsg("│     SBN berhasil dibeli !!!    │");
                    Util.successMsg("╘════════════════════════════════╛");
                    return;
                case "kosong":
                    Util.errorMsg("╒════════════════════════════════╕");
                    Util.errorMsg("│     SBN tidak ditemukan !!!    │");
                    Util.errorMsg("╘════════════════════════════════╛");
                    break;
                case "kekurangan":
                    Util.errorMsg("╒════════════════════════════════╕");
                    Util.errorMsg("│        Jumlah kuota harus      │");
                    Util.errorMsg("│         lebih dari 0 !!!       │");
                    Util.errorMsg("╘════════════════════════════════╛");
                    break;
                case "kelebihan":
                    Util.errorMsg("╒════════════════════════════════╕");
                    Util.errorMsg("│      Jumlah kuota melebihi     │");
                    Util.errorMsg("│       jumlah tersedia !!!      │");
                    Util.errorMsg("╘════════════════════════════════╛");
                    break;
                default:
                    Util.errorMsg("╒════════════════════════════════╕");
                    Util.errorMsg("│      Input Tidak Valid !!!     │");
                    Util.errorMsg("╘════════════════════════════════╛");
                    break;
            }
        }
    }
}
