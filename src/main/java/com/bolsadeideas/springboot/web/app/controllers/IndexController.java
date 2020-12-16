package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bolsadeideas.springboot.web.app.model.IInyeccion;
import com.bolsadeideas.springboot.web.app.model.ListaUsuario;
import com.bolsadeideas.springboot.web.app.model.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	//Autowired - Este atributo es para que la clase Inyeccion quede como inyección y no tenga que utilizar la palabra reservada 'new' object.
	//Ademas agrego un qualifier para indicar que dependencia quiero implementacion quiero inyectar.
	@Autowired
	@Qualifier("MiservicioComplejo")
	private IInyeccion inyeccion;
	
	@Autowired
	private ListaUsuario listaUsuarios;
	
	//Inyección de texto desde el application.properties
	@Value("${texto.indexcontroller.pruebainyecciontexto}")
	private String textoPrueba;
	
	//GetMapping o PostMapping igual existen y dan lo mismo.
	
	//Cada vez que se llame a la ruta / se va a ejecutar el metodo de abajo - de tipo GET
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	//Controlador con datos desde el modelo (Creando un objeto desde el modelo)
	@RequestMapping("/usuario")
	public String usuario(Model model) {
		
		Usuario usuario = new Usuario();
		usuario.setNombre("Carlos Alberto");
		usuario.setApellido("Ortiz 	Mardones");
		usuario.setCorreo("cortizmardones@gmail.com");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", textoPrueba);
		
		return "usuario";
	}
	
	//Controlador con datos desde el modelo
	@RequestMapping("/usuarios")
	public String usuarios(Model model) {
	
		model.addAttribute("listaUsuarios", listaUsuarios.listarUsuario());
		model.addAttribute("titulo", "Vista Lista Usuarios");
		
		return "usuarios";
	}
	
	//Rutas con parametros - Se especifica que sea opcional y se le agrega un valor por defecto.
	@RequestMapping("/parametro")
	public String parametro(@RequestParam(name="parametro" , required = false , defaultValue = "Default Value") String parametro , Model model) {
		model.addAttribute("parametro", "El parametro enviado es : " + parametro);
		return "parametro";
	}
	
	//Metodo con mas de un parametro.
	@RequestMapping("/parametroNumerico")
	public String parametroNumerico(@RequestParam(name="nombre") String nombre, @RequestParam(name="edad") int edad , Model model) {
		model.addAttribute("parametro", "El nombre enviado es : " + nombre + " y su edad es : " + edad );
		return "parametro";
	}
	
	//Lo mismo de arriba pero de otra forma.
	@RequestMapping("/parametroRequest")
	public String parametroNumerico(HttpServletRequest request , Model model) {
		String nombre = request.getParameter("nombre");
		Integer edad = Integer.parseInt(request.getParameter("edad"));
		model.addAttribute("parametro", "El nombre enviado es : " + nombre + " y su edad es : " + edad );
		return "parametro";
	}
	
	//Metodo con mas de un parametro.
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam(name="nombre") String nombre , @RequestParam(name="apellido") String apellido , @RequestParam(name="correo") String correo, Model model) {
		Usuario usuario = new Usuario(nombre,apellido,correo);
		listaUsuarios.eliminarUsuario(usuario);
		model.addAttribute("listaUsuarios", listaUsuarios.listarUsuario());
		return "usuarios";
	}
	
	//PATH VARIABLES
	@RequestMapping("/eliminarPath/{nombre}/{apellido}/{correo}")
	public String eliminarPath(@PathVariable String nombre , @PathVariable String apellido , @PathVariable String correo , Model model) {

		Usuario usuario = new Usuario(nombre,apellido,correo);
		listaUsuarios.eliminarUsuario(usuario);
		model.addAttribute("listaUsuarios", listaUsuarios.listarUsuario());
		return "usuarios";
	}
	
	@RequestMapping("/agregar/{nombre}/{apellido}/{correo}")
	public String path(@PathVariable String nombre ,@PathVariable String apellido ,@PathVariable String correo , Model model) {
		
		listaUsuarios.insertarUsuario(new Usuario(nombre, apellido, correo));
		model.addAttribute("listaUsuarios", listaUsuarios.listarUsuario());
		return "usuarios";
	}
	
	//En este metodo lo importante es el atributo NAME desde el HTML5 (Ese es el que hace que lleguen los valores al controlador)
	@RequestMapping("/agregar")
	public String agregar(@RequestParam(name="nombre") String nombre, @RequestParam(name="apellido") String apellido , @RequestParam(name="correo") String correo , Model model) {
		listaUsuarios.insertarUsuario(new Usuario(nombre, apellido, correo));
		model.addAttribute("listaUsuarios", listaUsuarios.listarUsuario());
		return "usuarios";
	}
	
		
	//Redirecciones con redirect (Recarga la página y pierdo las propiedades http) 
	//En este caso me redirige la ruta /otraForma desde el inicio del proyecto al listado de usuarios.
	@RequestMapping("/redirect")
	public String redirect() {
		return "redirect:/app/usuarios";
		//return "redirect:https://www.google.cl";
	}
	
	//Redirecciones con forward (No recarga la página) 
	//(Los parametros del request http no se pierden ni cambia la url , es para enmascarar las url)
	@RequestMapping("/forward")
	public String forward() {
		return "forward:/app/usuarios";
	}
	
	//Inyección de dependencias
	@RequestMapping("/inyeccion")
	public String inyeccion(Model model) {
		model.addAttribute("inyeccion",inyeccion.inyectarDependencias());
		return "inyeccion";
	}
		
	////Controlador con datos desde el modelo (MODEL ATRIBUTTE Generalmente se ocupa para llenar valores por defecto en formularios)
	@ModelAttribute()
	public List<String> listaFormulario(Model model){
		List<String> listaFormulario = new ArrayList<String>();
		listaFormulario.add("Dato 1");
		listaFormulario.add("Dato 2");
		listaFormulario.add("Dato 3");
		listaFormulario.add("Contabilidad");
		listaFormulario.add("Informática");
		listaFormulario.add("Recursos Humanos");
		listaFormulario.add("Cobranzas");
		listaFormulario.add("Atención a clientes");
		listaFormulario.add("Oficina de partes");
		listaFormulario.add("Otros");
		model.addAttribute("listaFormulario", listaFormulario);
		return listaFormulario;
	}
	
	//Probar y llevar esos datos a un formulario.
	@RequestMapping("/formulario")
	public String formulario(Model model){
		model.addAttribute("listaFormulario", listaFormulario(model));
		return "formulario";
	}
	
	
	//Investigar sobre el postConstruct y el preDestroy (Video 43 udemy)
	
	//Mapear un controlador a mas de una ruta y especificando el verbo HTTP
	@RequestMapping(value={"/contact","/home"} , method = RequestMethod.GET)
	//@RequestMapping(value={"/contact","/home"} , method = RequestMethod.POST)
	public String ruta_random() {
		return "hola mundo";
	}
	
}
