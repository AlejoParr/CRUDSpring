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
import com.entrenamientospring.interfaceServices.InterfaceClienteService;
import com.entrenamientospring.models.Cliente;


@Controller
@RequestMapping // Realiza un mapping de la base de datos. 
public class ClienteController {
	
	@Autowired
	private InterfaceClienteService serviceCliente; //Trae la lista de los clientes desde la interfaz de servicio
	
	@GetMapping("Cliente/listadoCliente") //Equivale a la ruta de acceso de JSP 
	public String listadoCliente(Model model) { 
		
		List<Cliente> cliente = serviceCliente.listadoCliente(); //Usa la variable cliente como parámetro para traer la información...
														  // ...desde el modelo cliente y la envía a la lista.
		
		model.addAttribute("Cliente", cliente); //Asigna la información a la vista "Cliente" desde la variable...
											   // ...cliente creada en la línea de arriba. 
		return "Cliente/listadoCliente";  //Retorna la vista del listado de los clientes.  
	}
	
	@GetMapping("Cliente/insertarCliente") 
	public String vistaGuardar(Model model) { 
		model.addAttribute ("cliente", new Cliente()); //Crea el nuevo cliente y le asigna los parámetros que vienen del model
		return "Cliente/insertarCliente"; 
		//Retorna la vista de guargar nuevo cliente. 
	}
	
	@PostMapping("Cliente/guardarCliente")   
	public String guardarCliente(@Validated Cliente c, Model model) {
		serviceCliente.guardarCliente(c); //Trae los datos almacenados en la variable c. 
		return "redirect:/Cliente/listadoCliente"; 	
	}
	
	@GetMapping("Cliente/actualizarCliente/{id}")
	public String actualizarCliente(@PathVariable int id, Model model) {
		Optional<Cliente> cliente = serviceCliente.consultarCliente(id); //Consulta la información del cliente
		model.addAttribute("cliente", cliente);
		return "Cliente/actualizarCliente";
	}
	
	@GetMapping("Cliente/borrarCliente/{id}") 
	public String borrarCliente(@PathVariable int id, Model model) {
		serviceCliente.borrarCliente(id);
		return "redirect:/Cliente/listadoCliente"; 
	}
}


