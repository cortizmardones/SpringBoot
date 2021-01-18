package com.bolsadeideas.springboot.web.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.web.app.model.dao.ITransportistaDao;
import com.bolsadeideas.springboot.web.app.model.entity.Transportista;

@Service
public class TransportistaServiceImpl implements ITransportistaService{
	
	@Autowired 
	private ITransportistaDao iTransportistaDao;

	@Override
	@Transactional
	public List<Transportista> findAll() {
		return (List<Transportista>) iTransportistaDao.findAll();
	}

}
