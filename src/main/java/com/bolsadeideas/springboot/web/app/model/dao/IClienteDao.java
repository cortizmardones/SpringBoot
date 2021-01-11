package com.bolsadeideas.springboot.web.app.model.dao;

import java.util.List;

import com.bolsadeideas.springboot.web.app.model.entity.Cliente;

public interface IClienteDao {
	
	public List<Cliente> findAll();

}
