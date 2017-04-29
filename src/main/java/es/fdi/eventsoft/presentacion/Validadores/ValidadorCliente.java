package es.fdi.eventsoft.presentacion.Validadores;

import es.fdi.eventsoft.negocio.Usuario.TCliente;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.ConstraintViolation;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;
import java.util.Set;

/**
 * Created by Tomas on 29/04/17.
 */
public class ValidadorCliente implements Validator {



    public boolean supports(Class clazz) {
        return TCliente.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
        TCliente cliente = (TCliente) target;

        if(cliente.getNombre() == null || cliente.getNombre().equalsIgnoreCase("")) {
            errors.rejectValue("nombre", "your_error_code");
        }

        // do "complex" validation here

    }
}
