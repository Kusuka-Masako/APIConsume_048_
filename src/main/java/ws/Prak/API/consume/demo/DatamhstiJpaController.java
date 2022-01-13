/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.Prak.API.consume.demo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ws.Prak.API.consume.demo.exceptions.NonexistentEntityException;
import ws.Prak.API.consume.demo.exceptions.PreexistingEntityException;

/**
 *
 * @author PAVILION GAMING
 */
public class DatamhstiJpaController implements Serializable {

    public DatamhstiJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ws.Prak.API.consume_demo_jar_0.0.1-SNAPSHOTPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Datamhsti datamhsti) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(datamhsti);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDatamhsti(datamhsti.getId()) != null) {
                throw new PreexistingEntityException("Datamhsti " + datamhsti + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Datamhsti datamhsti) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            datamhsti = em.merge(datamhsti);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = datamhsti.getId();
                if (findDatamhsti(id) == null) {
                    throw new NonexistentEntityException("The datamhsti with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Datamhsti datamhsti;
            try {
                datamhsti = em.getReference(Datamhsti.class, id);
                datamhsti.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The datamhsti with id " + id + " no longer exists.", enfe);
            }
            em.remove(datamhsti);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Datamhsti> findDatamhstiEntities() {
        return findDatamhstiEntities(true, -1, -1);
    }

    public List<Datamhsti> findDatamhstiEntities(int maxResults, int firstResult) {
        return findDatamhstiEntities(false, maxResults, firstResult);
    }

    private List<Datamhsti> findDatamhstiEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Datamhsti.class));
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

    public Datamhsti findDatamhsti(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Datamhsti.class, id);
        } finally {
            em.close();
        }
    }

    public int getDatamhstiCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Datamhsti> rt = cq.from(Datamhsti.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
