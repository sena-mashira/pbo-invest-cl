package service;

import data.SBNData;
import model.SBN;

import java.time.LocalDate;
import java.util.Collection;

public class SBNService {
    public SBNService() {
        tambahSBN(new SBN("SBN2025", "SBN Negara 2025", 6.0, LocalDate.of(2025, 12, 31), 1000000, 100));
        tambahSBN(new SBN("SBN2026", "SBN Negara 2026", 5.5, LocalDate.of(2026, 12, 31), 1500000, 800));
        tambahSBN(new SBN("SBN2027", "SBN Negara 2027", 7.0, LocalDate.of(2027, 12, 31), 2000000, 120));
        tambahSBN(new SBN("SBN2028", "SBN Negara 2028", 6.5, LocalDate.of(2028, 12, 31), 1200000, 110));
        tambahSBN(new SBN("SBN2029", "SBN Negara 2029", 6.8, LocalDate.of(2029, 12, 31), 1500000, 150));
    }

    public boolean isSBNNull() {
        if(SBNData.getPortofolioSBN().isEmpty()){
            return true;
        } else {
            return false;
        }
    }

    public boolean tambahSBN(SBN sbn) {
        if (SBNData.getSBN().get(sbn.getKode()) != null) {
            return false;
        }

        SBNData.getSBN().put(sbn.getKode(), sbn);
        return true;
    }

    public Collection<SBN> getSemuaSBN() {
        return SBNData.getSBN().values();
    }

    public Collection<SBN> getSemuaSBNDimilki() { return SBNData.getPortofolioSBN().values(); }

    public String beliSBN(String kode, int kuota) {
        SBN sbn = SBNData.getSBN().get(kode);

        if (sbn == null) return "kosong";

        if (kuota <= 0) return "kekurangan";
        else if (kuota > sbn.getKuotaNasional()) return "kelebihan";

        sbn.setKuotaNasional(sbn.getKuotaNasional() - kuota);

        SBN sbnYangDibeli;
        if (SBNData.getPortofolioSBN().get(kode) == null) {
            sbnYangDibeli = new SBN(
                    sbn.getKode(),
                    sbn.getNama(),
                    sbn.getBunga(),
                    sbn.getTanggalJatuhTempo(),
                    sbn.getNominal(),
                    kuota
            );

            SBNData.getPortofolioSBN().put(sbnYangDibeli.getKode(), sbnYangDibeli);
        } else {
            SBN sbnSebelumnya = SBNData.getPortofolioSBN().get(kode);
            sbnSebelumnya.setKuotaNasional(kuota + (int) sbnSebelumnya.getKuotaNasional());
        }

        return "berhasil";
    }
}