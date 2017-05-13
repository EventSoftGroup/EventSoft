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

    public void begin(){

        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    public void commit(){
        em.getTransaction().commit();
        em.close();
    }

    public void alta(T t) {
        try {
            em.merge(t);
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e.getMessage());
            throw e;
        }
    }

    public void baja(Long id) {
        try {
            em.remove(em.find(entityClass, id));
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }


    public void modifica(T t) {
        try {
            em.merge(t);
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public T consulta(Long id) {

        return em.find(entityClass, id);
    }

    public List<T> listado() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(entityClass);
        //System.out.println("ServicioIntegracion: " + entityClass.toString());
        Root<T> root = cq.from(entityClass);
        CriteriaQuery<T> all = cq.select(root);
        TypedQuery<T> allQuery = em.createQuery(all);
        List<T> listado = allQuery.getResultList();

        return listado;
    }

    public Object ejecutarQuery(String query){

        return em.createQuery(query).getResultList();
    }

    public Long getRowCount() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        cq.select(cb.count(cq.from(entityClass)));

        return em.createQuery(cq).getSingleResult();
    }
}
