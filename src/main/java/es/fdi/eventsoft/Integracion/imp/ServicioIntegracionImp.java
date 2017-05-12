package es.fdi.eventsoft.Integracion.imp;


import es.fdi.eventsoft.Integracion.FachadaIntegracion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ServicioIntegracionImp<T> implements FachadaIntegracion<T> {

    protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("aplicacion");
    protected EntityManager em;
    protected Class<T> entityClass;


    public ServicioIntegracionImp(Class<T> t) {
        entityClass = t;
    }

    public void alta(T t) {
        em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e.getMessage());
            throw e;
        }
    }

    public void baja(Long id) {
        em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            T t = em.find(entityClass, id);
            em.remove(t);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }


    public void modifica(T t) {
        em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public T consulta(Long id) {
        em = emf.createEntityManager();
        T t = em.find(entityClass, id);
        em.close();

        return t;
    }

    public List<T> listado() {
        em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(entityClass);
        //System.out.println("ServicioIntegracion: " + entityClass.toString());
        Root<T> root = cq.from(entityClass);
        CriteriaQuery<T> all = cq.select(root);
        TypedQuery<T> allQuery = em.createQuery(all);
        List<T> listado = allQuery.getResultList();
        em.close();

        return listado;
    }

    public Object ejecutarQuery(String query){
        em = emf.createEntityManager();
        Object result = em.createQuery(query).getResultList();
        em.close();
        return result;
    }

    public Long getRowCount() {
        em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        cq.select(cb.count(cq.from(entityClass)));
        Long count = em.createQuery(cq).getSingleResult();
        em.close();

        return count;
    }
}
