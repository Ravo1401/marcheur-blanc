package mpandeha;

import carte.Carte;
import carte.Lieu;
import carte.Rue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MarcheurTest {
    private Lieu marais, balançoire, hei, sekolintsika, pullman, esti, boulevard, nexta;
    private Carte carte;
    private Marcheur marcheur;

    @BeforeEach
    public void setUp() {
        // Création des lieux
        marais = new Lieu("Marais");
        balançoire = new Lieu("Balançoire");
        hei = new Lieu("HEI");
        sekolintsika = new Lieu("Sekolintsika");
        pullman = new Lieu("Pullman");
        esti = new Lieu("ESTI");
        boulevard = new Lieu("Boulevard de l'Europe");
        nexta = new Lieu("Nexta");

        // Création de la carte
        carte = new Carte();
        carte.ajouterRue(new Rue(marais, sekolintsika));
        carte.ajouterRue(new Rue(sekolintsika, hei));
        carte.ajouterRue(new Rue(hei, pullman));
        carte.ajouterRue(new Rue(pullman, balançoire));
        carte.ajouterRue(new Rue(balançoire, boulevard));
        carte.ajouterRue(new Rue(boulevard, esti));
        carte.ajouterRue(new Rue(pullman, nexta));

        // Création du marcheur
        marcheur = new Marcheur(hei, carte);
    }

    @Test
    public void testLieuxCreation() {
        assertNotNull(marais);
        assertEquals("Marais", marais.getNom());
    }

    @Test
    public void testCarteCreation() {
        List<Rue> ruesDepuisHEI = carte.getRuesDepuis(hei);
        assertNotNull(ruesDepuisHEI);
        assertEquals(1, ruesDepuisHEI.size());
        assertEquals("Pullman", ruesDepuisHEI.get(0).getDestination().getNom());
    }

    @Test
    public void testMarcheurInitialPosition() {
        assertEquals("HEI", marcheur.getLieuActuel().getNom());
    }

    @Test
    public void testTrajet() {
        Trajet trajet = new Trajet(marcheur, esti);
        trajet.marcher();
        List<Lieu> lieuxVisites = trajet.getLieux();
        assertNotNull(lieuxVisites);
        assertTrue(lieuxVisites.size() > 1);
        assertEquals("HEI", lieuxVisites.get(0).getNom());
        assertEquals("ESTI", lieuxVisites.get(lieuxVisites.size() - 1).getNom());
    }
}