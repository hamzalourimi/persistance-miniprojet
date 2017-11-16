/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.persistance.miniprojet;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Application class.
 *
 * @author Ibne Yaala Wafa (wafaibneyaala@gmail.com)
 */
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    
     @Column(name = "telephone", nullable = false)
    private int telephone;

    @Column(name = "nom", length = 255, nullable = true)
    private String nom;

    @Column(name = "adresse",length = 255, nullable = true)
    private String adresse;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Sejour> sejour = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<Sejour> getSejour() {
        return sejour;
    }

    public void setSejour(List<Sejour> sejour) {
        this.sejour = sejour;
    }
    
  

  
}
