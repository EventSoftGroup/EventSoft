package es.fdi.eventsoft.Negocio.Entidades.Validadores;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TelefonoValidator implements ConstraintValidator<Telefono, String> {

	@Override
	public void initialize(Telefono paramA) {
	}

	@Override
	public boolean isValid(String phoneNo, ConstraintValidatorContext ctx) {
		if(phoneNo == null){
			return false;
		}
		//validate phone numbers of format "123456789"
        if (phoneNo.matches("\\d{9}")) return true;
        //return false if nothing matches the input
        else return false;
	}

}