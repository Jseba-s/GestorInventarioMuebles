/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestormuebles.Logica;

import java.io.Serializable;
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
public class Materiales implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idMaterial;
    private String nombreMaterial;
    private String tipoMaterial;
    private int cantidadMaterial;
    
    @ManyToOne
    @JoinColumn(name = "id_Proveedor")
    private Proveedor materialProveedor;
    
    public Materiales() {
    }

    public Materiales(int idMaterial, String nombreMaterial, String tipoMaterial, int cantidadMaterial, Proveedor materialProveedor) {
        this.idMaterial = idMaterial;
        this.nombreMaterial = nombreMaterial;
        this.tipoMaterial = tipoMaterial;
        this.cantidadMaterial = cantidadMaterial;
        this.materialProveedor = materialProveedor;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public int getCantidadMaterial() {
        return cantidadMaterial;
    }

    public void setCantidadMaterial(int cantidadMaterial) {
        this.cantidadMaterial = cantidadMaterial;
    }

    public Proveedor getMaterialProveedor() {
        return materialProveedor;
    }

    public void setMaterialProveedor(Proveedor materialProveedor) {
        this.materialProveedor = materialProveedor;
    }
    
    
    
}
