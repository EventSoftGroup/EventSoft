package es.fdi.eventsoft.negocio.entidades.validadores;

import es.fdi.eventsoft.negocio.entidades.Servicio;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by fernando on 10/06/2017.
 */
public class ServicioValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Servicio.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Servicio servicio = (Servicio) o;
        if(servicio.getNombre().equalsIgnoreCase("")){
            errors.rejectValue("nombre" , "error.servicio", "Campo vacio. Rellenalo");
        }
        else if (servicio.getDescripcion().equalsIgnoreCase("")) {
            errors.rejectValue("descrpcion" , "error.servicio", "Campo vacio. Rellenalo");
        }
    }
}
