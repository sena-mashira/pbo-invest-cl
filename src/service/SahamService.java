package service;

import data.SahamData;
import model.Saham;

import java.util.*;

// Service class that handle all Saham business logic
public class SahamService {
//    Construct function that add Saham Dummy Data
    public SahamService() {
        tambahSaham(new Saham("BCA", "Bank BCA", 8700, 1000));
        tambahSaham(new Saham("TLKM", "Telkom", 4200, 1500));
        tambahSaham(new Saham("UNVR", "Unilever", 5100, 2000));
        tambahSaham(new Saham("BBCA", "Bank Central Asia", 7000, 500));
        tambahSaham(new Saham("PGAS", "Perusahaan Gas Negara", 1600, 800));
    }

// Check if Saham is null
    public boolean isSahamNull() {
        if(SahamData.getPortofolioSaham().isEmpty()){
            return true;
        } else {
            return false;
        }
    }

// Function to add Saham into SahamData
    public boolean tambahSaham(Saham saham) {
//        Check if saham with the same Kode exist
        if (SahamData.getSaham().get(saham.getKode()) != null) {
            return false;
        }
// Store Saham into SahamData
        SahamData.getSaham().put(saham.getKode(), saham);
        return true;
    }

//    Function to change price of Saham
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

//    Function to turn Saham into Collection
    public Collection<Saham> getSemuaSaham() {
        return SahamData.getSaham().values();
    }

//    Function to turn Owned Saham into Collection
    public Collection<Saham> getSemuaSahamDimiliki() {
        return SahamData.getPortofolioSaham().values();
    }

//    Function to buy Saham
    public String beliSaham(String kode, int jumlah) {
        Saham sahamDipilih = SahamData.getSaham().get(kode);
//        Check if Saham really exist
        if (sahamDipilih == null) return "kosong";
//        Check if jumlah is more than 0
        else if (jumlah <= 0) return "kekurangan";
//        check if jumlah is more than selected Jumlah Saham
        else if (jumlah > sahamDipilih.getJumlah()) return "kelebihan";

        Saham sahamYangDibeli;
        double harga = sahamDipilih.getHarga();
//        Check if customer already bought the Saham or not, if not yet run the code below
        if (SahamData.getPortofolioSaham().get(kode) == null) {
//            Create new Saham object
            sahamYangDibeli = new Saham(
                    sahamDipilih.getKode(),
                    sahamDipilih.getNamaPerusahaan(),
                    harga*jumlah,
                    jumlah
            );
//            Store Saham into SahamData
            SahamData.getPortofolioSaham().put(sahamYangDibeli.getKode(), sahamYangDibeli);
        } else {
//            if already bought, add old Jumlah Saham with the new one
            Saham sahamSebelumnya = SahamData.getPortofolioSaham().get(kode);
            sahamSebelumnya.setJumlah(jumlah + (int) sahamSebelumnya.getJumlah());
        }
//        Decrease Jumlah of selected Saham
        sahamDipilih.setJumlah((int) sahamDipilih.getJumlah() - jumlah);

        return "berhasil";
    }

//    Funtion to sell Saham
    public String jualSaham(String kode, int jumlah) {
        Saham portofolio = SahamData.getPortofolioSaham().get(kode);
//        Check if owned Saham with the same Kode exist
        if (portofolio == null) return "kosong";

        int jumlahDimiliki = (int) portofolio.getJumlah();

//        Check if jumlah is more than 0
        if (jumlah <= 0) return "kekurangan";
//        check if jumlah is more than owned Jumlah Saham
        else if (jumlah > jumlahDimiliki) return "kelebihan";

        int sisa = jumlahDimiliki - jumlah;

//        Check if owned Jumlah Saham is more than zero, if yes run the code below
        if (sisa > 0) {
//            Decrease the owned Jumlah Saham with Jumlah sold
            portofolio.setJumlah(sisa);
        } else {
//            if owned jumlah less than zero, remove from SahamData
            SahamData.getPortofolioSaham().remove(kode);
        }

        return "berhasil";
    }
}