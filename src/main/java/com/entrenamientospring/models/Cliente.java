package com.entrenamientospring.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity //Importa la librería Entity
@Table(name = "cliente") //Importa la librería Table y crea la tabla "cliente"


public class Cliente {
	@Id //Se define el Id como primary key y también se importa la librería. 
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Se crearán las variables listadas dentro de la clase. 
	private int Id;
	private String Nombre;
	private String Cedula;
	private String Direccion; 
	private String Telefono;
	
	//Método constructor creado con el asistente de Spring. 
		public Cliente(int id, String nombre, String cedula, String direccion, String telefono) {

			Id = id;
			Nombre = nombre;
			Cedula = cedula;
			Direccion = direccion;
			Telefono = telefono;
		}
		
		public Cliente () {
			
		}
		
		/*Getters y Setters para los atributos, pero generados 
		 desde click derecho, luego Source y generar getters y setters. */
		
		public int getId() {
			return Id;
		}
		public void setId(int id) {
			Id = id;
		}
		public String getNombre() {
			return Nombre;
		}
		public void setNombre(String nombre) {
			Nombre = nombre;
		}
		public String getCedula() {
			return Cedula;
		}
		public void setCedula(String cedula) {
			Cedula = cedula; 
		}
		public String getDireccion() {
			return Direccion;
		}
		public void setDireccion(String direccion) {
			Direccion = direccion;
		}
		public String getTelefono() {
			return Telefono;
		}
		public void setTelefono(String telefono) {
			Telefono = telefono;
		}  

}