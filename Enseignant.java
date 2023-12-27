import java.io.Serializable;
public class Enseignant implements Serializable  {
    private String nom;
    private String prenom;
    private String email;
    private String grade;
    private Departement departement;

    public Enseignant(String nom, String prenom, String email, String grade, Departement departement) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.grade = grade;
        this.departement = departement;
    }
    public String getNom() {
        return nom;
    }

    // Getter et setter pour les attributs

    // Méthode pour assigner un enseignant à un département
    public void assignerDepartement(Departement departement) {
        this.departement = departement;
        System.out.println("L'enseignant " + this.getNom() + " a été assigné au département " + departement.getIntitule());
    }
}
