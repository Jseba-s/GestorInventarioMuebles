/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestormuebles.Logica;

/**
 *
 * @author Jseba
 */
public class Materiales {
    private int idMaterial;
    private String nombreMaterial;
    private String tipoMaterial;
    private int cantidadMaterial;
    
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
