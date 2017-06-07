package es.fdi.eventsoft.negocio.entidades.validadores;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FechaEventosValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface FechaEventos {
 
     
    String message() default "No es una fecha superior a la inicial";
     
    Class<?>[] groups() default {};
     
    Class<? extends Payload>[] payload() default {};
      
}