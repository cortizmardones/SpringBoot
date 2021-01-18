package com.bolsadeideas.springboot.web.app.services;

import java.util.List;

import com.bolsadeideas.springboot.web.app.model.entity.Transportista;

public interface ITransportistaService {
	
	public List<Transportista> findAll();

}
