package com.bolsadeideas.springboot.web.app.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bolsadeideas.springboot.web.app.model.Usuario;



//Es importante que esta clase de validación personalizada funciona con el archivo messages.properties y los mensajes personalizados que tenemos ahi.
@Component
public class UsuarioValidate implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Usuario.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nombre", "NotEmpty.usuario.nombre");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"apellido", "NotEmpty.usuario.apellido");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"correo", "NotEmpty.usuario.correo");

//	Esta parte es por si quisiera realizar una validación personalizada para atributos de una clase.
//		Usuario usuario = (Usuario)target;
//		if(!usuario.getIdentificador().matches("[0-9]{2}[.][0-9]{3}[.][0-9]{3}[-][a-zA-Z]{1}")) {
//			errors.rejectValue("identificador", "Pattern.usuario.identificador");
//		}

	}

}
