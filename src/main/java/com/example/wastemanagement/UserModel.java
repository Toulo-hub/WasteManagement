package com.example.wastemanagement;

public class UserModel {
    String nom;
    String prenom;
    String lieu;
    String heure;

    public UserModel(){

    }

    //les geters
    public String getNom(){
        return nom;
    }
    public String getPrenom(){
        return prenom;
    }
    public String getLieu(){
        return lieu;
    }
    public String getHeure(){
        return heure;
    }

    // les seters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }
}
