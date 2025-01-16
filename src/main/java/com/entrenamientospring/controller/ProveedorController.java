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
import com.entrenamientospring.interfaceServices.InterfaceProveedorService;
import com.entrenamientospring.models.Proveedor;

@Controller
@RequestMapping
public class ProveedorController {
	
	@Autowired
	public InterfaceProveedorService serviceProveedor;
	
	@GetMapping("Proveedor/listadoProveedor")
	public String listadoProveedor (Model model) {
		List<Proveedor> proveedor = serviceProveedor.listadoProveedor();
		model.addAttribute("Proveedor", proveedor);
		return "Proveedor/listadoProveedor";
	}
	
	@GetMapping("Proveedor/insertarProveedor") 
	public String vistaGuardar(Model model) { 
		model.addAttribute ("proveedor", new Proveedor()); //Crea el nuevo proveedor y le asigna los parámetros que vienen del model
		return "Proveedor/insertarProveedor";
		//Retorna la vista para insertar el Proveedor.
	}
	
	@PostMapping("Proveedor/guardarProveedor") 
	public String guardarProveedor(@Validated Proveedor pro, Model model) {
		serviceProveedor.guardarProveedor(pro); //Trae los datos almacenados en la variable pro. 
		return "redirect:/Proveedor/listadoProveedor"; //Una vez guardado, lleva a la vista del listado. 
	}
	
	@GetMapping("Proveedor/actualizarProveedor/{id}")
	public String actualizarProveedor(@PathVariable int id, Model model) {
		Optional<Proveedor> proveedor = serviceProveedor.consultarProveedor(id); //Consulta la información del cliente
		model.addAttribute("proveedor", proveedor);
		return "Proveedor/actualizarProveedor";
	}
	
	@GetMapping("Proveedor/borrarProveedor/{id}") 
	public String borrarProveedor(@PathVariable int id, Model model) {
		serviceProveedor.borrarProveedor(id); // Elimina la info del ID
		return "redirect:/Proveedor/listadoProveedor"; // Carga la vista listado con la información actualizada. 
	}
}
