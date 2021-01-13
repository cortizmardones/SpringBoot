package com.bolsadeideas.springboot.web.app.model.dao;

import java.util.List;

import com.bolsadeideas.springboot.web.app.model.entity.Acceso;

public interface IAccesoDao {
	
	public List<Acceso> findAll();
	
	public void save(Acceso acceso);
	
	public void edit(Long id);
	
	public Acceso findOne(Long id);
	
	public void delete(Long id);

}
