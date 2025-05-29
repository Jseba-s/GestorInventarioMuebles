/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestormuebles.Logica;

import java.io.Serializable;
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
public class CategoriaMaterial implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idcategoriaMaterial;
    private String nombreCategoria;
    private String descripcionCategoria;
    
    @OneToMany(mappedBy = "categoriaMaterial")
    private List<Materiales> materialescategoria;

    public CategoriaMaterial() {
    }

    public CategoriaMaterial(int idcategoriaMaterial, String nombreCategoria, String descripcionCategoria, List<Materiales> materialescategoria) {
        this.idcategoriaMaterial = idcategoriaMaterial;
        this.nombreCategoria = nombreCategoria;
        this.descripcionCategoria = descripcionCategoria;
        this.materialescategoria = materialescategoria;
    }

   

    public int getIdcategoriaMaterial() {
        return idcategoriaMaterial;
    }

    public void setIdcategoriaMaterial(int idcategoriaMaterial) {
        this.idcategoriaMaterial = idcategoriaMaterial;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }

    public List<Materiales> getMaterialescategoria() {
        return materialescategoria;
    }

    public void setMaterialescategoria(List<Materiales> materialescategoria) {
        this.materialescategoria = materialescategoria;
    }
    
    
}
