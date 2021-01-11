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
		return em.createQuery("from Cliente").getResultList();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		em.persist(cliente);
	}

	@Override
	public void find(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	
	//Hay otros metodos merge(actualizar) y remove (eliminar)

}
