import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Création d'un département
        Departement departementInfo = new Departement("Informatique", null);

        // Création d'un enseignant
        Enseignant professeur = new Enseignant("Ait", "Said", "jean.dupont@example.com", "Professeur", departementInfo);

        // Création d'une filière
        Filiere filiereInfo = new Filiere("Ingénierie Informatique", professeur, departementInfo);
        Filiere filiereSitd= new Filiere( "Systeme d'Information",professeur, departementInfo);

        // Création d'un module
        Module moduleProg = new Module("Programmation", filiereInfo, professeur);

        // Création d'un étudiant
        Etudiant etudiant1 = new Etudiant("Sidi", "Ahmed", "sidi.ahmed@example.com", 123456, filiereInfo);
        // Methode pour charger les fichiers
        Filiere filiereChargee = Filiere.chargerDepuisFichier("filiereInfo.dat");
        Module moduleCharge = Module.chargerDepuisFichier("moduleProg.dat");
        Etudiant etudiantCharge = Etudiant.chargerDepuisFichier("etudiant1.dat");

        // Utilisez vos instances pour tester votre programme
        filiereInfo.sauvegarderDansFichier("filiereInfo.dat");
        moduleProg.sauvegarderDansFichier("moduleProg.dat");
        etudiant1.sauvegarderDansFichier("etudiant1.dat");


                // Exemple d'utilisation des getters
        System.out.println("Nom de l'étudiant : " + etudiant1.getNom());
        System.out.println("Nom de la filiere : " + filiereInfo.getIntitule());
        System.out.println("Nom du module : " + moduleProg.getIntitule());
        System.out.println("Nom du departement : " + departementInfo.getIntitule());
        System.out.println("Nom de l'enseignant : " + professeur.getNom());

        Scanner scanner = new Scanner(System.in);

        int choix;
        do {
            System.out.println("Menu Principal :");
            System.out.println("1. Ajouter une nouvelle filière");
            System.out.println("2. Ajouter un nouvel enseignant");
            System.out.println("3. Ajouter un nouveau module");
            System.out.println("4. Inscrire un nouvel étudiant");
            System.out.println("5. Quitter");
            System.out.print("Choix : ");

            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    ajouterNouvelleFiliere();
                    break;
                case 2:
                    ajouterNouvelEnseignant();
                    break;
                case 3:
                    ajouterNouveauModule();
                    break;
                case 4:
                    inscrireNouvelEtudiant();
                    break;
                case 5:
                    System.out.println("Programme terminé.");
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        } while (choix != 5);
    }

    private static void ajouterNouvelleFiliere() {
        // Ajouter le code pour créer une nouvelle filière
        // Créer une nouvelle filière
        System.out.println("Veuillez entrer le nom de la nouvelle filière : ");
        Scanner scanner = new Scanner(System.in);
        String nouveauNomFiliere = scanner.nextLine();

    }

    private static void ajouterNouvelEnseignant() {
        // Ajouter le code pour créer un nouvel enseignant
        System.out.println("Veuillez entrer le nom du nouveau Emseignant : ");
        Scanner scanner = new Scanner(System.in);
        String nouveauNomEnseignant = scanner.nextLine();
    }

    private static void ajouterNouveauModule() {
        // Ajouter le code pour créer un nouveau module
        System.out.println("Veuillez entrer le nom du nouveau Module : ");
        Scanner scanner = new Scanner(System.in);
        String nouveauNomModule = scanner.nextLine();
    }

    private static void inscrireNouvelEtudiant() {
        // Ajouter le code pour inscrire un nouvel étudiant
        System.out.println("Veuillez entrer le nom du nouveau Etudiant: ");
        Scanner scanner = new Scanner(System.in);
        String nouveauNomEtudiant = scanner.nextLine();
    }
}
