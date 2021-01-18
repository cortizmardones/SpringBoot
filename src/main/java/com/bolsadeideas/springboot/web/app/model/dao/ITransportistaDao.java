package com.bolsadeideas.springboot.web.app.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.web.app.model.entity.Transportista;

public interface ITransportistaDao extends CrudRepository<Transportista, Long>{

}
