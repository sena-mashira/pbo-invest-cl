package model;

import java.time.LocalDate;

public class SBN {
    private String kode;
    private String nama;
    private double bunga;
    private LocalDate tanggalJatuhTempo;
    private int kuotaNasional;

    public SBN(String kode, String nama, double bunga, LocalDate tanggalJatuhTempo, int kuotaNasional) {
        this.kode = kode;
        this.nama = nama;
        this.bunga = bunga;
        this.tanggalJatuhTempo = tanggalJatuhTempo;
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

    public int getKuotaNasional() {
        return kuotaNasional;
    }

    public void setKuotaNasional(int kuotaNasional) {
        this.kuotaNasional = kuotaNasional;
    }

    // Cek apakah masih aktif
    public boolean isAktif() {
        return LocalDate.now().isBefore(tanggalJatuhTempo);
    }

    public boolean beli(int jumlah) {
        if (kuotaNasional >= jumlah && isAktif()) {
            kuotaNasional -= jumlah;
            return true;
        }
        return false;
    }
}

