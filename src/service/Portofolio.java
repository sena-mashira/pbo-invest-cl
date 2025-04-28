package service;

public class Portofolio {
    private final Portofolio portofolio;

    public PortofolioService() {
        this.portofolio = new Portofolio();
    }

    public Portofolio getPortofolio() {
        return portofolio;
    }

    public void beliSaham(Saham saham, int jumlah) {
        if (saham == null || jumlah <= 0) {
            System.out.println("Pembelian saham gagal: data tidak valid.");
            return;
        }
        portofolio.tambahSaham(saham.getKode(), jumlah);
        System.out.println("Berhasil membeli " + jumlah + " lembar saham " + saham.getNamaPerusahaan());
    }

    public void jualSaham(Saham saham, int jumlah) {
        if (saham == null || jumlah <= 0) {
            System.out.println("Penjualan saham gagal: data tidak valid.");
            return;
        }
        boolean sukses = portofolio.jualSaham(saham.getKode(), jumlah);
        if (sukses) {
            System.out.println("Berhasil menjual " + jumlah + " lembar saham " + saham.getNamaPerusahaan());
        }
    }

    public void beliSBN(SBN sbn, double nominal) {
        if (sbn == null || nominal <= 0) {
            System.out.println("Pembelian SBN gagal: data tidak valid.");
            return;
        }
        if (sbn.getKuotaNasional() < nominal) {
            System.out.println("Pembelian gagal, kuota nasional tidak mencukupi.");
            return;
        }
        sbn.setKuotaNasional(sbn.getKuotaNasional() - nominal);
        portofolio.tambahSBN(sbn.getKode(), nominal);
        System.out.println("Berhasil membeli SBN " + sbn.getNama() + " sebesar Rp " + nominal);
    }

    public void tampilkanPortofolio(Map<String, Saham> semuaSaham, Map<String, SBN> semuaSBN) {
        System.out.println("=== PORTOFOLIO SAHAM ===");
        for (Map.Entry<String, Integer> entry : portofolio.getSahamDimiliki().entrySet()) {
            String kode = entry.getKey();
            int jumlah = entry.getValue();
            Saham saham = semuaSaham.get(kode);
            if (saham != null) {
                double totalPembelian = saham.getHarga() * jumlah;
                System.out.println("Saham: " + saham.getNamaPerusahaan() + " | Kode: " + kode +
                        " | Jumlah: " + jumlah + " lembar | Harga per lembar: Rp " + saham.getHarga() +
                        " | Total Nilai: Rp " + totalPembelian);
            }
        }

        System.out.println("\n=== PORTOFOLIO SBN ===");
        for (Map.Entry<String, Double> entry : portofolio.getSbnDimiliki().entrySet()) {
            String kode = entry.getKey();
            double nominal = entry.getValue();
            SBN sbn = semuaSBN.get(kode);
            if (sbn != null) {
                double kuponBulanan = (sbn.getBunga() / 12 / 100) * 0.9 * nominal;
                System.out.println("SBN: " + sbn.getNama() + " | Kode: " + kode +
                        " | Nominal Investasi: Rp " + nominal +
                        " | Bunga / bulan: Rp " + kuponBulanan);
            }
        }
    }