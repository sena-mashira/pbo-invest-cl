package ui;

import model.Saham;
import service.SahamService;
import util.Util;

import java.util.Scanner;

public class SahamMenu {
    Scanner sc = new Scanner(System.in);
    SahamService sahamService = new SahamService();

    public void listSaham() {
        System.out.print(
                "╒══════╤════════════╤════════════╕\n" +
                "│ Kode │ Perusahaan │ Harga      │\n" +
                "├──────┼────────────┼────────────┤\n");
        for (Saham saham : sahamService.getSemuaSaham()) {
            System.out.printf("│ %-4s │ %-10s │ %-10.2f │%n",
                    saham.getKode(), saham.getNamaPerusahaan(), saham.getHarga());
        }
        System.out.println("╘══════╧════════════╧════════════╛");

        System.out.println("Tekan \"ENTER\" untuk melanjutkan... ");
        sc.nextLine();
    }

    public void tambahSahamMenu() {
        System.out.println("╒════════════╤═══════════════════╕");
        System.out.print("  Kode       │ ");
        String kode = sc.nextLine();
        System.out.println("├────────────┼───────────────────┤");
        System.out.print("  Perusahaan │ ");
        String perusahaan = sc.nextLine();
        System.out.println("├────────────┼───────────────────┤");
        System.out.print("  Harga      │ ");
        double harga = sc.nextDouble();
        System.out.println("╘═════════════╧══════════════════╛");

        Saham saham = new Saham(kode, perusahaan, harga);

        if (sahamService.tambahSaham(saham)) {
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

    public void ubahSahamMenu() {
        System.out.println("╒════════════╤═══════════════════╕");
        System.out.print("  Kode       │ ");
        String kode = sc.next();
        System.out.println("├────────────┼───────────────────┤");
        System.out.print("  Harga Baru │ ");
        double harga = sc.nextDouble();
        System.out.println("╘═════════════╧══════════════════╛");

        if (sahamService.ubahHargaSaham(kode, harga)) {
            Util.successMsg("╒════════════════════════════════╕");
            Util.successMsg("│    Harga berhasil diubah !!!   │");
            Util.successMsg("╘════════════════════════════════╛");
        } else {
            Util.errorMsg("╒════════════════════════════════╕");
            Util.errorMsg("│    Saham tidak ditemukan !!!   │");
            Util.errorMsg("╘════════════════════════════════╛");
        }
    }
}
