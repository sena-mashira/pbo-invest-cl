package model;

// Model for Saham
public class Saham {
    private String kode;
    private String namaPerusahaan;
    private double harga;
    private int jumlah;

    public Saham(String kode, String namaPerusahaan, double harga, int jumlah) {
        this.kode = kode;
        this.namaPerusahaan = namaPerusahaan;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    public String getKode() {
        return kode;
    }

    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public double getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
}
