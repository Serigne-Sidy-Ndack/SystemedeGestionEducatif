import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;



public class Filiere implements Serializable{
    private String intitule;
    private Enseignant responsable;
    private Departement departement;
    private List<Etudiant> etudiants = new ArrayList<>();
    private List<Module> modules = new ArrayList<>();  // Ajout de la liste de modules

    public Filiere(String intitule, Enseignant responsable, Departement departement) {
        this.intitule = intitule;
        this.responsable = responsable;
        this.departement = departement;
    }
    // Méthode pour sauvegarder les données de la filière dans un fichier
    public void sauvegarderDansFichier(String nomFichier) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomFichier))) {
            oos.writeObject(this);
            System.out.println("Données de la filière sauvegardées avec succès dans le fichier.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la sauvegarde de la filière dans le fichier.");
        }
    }
    // Méthode pour charger les données de la filière à partir d'un fichier
    public static Filiere chargerDepuisFichier(String nomFichier) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomFichier))) {
            return (Filiere) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Erreur lors du chargement de la filière à partir du fichier.");
            return null;
        }
    }



    // Getter et setter pour les attributs

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Enseignant getResponsable() {
        return responsable;
    }

    public void setResponsable(Enseignant responsable) {
        this.responsable = responsable;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    // Méthode pour ajouter un module à la filière
    public void ajouterModule(Module module) {
        modules.add(module);
    }

    // Méthode pour attribuer un responsable à la filière
    public void attribuerResponsable(Enseignant enseignant) {
        this.responsable = enseignant;
    }

    // Méthode pour inscrire un étudiant à la filière
    public void inscrireEtudiant(Etudiant etudiant) {
        // Vérifier si l'étudiant n'est pas déjà inscrit
        if (!etudiants.contains(etudiant)) {
            etudiants.add(etudiant);
            etudiant.setFiliere(this);
            System.out.println("L'étudiant " + etudiant.getNom() + " a été inscrit à la filière " + this.getIntitule());
        } else {
            System.out.println("L'étudiant est déjà inscrit à cette filière.");
        }
    }
}
