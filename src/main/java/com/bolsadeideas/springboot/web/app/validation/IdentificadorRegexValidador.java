package com.bolsadeideas.springboot.web.app.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdentificadorRegexValidador implements ConstraintValidator<IdentificadorRegex, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value.matches("[0-9]{2}[.][0-9]{3}[.][0-9]{3}[-][a-zA-Z]{1}")) {
			return true;
		} else {
			return false;
		}
		
	}
	
}
