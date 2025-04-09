package com.polytechnique.LogiqueMetier.Utilisateur;

import com.polytechnique.LogiqueMetier.BD.Connection_BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Utilisateur {
    private String prenom;
    private String nom;
    private String tel;
    private String mail;
    private String idUtilisateur;
    private String mot_de_passe;

    // Constructeurs
    public Utilisateur() {}

    public Utilisateur(String nom, String prenom, String tel, String mail,String mot_de_passe) {
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.mail = mail;
        this.mot_de_passe=mot_de_passe;
        this.idUtilisateur="none";
    }

    // Getters et setters
    public String getNom() { return this.nom; }
    public void setNom(String nom) { this.nom = nom; }


    public String getIdUtilisateur() { return this.idUtilisateur; }
    public void setIdUtilisateur(String idUtilisateur) { this.idUtilisateur = idUtilisateur; }

    public String getPrenom() { return this.prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getTel() { return this.tel; }
    public void setTel(String tel) { this.tel = tel; }

    public String getMail() { return this.mail; }
    public void setMail( String mail) { this.mail = mail; }

    public String getMot_de_passe() { return this.mot_de_passe; }
    public void setMot_de_passe( String mot_de_passe) { this.mot_de_passe = mot_de_passe; }


    // pour l'affichage d'un appareil
    @Override
    public String toString() {
        return "Utilisateur{" +
                "id='" + this.idUtilisateur + '\'' +
                ", nom='" + this.nom + '\'' +
                ", prenom='" + this.prenom + '\'' +
                ", mail=" + this.mail +
                ", mot de passe=" + this.mot_de_passe +
                '}';
    }
}