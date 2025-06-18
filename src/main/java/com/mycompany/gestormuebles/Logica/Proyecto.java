/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestormuebles.Logica;

import java.io.Serializable;
import java.util.Date;
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
public class Proyecto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idProyecto;
    private String nombreProyecto;
    private Date fechaInicio;
    private Date fechaterminada;
    private boolean estado;
    
    @ManyToOne
    @JoinColumn(name = "idReceta")
    private Receta recetaUsada;
    
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario_Proyecto;
    

    public Proyecto() {
    }

    public Proyecto(int idProyecto, String nombreProyecto, Date fechaInicio, Date fechaterminada, boolean estado, Receta recetaUsada, Usuario usuario_Proyecto) {
        this.idProyecto = idProyecto;
        this.nombreProyecto = nombreProyecto;
        this.fechaInicio = fechaInicio;
        this.fechaterminada = fechaterminada;
        this.estado = estado;
        this.recetaUsada = recetaUsada;
        this.usuario_Proyecto = usuario_Proyecto;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaterminada() {
        return fechaterminada;
    }

    public void setFechaterminada(Date fechaterminada) {
        this.fechaterminada = fechaterminada;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Receta getRecetaUsada() {
        return recetaUsada;
    }

    public void setRecetaUsada(Receta recetaUsada) {
        this.recetaUsada = recetaUsada;
    }

    public Usuario getusuario_Proyecto() {
        return usuario_Proyecto;
    }

    public void setusuario_Proyecto(Usuario usuario_Proyecto) {
        this.usuario_Proyecto = usuario_Proyecto;
    }
    
}
