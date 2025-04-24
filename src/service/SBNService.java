package service;

import model.SBN;
import model.Saham;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SBNService {
    private final Map<String, SBN> daftarSBN = new HashMap<>();

    public SBNService() {
        tambahSBN(new SBN("SBN001", "SBN Ritel 2025", 6.5, LocalDate.of(2025, 8, 20), 1000));
    }

    public boolean tambahSBN(SBN sbn) {
        if (daftarSBN.get(sbn.getKode()) != null) {
            return false;
        }

        daftarSBN.put(sbn.getKode(), sbn);
        return true;
    }

    public Collection<SBN> getSemuaSBN() {
        return daftarSBN.values();
    }
}
