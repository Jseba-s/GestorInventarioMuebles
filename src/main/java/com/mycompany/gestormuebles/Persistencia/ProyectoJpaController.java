package com.mycompany.gestormuebles.Persistencia;

import com.mycompany.gestormuebles.Logica.Proyecto;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProyectoJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public ProyectoJpaController() {
        emf = Persistence.createEntityManagerFactory("GestorMueblesPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Proyecto proyecto) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(proyecto);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void edit(Proyecto proyecto) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(proyecto);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void destroy(int id) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Proyecto proyecto = em.find(Proyecto.class, id);
            if (proyecto == null) {
                throw new Exception("El proyecto con id " + id + " no existe.");
            }
            em.remove(proyecto);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Proyecto findProyecto(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Proyecto.class, id);
        } finally {
            em.close();
        }
    }

    public List<Proyecto> findProyectoEntities() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT p FROM Proyecto p", Proyecto.class).getResultList();
        } finally {
            em.close();
        }
    }
}
