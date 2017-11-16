/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.persistance.miniprojet;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Application class.
 *
 * @author Ibne Yaala Wafa (wafaibneyaala@gmail.com)
 */
public class Application {

    /**
     * Attribute declaration for factory to share between methods.
     */
    private static SessionFactory factory;

    public static void main(String[] args) {
        System.out.println("JavaSE + Maven + Hibernate + MySQL : Many to One Association");

        // Open connection  pool
        factory = HibernateUtil.getSessionFactory();

        Session session = factory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            ///One To Many:
            ///// 1)Entre la table famille et produit

            // new produit
            Chambre Chambre_x = new Chambre();
            Chambre_x.setNumero(12);
            Chambre_x.setPrixParJour(120.1);

            session.save(Chambre_x);

            // new produit
            Chambre Chambre_y = new Chambre();
            Chambre_y.setNumero(122);
            Chambre_y.setPrixParJour(142.1);

            session.save(Chambre_y);

            // new produit
            Chambre Chambre_z = new Chambre();
            Chambre_z.setNumero(22);
            Chambre_z.setPrixParJour(142.1);

            session.save(Chambre_z);

            // new famille
            Categorie Categorie_a = new Categorie();
            Categorie_a.setLibelle("categorie a");

            Categorie_a.getChambres().add(Chambre_x);
            Categorie_a.getChambres().add(Chambre_y);
            session.save(Categorie_a);

            // new famille
            Categorie Categorie_b = new Categorie();
            Categorie_b.setLibelle("categorie b");

            Categorie_b.getChambres().add(Chambre_x);
            Categorie_b.getChambres().add(Chambre_y);
            session.save(Categorie_b);

            ///// 2)Entre la table client et commande
            // new commande
            Sejour Sejour_1 = new Sejour();
            Date date_1 = new Date();
            Date date_2 = new Date();
            Sejour_1.setDate_debut(date_1);
            Sejour_1.setDate_fin(date_2);
            session.save(Sejour_1);

            // new commande
            Sejour Sejour_2 = new Sejour();
            Sejour_2.setDate_debut(date_1);
            Sejour_2.setDate_fin(date_2);
            session.save(Sejour_2);
            // new commande
            Sejour Sejour_3 = new Sejour();
            Sejour_3.setDate_debut(date_1);
            Sejour_3.setDate_fin(date_2);
            session.save(Sejour_3);

            // new client 
            Client client_a = new Client();
            client_a.setNom("ala eddine ");
            client_a.setAdresse("djerba");
            client_a.getSejour().add(Sejour_1);
            session.save(client_a);

            // new client 
            Client client_b = new Client();
            client_b.setNom("wafa ");
            client_b.setAdresse("djerba");
            client_b.getSejour().add(Sejour_2);
            client_b.getSejour().add(Sejour_3);
            session.save(client_b);

            ///Many To Many:
            ///// 1)Entre la table produit et etiquette
            // new etiquette
            Option Option_a = new Option();
            Option_a.setNom("Option a");

            session.save(Option_a);

            // new etiquette
            Option Option_b = new Option();
            Option_b.setNom("Option b");

            session.save(Option_b);

            // new produit
            Chambre Chambre_a = new Chambre();
            Chambre_a.setNumero(12);
            Chambre_a.setPrixParJour(120.1);
            Chambre_a.getOption().add(Option_b);

            session.save(Chambre_a);

            // new produit
            Chambre Chambre_b = new Chambre();
            Chambre_b.setNumero(122);
            Chambre_b.setPrixParJour(142.1);
            Chambre_a.getOption().add(Option_a);
            session.save(Chambre_b);

            // new produit
            Chambre Chambre_c = new Chambre();
            Chambre_c.setNumero(22);
            Chambre_c.setPrixParJour(142.1);
            Chambre_a.getOption().add(Option_a);
            session.save(Chambre_c);
            ///// 1)Entre la table produit et etiquette
            // new commande
            Sejour Sejour_a = new Sejour();
            Date date_3 = new Date();
            Date date_4 = new Date();
            Sejour_a.setDate_debut(date_3);
            Sejour_a.setDate_fin(date_4);
            session.save(Sejour_a);

            Sejour Sejour_b = new Sejour();
            Sejour_b.setDate_debut(date_3);
            Sejour_b.setDate_fin(date_4);
            session.save(Sejour_b);
            // new produit
            Chambre Chambre_f = new Chambre();
            Chambre_f.setNumero(12);
            Chambre_f.setPrixParJour(120.1);
            Chambre_f.getSejour().add(Sejour_b);

            session.save(Chambre_f);

            // new produit
            Chambre Chambre_h = new Chambre();
            Chambre_h.setNumero(122);
            Chambre_h.setPrixParJour(142.1);
            Chambre_h.getSejour().add(Sejour_a);
            session.save(Chambre_h);

            // new produit
            Chambre Chambre_d = new Chambre();
            Chambre_d.setPrixParJour(142.1);
            Chambre_h.getSejour().add(Sejour_b);
            session.save(Chambre_d);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            //e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            session.close();
        }

        // Cleaning up connection pool
        factory.close();
    }
}
