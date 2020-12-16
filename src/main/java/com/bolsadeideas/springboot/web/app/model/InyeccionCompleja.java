package com.bolsadeideas.springboot.web.app.model;

import org.springframework.stereotype.Component;

@Component("MiservicioComplejo")
public class InyeccionCompleja implements IInyeccion {

	public String inyectarDependencias() {
		return "Inyectando dependencias COMPLEJAS ...";
	}
}
