package model;

import java.time.LocalDate;

// Model for SBN
public class SBN {
    private String kode;
    private String nama;
    private double bunga;
    private LocalDate tanggalJatuhTempo;
    private double nominal;
    private int kuotaNasional;

    public SBN(String kode, String nama, double bunga, LocalDate tanggalJatuhTempo, double nominal,  int kuotaNasional) {
        this.kode = kode;
        this.nama = nama;
        this.bunga = bunga;
        this.tanggalJatuhTempo = tanggalJatuhTempo;
        this.nominal = nominal;
        this.kuotaNasional = kuotaNasional;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public double getBunga() {
        return bunga;
    }

    public LocalDate getTanggalJatuhTempo() {
        return tanggalJatuhTempo;
    }

    public double getNominal() {
        return nominal;
    }

    public void setNominal(double nominal) {
        this.nominal = nominal;
    }

    public int getKuotaNasional() {
        return kuotaNasional;
    }

    public void setKuotaNasional(int kuotaNasional) {
        this.kuotaNasional = kuotaNasional;
    }

//    Simulation of SBN Coupon per month using %bunga / 12 bulan * 90% * nominal
    public double hitungKuponPerBulan() {
        double bungaBulanan = (bunga/100) / 12;
        return bungaBulanan * 0.9 * nominal;
    }
}

