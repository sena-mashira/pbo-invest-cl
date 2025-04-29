package data;

import model.SBN;

import java.util.HashMap;
import java.util.Map;

// Store all data about SBN
public class SBNData {
//    Store SBN that admin input
    private static final Map<String, SBN> daftarSBN = new HashMap<>();
//    Store SBN that customer brought
    private static final Map<String, SBN> portofolioSBN = new HashMap<>();

//    Getter for daftarSBN
    public static Map<String, SBN> getSBN() {
        return daftarSBN;
    }

//    Getter for portofolioSBN
    public static Map<String, SBN> getPortofolioSBN() {
        return portofolioSBN;
    }
}
