package com.bolsadeideas.springboot.web.app.interceptors;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component("TiempoTranscurridoInterceptor")
public class TiempoTranscurridoInterceptor implements HandlerInterceptor{
	
	private static final Logger logger = LoggerFactory.getLogger(TiempoTranscurridoInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		//Por si quiero ver que ruta estoy invocando
//		if(handler instanceof HandlerMethod) {
//			HandlerMethod metodo = (HandlerMethod) handler;
//			logger.info("Se llamo a la ruta: " + metodo.getMethod().getName());
//		}
		
		logger.info("Tiempo Transcurrido Interceptor: preHandle() entrando ... ");
		long tiempoInicio = System.currentTimeMillis();
		//Guarda en el request el tiempo de inicio para restarlo en el siguiente metodo.
		request.setAttribute("tiempoInicio", tiempoInicio);
		
		//Simulación de delay (DEMORA PROGRAMADA)
//		Random random = new Random();
//		Integer demora = random.nextInt(500);
//		Thread.sleep(demora);
		
		return true;
		
		
		//Ejemplo si no pasamos la validacion y no queremos que el usuario siga navegando y redirigirlo a una ruta especifica
//		response.sendRedirect(request.getContextPath().concat("/login"));
//		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
		long tiempoFin = System.currentTimeMillis();
		//Acá traigo la propiedad del metodo preHandle
		long tiempoInicio = (Long) request.getAttribute("tiempoInicio");
		double tiempoTranscurrido = tiempoFin - tiempoInicio;
		double segundos = tiempoTranscurrido/1000;
		
		//Paso de atributo a la vista
		if( handler instanceof HandlerMethod && modelAndView != null) {
			modelAndView.addObject("TiempoTranscurrido", segundos);
		}
		
		logger.info("Tiempo transcurrido: " + tiempoTranscurrido + "milisegundos");
		logger.info("Tiempo Transcurrido Interceptor: preHandle() saliendo ... ");
	}

}
