package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.model.venta.Factura;

@Controller
@RequestMapping("/factura")
public class FacturaController {
	
	
	//Inyección de texto desde el application.properties
	@Value("${cliente.nombre}")
	private String NombreCliente;
	
	//Inyección de texto desde el application.properties
	@Value("${cliente.apellido}")
	private String ApellidoCliente;
	
	//Inyección de texto desde el application.properties
	@Value("${factura.descripcion}")
	private String DescripcionFactura;
	
	//Inyección de dependencia desde la clase FACTURA (De ahi para atrás se hace toda la magia de la inyección sin la palabra NEW)
	@Autowired
	private Factura factura;
	
	@RequestMapping("/ver")
	public String ver(Model model) {
		model.addAttribute("factura", factura);
		model.addAttribute("titulo","Ejemplo factura con inyeccón de dependencia");
		model.addAttribute("NombreCliente", NombreCliente);
		model.addAttribute("ApellidoCliente", ApellidoCliente);
		model.addAttribute("DescripcionFactura", DescripcionFactura);
		return "factura";
	}
	
}
