package com.bolsadeideas.springboot.web.app.model;

import org.springframework.stereotype.Component;

@Component
public class Loggin {
	
	private String mail;
	private String password;
	
	public Loggin() {
		
	}
		
	public Loggin(String mail, String password) {
		this.mail = mail;
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean validarUsuario(String usuario , String password) {
		if(usuario.equalsIgnoreCase("cortizmardones@gmail.com") && password.equals("Mhunter.4")) {
			return true;
		}else {
			return false;
		}
	}
	
}
