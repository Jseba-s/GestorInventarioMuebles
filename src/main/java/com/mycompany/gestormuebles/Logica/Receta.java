/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestormuebles.Logica;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Jseba
 */
@Entity
public class Receta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idReceta;
    private String nombreReceta;
    private String DescripcionReceta;
    @OneToMany(mappedBy = "recetaUsada")
    private List<Proyecto> recetasProyecto;

    @OneToMany(mappedBy = "recetaMaterial")
    private List<Receta_Material> listaMateriales = new ArrayList<>();

    public Receta() {
    }

    public Receta(int idReceta, String nombreReceta, String DescripcionReceta, List<Proyecto> recetasProyecto) {
        this.idReceta = idReceta;
        this.nombreReceta = nombreReceta;
        this.DescripcionReceta = DescripcionReceta;
        this.recetasProyecto = recetasProyecto;
    }

    
    

    public int getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }

    public String getNombreReceta() {
        return nombreReceta;
    }

    public void setNombreReceta(String nombreReceta) {
        this.nombreReceta = nombreReceta;
    }

    public String getDescripcionReceta() {
        return DescripcionReceta;
    }

    public void setDescripcionReceta(String DescripcionReceta) {
        this.DescripcionReceta = DescripcionReceta;
    }

    public List<Proyecto> getRecetasProyecto() {
        return recetasProyecto;
    }

    public void setRecetasProyecto(List<Proyecto> recetasProyecto) {
        this.recetasProyecto = recetasProyecto;
    }

    public List<Receta_Material> getListaMateriales() {
        return listaMateriales;
    }

    public void setListaMateriales(List<Receta_Material> listaMateriales) {
        this.listaMateriales = listaMateriales;
    }

    
}
