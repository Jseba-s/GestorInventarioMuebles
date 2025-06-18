package com.mycompany.gestormuebles.persistencia;

import com.mycompany.gestormuebles.Logica.Receta;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class RecetaJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public RecetaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public RecetaJpaController() {
        this.emf = Persistence.createEntityManagerFactory("GestorMueblesPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Receta receta) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(receta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Receta receta) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            receta = em.merge(receta);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findReceta(receta.getIdReceta()) == null) {
                throw new Exception("La receta con ID " + receta.getIdReceta() + " no existe.", ex);
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
            Receta receta;
            try {
                receta = em.getReference(Receta.class, id);
                receta.getIdReceta();
            } catch (EntityNotFoundException enfe) {
                throw new Exception("La receta con ID " + id + " no existe.", enfe);
            }
            em.remove(receta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Receta> findRecetaEntities() {
        return findRecetaEntities(true, -1, -1);
    }

    public List<Receta> findRecetaEntities(int maxResults, int firstResult) {
        return findRecetaEntities(false, maxResults, firstResult);
    }

    private List<Receta> findRecetaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Receta.class));
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

    public Receta findReceta(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Receta.class, id);
        } finally {
            em.close();
        }
    }

    public int getRecetaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Receta> rt = cq.from(Receta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Receta> findRecetasConMateriales() {
    EntityManager em = getEntityManager();
    try {
        return em.createQuery(
            "SELECT DISTINCT r FROM Receta r LEFT JOIN FETCH r.listaMateriales rm LEFT JOIN FETCH rm.materialReceta",
            Receta.class
        ).getResultList();
    } finally {
        em.close();
    }
}
}
