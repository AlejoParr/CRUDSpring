package com.entrenamientospring.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity //Importa la librería Entity
@Table(name = "factura") //Importa la librería Table y crea la tabla "factura"

public class Factura {
	@Id //Se define el Id como primary key y también se importa la librería. 
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Se crearán las variables listadas dentro de la clase. 
	private int Id;
	private String Fecha;
	private int Total;
	
	@ManyToOne 
	@JoinColumn(name = "Cliente_id") // Definición de la llave foranea
	private Cliente cliente; //Instancia del modelo del Cliente. 

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	public int getTotal() {
		return Total;
	}

	public void setTotal(int total) {
		Total = total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	
}

