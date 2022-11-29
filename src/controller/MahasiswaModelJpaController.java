/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.exceptions.NonexistentEntityException;
import controller.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.MahasiswaModel;

/**
 *
 * @author admin
 */
public class MahasiswaModelJpaController implements Serializable {

    public MahasiswaModelJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MahasiswaModel mahasiswaModel) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(mahasiswaModel);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMahasiswaModel(mahasiswaModel.getNpm()) != null) {
                throw new PreexistingEntityException("MahasiswaModel " + mahasiswaModel + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MahasiswaModel mahasiswaModel) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            mahasiswaModel = em.merge(mahasiswaModel);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = mahasiswaModel.getNpm();
                if (findMahasiswaModel(id) == null) {
                    throw new NonexistentEntityException("The mahasiswaModel with id " + id + " no longer exists.");
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
            MahasiswaModel mahasiswaModel;
            try {
                mahasiswaModel = em.getReference(MahasiswaModel.class, id);
                mahasiswaModel.getNpm();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mahasiswaModel with id " + id + " no longer exists.", enfe);
            }
            em.remove(mahasiswaModel);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MahasiswaModel> findMahasiswaModelEntities() {
        return findMahasiswaModelEntities(true, -1, -1);
    }

    public List<MahasiswaModel> findMahasiswaModelEntities(int maxResults, int firstResult) {
        return findMahasiswaModelEntities(false, maxResults, firstResult);
    }

    private List<MahasiswaModel> findMahasiswaModelEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MahasiswaModel.class));
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

    public MahasiswaModel findMahasiswaModel(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MahasiswaModel.class, id);
        } finally {
            em.close();
        }
    }

    public int getMahasiswaModelCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MahasiswaModel> rt = cq.from(MahasiswaModel.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
