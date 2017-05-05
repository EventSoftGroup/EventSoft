package es.fdi.eventsoft.Integracion;

import java.util.List;

/**
 * Created by Rodrigo de Miguel on 05/05/2017.
 */
public interface FachadaServicioIntegracion<T> {

        public void alta(T t);

        public void baja(Long id);

        public void modifica(T t);

        public T consulta(Long id);

        public List<T> listado();

        public Long getRowCount();
    }
}
