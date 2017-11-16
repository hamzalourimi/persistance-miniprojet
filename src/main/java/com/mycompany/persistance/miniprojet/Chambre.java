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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Application class.
 *
 * @author Ibne Yaala Wafa (wafaibneyaala@gmail.com)
 */
@Entity
@Table(name = "produit")
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "numero", length = 255, nullable = true)
    private int numero;

    @Column(name = "prixParJour", length = 255, nullable = true)
    private Double prixParJour;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "chambre_sejour",
            joinColumns = {
                @JoinColumn(name = "chambre_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "sejour_id")})
    private List<Sejour> sejour = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "chambre_option",
            joinColumns = {
                @JoinColumn(name = "chambre_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "option_id")})
    private List<Option> option = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Double getPrixParJour() {
        return prixParJour;
    }

    public void setPrixParJour(Double prixParJour) {
        this.prixParJour = prixParJour;
    }

    public List<Sejour> getSejour() {
        return sejour;
    }

    public void setSejour(List<Sejour> sejour) {
        this.sejour = sejour;
    }

    public List<Option> getOption() {
        return option;
    }

    public void setOption(List<Option> option) {
        this.option = option;
    }

  
}
