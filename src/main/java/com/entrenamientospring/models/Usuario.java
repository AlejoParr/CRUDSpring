package com.entrenamientospring.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
	
@Entity
@Table (name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String username;
	private String password;
	private String email;
	private String nombre_completo;
	private String rol;
	
	public Usuario(int id, String username, String password, String email, String nombre_completo, String rol) {
		Id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.nombre_completo = nombre_completo;
		this.rol = rol;
	} 
	
	public Usuario() {	//Constructor vacío para verificar si está loggeado
	}
	


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre_completo() {
		return nombre_completo;
	}

	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}


	}
