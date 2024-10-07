/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import ma.projet.beans.Developpeur;
import ma.projet.dao.IDao;
import ma.projet.connexion.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DeveloppeurService implements IDao<Developpeur> {
    private Connection connection = Connexion.getConnection();

    @Override
    public boolean create(Developpeur dev) {
        try {
            String query = "INSERT INTO developpeur (id, nom, salaire) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, dev.getId());
            ps.setString(2, dev.getNom());
            ps.setDouble(3, dev.getSalaire());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error1: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Developpeur dev) {
        // Méthode de mise à jour
        return false;
    }

    @Override
    public boolean delete(Developpeur dev) {
        // Méthode de suppression
        return false;
    }

    @Override
    public Developpeur getById(int id) {
        try {
            String query = "SELECT * FROM developpeur WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Developpeur(rs.getInt("id"), rs.getString("nom"), rs.getDouble("salaire"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Developpeur> getAll() {
        List<Developpeur> devs = new ArrayList<>();
        try {
            String query = "SELECT * FROM developpeur";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                devs.add(new Developpeur(rs.getInt("id"), rs.getString("nom"), rs.getDouble("salaire")));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return devs;
    }
}

