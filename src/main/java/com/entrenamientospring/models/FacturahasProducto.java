package com.entrenamientospring.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity 
@Table(name = "facturahasproducto") 

public class FacturahasProducto {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int Id;
	private int Cantidad;
	
	@ManyToOne //Relación de muchos a uno entre producto y factura 
	@JoinColumn(name = "Producto_id") // Definición de la llave foranea 
	private Producto producto; //Instancia del modelo 
	
	@ManyToOne //Relación de muchos a uno entre cliente y factura 
	@JoinColumn(name = "Factura_id") // Definición de la llave foranea
	private Factura factura; //Instancia del modelo 

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getCantidad() {
		return Cantidad;
	}

	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}



}
