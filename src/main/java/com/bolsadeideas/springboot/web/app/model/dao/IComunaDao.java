package com.bolsadeideas.springboot.web.app.model.dao;

import java.util.List;
import com.bolsadeideas.springboot.web.app.model.entity.Comuna;

public interface IComunaDao {

	public List<Comuna> findAll();
	
	public Comuna findOne(Long id);
	
}
