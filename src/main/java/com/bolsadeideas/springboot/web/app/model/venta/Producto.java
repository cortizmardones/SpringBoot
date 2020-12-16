package com.bolsadeideas.springboot.web.app.model.venta;

public class Producto {

	private String nombre;
	private Integer precio;

	public Producto() {
	}

	public Producto(String nombre, Integer precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", precio=" + precio + "]";
	}

}
