package es.fdi.eventsoft.negocio.entidades.validadores;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Calendar;
import java.util.Date;

public class FechaEventosValidator implements ConstraintValidator<FechaEventos, Object> {

	@Override
	public void initialize(final FechaEventos annotation) { }

	@Override
	public boolean isValid(Object o, ConstraintValidatorContext ctx) {

		System.out.println("Mi objeto");
		System.out.println(o);

		return true;
	}

}