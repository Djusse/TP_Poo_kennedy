package com.polytechnique.LogiqueMetier.Appareil;

import com.polytechnique.LogiqueMetier.BD.Connection_BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Appareil {
    private String numeroSerie;
    private String nom;
    private String categorie;
    private String type;
    private String idUtilisateur;

    // Constructeurs
    public Appareil() {}

    public Appareil(String numeroSerie, String nom, String categorie, String type, String idUtilisateur) {
        this.numeroSerie = numeroSerie;
        this.nom = nom;
        this.categorie = categorie;
        this.type = type;
        this.idUtilisateur=idUtilisateur;
    }

    // Getters et setters
    public String getNumeroSerie() { return numeroSerie; }
    public void setNumeroSerie(String numeroSerie) { this.numeroSerie = numeroSerie; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getMarque() { return categorie; }
    public void setMarque(String marque) { this.categorie = marque; }

    public String getCategorie() { return this.categorie; }
    public void setCategorie( String categorie) { this.categorie = categorie; }

    public String getIdUtilisateur() { return this.idUtilisateur; }
    public void setIdUtilisateur( String idUtilisateur) { this.idUtilisateur = idUtilisateur; }

    public String getType() { return this.type; }
    public void setType( String type) { this.type = type; }


    // pour l'affichage d'un appareil
    @Override
    public String toString() {
        return "Appareil{" +
                "numeroSerie='" + numeroSerie + '\'' +
                ", nom='" + nom + '\'' +
                ", categorie='" + categorie + '\'' +
                ", type=" + this.type +
                '}';
    }
}