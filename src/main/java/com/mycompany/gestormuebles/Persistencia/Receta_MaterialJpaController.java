package com.mycompany.gestormuebles.Persistencia;

import com.mycompany.gestormuebles.Logica.Receta_Material;
import com.mycompany.gestormuebles.Persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class Receta_MaterialJpaController implements Serializable {

    public Receta_MaterialJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public Receta_MaterialJpaController() {
        this.emf = Persistence.createEntityManagerFactory("GestorMueblesPU"); 
    }

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Receta_Material receta_Material) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(receta_Material);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Receta_Material receta_Material) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            receta_Material = em.merge(receta_Material);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Receta_Material receta_Material;
            try {
                receta_Material = em.getReference(Receta_Material.class, id);
                receta_Material.getIdRecetaMaterial();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("La receta_material con id " + id + " no existe.", enfe);
            }
            em.remove(receta_Material);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Receta_Material> findReceta_MaterialEntities() {
        return findReceta_MaterialEntities(true, -1, -1);
    }

    public List<Receta_Material> findReceta_MaterialEntities(int maxResults, int firstResult) {
        return findReceta_MaterialEntities(false, maxResults, firstResult);
    }

    private List<Receta_Material> findReceta_MaterialEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Receta_Material.class));
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

    public Receta_Material findReceta_Material(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Receta_Material.class, id);
        } finally {
            em.close();
        }
    }

    public int getReceta_MaterialCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Receta_Material> rt = cq.from(Receta_Material.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
