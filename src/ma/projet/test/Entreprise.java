/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import ma.projet.beans.Developpeur;
import ma.projet.beans.Manager;
import ma.projet.service.DeveloppeurService;
import ma.projet.service.ManagerService;

public class Entreprise {

    public static void main(String[] args) {
        DeveloppeurService devService = new DeveloppeurService();
        ManagerService managerService = new ManagerService();

        
        Developpeur dev1 = new Developpeur(1, "Dev1", 3000);
        Developpeur dev2 = new Developpeur(2, "Dev2", 3200);
        devService.create(dev1);
        devService.create(dev2);

        
        
        Manager manager = new Manager(3, "Manager", 5000);
        managerService.create(manager);

        
        Developpeur dev3 = new Developpeur(4, "Dev3", 3400);
        devService.create(dev3);


        
        Manager directeurGeneral = new Manager(5, "Directeur Général", 7000);
        managerService.create(directeurGeneral); 
               
        // Afficher les employés
        System.out.println("Liste des employés :");
        System.out.println(directeurGeneral.getNom() + " - " + directeurGeneral.getSalaire());
        System.out.println(manager.getNom() + " - " + manager.getSalaire());
        for (Developpeur dev : devService.getAll()) {
            System.out.println(dev.getNom() + " - " + dev.getSalaire());
        }
    }
}
