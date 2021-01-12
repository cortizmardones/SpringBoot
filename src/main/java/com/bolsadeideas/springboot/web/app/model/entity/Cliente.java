package com.bolsadeideas.springboot.web.app.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
//la anotación table es para darle otro nombre a la tabla - si no esta por default se llamara igual que la clase
@Table(name = "clientes")
public class Cliente implements Serializable {

	// Este anotación indica que sera la llave primaria
	@Id
	// Esta anotación es para la programación de las secuencias , si son autoincrementales , etc
	/*Para que funcionar la clausula IDENTITY tuve que crear la restricción en la bdd primero.
	 * 	ALTER TABLE `db_springboot`.`clientes` 
		CHANGE COLUMN `id` `id` INT NOT NULL AUTO_INCREMENT ;
	 * */
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	private String nombre;
	private String apellido;
	private String email;

	// Esta anotación es para cambiar el nombre del campo en la tabla.
	@Column(name = "create_at")
	
	// Esta anotación establece el tipo de dato fecha
//	@Temporal(TemporalType.DATE)
//	//Formato a la fecha
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private String createAt;
	
	// Esta anotación es para cambiar el nombre del campo en la tabla.
	@Column(name = "id_comuna")
	private int comuna;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreateAt() {
		return createAt;
	}

	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}
	
	public int getComuna() {
		return comuna;
	}

	public void setComuna(int comuna) {
		this.comuna = comuna;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

}
