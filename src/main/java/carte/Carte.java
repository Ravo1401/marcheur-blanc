package carte;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Carte {

    private Map<Lieu, List<Rue>> ruesParLieu;

    public Carte() {
        ruesParLieu = new HashMap<>();
    }

    public void ajouterRue(Rue rue) {
        if (!ruesParLieu.containsKey(rue.getOrigine())) {
            ruesParLieu.put(rue.getOrigine(), new ArrayList<>());
        }
        ruesParLieu.get(rue.getOrigine()).add(rue);
    }

    public List<Rue> getRuesDepuis(Lieu lieu) {
        return ruesParLieu.getOrDefault(lieu, new ArrayList<>());
    }

}