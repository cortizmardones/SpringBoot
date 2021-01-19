package com.bolsadeideas.springboot.web.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.web.app.model.dao.IClienteDao;
import com.bolsadeideas.springboot.web.app.model.entity.Cliente;
import com.bolsadeideas.springboot.web.app.model.entity.Transportista;
import com.bolsadeideas.springboot.web.app.services.ITransportistaService;

//Acá se configuran los famosos CORS (Intercambio de recursos de origen cruzado) para permitir que angular lea los json
@CrossOrigin(origins = "http://localhost:42000")
@RestController
@RequestMapping("/api")
public class ClienteRestController {
	
	@Autowired
	private ITransportistaService iTransportistaService;
	
	@Autowired
	private IClienteDao iClienteDao;
	
	
	//Forma mas elegante del video , agregando una interfaz adicional y creando servicios.
	@RequestMapping("/listarTransportistas")
	public List<Transportista> returnAllTransportista(){
		return (List<Transportista>) iTransportistaService.findAll();
	}
	
	//Forma tradicional que hice durante el curso.
	@RequestMapping("/listarClientes")
	public List<Cliente> returnAllClientes() {
		return iClienteDao.findAll();
	}
	
	//

}
