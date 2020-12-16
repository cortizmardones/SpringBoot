package com.bolsadeideas.springboot.web.app.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class InyeccionSimple implements IInyeccion {

	public String inyectarDependencias() {
		return "Inyectando dependencias SIMPLES ...";
	}
}
