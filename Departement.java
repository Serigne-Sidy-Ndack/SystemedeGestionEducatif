import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

 public class Departement implements Serializable {
    private String intitule;
    private Enseignant responsable;
    private List<Filiere> filieres = new ArrayList<>();  // Ajout de la liste de filières

    public Departement(String intitule, Enseignant responsable) {
        this.intitule = intitule;
        this.responsable = responsable;
    }

    // Méthode pour ajouter une filière au département
    public void ajouterFiliere(Filiere filiere) {
        filieres.add(filiere);
    }

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
}
