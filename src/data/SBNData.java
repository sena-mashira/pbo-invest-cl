package data;

import model.SBN;

import java.util.HashMap;
import java.util.Map;

public class SBNData {
    private static final Map<String, SBN> daftarSBN = new HashMap<>();
    private static final Map<String, SBN> portofolioSBN = new HashMap<>();

    public static Map<String, SBN> getSBN() {
        return daftarSBN;
    }

    public static Map<String, SBN> getPortofolioSBN() {
        return portofolioSBN;
    }
}
