package com.bolsadeideas.springboot.web.app.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ListaUsuario {

	private List<Usuario> listaUsuarios = new ArrayList<>();

	public ListaUsuario() {
	}

	public int size() {
		return listaUsuarios.size();
	}

	public void insertarUsuario(Usuario usuario) {
		listaUsuarios.add(usuario);
	}

	public void eliminarUsuario(Usuario usuario) {

		for (int i = 0; i < listaUsuarios.size(); i++) {
			if (listaUsuarios.get(i).getNombre().equals(usuario.getNombre()) && listaUsuarios.get(i).getApellido().equals(usuario.getApellido()) && listaUsuarios.get(i).getCorreo().equals(usuario.getCorreo())) {
				listaUsuarios.remove(i);
			}
		}
	}

	public List<Usuario> listarUsuario() {
		return listaUsuarios;
	}

}
