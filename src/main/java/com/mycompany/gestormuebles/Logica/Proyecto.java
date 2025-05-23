/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestormuebles.Logica;

import java.util.Date;

/**
 *
 * @author Jseba
 */
public class Proyecto {
    private int idProyecto;
    private String nombreProyecto;
    private Date fechaInicio;
    private Date fechaterminada;
    private boolean estado;
    private Receta recetaUsada;
    private Usuario usuarioProyecto;

    public Proyecto() {
    }

    public Proyecto(int idProyecto, String nombreProyecto, Date fechaInicio, Date fechaterminada, boolean estado, Receta recetaUsada, Usuario usuarioProyecto) {
        this.idProyecto = idProyecto;
        this.nombreProyecto = nombreProyecto;
        this.fechaInicio = fechaInicio;
        this.fechaterminada = fechaterminada;
        this.estado = estado;
        this.recetaUsada = recetaUsada;
        this.usuarioProyecto = usuarioProyecto;
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

    public Usuario getUsuarioProyecto() {
        return usuarioProyecto;
    }

    public void setUsuarioProyecto(Usuario usuarioProyecto) {
        this.usuarioProyecto = usuarioProyecto;
    }
    
}
