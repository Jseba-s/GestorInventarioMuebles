/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestormuebles.Logica;

import java.util.List;

/**
 *
 * @author Jseba
 */
public class Receta {
    private int idReceta;
    private String nombreReceta;
    private String DescripcionReceta;
    private List <Materiales> listaMateriales;

    public Receta() {
    }

    public Receta(int idReceta, String nombreReceta, String DescripcionReceta, List<Materiales> listaMateriales) {
        this.idReceta = idReceta;
        this.nombreReceta = nombreReceta;
        this.DescripcionReceta = DescripcionReceta;
        this.listaMateriales = listaMateriales;
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

    public List<Materiales> getListaMateriales() {
        return listaMateriales;
    }

    public void setListaMateriales(List<Materiales> listaMateriales) {
        this.listaMateriales = listaMateriales;
    }
    
    
}
