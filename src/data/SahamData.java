package data;

import model.Saham;

import java.util.HashMap;
import java.util.Map;

public class SahamData {
    private static final Map<String, Saham> daftarSaham = new HashMap<>();
    private static final Map<String, Saham> portofolioSaham = new HashMap<>();

    public static Map<String, Saham> getSaham() {
        return daftarSaham;
    }

    public static Map<String, Saham> getPortofolioSaham() {
        return portofolioSaham;
    }
}
