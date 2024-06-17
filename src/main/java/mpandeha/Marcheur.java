package mpandeha;



import carte.Carte;
import carte.Lieu;
import carte.Rue;

import java.util.List;
import java.util.Random;

public class Marcheur {

    private Lieu lieuActuel;
    private Carte carte;

    public Marcheur(Lieu lieuActuel, Carte carte) {
        this.lieuActuel = lieuActuel;
        this.carte = carte;
    }

    public Lieu getLieuActuel() {
        return lieuActuel;
    }

    public void marcher() {
        List<Rue> ruesPossibles = carte.getRuesDepuis(lieuActuel);
        if (!ruesPossibles.isEmpty()) {
            Random random = new Random();
            Rue rueChoisie = ruesPossibles.get(random.nextInt(ruesPossibles.size()));
            System.out.println("Marcheur se déplace de " + lieuActuel.getNom() + " à " + rueChoisie.getDestination().getNom());
            lieuActuel = rueChoisie.getDestination();
        } else {
            System.out.println("Aucune rue possible depuis " + lieuActuel.getNom());
        }
    }

}