package com.polytechnique.LogiqueMetier.BD.Manipulation_Table;

import com.polytechnique.LogiqueMetier.BD.Connection_BD;
import com.polytechnique.LogiqueMetier.Utilisateur.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Table_Utilisateur {

    // fonction pour ajouter un utilisateur dans la bd
    public static boolean ajouterUtilisateur(Utilisateur u) {
        String sql = "INSERT INTO Utilisateur(nom, prenom, tel, mail, mot_de_passe) VALUES(?, ?, ?, ?, ?)";

        try (Connection conn = Connection_BD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, u.getNom());
            pstmt.setString(2, u.getPrenom());
            pstmt.setString(3, u.getTel());
            pstmt.setString(4,u.getMail());
            pstmt.setString(5, u.getMot_de_passe());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout de l'utilisateur: " + e.getMessage());
            return false;
        }
    }

    // fonction pour supprimmer un utilisateur de la bd
    public static boolean supprimerUtilisateur(String id) {
        String sql = "DELETE FROM Utilisateur WHERE id_utilisateur = ?";

        try (Connection conn = Connection_BD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de l'utilisateur: " + e.getMessage());
            return false;
        }
    }

    // fonction pour rechercher un utilisateur dans la bd
    public static Utilisateur rechercher(String id) {
        String sql = "SELECT * FROM Utilisateur WHERE id_Utilisateur = ?";
        Utilisateur utilisateur = null;

        try (Connection conn = Connection_BD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                utilisateur = new Utilisateur(
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("tel"),
                        rs.getString("mail"),
                        rs.getString("mot_de_passe")
                );
            }

            rs.close();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche de l'utilisateur: " + e.getMessage());
        }
        return utilisateur;
    }
    // surcharge de la methode rechercher
    public static Utilisateur rechercher(String mail,String password) {
        String sql = "SELECT * FROM Utilisateur WHERE mail = ? and mot_de_passe = ? ";
        Utilisateur utilisateur = null;

        try (Connection conn = Connection_BD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, mail);
            pstmt.setString(2,password);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                utilisateur = new Utilisateur(
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("tel"),
                        rs.getString("mail"),
                        rs.getString("mot_de_passe")
                );
            }

            rs.close();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche de l'utilisateur: " + e.getMessage());
        }
        return utilisateur;
    }

    // fonction pour vérifier si un utilisateur est déjà dans la bd et qui retourne son identifiant si oui
    public static String existance_bd(Utilisateur u) {
        String sql = "select id_utilisateur from Utilisateur where nom = ? and prenom = ? and tel = ? and mail = ?";
        String id = null;

        try (Connection conn = Connection_BD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, u.getNom()); // Utiliser des getters
            pstmt.setString(2, u.getPrenom());
            pstmt.setString(3, u.getTel());
            pstmt.setString(4, u.getMail());

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    id = rs.getString("id_utilisateur");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche de l'utilisateur: " + e.getMessage());
        }

        return id;
    }

}
