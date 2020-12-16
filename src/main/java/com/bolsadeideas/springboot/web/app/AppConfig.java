package com.bolsadeideas.springboot.web.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.bolsadeideas.springboot.web.app.model.venta.ItemFactura;
import com.bolsadeideas.springboot.web.app.model.venta.Producto;

@Configuration
public class AppConfig {

	@Bean("itemsFactura")
	@Primary
	public List<ItemFactura> registrarItems(){
		Producto producto1 = new Producto("Camara Sony" , 89990);
		Producto producto2 = new Producto("Bicicleta Bianchi" , 299000);
		Producto producto3 = new Producto("Notebook Lenovo V310" , 315000);
		Producto producto4 = new Producto("Monitor Samsung VRT-500" , 69990);
		Producto producto5 = new Producto("Motorola One Hyper" , 196000);
		Producto producto6 = new Producto("Enchufe Alargador Baticcino" , 8990);
		
		ItemFactura linea1 = new ItemFactura(producto1, 2);
		ItemFactura linea2 = new ItemFactura(producto2, 2);
		ItemFactura linea3 = new ItemFactura(producto3, 2);
		ItemFactura linea4 = new ItemFactura(producto4, 2);
		ItemFactura linea5 = new ItemFactura(producto5, 2);
		ItemFactura linea6 = new ItemFactura(producto6, 2);
		
		return Arrays.asList(linea1,linea2,linea3,linea4,linea5,linea6);
	
	}
	
	@Bean("itemsFacturaOficina")
	public List<ItemFactura> registrarItemsOficina(){
		Producto producto1 = new Producto("Monitor LG LCD 24" , 89990);
		Producto producto2 = new Producto("Notebook Asus" , 299000);
		Producto producto3 = new Producto("Impresora Multifuncional HP" , 315000);
		Producto producto4 = new Producto("Escritorio oficina" , 69990);
		
		ItemFactura linea1 = new ItemFactura(producto1, 2);
		ItemFactura linea2 = new ItemFactura(producto2, 2);
		ItemFactura linea3 = new ItemFactura(producto3, 2);
		ItemFactura linea4 = new ItemFactura(producto4, 2);

		
		return Arrays.asList(linea1,linea2,linea3,linea4);
	
	}
	
}
