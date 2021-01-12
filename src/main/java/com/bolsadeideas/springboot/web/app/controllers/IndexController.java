package com.bolsadeideas.springboot.web.app.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import com.bolsadeideas.springboot.web.app.model.IInyeccion;
import com.bolsadeideas.springboot.web.app.model.ListaUsuario;
import com.bolsadeideas.springboot.web.app.model.Loggin;
import com.bolsadeideas.springboot.web.app.model.Usuario;
import com.bolsadeideas.springboot.web.app.model.dao.IClienteDao;
import com.bolsadeideas.springboot.web.app.model.dao.IComunaDao;
import com.bolsadeideas.springboot.web.app.model.entity.Cliente;
import com.bolsadeideas.springboot.web.app.validation.UsuarioValidate;

@Controller
@RequestMapping("/app")
@SessionAttributes("usuario")
public class IndexController {

	// ################## INICIO ATRIBUTOS ##################

	// Autowired - Este atributo es para que la clase Inyeccion quede como inyección
	// y no tenga que utilizar la palabra reservada 'new' object.
	// Ademas agrego un qualifier para indicar que dependencia quiero implementacion
	// quiero inyectar (Puedo elegir más de una).
	@Autowired
	@Qualifier("MiservicioComplejo")
	private IInyeccion inyeccion;

	// Inyección de texto desde el application.properties
	@Value("${texto.indexcontroller.pruebainyecciontexto}")
	private String textoPrueba;

	@Autowired
	private ListaUsuario listaUsuarios;

//	@Autowired
//	private UsuarioValidate validador;

//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		binder.setValidator(validador);
//		//binder.addValidators(validador);
//	}

	// ################## FIN ATRIBUTOS ##################
	
	
	
	
	

	// ################## INICIO MODEL ATRIBUTTES ##################

	//// Controlador con datos desde el modelo (MODEL ATRIBUTTE Generalmente se
	//// ocupa para llenar valores por defecto en formularios)
	@ModelAttribute()
	public List<String> listaFormulario(Model model) {
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

	// ################## FIN MODEL ATRIBUTTES ##################
	
	
	
	
	
	
	
	// ################## INICIO METODOS MUERTOS ##################
	
	// Metodo para agregar por path relativos.
//	@RequestMapping("/agregar/{nombre}/{apellido}/{correo}")
//	public String path(@PathVariable String nombre ,@PathVariable String apellido ,@PathVariable String correo , Model model) {
//		
//		listaUsuarios.insertarUsuario(new Usuario(nombre, apellido, correo));
//		model.addAttribute("listaUsuarios", listaUsuarios.listarUsuario());
//		return "usuarios";
//	}

// En este metodo lo importante es el atributo NAME desde el HTML5 (Ese es el
// que hace que lleguen los valores al controlador)
//	@RequestMapping("/agregar")
//	public String agregar(@RequestParam(name="nombre") String nombre, @RequestParam(name="apellido") String apellido , @RequestParam(name="correo") String correo , Model model) {
//		listaUsuarios.insertarUsuario(new Usuario(nombre, apellido, correo));
//		model.addAttribute("listaUsuarios", listaUsuarios.listarUsuario());
//		return "usuarios";
//	}

// Este metodo funciona igual que el de arriba pero con la inyección del usuario
// directo (evito la palabra new) siempre y cuando los name del HTML se llamen
// igual a los atributos de la clase Usuario
// Agregando el th:object en el formulario ya no necesito el name y el th:value
// en el formulario porque el formulario se asocio al objeto usuario con el tag
// th:object="${usuario}
//	@RequestMapping("/agregar")
//	public String agregar(@Valid Usuario usuario, BindingResult result, Model model , SessionStatus status) throws ParseException {
//
//		if (result.hasErrors()) {
//			
//			//Si implemento estas logicas tengo que cambiar las lineas comentadas en el html de la vista.
////			Map<String, String> errores = new HashMap<>();
//			// Forma más corta de recorrer los errores.
////			result.getFieldErrors().forEach(err->{
////			errores.put(err.getField(),"El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
////			});
//			//Forma tradicional de recorrer los errores.
////			for (int i = 0; result.getFieldErrors().size() > i; i++) {
////				errores.put(result.getFieldErrors().get(i).getField(),"El campo ".concat(result.getFieldErrors().get(i).getField()).concat(" ").concat(result.getFieldErrors().get(i).getDefaultMessage()));
////			}
////			model.addAttribute("listaUsuarios", listaUsuarios.listarUsuario());
////			model.addAttribute("errores",errores);
//			model.addAttribute("listaUsuarios", listaUsuarios.listarUsuario());
//			return "usuarios";
//		}
//
//		listaUsuarios.insertarUsuario(usuario);
//		model.addAttribute("listaUsuarios", listaUsuarios.listarUsuario());
//		status.setComplete();
//		return "usuarios";
//	}
	// ################## INICIO METODOS MUERTOS ##################
	
	
	
	
	
	
	

	// ################## INICIO METODOS NORMALES ##################

	// GetMapping o PostMapping igual existen y dan lo mismo.

	// Cada vez que se llame a la ruta / se va a ejecutar el metodo de abajo - de
	// tipo GET
	@RequestMapping("/")
	public String index(Loggin loggin , Model model) {
		model.addAttribute("titulo", "Loggin de usuario");
		return "loggin";
	}
	
	@RequestMapping("/index")
	public String indice(Model model) {
		model.addAttribute("index", "Indice");
		return "index";
	}

	// Controlador con datos desde el modelo (Creando un objeto desde el modelo)
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

	// Rutas con parametros - Se especifica que sea opcional y se le agrega un valor
	// por defecto.
	@RequestMapping("/parametro")
	public String parametro(
			@RequestParam(name = "parametro", required = false, defaultValue = "Default Value") String parametro,
			Model model) {
		model.addAttribute("parametro", "El parametro enviado es : " + parametro);
		return "parametro";
	}

	// Metodo con mas de un parametro.
	@RequestMapping("/parametroNumerico")
	public String parametroNumerico(@RequestParam(name = "nombre") String nombre, @RequestParam(name = "edad") int edad,
			Model model) {
		model.addAttribute("parametro", "El nombre enviado es : " + nombre + " y su edad es : " + edad);
		return "parametro";
	}

	// Lo mismo de arriba pero de otra forma.
	@RequestMapping("/parametroRequest")
	public String parametroNumerico(HttpServletRequest request, Model model) {
		String nombre = request.getParameter("nombre");
		Integer edad = Integer.parseInt(request.getParameter("edad"));
		model.addAttribute("parametro", "El nombre enviado es : " + nombre + " y su edad es : " + edad);
		return "parametro";
	}

	// Metodo con mas de un parametro.
	@RequestMapping("/eliminar")
	public String eliminar(Usuario usuario, @RequestParam(name = "nombre") String nombre,
			@RequestParam(name = "apellido") String apellido, @RequestParam(name = "correo") String correo,
			Model model) {
		Usuario usuarioEntrante = new Usuario(nombre, apellido, correo);
		listaUsuarios.eliminarUsuario(usuarioEntrante);
		model.addAttribute("listaUsuarios", listaUsuarios.listarUsuario());
		return "usuarios";
	}

	// PATH VARIABLES
	@RequestMapping("/eliminarPath/{nombre}/{apellido}/{correo}")
	public String eliminarPath(Usuario usuario, @PathVariable String nombre, @PathVariable String apellido,
			@PathVariable String correo, Model model) {

		Usuario usuarioEntrante = new Usuario(nombre, apellido, correo);
		listaUsuarios.eliminarUsuario(usuarioEntrante);
		model.addAttribute("listaUsuarios", listaUsuarios.listarUsuario());
		return "usuarios";
	}

	// Redirecciones con redirect (Recarga la página y pierdo las propiedades http)
	// En este caso me redirige la ruta /otraForma desde el inicio del proyecto al
	// listado de usuarios.
	@RequestMapping("/redirect")
	public String redirect() {
		return "redirect:/app/usuarios";
		// return "redirect:https://www.google.cl";
	}

	// Redirecciones con forward (No recarga la página)
	// (Los parametros del request http no se pierden ni cambia la url , es para
	// enmascarar las url)
	// No funciona con sitios de intentet (El alcancé es solo dentro del proyecto)
	@RequestMapping("/forward")
	public String forward() {
		return "forward:/app/usuarios";
	}

	// Inyección de dependencias - Ocupa la propiedad del inicio de la clase
	@RequestMapping("/inyeccion")
	public String inyeccion(Model model) {
		model.addAttribute("inyeccion", inyeccion.inyectarDependencias());
		return "inyeccion";
	}

	// Probar y llevar esos datos a un formulario.
	@RequestMapping("/formulario")
	public String formulario(Model model) {
		model.addAttribute("listaFormulario", listaFormulario(model));
		return "formulario";
	}

	// Investigar sobre el postConstruct y el preDestroy (Video 43 udemy)

	// Mapear un controlador a mas de una ruta y especificando el verbo HTTP
	@RequestMapping(value = { "/contact", "/home" }, method = RequestMethod.GET)
	// @RequestMapping(value={"/contact","/home"} , method = RequestMethod.POST)
	public String ruta_random() {
		return "hola mundo";
	}

	// Metodos asociados al formulario

	// Controlador con datos desde el modelo
	@RequestMapping("/usuarios")
	public String usuarios(Usuario usuario, Model model) {

		model.addAttribute("listaUsuarios", listaUsuarios.listarUsuario());
		model.addAttribute("titulo", "Vista Lista Usuarios");

		return "usuarios";
	}

	@RequestMapping("/agregar")
	public String agregar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status)
			throws ParseException {

		// El status era para cuando tenemos un archivo null como los autoincrementables
		// en una BDD
		status.setComplete();

		if (result.hasErrors()) {
			model.addAttribute("listaUsuarios", listaUsuarios.listarUsuario());
			return "usuarios";
		}

		listaUsuarios.insertarUsuario(usuario);
		model.addAttribute("listaUsuarios", listaUsuarios.listarUsuario());

		// Comento esta linea porque cree el metodo initBinder
		// validador.validate(usuario, result);
		return "usuarios";
	}

	@RequestMapping("/loggin")
	public String loggin(Loggin loggin, Model model) {
		model.addAttribute("titulo", "Loggin de usuario");
		return "loggin";
	}

	@RequestMapping("/procesarLoggin")
	public String procesarLoggin(@Valid Loggin loggin, BindingResult result, Model model) {

		if (loggin.validarUsuario(loggin.getMail(), loggin.getPassword())) {
			model.addAttribute("index", "indice");
			return "index";
		} else {
			model.addAttribute("errorCredenciales", "Credenciales incorrectas");
			return "loggin";
		}
	}
	
	@RequestMapping("/fueraDeHorario")
	public String fueraDeHorario(Model model) {
		model.addAttribute("fueraDeHorario", "Usuario conectado fuera de horario");
		return "fueraDeHorario";
	}

	// ################## FIN METODOS NORMALES ##################
	
	
	
	
	
	
	
	
	
	
	// ################## INICIO JPA ##################
	
	@Autowired
	private IClienteDao IclienteDao;
	
	@Autowired
	private IComunaDao IcomunaDao; 
	
	@RequestMapping("/listaUsuariosBD")
	public String listarUsuarios(Model model , Cliente cliente) {
		//Traigo los datos de la bdd
		model.addAttribute("titulo", "Lista de usuarios");
		model.addAttribute("listaUsuariosBD", IclienteDao.findAll());
		model.addAttribute("listadoComunasBD",IcomunaDao.findAll());
		//Retorno la vista con la lista de usuarios.
		return "/listaUsuariosBD";
	}
	
	@RequestMapping("/agregarUsuarioBD")
	public String agregarUsuarioBD(Cliente cliente , Model model) {
		IclienteDao.save(cliente);
		//Agrego la redirección despues de agregar el usuario a la BDD para no tener que volver a generar la logica de listar los usuarios (Reutilizar metodo listar)
		return "redirect:/app/listaUsuariosBD";
	}
		
	// ################## FIN JPA ##################
	

}
