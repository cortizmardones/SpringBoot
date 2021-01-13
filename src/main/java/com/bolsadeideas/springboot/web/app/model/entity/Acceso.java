package com.bolsadeideas.springboot.web.app.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accesos")
public class Acceso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	private String email;
	private String pass;
	
	public Acceso() {
		
	}
	
	public Acceso(int id , String email , String pass) {
		this.id= id;
		this.email=email;
		this.pass=pass;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Acceso [id=" + id + ", email=" + email + ", pass=" + pass + "]";
	}
	
}
