package com.bolsadeideas.springboot.web.app.model.dao;

import java.util.List;

import com.bolsadeideas.springboot.web.app.model.entity.Cliente;

public interface IClienteDao {
	
	public List<Cliente> findAll();
	
	public void save(Cliente cliente);
	
	public void edit(Cliente cliente);
	
	public Cliente findOne(Long id);
	
	public void delete(Long id);

}
