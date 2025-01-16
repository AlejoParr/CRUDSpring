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
import com.entrenamientospring.interfaceServices.InterfaceProductoService;
import com.entrenamientospring.interfaceServices.InterfaceProveedorService;
import com.entrenamientospring.models.Producto;
import com.entrenamientospring.models.Proveedor;

@Controller
@RequestMapping
public class ProductoController {
	
	@Autowired
	private InterfaceProductoService serviceProducto;
	
	@Autowired
	private InterfaceProveedorService serviceProveedor;
	
	@GetMapping("Producto/listadoProducto")
	public String listadoProducto(Model model) {
		List<Producto> producto = serviceProducto.listadoProducto();
		model.addAttribute("Producto", producto);
		return "Producto/listadoProducto"; //Retorna la vista listadoProducto
	}
	
	@GetMapping("Producto/listarProductosInactivos")
	public String listadoProductosInactivos(Model model) {
		List<Producto> producto = serviceProducto.listadoProductosInactivos();
		model.addAttribute("Producto", producto);
		return "Producto/listarProductosInactivos";
	} 
	
	@GetMapping("Producto/insertarProducto") 
	public String vistaGuardar(Model model) { 
		List<Proveedor> proveedor = serviceProveedor.listadoProveedor();
		model.addAttribute ("producto", new Producto()); 
		model.addAttribute("proveedor", proveedor);
		return "Producto/insertarProducto";  //Retorna la vista de guargar nuevo producto. 
	}
	
	@PostMapping("Producto/guardarProducto")   
	public String guardarProducto(@Validated Producto prod, Model model) {
		serviceProducto.guardarProducto(prod); //Trae los datos almacenados en la variable prod. 
		return "redirect:/Producto/listadoProducto"; 	
	}
	
	@GetMapping("Producto/actualizarProducto/{id}")
	public String actualizarProducto(@PathVariable int id, Model model) {
		Optional<Producto> producto = serviceProducto.consultarProducto(id); //Consulta la información del producto 
		model.addAttribute("producto", producto);
		List<Proveedor> proveedor = serviceProveedor.listadoProveedor(); //Trae a la vista el listado de proveedores
		model.addAttribute("proveedor", proveedor);
		return "Producto/actualizarProducto";
	}
	
	@GetMapping("Producto/desactivarProducto/{id}") 
	public String desactivarProducto(@PathVariable int id, Model model) {
		Optional<Producto> producto = serviceProducto.consultarProducto(id);
		List<Proveedor> proveedor = serviceProveedor.listadoProveedor();
		model.addAttribute("producto", producto);
		model.addAttribute("proveedor", proveedor); //Trae a la vista el listado de proveedores
		return "/Producto/desactivarProducto";
	}
}
