package com.bolsadeideas.springboot.web.app.interceptors;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

//Le pongo nombre al interceptor para despues inyectarlo especificamente a través de un qualifier
@Component("horario")
public class ValidadorHoraInterceptor implements HandlerInterceptor {
	
	//Con value traigo los mensajes desde el archivo application.properties
	@Value("${config.horario.apertura}")
	private Integer horaApertura;
	
	@Value("${config.horario.cierre}")
	private Integer horaCierre;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
				
		//Obtengo la hora del dia para validar si el usuario que entra al sistema esta dentro del horario de atención
		Calendar calendar = Calendar.getInstance();
		Integer hora = calendar.get(Calendar.HOUR_OF_DAY);
		
		//Si esta dentro del horario lo dejo pasar , si no lo redirigo a una rita de error.
		if( hora >= horaApertura && hora < horaCierre ) {
			
			StringBuilder mensaje = new StringBuilder("Bienvenido al horario de atención de clientes ");			
			mensaje.append(" , Si estas dentro del horario de atención");
			request.setAttribute("mensaje", mensaje.toString());
			return true;
			
		} else {
			
			//Redirigir si no esta dentro del horario de atención (ESTA REDIRECCIÓN NO ME LEE LOS DATOS DEL HEAD - LA VISTA APARECE SIN ESTILOS DE BOOTSTRAP)
			response.sendRedirect(request.getContextPath().concat("/app/fueraDeHorario"));
			return false;
		
		}
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
		//Recuperar el mensaje que cree arriba (Metodo Pre-handler)
		String mensaje = (String) request.getAttribute("mensaje");
		
		//Pasar datos a la vista
		if(modelAndView != null && request instanceof HandlerMapping) {
			modelAndView.addObject("mensaje",mensaje);
		}
		
	}
	
}
