package es.fdi.eventsoft.negocio.entidades.validadores;

import es.fdi.eventsoft.negocio.entidades.usuario.Usuario;
import es.fdi.eventsoft.negocio.servicios.usuarios.imp.SAUsuarioImp;
import es.fdi.eventsoft.negocio.servicios.usuarios.imp.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Autowired
    private SAUsuarioImp servicioUsuario;

    @Override
    public boolean supports(Class<?> aClass) {
        return Usuario.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Usuario usuario = (Usuario) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "direccion", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "localidad", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "provincia", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codigoPostal", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono", "NotEmpty");
    }
}
