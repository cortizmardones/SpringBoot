package com.bolsadeideas.springboot.web.app.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.CLASS;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = IdentificadorRegexValidador.class)
@Retention(CLASS)
@Target({ FIELD, METHOD })
public @interface IdentificadorRegex {
	
	//String message() default "{javax.validation.constraints.NotEmpty.message}";
	
	//Para palicar este mensaje debo indicarle en la clase JAVA.
	String message() default "{Mensaje personalizado}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
