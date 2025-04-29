package service;

import data.SahamData;
import model.Saham;

import java.util.*;

public class SahamService {
    public SahamService() {
        tambahSaham(new Saham("BCA", "Bank BCA", 8700, 1000));
        tambahSaham(new Saham("TLKM", "Telkom", 4200, 1500));
        tambahSaham(new Saham("UNVR", "Unilever", 5100, 2000));
        tambahSaham(new Saham("BBCA", "Bank Central Asia", 7000, 500));
        tambahSaham(new Saham("PGAS", "Perusahaan Gas Negara", 1600, 800));
    }

    public boolean isSahamNull() {
        if(SahamData.getPortofolioSaham().isEmpty()){
            return true;
        } else {
            return false;
        }
    }

    public boolean tambahSaham(Saham saham) {
        if (SahamData.getSaham().get(saham.getKode()) != null) {
            return false;
        }

        SahamData.getSaham().put(saham.getKode(), saham);
        return true;
    }

    public boolean ubahHargaSaham(String kode, double hargaBaru) {
        Saham saham = SahamData.getSaham().get(kode);

        if (saham != null) {
            saham.setHarga(hargaBaru);
            return true;
        }

        return false;
    }

    public Saham getSaham(String kode) {
        return SahamData.getSaham().get(kode);
    }

    public Collection<Saham> getSemuaSaham() {
        return SahamData.getSaham().values();
    }

    public Collection<Saham> getSemuaSahamDimiliki() {
        return SahamData.getPortofolioSaham().values();
    }

    public String beliSaham(String kode, int jumlah) {
        Saham sahamDipilih = SahamData.getSaham().get(kode);

        if (sahamDipilih == null) return "kosong";

        if (jumlah <= 0) return "kekurangan";
        else if (jumlah > sahamDipilih.getJumlah()) return "kelebihan";

        Saham sahamYangDibeli;
        double harga = sahamDipilih.getHarga();
        if (SahamData.getPortofolioSaham().get(kode) == null) {
            sahamYangDibeli = new Saham(
                    sahamDipilih.getKode(),
                    sahamDipilih.getNamaPerusahaan(),
                    harga*jumlah,
                    jumlah
            );

            SahamData.getPortofolioSaham().put(sahamYangDibeli.getKode(), sahamYangDibeli);
        } else {
            Saham sahamSebelumnya = SahamData.getPortofolioSaham().get(kode);
            sahamSebelumnya.setJumlah(jumlah + (int) sahamSebelumnya.getJumlah());
        }

        sahamDipilih.setJumlah((int) sahamDipilih.getJumlah() - jumlah);

        return "berhasil";
    }

    public String jualSaham(String kode, int jumlah) {
        Saham portofolio = SahamData.getPortofolioSaham().get(kode);

        if (portofolio == null) return "kosong";

        int jumlahDimiliki = (int) portofolio.getJumlah();

        if (jumlah <= 0) {
            return "kekurangan";
        }

        if (jumlah > jumlahDimiliki) {
            return "kelebihan";
        }

        int sisa = jumlahDimiliki - jumlah;

        if (sisa > 0) {
            portofolio.setJumlah(sisa);
        } else {
            SahamData.getPortofolioSaham().remove(kode);
        }

        return "berhasil";
    }
}