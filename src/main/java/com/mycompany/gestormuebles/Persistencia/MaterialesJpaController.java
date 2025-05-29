package com.mycompany.gestormuebles.persistencia;

import com.mycompany.gestormuebles.Logica.Materiales;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;



public class MaterialesJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public MaterialesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public MaterialesJpaController(){
        emf = Persistence.createEntityManagerFactory("GestorMueblesPU");
    }
    public void create(Materiales materiales) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(materiales);
        em.getTransaction().commit();
        em.close();
    }

    public void edit(Materiales materiales) throws Exception {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        materiales = em.merge(materiales);
        em.getTransaction().commit();
        em.close();
    }

    public void destroy(int id) throws Exception {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Materiales materiales = em.getReference(Materiales.class, id);
        em.remove(materiales);
        em.getTransaction().commit();
        em.close();
    }

    public List<Materiales> findMaterialesEntities() {
        return findMaterialesEntities(true, -1, -1);
    }

    public List<Materiales> findMaterialesEntities(int maxResults, int firstResult) {
        return findMaterialesEntities(false, maxResults, firstResult);
    }

    private List<Materiales> findMaterialesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Materiales.class));
        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        List<Materiales> lista = q.getResultList();
        em.close();
        return lista;
    }

    public Materiales findMateriales(int id) {
        EntityManager em = getEntityManager();
        Materiales materiales = em.find(Materiales.class, id);
        em.close();
        return materiales;
    }

    public int getMaterialesCount() {
        EntityManager em = getEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<Materiales> rt = cq.from(Materiales.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        int count = ((Long) q.getSingleResult()).intValue();
        em.close();
        return count;
    }
}
