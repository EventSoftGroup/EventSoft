package es.fdi.eventsoft.Integracion;

import es.fdi.eventsoft.Integracion.imp.ServicioIntegracionImp;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rodrigo de Miguel on 05/05/2017.
 */
public interface FachadaIntegracion<T> {

        /**
         * Constructor del servicio.
         *
         * @param <T> Class para parametrizar el servicio
         *
         * @return Nueva instancia del servicio de integracion parametrizado para T
         */
        static <T> FachadaIntegracion<T> newInstance(Class<T> t){
                return new ServicioIntegracionImp(t);
        }



        /**
         * Alta de la @Entity tipo <T>
         *
         * @param <T> Entidad a persistir
         *
         * @return Instancia de la @Entity administadra (managed) que se persistió.
         *              Null si hay error.
         */
        <T> T  alta(T t);


        /**
         * Baja de una entidad por ID
         *
         * @param id ID de la entidad
         *
         * @return True si baja corecta
         *         False si hubo error.
         */
        boolean baja(Long id);


        /**
         * Modificacion de la @Entity tipo <T>
         *
         * @param <T> @Entity a modificar
         *
         * @return Instancia de la @Entity administadra (managed) que se persistió.
         *         Null si hubo error.
         */
        boolean modifica(T t);


        /**
         * Busqueda de la entidad por ID
         *
         * @param id ID de la entidad a buscar
         *
         * @return @Entity buscada por ID
         *          Null si la @Entity no funciona
         */
        T consulta(Long id);

        List<T> listado();

        Long getRowCount();


        /** Ejecuta la query pasada
         *
         * @param nameQuery Query en Lenguaje HQL
         * @param params Lista de pares de los parametros de la Query
         *               String: nombre del parametro
         *               Object: parametro
         *
         * @return List con el resultado
         */
        List ejecutarNamedQuery(String nameQuery, List<Pair<String, Object>> params);



        /**
         * Inicio de una nueva transacción
         */
        void begin();


        /**
         * Commit de la transaccion, haciendo efectivos los cambios en la BBDD
         */
        void commit();

}

