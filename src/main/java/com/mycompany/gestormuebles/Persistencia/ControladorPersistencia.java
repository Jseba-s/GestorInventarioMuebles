/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestormuebles.Persistencia;

import com.mycompany.gestormuebles.Logica.CategoriaMaterial;
import com.mycompany.gestormuebles.Persistencia.CategoriaMaterialJpaController;
import com.mycompany.gestormuebles.Logica.Materiales;
import com.mycompany.gestormuebles.Logica.Proveedor;
import com.mycompany.gestormuebles.Logica.Receta;
import com.mycompany.gestormuebles.Logica.Receta_Material;
import com.mycompany.gestormuebles.Persistencia.exceptions.NonexistentEntityException;
import com.mycompany.gestormuebles.Persistencia.MaterialesJpaController;
import com.mycompany.gestormuebles.Persistencia.ProveedorJpaController;
import com.mycompany.gestormuebles.Persistencia.RecetaJpaController;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jseba
 */
public class ControladorPersistencia {

    ProveedorJpaController proveedorJPA = new ProveedorJpaController();
    CategoriaMaterialJpaController categoriaJPA = new CategoriaMaterialJpaController();
    MaterialesJpaController materialesJPA = new MaterialesJpaController();
    RecetaJpaController recetaJPA = new RecetaJpaController();
    Receta_MaterialJpaController recetaMaterialJpa = new Receta_MaterialJpaController();

    public List<Proveedor> traerProveedores() {
        return proveedorJPA.findProveedorEntities();
    }

    public void guardarProveedor(Proveedor proveedorobj) {
        proveedorJPA.create(proveedorobj);
    }

    public List<CategoriaMaterial> traerCategoria() {
        return categoriaJPA.findCategoriaMaterialEntities();
    }

    public List<Materiales> traerMateriales() {
        return materialesJPA.findMaterialesEntities();
    }

    public void eliminarProveedor(int id_Proveedor) {
        try {
            proveedorJPA.destroy(id_Proveedor);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Proveedor traerProveedores(int id_usuario) {
        return proveedorJPA.findProveedor(id_usuario);
    }

    public void editarProveedor(Proveedor proveedor1) {
        try {
            proveedorJPA.edit(proveedor1);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardarMaterial(Materiales materialobj) {
        materialesJPA.create(materialobj);
    }

    public void eliminarMaterial(int id_Material) {
        try {
            materialesJPA.destroy(id_Material);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Materiales traerMateriales(int id_Materiales) {
        return materialesJPA.findMateriales(id_Materiales);
    }

    public void editarMaterial(Materiales material1) {
        try {
            materialesJPA.edit(material1);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardarReceta(Receta receta) {
        recetaJPA.create(receta);
    }

    public void guardarRecetaMaterial(Receta_Material recetaMaterial) {
        recetaMaterialJpa.create(recetaMaterial);
    }

    public List<Receta> traerRecetas() {
        return recetaJPA.findRecetasConMateriales();
    }

    public void eliminarReceta(int idReceta) {
        try {
            recetaJPA.destroy(idReceta);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Receta traerRecetas(int idReceta) {
        return recetaJPA.findReceta(idReceta);
    }

    public void eliminarRelacion(int idRecetaMaterial) {
        try {
            recetaMaterialJpa.destroy(idRecetaMaterial);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
