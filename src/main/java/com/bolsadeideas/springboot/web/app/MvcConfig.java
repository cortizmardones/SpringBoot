package com.bolsadeideas.springboot.web.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	
	@Autowired
	@Qualifier("TiempoTranscurridoInterceptor")
	private HandlerInterceptor tiempoTranscurridoInterceptor;
	
	@Autowired
	@Qualifier("horario")
	private HandlerInterceptor horario;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		
		//OJO IMPORANTE:
		//SI NO ESPECIFICO A QUE RUTA VA AFECTAR ESTE INTERCEPTOR SE VA A APLICAR A TODOS LOS METODOS DEL CONTROLADOR
		
		//registry.addInterceptor(tiempoTranscurridoInterceptor); //.addPathPatterns("/rutas","/rutas");
		
		
		//En esta parte excluyo estas 2 rutas para evitar que se forme un loop infinito de redirecciones.
		registry.addInterceptor(horario).excludePathPatterns("/app/fueraDeHorario","/app/loggin");
	}
	
}
