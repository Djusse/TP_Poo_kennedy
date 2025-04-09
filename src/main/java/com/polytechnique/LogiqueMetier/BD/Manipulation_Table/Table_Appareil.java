package com.polytechnique.LogiqueMetier.BD.Manipulation_Table;

import com.polytechnique.LogiqueMetier.Appareil.Appareil;
import com.polytechnique.LogiqueMetier.BD.Connection_BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Table_Appareil {
    // pour ajouter un appareil dans la base de donnée
    public static boolean ajouterAppareil(Appareil a) {
        String sql = "INSERT INTO Appareils(numero_Serie, categorie, type, nom, id_utilisateur) VALUES(?, ?, ?, ?, ?)";

        try (Connection conn = Connection_BD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, a.getNumeroSerie());
            pstmt.setString(2, a.getCategorie());
            pstmt.setString(3, a.getType());
            pstmt.setString(4,a.getNom());
            pstmt.setString(5, a.getIdUtilisateur());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout de l'appareil: " + e.getMessage());
            return false;
        }
    }

    // supprime un appareil de la base de donnée
    public static boolean supprimerAppareil(String numeroSerie) {
        String sql = "DELETE FROM Appareils WHERE numero_Serie = ?";

        try (Connection conn = Connection_BD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, numeroSerie);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de l'appareil: " + e.getMessage());
            return false;
        }
    }

    // fonction pour rechercher un appareil dans une base de donnée
    public static Appareil rechercher(String numeroSerie) {
        String sql = "SELECT * FROM Appareils WHERE numero_Serie = ?";
        Appareil appareil = null;

        try (Connection conn = Connection_BD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, numeroSerie);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                appareil = new Appareil(
                        rs.getString("numero_Serie"),
                        rs.getString("nom"),
                        rs.getString("categorie"),
                        rs.getString("type"),
                        rs.getString("id_utilisateur")
                );
            }

            rs.close();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche de l'appareil: " + e.getMessage());
        }
        return appareil;
    }
}
