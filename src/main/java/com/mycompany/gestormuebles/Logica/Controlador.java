/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestormuebles.Logica;

import com.mycompany.gestormuebles.Persistencia.ControladorPersistencia;
import java.util.List;

/**
 *
 * @author Jseba
 */
public class Controlador {
    
    ControladorPersistencia controlpersis = new ControladorPersistencia();

    public List<Proveedor> traerProveedores() {
        return controlpersis.traerProveedores();
    }

    public void guardarProveedor(String nombreP, String contactoP, String telefonoP, String direccionP, String correoP, String estadoP) {
    Proveedor proveedorobj = new Proveedor();
    proveedorobj.setNombreProveedor(nombreP);
    proveedorobj.setContactoProveedor(contactoP);
    proveedorobj.setTelefonoProveedor(telefonoP);
    proveedorobj.setDireccion(direccionP);
    proveedorobj.setCorreoProveedor(correoP);
    proveedorobj.setEstado(estadoP);
    
    controlpersis.guardarProveedor(proveedorobj);
    }

    
  
}
