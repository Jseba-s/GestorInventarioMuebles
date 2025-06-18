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
public class Proveedor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idProveedor;
    private String nombreProveedor;
    private String contactoProveedor;
    private String telefonoProveedor;
    private String correoProveedor;
    private String direccion;
    private String estado;
    
    @OneToMany(mappedBy = "materialProveedor")
    private List<Materiales> materialesProveedor; 
    
    
    public Proveedor() {
    }

    public Proveedor(int idProveedor, String nombreProveedor, String contactoProveedor, String telefonoProveedor, String correoProveedor, String direccion, String estado, List<Materiales> materialesProveedor) {
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
        this.contactoProveedor = contactoProveedor;
        this.telefonoProveedor = telefonoProveedor;
        this.correoProveedor = correoProveedor;
        this.direccion = direccion;
        this.estado = estado;
        this.materialesProveedor = materialesProveedor;
    }

    

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getContactoProveedor() {
        return contactoProveedor;
    }

    public void setContactoProveedor(String contactoProveedor) {
        this.contactoProveedor = contactoProveedor;
    }

    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    public String getCorreoProveedor() {
        return correoProveedor;
    }

    public void setCorreoProveedor(String correoProveedor) {
        this.correoProveedor = correoProveedor;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Materiales> getMaterialesProveedor() {
        return materialesProveedor;
    }

    public void setMaterialesProveedor(List<Materiales> materialesProveedor) {
        this.materialesProveedor = materialesProveedor;
    }
    
    
    
}
