package com.bolsadeideas.springboot.web.app.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.bolsadeideas.springboot.web.app.model.entity.Acceso;

@Repository
public class AccesoDaoImplements implements IAccesoDao{
	
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Acceso> findAll() {
		return em.createQuery("from Acceso").getResultList();
	}

	@Override
	public void save(Acceso acceso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Acceso findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
