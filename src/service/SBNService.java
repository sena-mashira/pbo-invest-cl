package service;

import data.SBNData;
import model.SBN;

import java.time.LocalDate;
import java.util.Collection;

// Service class that handle all SBN business logic
public class SBNService {

//    Construct function that add SBN Dummy Data
    public SBNService() {
        tambahSBN(new SBN("SBN2025", "SBN Negara 2025", 6.0, LocalDate.of(2025, 12, 31), 1000000, 100));
        tambahSBN(new SBN("SBN2026", "SBN Negara 2026", 5.5, LocalDate.of(2026, 12, 31), 1500000, 800));
        tambahSBN(new SBN("SBN2027", "SBN Negara 2027", 7.0, LocalDate.of(2027, 12, 31), 2000000, 120));
        tambahSBN(new SBN("SBN2028", "SBN Negara 2028", 6.5, LocalDate.of(2028, 12, 31), 1200000, 110));
        tambahSBN(new SBN("SBN2029", "SBN Negara 2029", 6.8, LocalDate.of(2029, 12, 31), 1500000, 150));
    }

// Check if SBN is null
    public boolean isSBNNull() {
        if(SBNData.getPortofolioSBN().isEmpty()){
            return true;
        } else {
            return false;
        }
    }

// Function to add SBN into SBNData
    public boolean tambahSBN(SBN sbn) {
        if (SBNData.getSBN().get(sbn.getKode()) != null) {
            return false;
        }
// Store SBN into SBNData
        SBNData.getSBN().put(sbn.getKode(), sbn);
        return true;
    }

//    Function to turn SBN into Collection
    public Collection<SBN> getSemuaSBN() {
        return SBNData.getSBN().values();
    }

//    Function to turn Owned SBN into Collection
    public Collection<SBN> getSemuaSBNDimilki() {
        return SBNData.getPortofolioSBN().values();
    }

//    Function to buy SBN
    public String beliSBN(String kode, int kuota) {
        SBN sbn = SBNData.getSBN().get(kode);
//        Check if SBN really exist
        if (sbn == null) return "kosong";
//        Check if kuota is more than 0
        else if (kuota <= 0) return "kekurangan";
//        check if kuota is more than selected Jumlah SBN
        else if (kuota > sbn.getKuotaNasional()) return "kelebihan";

        SBN sbnYangDibeli;
//        Check if customer already bought the SBN or not, if not yet run the code below
        if (SBNData.getPortofolioSBN().get(kode) == null) {
//            Create new SBN object
            sbnYangDibeli = new SBN(
                    sbn.getKode(),
                    sbn.getNama(),
                    sbn.getBunga(),
                    sbn.getTanggalJatuhTempo(),
                    sbn.getNominal(),
                    kuota
            );
//            Store SBN into SBNData
            SBNData.getPortofolioSBN().put(sbnYangDibeli.getKode(), sbnYangDibeli);
        } else {
//            if already bought, add old Jumlah SBN with the new one
            SBN sbnSebelumnya = SBNData.getPortofolioSBN().get(kode);
            sbnSebelumnya.setKuotaNasional(kuota + (int) sbnSebelumnya.getKuotaNasional());
        }
//        Decrease Jumlah of selected SBN
        sbn.setKuotaNasional(sbn.getKuotaNasional() - kuota);

        return "berhasil";
    }
}