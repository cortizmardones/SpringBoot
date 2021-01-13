package com.bolsadeideas.springboot.web.app.model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.web.app.model.entity.Cliente;

//ANotación de spring como un component pero dedicado a BDD
@Repository
public class ClienteDaoImplements implements IClienteDao {

	@PersistenceContext
	private EntityManager em;
	
	//Anotacion para definir la query solo lectura (Para los select)
	//Transactional es para hacer la query transactional (incluir rollback en caso de  falla , etc)
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Cliente> findAll() {
		
		//El nombre siempre tiene que ser el de la clase y siempre con la primera letra en mayuscula o arrojara errores. (IMPORTANTE)
		return em.createQuery("from Cliente").getResultList();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		em.persist(cliente);
	}

	@Override
	@Transactional
	public void edit(Long id) {
		//merge(actualizar)
		
	}
	
	@Override
	public Cliente findOne(Long id) {
		return em.find(Cliente.class,id);
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		
		Cliente cliente = findOne(id);
		em.remove(cliente);
	}


	
	
	

}
