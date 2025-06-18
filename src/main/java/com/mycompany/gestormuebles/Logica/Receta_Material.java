/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestormuebles.Logica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Jseba
 */

@Entity
public class Receta_Material {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idRecetaMaterial;
    
    @ManyToOne
    @JoinColumn(name = "idReceta")
    private Receta recetaMaterial;
    
    @ManyToOne
    @JoinColumn(name = "idMaterial")
    private Materiales materialReceta;
    private double cantidad;

    public Receta_Material(int idRecetaMaterial, Receta recetaMaterial, Materiales materialReceta, double cantidad) {
        this.idRecetaMaterial = idRecetaMaterial;
        this.recetaMaterial = recetaMaterial;
        this.materialReceta = materialReceta;
        this.cantidad = cantidad;
    }

    public Receta_Material() {
    }

    public int getIdRecetaMaterial() {
        return idRecetaMaterial;
    }

    public void setIdRecetaMaterial(int idRecetaMaterial) {
        this.idRecetaMaterial = idRecetaMaterial;
    }

    public Receta getRecetaMaterial() {
        return recetaMaterial;
    }

    public void setRecetaMaterial(Receta recetaMaterial) {
        this.recetaMaterial = recetaMaterial;
    }

    public Materiales getMaterialReceta() {
        return materialReceta;
    }

    public void setMaterialReceta(Materiales materialReceta) {
        this.materialReceta = materialReceta;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    
    
}
