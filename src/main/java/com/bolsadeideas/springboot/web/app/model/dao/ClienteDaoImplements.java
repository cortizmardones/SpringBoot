package com.bolsadeideas.springboot.web.app.model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.web.app.model.entity.Cliente;

//ANotación de spring como un component pero dedicado a BDD
@Repository
public class ClienteDaoImplements implements IClienteDao {

	private EntityManager em;
	
	//Anotacion para definir la query solo lectura (Para los select)
	//Transactional es para hacer la query transactional (incluir rollback en caso de  falla , etc)
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Cliente> findAll() {
		return em.createQuery("from Cliente").getResultList();
	}

}
