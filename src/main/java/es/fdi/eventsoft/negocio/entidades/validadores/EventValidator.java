package es.fdi.eventsoft.negocio.entidades.validadores;

import es.fdi.eventsoft.negocio.entidades.Evento;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by fernando on 09/06/2017.
 */
@Component
public class EventValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Evento.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Evento evento = (Evento) o;

        if(evento.getNombre().equalsIgnoreCase("")){
            errors.rejectValue("nombre" , "error.evento", "Campo vacio. Rellenalo");
        }
        else if(evento.getLugar().equalsIgnoreCase("")){
            errors.rejectValue("lugar" , "error.evento", "Campo vacio. Rellenalo");
        }
        else if (evento.getDescripcion().equalsIgnoreCase("")) {
            errors.rejectValue("descrpcion" , "error.evento", "Campo vacio. Rellenalo");
        }
        else if(evento.getFechaInicio().after(evento.getFechaFin())) {
            errors.rejectValue("fechaInicio" , "error.evento", "Fecha posterior a la de Fin. Ajustela");
        }
    }
}
