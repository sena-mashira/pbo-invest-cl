package ui;

import model.Saham;
import service.SahamService;
import util.Util;

import java.util.Scanner;

public class SahamMenu {
    Scanner sc = new Scanner(System.in);
    SahamService sahamService = new SahamService();

    // Admin Menu
    public void listSaham() {
        System.out.print(
                "╒══════╤════════════════════════════════╤════════════╤════════════╕\n" +
                "│ Kode │ Perusahaan                     │ Harga      │ Jumlah     |\n" +
                "├──────┼────────────────────────────────┼────────────┼────────────┤\n");
        for (Saham saham : sahamService.getSemuaSaham()) {
            System.out.printf("│ %-4s │ %-30s │ Rp.%-7.2f │ %-10d |%n",
                    saham.getKode(), saham.getNamaPerusahaan(), saham.getHarga(), (int) saham.getJumlah());
        }
        System.out.println("╘══════╧════════════════════════════════╧════════════╧════════════╛");
    }

    public void tambahSahamMenu() {
        System.out.println("╒════════════╤═══════════════════╕");
        System.out.print("  Kode       │ ");
        String kode = sc.next();
        sc.nextLine();
        System.out.println("├────────────┼───────────────────┤");
        System.out.print("  Perusahaan │ ");
        String perusahaan = sc.nextLine();
        System.out.println("├────────────┼───────────────────┤");
        System.out.print("  Harga      │ ");
        double harga = sc.nextDouble();
        System.out.println("├────────────┼───────────────────┤");
        System.out.print("  Jumlah     │ ");
        int jumlah = sc.nextInt();
        System.out.println("╘═════════════╧══════════════════╛");

        Saham saham = new Saham(kode, perusahaan, harga, jumlah);

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

        listSaham();

        Util.pressToContinue(sc);

        System.out.println("╒════════════╤═══════════════════╕");
        System.out.print("  Kode       │ ");
        String kode = sc.next();
        System.out.println("├────────────┼───────────────────┤");
        System.out.print("  Harga Baru │ ");
        double harga = sc.nextDouble();
        System.out.println("╘════════════╧═══════════════════╛");

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

    // Customer Menu
    public void portofolioSaham() {
        int jumlah;
        double hargaTerbaru;

        System.out.print(
                "╒════════════╤════════════════════════════════╤════════════════════════════╤════════════════════════════╤════════════════╕\n" +
                "│ Kode       │ Perusahaan                     │ Harga Beli                 │ Harga Saat ini             | Jumlah         |\n" +
                "├────────────┼────────────────────────────────┼────────────────────────────┼────────────────────────────┼────────────────┤\n");
        for (Saham saham : sahamService.getSemuaSahamDimiliki()) {
            hargaTerbaru = sahamService.getSaham(saham.getKode()).getHarga();
            jumlah = (int) saham.getJumlah();
            System.out.printf("│ %-10s │ %-30s │ Rp.%-23.2f │ Rp.%-23.2f │ %-14d |%n",
                    saham.getKode(), saham.getNamaPerusahaan(), (saham.getHarga() * jumlah), (hargaTerbaru * jumlah),(int) jumlah);
        }
        System.out.println("╘════════════╧════════════════════════════════╧════════════════════════════╧════════════════════════════╧════════════════╛");
    }

    public void beliSahamMenu() {

        listSaham();

        Util.pressToContinue(sc);

        while (true) {
            System.out.println("╒════════════╤═══════════════════╕");
            System.out.print("  Kode       │ ");
            String kode = sc.next();
            System.out.println("├────────────┼───────────────────┤");
            System.out.print("  Jumlah     │ ");
            int jumlah = sc.nextInt();
            System.out.println("╘════════════╧═══════════════════╛");

            String result = sahamService.beliSaham(kode, jumlah);

            switch (result) {
                case "berhasil":
                    Util.successMsg("╒════════════════════════════════╕");
                    Util.successMsg("│    Saham berhasil dibeli !!!   │");
                    Util.successMsg("╘════════════════════════════════╛");
                    return;
                case "kosong":
                    Util.errorMsg("╒════════════════════════════════╕");
                    Util.errorMsg("│    Saham tidak ditemukan !!!   │");
                    Util.errorMsg("╘════════════════════════════════╛");
                    break;
                case "kekurangan":
                    Util.errorMsg("╒════════════════════════════════╕");
                    Util.errorMsg("│       Jumlah lembar harus      │");
                    Util.errorMsg("│         lebih dari 0 !!!       │");
                    Util.errorMsg("╘════════════════════════════════╛");
                    break;
                case "kelebihan":
                    Util.errorMsg("╒════════════════════════════════╕");
                    Util.errorMsg("│     Jumlah lembar melebihi     │");
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

    public void jualSahamMenu() {

        if (sahamService.isSahamNull()) {
            Util.errorMsg("╒════════════════════════════════╕");
            Util.errorMsg("│        Tidak ada Saham !!!     │");
            Util.errorMsg("╘════════════════════════════════╛");
            return;
        }

        portofolioSaham();

        Util.pressToContinue(sc);

        System.out.println("╒════════════╤═══════════════════╕");
        System.out.print("  Kode       │ ");
        String kode = sc.next();
        System.out.println("├────────────┼───────────────────┤");
        System.out.print("  Jumlah     │ ");
        int jumlah = sc.nextInt();
        System.out.println("╘════════════╧═══════════════════╛");

        String result = sahamService.jualSaham(kode, jumlah);

        switch (result) {
            case "berhasil":
                Util.successMsg("╒════════════════════════════════╕");
                Util.successMsg("│    Saham berhasil diubah !!!   │");
                Util.successMsg("╘════════════════════════════════╛");
                break;
            case "kosong":
                Util.errorMsg("╒════════════════════════════════╕");
                Util.errorMsg("│    Saham tidak ditemukan !!!   │");
                Util.errorMsg("╘════════════════════════════════╛");
                break;
            case "kekurangan":
                Util.errorMsg("╒════════════════════════════════╕");
                Util.errorMsg("│       Jumlah lembar harus      │");
                Util.errorMsg("│         lebih dari 0 !!!       │");
                Util.errorMsg("╘════════════════════════════════╛");
                break;
            case "kelebihan":
                Util.errorMsg("╒════════════════════════════════╕");
                Util.errorMsg("│     Jumlah lembar melebihi     │");
                Util.errorMsg("│       jumlah dimiliki !!!      │");
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
