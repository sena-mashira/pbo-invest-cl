package service;

import model.SBN;
import model.Saham;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SBNService {
    private final Map<String, SBN> daftarSBN = new HashMap<>();

    public SBNService() {
        tambahSBN(new SBN("SBN001", "SBN Ritel 2025", 6.5, LocalDate.of(2025, 8, 20), 1000));
    }

    public boolean tambahSBN(SBN sbn) {
        if (daftarSBN.get(sbn.getKode()) != null) {
            return false;
        }

        daftarSBN.put(sbn.getKode(), sbn);
        return true;
    }

    public Collection<SBN> getSemuaSBN() {
        return daftarSBN.values();
    }

    public boolean beliSBN(Map<String, Double> portofolioSBN, String kode, int nominal) {
        SBN sbn = daftarSBN.get(kode);

        if (sbn == null) {
            System.out.println("SBN dengan kode " + kode + " tidak ditemukan.");
            return false;
        }

        if (nominal <= 0) {
            System.out.println("Nominal pembelian harus lebih dari 0.");
            return false;
        }

        if (sbn.getKuotaNasional() < nominal) {
            System.out.println("Pembelian gagal. Kuota nasional tidak mencukupi.");
            return false;
        }
        sbn.setKuotaNasional(sbn.getKuotaNasional() - nominal);

        portofolioSBN.put(kode, portofolioSBN.getOrDefault(kode, 0.0) + nominal);

        System.out.println("Berhasil membeli SBN " + sbn.getNama() + " sebesar Rp " + nominal);
        return true;
    }
    public void simulasiKuponBulananSBN(Map<String, Double> portofolioSBN) {
        System.out.println("\n--- Simulasi Kupon Bulanan SBN ---");

        for (Map.Entry<String, Double> entry : portofolioSBN.entrySet()) {
            String kode = entry.getKey();
            double nominal = entry.getValue();

            SBN sbn = daftarSBN.get(kode);

            if (sbn != null) {
                double bunga = sbn.getBunga();
                double kuponBulanan = (bunga / 100 / 12) * 0.9 * nominal;

                System.out.println("Kode: " + sbn.getKode());
                System.out.println("Nama: " + sbn.getNama());
                System.out.println("Nominal Investasi: Rp " + nominal);
                System.out.printf("Kupon Per Bulan (90%% dari %.2f%%): Rp %.2f\n\n", bunga, kuponBulanan);
            }
        }

        if (portofolioSBN.isEmpty()) {
            System.out.println("Anda belum memiliki investasi SBN.");
        }
    }