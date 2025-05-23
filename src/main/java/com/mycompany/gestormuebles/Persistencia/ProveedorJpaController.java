package com.mycompany.gestormuebles.Persistencia;

import com.mycompany.gestormuebles.Logica.Materiales;
import com.mycompany.gestormuebles.Logica.Proveedor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class ProveedorJpaController implements Serializable {

    public ProveedorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public ProveedorJpaController(){
        emf = Persistence.createEntityManagerFactory("GestorMueblesPU");
    }

    public void create(Proveedor proveedor) {
        if (proveedor.getMaterialesProveedor() == null) {
            proveedor.setMaterialesProveedor(new ArrayList<>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Materiales> attachedMateriales = new ArrayList<>();
            for (Materiales materiales : proveedor.getMaterialesProveedor()) {
                materiales = em.getReference(materiales.getClass(), materiales.getIdMaterial());
                attachedMateriales.add(materiales);
            }
            proveedor.setMaterialesProveedor(attachedMateriales);
            em.persist(proveedor);
            for (Materiales materiales : proveedor.getMaterialesProveedor()) {
                Proveedor oldProveedor = materiales.getMaterialProveedor();
                materiales.setMaterialProveedor(proveedor);
                materiales = em.merge(materiales);
                if (oldProveedor != null) {
                    oldProveedor.getMaterialesProveedor().remove(materiales);
                    oldProveedor = em.merge(oldProveedor);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Proveedor proveedor) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proveedor persistentProveedor = em.find(Proveedor.class, proveedor.getIdProveedor());
            List<Materiales> materialesOld = persistentProveedor.getMaterialesProveedor();
            List<Materiales> materialesNew = proveedor.getMaterialesProveedor();
            List<Materiales> attachedMaterialesNew = new ArrayList<>();
            for (Materiales materiales : materialesNew) {
                materiales = em.getReference(materiales.getClass(), materiales.getIdMaterial());
                attachedMaterialesNew.add(materiales);
            }
            materialesNew = attachedMaterialesNew;
            proveedor.setMaterialesProveedor(materialesNew);
            proveedor = em.merge(proveedor);
            for (Materiales materialesOldItem : materialesOld) {
                if (!materialesNew.contains(materialesOldItem)) {
                    materialesOldItem.setMaterialProveedor(null);
                    materialesOldItem = em.merge(materialesOldItem);
                }
            }
            for (Materiales materialesNewItem : materialesNew) {
                if (!materialesOld.contains(materialesNewItem)) {
                    Proveedor oldProveedorOfMateriales = materialesNewItem.getMaterialProveedor();
                    materialesNewItem.setMaterialProveedor(proveedor);
                    materialesNewItem = em.merge(materialesNewItem);
                    if (oldProveedorOfMateriales != null && !oldProveedorOfMateriales.equals(proveedor)) {
                        oldProveedorOfMateriales.getMaterialesProveedor().remove(materialesNewItem);
                        oldProveedorOfMateriales = em.merge(oldProveedorOfMateriales);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            int id = proveedor.getIdProveedor();
            if (findProveedor(id) == null) {
                throw new Exception("The proveedor with id " + id + " no longer exists.");
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
            Proveedor proveedor;
            try {
                proveedor = em.getReference(Proveedor.class, id);
                proveedor.getIdProveedor();
            } catch (EntityNotFoundException enfe) {
                throw new Exception("The proveedor with id " + id + " no longer exists.", enfe);
            }
            List<Materiales> materialesProveedor = proveedor.getMaterialesProveedor();
            for (Materiales materiales : materialesProveedor) {
                materiales.setMaterialProveedor(null);
                materiales = em.merge(materiales);
            }
            em.remove(proveedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Proveedor> findProveedorEntities() {
        return findProveedorEntities(true, -1, -1);
    }

    public List<Proveedor> findProveedorEntities(int maxResults, int firstResult) {
        return findProveedorEntities(false, maxResults, firstResult);
    }

    private List<Proveedor> findProveedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Proveedor> cq = em.getCriteriaBuilder().createQuery(Proveedor.class);
            cq.select(cq.from(Proveedor.class));
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

    public Proveedor findProveedor(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Proveedor.class, id);
        } finally {
            em.close();
        }
    }

    public int getProveedorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Long> cq = em.getCriteriaBuilder().createQuery(Long.class);
            Root<Proveedor> rt = cq.from(Proveedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}