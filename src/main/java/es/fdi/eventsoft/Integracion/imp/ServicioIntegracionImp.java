package es.fdi.eventsoft.Integracion.imp;


import es.fdi.eventsoft.Integracion.FachadaIntegracion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ServicioIntegracionImp<T> implements FachadaIntegracion<T> {

    protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("aplicacion");
    protected EntityManager em;
    protected Class<T> entityClass;


    public ServicioIntegracionImp(Class<T> t) {
        entityClass = t;
    }


    /**
     * @see FachadaIntegracion<T>{@link #alta(Object)}
     */
    public <T> T  alta(T t) {
        try {
            return em.merge(t);
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e.getMessage());

            return null;
        }
    }


    /**
     * @see FachadaIntegracion<T>{@link #baja(Long)}
     */
    public boolean baja(Long id) {
        try {
            em.remove(em.find(entityClass, id));
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
    }

    /**
     * @see FachadaIntegracion<T>{@link #modifica(Object)}
     */
    public <T> T modifica(T t) {
            try {
                return em.merge(t);
            } catch (Exception e) {
                em.getTransaction().rollback();
                return null;
            }
        }


    /**
     * @see FachadaIntegracion<T>{@link #consulta(Long)}
     */
    public T consulta(Long id) {
        return em.find(entityClass, id);
    }



    /**
     * @see FachadaIntegracion<T>{@link #listado()}
     */
    public List<T> listado() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(entityClass);
        Root<T> root = cq.from(entityClass);
        CriteriaQuery<T> all = cq.select(root);
        TypedQuery<T> allQuery = em.createQuery(all);
        List<T> listado = allQuery.getResultList();

        return listado;
    }

    /**
     * @see FachadaIntegracion<T>{@link #ejecutarQuery(String)}
     */
    public List ejecutarQuery(String query){
        return em.createQuery(query).getResultList();
    }



    /**
     * @see FachadaIntegracion<T>{@link #getRowCount()}
     */
    public Long getRowCount() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        cq.select(cb.count(cq.from(entityClass)));
        return em.createQuery(cq).getSingleResult();
    }


    /**
     * @see FachadaIntegracion<T>{@link #begin()}
     */
    public void begin(){
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }


    /**
     * @see FachadaIntegracion<T>{@link #commit()}
     */
    public void commit(){
        if(em.getTransaction().isActive()){
            em.getTransaction().commit();
        }
        em.close();
    }

}

