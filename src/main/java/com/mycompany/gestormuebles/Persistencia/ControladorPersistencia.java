/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestormuebles.Persistencia;

import com.mycompany.gestormuebles.Logica.Proveedor;
import java.util.List;

/**
 *
 * @author Jseba
 */
public class ControladorPersistencia {
    ProveedorJpaController proveedorJPA = new ProveedorJpaController();

    public List<Proveedor> traerProveedores() {
        return proveedorJPA.findProveedorEntities();
    }

    public void guardarProveedor(Proveedor proveedorobj) {
        proveedorJPA.create(proveedorobj);
    }
    
}
