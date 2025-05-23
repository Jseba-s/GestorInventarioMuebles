package com.mycompany.gestormuebles.Persistencia;

import com.mycompany.gestormuebles.Logica.Proveedor;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ProveedorJpaController implements Serializable {

    private EntityManagerFactory emf;

    // Constructor que recibe el EntityManagerFactory desde fuera
    public ProveedorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    // Método para obtener el EntityManager
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    
    public ProveedorJpaController(){
        emf = Persistence.createEntityManagerFactory("GestorMueblesPU");
    }
    // Crear un nuevo proveedor
    public void create(Proveedor proveedor) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(proveedor);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // Editar un proveedor existente
    public void edit(Proveedor proveedor) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            proveedor = em.merge(proveedor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception("Error al editar proveedor: " + ex.getMessage(), ex);
        } finally {
            em.close();
        }
    }

    // Eliminar un proveedor por ID
    public void destroy(int id) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Proveedor proveedor;
            try {
                proveedor = em.getReference(Proveedor.class, id);
                proveedor.getIdProveedor(); // fuerza la carga
            } catch (EntityNotFoundException enfe) {
                throw new Exception("El proveedor con id " + id + " no existe.", enfe);
            }
            em.remove(proveedor);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // Obtener todos los proveedores
    public List<Proveedor> findProveedorEntities() {
        return findProveedorEntities(true, -1, -1);
    }

    // Obtener proveedores con paginación
    public List<Proveedor> findProveedorEntities(int maxResults, int firstResult) {
        return findProveedorEntities(false, maxResults, firstResult);
    }

    private List<Proveedor> findProveedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT p FROM Proveedor p");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    // Buscar un proveedor por ID
    public Proveedor findProveedor(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Proveedor.class, id);
        } finally {
            em.close();
        }
    }

    // Contar proveedores
    public int getProveedorCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT COUNT(p) FROM Proveedor p");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
