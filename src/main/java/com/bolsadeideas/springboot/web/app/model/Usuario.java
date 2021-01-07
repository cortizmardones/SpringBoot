package com.bolsadeideas.springboot.web.app.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.bolsadeideas.springboot.web.app.validation.IdentificadorRegex;

@Component
public class Usuario {
	
//	Para crear expresiones regulares personalizadas
//	@Pattern(regexp = "[0-9]{2}[.][0-9]{3}[.][0-9]{3}[-][a-zA-Z]{1}")
//	Este identificador lo cree para generar mensajes personalizados y validaciones más complejas.
//	@IdentificadorRegex
//	private String identificadorUnico;
	
	@NotEmpty(message = "El campo 'Nombre' no debe estar vacío") 
	private String nombre;
	
	@NotEmpty(message = "El campo 'Apellido' no debe estar vacío")
	@Size(min = 3 , max = 20)
	private String apellido;
	
	//NotBlank (También existe este campo que valida si algo esta vacio)
	@NotEmpty(message = "El campo 'Correo' no debe estar vacío")
	@Email
	private String correo;
	
	public Usuario() {
		
	}
	
	public Usuario(String nombre, String apellido, String correo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + "]";
	}
	
}
