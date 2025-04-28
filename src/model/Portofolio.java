package model;

    public class Portofolio {
        private String kodeProduk;
        private String namaProduk;
        private int jumlah;
        private double nilaiAwal;

        public Portofolio(String kodeProduk, String namaProduk, int jumlah, double nilaiAwal) {
            this.kodeProduk = kodeProduk;
            this.namaProduk = namaProduk;
            this.jumlah = jumlah;
            this.nilaiAwal = nilaiAwal;
        }

        public String getKodeProduk() {
            return kodeProduk;
        }

        public String getNamaProduk() {
            return namaProduk;
        }

        public int getJumlah() {
            return jumlah;
        }

        public double getNilaiAwal() {
            return nilaiAwal;
        }

        public void setJumlah(int jumlah) {
            this.jumlah = jumlah;
        }

        public void setNilaiAwal(double nilaiAwal) {
            this.nilaiAwal = nilaiAwal;
        }

        @Override
        public String toString() {
            return String.format("%-10s %-20s Jumlah: %-5d Nilai Awal: Rp%,.2f",
                    kodeProduk, namaProduk, jumlah, nilaiAwal);
        }
