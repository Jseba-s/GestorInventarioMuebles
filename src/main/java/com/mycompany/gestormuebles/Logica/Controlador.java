/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestormuebles.Logica;

import com.mycompany.gestormuebles.Persistencia.ControladorPersistencia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jseba
 */
public class Controlador {

    ControladorPersistencia controlpersis = new ControladorPersistencia();

    Proveedor proveedorobj = new Proveedor();
    CategoriaMaterial categoriaobj = new CategoriaMaterial();

    public List<Proveedor> traerProveedores() {
        return controlpersis.traerProveedores();
    }

    public void guardarProveedor(String nombreP, String contactoP, String telefonoP, String direccionP, String correoP, String estadoP) {
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

    public void guardarMaterial(String Nombrematerial, String proveedor, String categoria, int cantidadf) {
        Materiales materialobj = new Materiales();
        materialobj.setNombreMaterial(Nombrematerial);
        materialobj.setCantidadMaterial(cantidadf);
        proveedorobj = this.traerProveedores(proveedor);
        if (proveedorobj != null) {
            materialobj.setMaterialProveedor(proveedorobj);
        }
        categoriaobj = this.traerCatogorias(categoria);
        if (categoriaobj != null) {
            materialobj.setCategoriaMaterial(categoriaobj);
        }
        controlpersis.guardarMaterial(materialobj);
    }

    private Proveedor traerProveedores(String proveedor) {
        List<Proveedor> listaProveedores = controlpersis.traerProveedores();
        for (Proveedor proveedores : listaProveedores) {
            if (proveedores.getNombreProveedor().equals(proveedor)) {
                return proveedores;
            }
        }
        return null;

    }

    private CategoriaMaterial traerCatogorias(String categoria) {
        List<CategoriaMaterial> listaCategorias = controlpersis.traerCategoria();
        for (CategoriaMaterial categorias : listaCategorias) {
            if (categorias.getNombreCategoria().equals(categoria)) {
                return categorias;
            }
        }
        return null;
    }

    public void eliminarMaterial(int id_Material) {
        controlpersis.eliminarMaterial(id_Material);
    }

    public Materiales traerMaterial(int id_Materiales) {
        return controlpersis.traerMateriales(id_Materiales);
    }

    public void ModificarMaterial(Materiales material1, String nombreM, String proveedorM, int cantidadMf, String categoriaM) {
        material1.setNombreMaterial(nombreM);
        material1.setCantidadMaterial(cantidadMf);
        proveedorobj = this.traerProveedores(proveedorM);
        if (proveedorobj != null) {
            material1.setMaterialProveedor(proveedorobj);
        }
        
        categoriaobj = this.traerCatogorias(categoriaM);
        if (categoriaobj != null) {
            material1.setCategoriaMaterial(categoriaobj);
        }
        
       controlpersis.editarMaterial(material1);
    }

    public void guardarReceta(Receta receta) {
        controlpersis.guardarReceta(receta);
    }

    public void guardarRecetaMaterial(Receta_Material recetaMaterial) {
        controlpersis.guardarRecetaMaterial(recetaMaterial);
    }

    public List<Receta> traerRecetas() {
        return controlpersis.traerRecetas();
    }

    public void eliminarReceta(int idReceta) {
        Receta receta = controlpersis.traerRecetas(idReceta);
        if (receta != null) {
            List<Receta_Material> relaciones = receta.getListaMateriales();
            for (Receta_Material rm : new ArrayList<>(relaciones)){
                controlpersis.eliminarRelacion(rm.getIdRecetaMaterial());
            }
            controlpersis.eliminarReceta(idReceta);
        }
    }

    
    public Receta traerReceta(int idReceta){
        return controlpersis.traerRecetas(idReceta);
    }
   

    

    

}
