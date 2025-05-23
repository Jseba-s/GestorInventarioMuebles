/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestormuebles.Persistencia;

import com.mycompany.gestormuebles.Logica.Materiales;
import com.mycompany.gestormuebles.Logica.Proveedor;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class MaterialesJpaController implements Serializable {

    public MaterialesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public MaterialesJpaController(){
        emf = Persistence.createEntityManagerFactory("GestorMueblesPU");
    }

    public void create(Materiales materiales) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proveedor proveedor = materiales.getMaterialProveedor();
            if (proveedor != null) {
                proveedor = em.getReference(proveedor.getClass(), proveedor.getIdProveedor());
                materiales.setMaterialProveedor(proveedor);
            }
            em.persist(materiales);
            if (proveedor != null) {
                proveedor.getMaterialesProveedor().add(materiales);
                proveedor = em.merge(proveedor);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Materiales materiales) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Materiales persistentMateriales = em.find(Materiales.class, materiales.getIdMaterial());
            Proveedor proveedorOld = persistentMateriales.getMaterialProveedor();
            Proveedor proveedorNew = materiales.getMaterialProveedor();
            if (proveedorNew != null) {
                proveedorNew = em.getReference(proveedorNew.getClass(), proveedorNew.getIdProveedor());
                materiales.setMaterialProveedor(proveedorNew);
            }
            materiales = em.merge(materiales);
            if (proveedorOld != null && !proveedorOld.equals(proveedorNew)) {
                proveedorOld.getMaterialesProveedor().remove(materiales);
                proveedorOld = em.merge(proveedorOld);
            }
            if (proveedorNew != null && !proveedorNew.equals(proveedorOld)) {
                proveedorNew.getMaterialesProveedor().add(materiales);
                proveedorNew = em.merge(proveedorNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMateriales(materiales.getIdMaterial()) == null) {
                throw new Exception("The materiales with id " + materiales.getIdMaterial() + " no longer exists.");
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Materiales materiales;
            try {
                materiales = em.getReference(Materiales.class, id);
                materiales.getIdMaterial();
            } catch (EntityNotFoundException enfe) {
                throw new Exception("The materiales with id " + id + " no longer exists.", enfe);
            }
            Proveedor proveedor = materiales.getMaterialProveedor();
            if (proveedor != null) {
                proveedor.getMaterialesProveedor().remove(materiales);
                proveedor = em.merge(proveedor);
            }
            em.remove(materiales);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Materiales> findMaterialesEntities() {
        return findMaterialesEntities(true, -1, -1);
    }

    public List<Materiales> findMaterialesEntities(int maxResults, int firstResult) {
        return findMaterialesEntities(false, maxResults, firstResult);
    }

    private List<Materiales> findMaterialesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Materiales> cq = em.getCriteriaBuilder().createQuery(Materiales.class);
            cq.select(cq.from(Materiales.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Materiales findMateriales(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Materiales.class, id);
        } finally {
            em.close();
        }
    }

    public int getMaterialesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Long> cq = em.getCriteriaBuilder().createQuery(Long.class);
            Root<Materiales> rt = cq.from(Materiales.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
