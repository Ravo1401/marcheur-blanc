package mpandeha;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Marcheur {

    private String lieuActuel;
    private List<String> chemin;

    public Marcheur(String lieuDepart) {
        this.lieuActuel = lieuDepart;
        this.chemin = new ArrayList<>();
        chemin.add(lieuDepart);
    }

    public boolean seDeplacer(String destination, String[][] carte) {
        // Trouver le prochain lieu accessible au hasard
        List<String> lieuxAccessibles = new ArrayList<>();
        for (String[] edge : carte) {
            if (edge[0].equals(lieuActuel) && !chemin.contains(edge[1])) {
                lieuxAccessibles.add(edge[1]);
            }
        }

        if (!lieuxAccessibles.isEmpty()) {
            Random random = new Random();
            String prochainLieu = lieuxAccessibles.get(random.nextInt(lieuxAccessibles.size()));
            lieuActuel = prochainLieu;
            chemin.add(prochainLieu);
            System.out.println("Se déplace de " + chemin.get(chemin.size() - 2) + " à " + chemin.get(chemin.size() - 1));
            return true;
        } else {
            System.out.println("Aucune rue accessible depuis " + lieuActuel);
            return false;
        }
    }

    public boolean estArrive(String destination) {
        return lieuActuel.equals(destination);
    }

    public List<String> getChemin() {
        return chemin;
    }

    public static void main(String[] args) {
        // Définir la carte d'Antananarivo
        String[][] carte = {
                {"Marais", "Sekolintsika"},
                {"Sekolintsika", "Marais"},
                {"Sekolintsika", "HEI"},
                {"HEI", "Sekolintsika"},
                {"HEI", "Pullman"},
                {"HEI", "Balançoire"},
                {"Pullman", "HEI"},
                {"Pullman", "Boulevard de l'Europe"},
                {"Pullman", "Nexta"},
                {"Balançoire", "HEI"},
                {"Balançoire", "Boulevard de l'Europe"},
                {"Boulevard de l'Europe", "Pullman"},
                {"Boulevard de l'Europe", "Balançoire"},
                {"Boulevard de l'Europe", "ESTI"},
                {"ESTI", "Boulevard de l'Europe"},
                {"Nexta", "Pullman"}
        };

        // Créer un marcheur qui démarre à HEI
        Marcheur bjarni = new Marcheur("HEI");

        // Faire marcher Bjarni aléatoirement jusqu'à arriver à ESTI
        while (!bjarni.estArrive("ESTI")) {
            if (!bjarni.seDeplacer("ESTI", carte)) {
                // Si aucune rue n'est accessible, on sort de la boucle
                System.out.println("Bjarni est coincé et ne peut plus se déplacer.");
                break;
            }
        }

        // Afficher le chemin parcouru par Bjarni
        System.out.println("Chemin parcouru : " + bjarni.getChemin());
    }
}
