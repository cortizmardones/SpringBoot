package com.bolsadeideas.springboot.web.app.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.bolsadeideas.springboot.web.app.model.entity.Comuna;

@Repository
public class ComunaDaoImplements implements IComunaDao {
	
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Comuna> findAll() {
		//Consulta en la tabla comunas ordenados por nombre
		return em.createQuery("from Comuna order by nombre asc").getResultList();
	}

}
