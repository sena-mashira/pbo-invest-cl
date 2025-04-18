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
}
