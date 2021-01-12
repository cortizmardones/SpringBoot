package com.bolsadeideas.springboot.web.app.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//la anotación table es para darle otro nombre a la tabla - si no esta por default se llamara igual que la clase
@Table(name = "comunas")
public class Comuna {
	
	@Id
	private int id;
	
	private String nombre;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
