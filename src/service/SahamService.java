package service;

import model.Saham;

import java.util.*;

public class SahamService {
    private final Map<String, Saham> daftarSaham = new HashMap<>();

    public SahamService() {
        tambahSaham(new Saham("BCA", "Bank BCA", 8700));
        tambahSaham(new Saham("TLKM", "Telkom", 4200));
        tambahSaham(new Saham("UNVR", "Unilever", 5100));
    }


    public boolean tambahSaham(Saham saham) {
        if (daftarSaham.get(saham.getKode()) != null) {
            return false;
        }

        daftarSaham.put(saham.getKode(), saham);
        return true;
    }

    public boolean ubahHargaSaham(String kode, double hargaBaru) {
        Saham saham = daftarSaham.get(kode);

        if (saham != null) {
            saham.setHarga(hargaBaru);
            return true;
        }

        return false;
    }

    public Collection<Saham> getSemuaSaham() {
        return daftarSaham.values();
    }

    public Saham getSahamByKode(String kode) {
        return daftarSaham.get(kode);
    }

    public Saham beliSaham(String kode, int jumlah) {
        Saham sahamDipilih = daftarSaham.get(kode);

        if (sahamDipilih == null) {
            System.out.println("Saham dengan kode " + kode + " tidak ditemukan.");
            return null;
        }

        if (jumlah <= 0) {
            System.out.println("Jumlah lembar saham harus lebih dari 0.");
            return null;
        }

        Saham sahamYangDibeli = new Saham(
                sahamDipilih.getKode(),
                sahamDipilih.getNamaPerusahaan(),
                sahamDipilih.getHarga()
        );
        sahamYangDibeli.setJumlah(jumlah);

        System.out.println("Berhasil membeli " + jumlah + " lembar saham " + sahamDipilih.getNamaPerusahaan() + " dengan harga Rp " + sahamDipilih.getHarga() + " per lembar.");

        return sahamYangDibeli;
    }

    public boolean jualSaham(Map<String, Integer> portofolio, String kode, int jumlah) {
        if (!portofolio.containsKey(kode)) {
            System.out.println("Anda tidak memiliki saham dengan kode " + kode + ".");
            return false;
        }

        int jumlahDimiliki = portofolio.get(kode);
        if (jumlah <= 0) {
            System.out.println("Jumlah lembar yang dijual harus lebih dari 0.");
            return false;
        }

        if (jumlah > jumlahDimiliki) {
            System.out.println("Jumlah lembar yang dijual melebihi jumlah yang Anda miliki.");
            return false;
        }

        int sisa = jumlahDimiliki - jumlah;
        if (sisa > 0) {
            portofolio.put(kode, sisa);
        } else {
            portofolio.remove(kode);
        }

        System.out.println("Berhasil menjual " + jumlah + " lembar saham " + kode + ".");
        return true;
    }
}