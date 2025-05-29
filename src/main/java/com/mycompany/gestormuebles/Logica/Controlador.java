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

    public List<Materiales> traerMateriales() {
        return controlpersis.traerMateriales();
    }

    public List<CategoriaMaterial> traerCatogorias() {
        return controlpersis.traerCategoria();
    }

    public void eliminarProveedor(int id_Proveedor) {
        controlpersis.eliminarProveedor(id_Proveedor);
    }

    public Proveedor traerProveedores(int id_usuario) {
        return controlpersis.traerProveedores(id_usuario);
    }

    public void modificarProveedor(Proveedor proveedor1, String nombreEp, String contactoEp, String telefonoEp, String direccionEp, String correoEp, String estadoP) {
        proveedor1.setNombreProveedor(nombreEp);
        proveedor1.setContactoProveedor(contactoEp);
        proveedor1.setTelefonoProveedor(telefonoEp);
        proveedor1.setDireccion(direccionEp);
        proveedor1.setCorreoProveedor(correoEp);
        proveedor1.setEstado(estadoP);
        
        controlpersis.editarProveedor(proveedor1);
    }

    

    
  
}
