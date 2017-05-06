package es.fdi.eventsoft.Presentacion.Validadores;

import es.fdi.eventsoft.Negocio.Entidades.Usuario.Cliente;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Tomas on 29/04/17.
 */
public class ValidadorCliente implements Validator {



    public boolean supports(Class clazz) {
        return Cliente.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
        Cliente cliente = (Cliente) target;

        if(cliente.getNombre() == null || cliente.getNombre().equalsIgnoreCase("")) {
            errors.rejectValue("nombre", "your_error_code");
        }

        // do "complex" validation here

    }
}
