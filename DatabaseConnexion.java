import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnexion {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mon_projet"; // Assurez-vous de remplacer 'mon_projet' par le nom de votre base de données
    private static final String USER = "root"; // Utilisateur par défaut de MySQL
    private static final String PASSWORD = ""; // Mot de passe par défaut de MySQL, changez-le si vous l'avez modifié

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connexion réussie à la base de données !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
        }
        return connection;
    }

    // Vous pouvez ajouter d'autres méthodes utiles ici, comme fermer la connexion, etc.
}
