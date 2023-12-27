import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Etudiant implements Serializable {
    private String nom;
    private String prenom;
    private String email;
    private int apogee;
    private Filiere filiere;
    private List<Module> modulesInscrits = new ArrayList<>();

    // Constructeur
    public Etudiant(String nom, String prenom, String email, int apogee, Filiere filiere) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.apogee = apogee;
        this.filiere = filiere;
    }
    // Méthode pour sauvegarder les données de l'étudiant dans un fichier
    public void sauvegarderDansFichier(String nomFichier) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomFichier))) {
            oos.writeObject(this);
            System.out.println("Données de l'étudiant sauvegardées avec succès dans le fichier.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la sauvegarde de l'étudiant dans le fichier.");
        }
    }
    // Méthode pour charger les données de l'étudiant à partir d'un fichier
    public static Etudiant chargerDepuisFichier(String nomFichier) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomFichier))) {
            return (Etudiant) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Erreur lors du chargement de l'étudiant à partir du fichier.");
            return null;
        }


    }


    // Getter et setter pour l'attribut filiere
    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public String getNom() {
        return nom;
    }

    // Méthode pour obtenir la note finale d'un étudiant pour un module
    public void obtenirNoteFinale(Module module, double note) {
        // Vérifier si l'étudiant est inscrit au module
        if (modulesInscrits.contains(module)) {
            System.out.println("Note finale de l'étudiant " + this.getNom() + " pour le module " + module.getIntitule() + " : " + note);
        } else {
            System.out.println("L'étudiant n'est pas inscrit à ce module.");
        }
    }
}
