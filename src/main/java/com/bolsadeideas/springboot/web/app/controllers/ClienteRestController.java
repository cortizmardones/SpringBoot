package com.bolsadeideas.springboot.web.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.web.app.model.entity.Transportista;
import com.bolsadeideas.springboot.web.app.services.ITransportistaService;

@RestController
@RequestMapping("/api")
public class ClienteRestController {
	
	@Autowired
	private ITransportistaService iTransportistaService;
	
	@RequestMapping("/listar")
	public List<Transportista> returnAll(){
		return (List<Transportista>) iTransportistaService.findAll();
	}

}
