/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import ma.projet.beans.Manager;
import ma.projet.dao.IDao;
import ma.projet.connexion.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ManagerService implements IDao<Manager> {
    private Connection connection = Connexion.getConnection();

    @Override
    public boolean create(Manager manager) {
        try {
            String query = "INSERT INTO manager (id, nom, salaire) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, manager.getId());
            ps.setString(2, manager.getNom());
            ps.setDouble(3, manager.getSalaire());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error1: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Manager manager) {
        try {
            String query = "UPDATE manager SET nom = ?, salaire = ? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, manager.getNom());
            ps.setDouble(2, manager.getSalaire());
            ps.setInt(3, manager.getId());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Manager manager) {
        try {
            String query = "DELETE FROM manager WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, manager.getId());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Manager getById(int id) {
        try {
            String query = "SELECT * FROM manager WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Manager(rs.getInt("id"), rs.getString("nom"), rs.getDouble("salaire"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Manager> getAll() {
        List<Manager> managers = new ArrayList<>();
        try {
            String query = "SELECT * FROM manager";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                managers.add(new Manager(rs.getInt("id"), rs.getString("nom"), rs.getDouble("salaire")));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return managers;
    }
}

