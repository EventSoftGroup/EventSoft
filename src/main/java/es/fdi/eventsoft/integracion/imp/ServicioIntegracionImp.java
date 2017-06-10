package es.fdi.eventsoft.integracion.imp;


import es.fdi.eventsoft.integracion.FachadaIntegracion;
import es.fdi.eventsoft.negocio.entidades.ClavesEventoServicio;
import javafx.util.Pair;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;

public class ServicioIntegracionImp<T> implements FachadaIntegracion<T> {

    static protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("aplicacion");

    @PersistenceContext(type=PersistenceContextType.EXTENDED)
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

    public boolean bajaEventoServicio(ClavesEventoServicio id) {
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
    public boolean modifica(T t) {
            try {
                em.merge(t);
                return true;
            } catch (Exception e) {
                em.getTransaction().rollback();
                e.printStackTrace();
                return false;
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
     * @see FachadaIntegracion<T>{@link #ejecutarNamedQuery(String, List)}
     */
    public List ejecutarNamedQuery(String nameQuery, List<Pair<String, Object>> params){
        Query q = em.createNamedQuery(nameQuery);

        /*Map<String, Object> ps = null;
        for (Map.Entry<String, Object> e : ps.entrySet()) {
            q.setParameter(e.getKey(), e.getValue());
        }
        */

        for (int i=0; i < params.size(); i++) {
            q.setParameter(params.get(i).getKey(), params.get(i).getValue());
        }

        return q.getResultList();
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
    public synchronized void begin(){
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

