package com.mycompany.gestormuebles.Logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CategoriaMaterialJpaController implements Serializable {

    private EntityManagerFactory emf = null;

     public CategoriaMaterialJpaController(){
        emf = Persistence.createEntityManagerFactory("GestorMueblesPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    

    public void create(CategoriaMaterial categoriaMaterial) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(categoriaMaterial);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void edit(CategoriaMaterial categoriaMaterial) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(categoriaMaterial);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void destroy(int id) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            CategoriaMaterial categoriaMaterial = em.find(CategoriaMaterial.class, id);
            if (categoriaMaterial == null) {
                throw new Exception("La categoría con id " + id + " no existe.");
            }
            em.remove(categoriaMaterial);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public CategoriaMaterial findCategoriaMaterial(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CategoriaMaterial.class, id);
        } finally {
            em.close();
        }
    }

    public List<CategoriaMaterial> findCategoriaMaterialEntities() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT c FROM CategoriaMaterial c", CategoriaMaterial.class).getResultList();
        } finally {
            em.close();
        }
    }
}
