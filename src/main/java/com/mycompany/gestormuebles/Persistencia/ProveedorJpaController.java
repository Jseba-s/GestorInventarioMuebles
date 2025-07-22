package com.mycompany.gestormuebles.Persistencia;

import com.mycompany.gestormuebles.Logica.Proveedor;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProveedorJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public ProveedorJpaController(){
        emf = Persistence.createEntityManagerFactory("GestorMueblesPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

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

    public void edit(Proveedor proveedor) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(proveedor);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void destroy(int id) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Proveedor proveedor = em.find(Proveedor.class, id);
            if (proveedor == null) {
                throw new Exception("El proveedor con id " + id + " no existe.");
            }
            em.remove(proveedor);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Proveedor findProveedor(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Proveedor.class, id);
        } finally {
            em.close();
        }
    }

    public List<Proveedor> findProveedorEntities() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT p FROM Proveedor p", Proveedor.class).getResultList();
        } finally {
            em.close();
        }
    }
}
