/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

public class Personne {
    protected int id;
    protected String nom;
    protected double salaire;

    public Personne(int id, String nom, double salaire) {
        this.id = id;
        this.nom = nom;
        this.salaire = salaire;
    }

    public String getNom() {
        return nom;
    }

    public double getSalaire() {
        return salaire;
    }

    public int getId() {
        return id;
    }

    
    public void afficher() {
        System.out.println("Nom: " + nom + ", Salaire: " + salaire);
    }
}