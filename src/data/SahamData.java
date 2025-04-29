package data;

import model.Saham;

import java.util.HashMap;
import java.util.Map;

// Store all data about saham
public class SahamData {
//    Store saham that admin input
    private static final Map<String, Saham> daftarSaham = new HashMap<>();
//    Store saham that customer bought
    private static final Map<String, Saham> portofolioSaham = new HashMap<>();

//    Getter for daftarSaham
    public static Map<String, Saham> getSaham() {
        return daftarSaham;
    }

//    Getter for portofolioSaham
    public static Map<String, Saham> getPortofolioSaham() {
        return portofolioSaham;
    }
}
