package com.entrenamientospring.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entrenamientospring.interfaceServices.InterfaceUsuarioService;
import com.entrenamientospring.models.Usuario;

@Controller
@RequestMapping
public class UsuarioController {
	
	@Autowired
	private InterfaceUsuarioService serviceUsuario;
	
	@GetMapping("Usuario/listadoUsuario")
	public String listadoUsuario(Model model) {
		
		List<Usuario> usuario = serviceUsuario.listadoUsuario();
		model.addAttribute("Usuario", usuario);
		return "Usuario/listadoUsuario";
	}
	
	@GetMapping("Usuario/insertarUsuario") 
	public String vistaGuardar(Model model) { 
		model.addAttribute ("usuario", new Usuario()); //Crea el nuevo cliente y le asigna los parámetros que vienen del model
		return "Usuario/insertarUsuario"; 
		//Retorna la vista de guargar nuevo cliente. 
	}
	
	@PostMapping("Usuario/guardarUsuario") 
	public String guardarUsuario(@Validated Usuario us, Model model) {
		serviceUsuario.guardarUsuario(us); //Trae los datos almacenados en la variable us. 
		return "redirect:/Usuario/listadoUsuario"; 	
	}
	
	@GetMapping("Usuario/actualizarUsuario/{id}")
	public String actualizarCliente(@PathVariable int id, Model model) {
		Optional<Usuario> usuario = serviceUsuario.consultarUsuario(id); //Consulta la información del cliente
		model.addAttribute("usuario", usuario);
		return "Usuario/actualizarUsuario";
	}
	
	@GetMapping("Usuario/borrarUsuario/{id}") 
	public String borrarCliente(@PathVariable int id, Model model) {
		serviceUsuario.borrarUsuario(id);
		return "redirect:/Usuario/listadoUsuario";
	}
}
