package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Joueur {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nom;
    private String prenom;
    private String poste;
    private boolean actif;

    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;

    public Joueur() {  
    }

    public Joueur(String nom, String prenom, String poste, boolean actif) {
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
        this.actif = actif;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    @Override
    public String toString() {
        return "Joueur [" + 
                "id=" + id + ", " +
                "nom='" + nom + '\'' + ", " +
                "prenom='" + prenom + '\'' + ", " +
                "poste='" + poste + '\'' + ", " +
                "actif=" + actif +
                ']';
    }
}