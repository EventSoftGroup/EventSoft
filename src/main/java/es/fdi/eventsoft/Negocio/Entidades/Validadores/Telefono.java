package es.fdi.eventsoft.Negocio.Entidades.Validadores;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TelefonoValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Telefono {
 
     
    String message() default "No es un número de teléfono válido";
     
    Class<?>[] groups() default {};
     
    Class<? extends Payload>[] payload() default {};
      
}