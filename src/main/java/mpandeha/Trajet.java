package mpandeha;

import carte.Lieu;
import mpandeha.Marcheur;

import java.util.ArrayList;
import java.util.List;

public class Trajet {

    private static final int MAX_STEPS = 1000;
    private List<Lieu> lieux;
    private Marcheur marcheur;
    private Lieu destination;

    public Trajet(Marcheur marcheur, Lieu destination) {
        this.marcheur = marcheur;
        this.destination = destination;
        lieux = new ArrayList<>();
        lieux.add(marcheur.getLieuActuel());
    }

    public void marcher() {
        int steps = 0;
        while (!marcheur.getLieuActuel().getNom().equals(destination.getNom())) {
            if (steps > MAX_STEPS) {
                throw new RuntimeException("Nombre maximum de pas atteint, possible boucle infinie.");
            }
            marcheur.marcher();
            lieux.add(marcheur.getLieuActuel());
            steps++;
        }
    }

    public List<Lieu> getLieux() {
        return lieux;
    }



}