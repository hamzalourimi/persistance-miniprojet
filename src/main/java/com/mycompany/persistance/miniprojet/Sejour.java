/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.persistance.miniprojet;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Application class.
 *
 * @author Ibne Yaala Wafa (wafaibneyaala@gmail.com)
 */
@Entity
@Table(name = "sejour")
public class Sejour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "date_debut", length = 255, nullable = true)
    private Date date_debut;
    @Column(name = "date_fin", length = 255, nullable = true)
    private Date date_fin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

   
    
    
}
