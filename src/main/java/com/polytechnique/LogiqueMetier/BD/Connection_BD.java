package com.polytechnique.LogiqueMetier.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection_BD {
    private static final String URL = "jdbc:mysql://localhost:3306/BD_Appareils";
    private static final String USER = "delta";
    private static final String PASSWORD = "root";

    private static Connection connection;

    // Constructeur privé pour empêcher l'instanciation
    private Connection_BD() {}

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Connexion à la BD établie avec succès");
            } catch (ClassNotFoundException e) {
                throw new SQLException("Driver JDBC non trouvé", e);
            }
        }
        return connection;
    }

    // pour fermer la connection a la BD
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connexion à la BD fermée");
            } catch (SQLException e) {
                System.err.println("Erreur lors de la fermeture de la connexion: " + e.getMessage());
            }
        }
    }
}