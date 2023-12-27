import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;



public class Module implements Serializable {
    private String intitule;
    private Filiere filiere;
    private Enseignant professeur;
    private List<Etudiant> etudiantsInscrits = new ArrayList<>();

    public Module(String intitule, Filiere filiere, Enseignant professeur) {
        this.intitule = intitule;
        this.filiere = filiere;
        this.professeur = professeur;
    }
    // Méthode pour sauvegarder les données du module dans un fichier
    public void sauvegarderDansFichier(String nomFichier) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomFichier))) {
            oos.writeObject(this);
            System.out.println("Données du module sauvegardées avec succès dans le fichier.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la sauvegarde du module dans le fichier.");
        }
    }
    // Méthode pour charger les données du module à partir d'un fichier
    public static Module chargerDepuisFichier(String nomFichier) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomFichier))) {
            return (Module) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Erreur lors du chargement du module à partir du fichier.");
            return null;
        }
    }

    // Getter pour l'attribut intitule
    public String getIntitule() {
        return intitule;
    }

    // Méthode pour attribuer un module à un étudiant
    public void attribuerModule(Etudiant etudiant) {
        // Vérifier si l'étudiant n'est pas déjà inscrit au module
        if (!etudiantsInscrits.contains(etudiant)) {
            etudiantsInscrits.add(etudiant);
        } else {
            System.out.println("L'étudiant est déjà inscrit à ce module.");
        }
    }
    // Méthode pour obtenir la liste des étudiants inscrits à ce module
    public List<Etudiant> getEtudiantsInscrits() {
        return etudiantsInscrits;
    }

    // Méthode pour obtenir la note finale d'un étudiant pour ce module
    public void obtenirNoteFinale(Etudiant etudiant, double note) {
        // Vérifier si l'étudiant est inscrit au module
        if (etudiantsInscrits.contains(etudiant)) {
            System.out.println("Note finale de l'étudiant " + etudiant.getNom() + " pour le module " + getIntitule() + " : " + note);
        } else {
            System.out.println("L'étudiant n'est pas inscrit à ce module.");
        }
    }
}
