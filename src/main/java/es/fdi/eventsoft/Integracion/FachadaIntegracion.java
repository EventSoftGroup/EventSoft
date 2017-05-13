package es.fdi.eventsoft.Integracion;

import es.fdi.eventsoft.Integracion.imp.ServicioIntegracionImp;

import java.util.List;

/**
 * Created by Rodrigo de Miguel on 05/05/2017.
 */
public interface FachadaIntegracion<T> {

        static <T> FachadaIntegracion<T> newInstance(Class<T> t){
                return new ServicioIntegracionImp(t);
        }

        void alta(T t);

        void baja(Long id);

        void modifica(T t);

        T consulta(Long id);

        List<T> listado();

        Long getRowCount();

        void begin();

        void commit();

}

