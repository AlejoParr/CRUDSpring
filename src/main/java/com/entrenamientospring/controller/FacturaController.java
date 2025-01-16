package com.entrenamientospring.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entrenamientospring.interfaceServices.InterfaceClienteService;
import com.entrenamientospring.interfaceServices.InterfaceFacturaService;
import com.entrenamientospring.interfaceServices.InterfaceFacturahasProductoService;
import com.entrenamientospring.interfaceServices.InterfaceProductoService;
import com.entrenamientospring.models.Cliente;
import com.entrenamientospring.models.Factura;
import com.entrenamientospring.models.FacturahasProducto;
import com.entrenamientospring.models.Producto;

@Controller
@RequestMapping
public class FacturaController {

	@Autowired
	private InterfaceFacturaService serviceFactura; 
	
	@Autowired
	private InterfaceClienteService serviceCliente; 
	
	@Autowired
	private InterfaceProductoService serviceProducto; 
	
	@Autowired 
	private InterfaceFacturahasProductoService serviceDetalle; 
	
	@GetMapping("Factura/listadoFactura") //Equivale a la ruta de acceso de JSP 
	public String listadoFactura(Model model) { 
		
		List<Factura> factura = serviceFactura.listadoFactura(); 
		
		model.addAttribute("Factura", factura); //Asigna la información a la vista "Factura" desde la variable factura creada en la línea de arriba. 
		return "Factura/listadoFactura";  //Retorna la vista 
	}
	
	@GetMapping("Factura/insertarFactura") 
	public String vistaGuardar(Model model) { 
		List<Cliente> cliente=serviceCliente.listadoCliente();
		List<Producto> producto=serviceProducto.listadoProducto(); 
		model.addAttribute ("factura", new Factura()); //Crea la nueva factura y le asigna los parámetros que vienen del model
		model.addAttribute ("cliente", cliente);
		model.addAttribute("producto", producto);
		Date fecha = new Date(); //Trae la fecha desde la utilidad de Java
		SimpleDateFormat formato = new SimpleDateFormat ("dd/MM/yyyy");
		String fechaFormateada = formato.format(fecha);	
		model.addAttribute("fecha", fechaFormateada);
		return "Factura/insertarFactura"; //Retorna la vista de guargar nueva Factura. 
	}
	
	@PostMapping("Factura/guardarFactura")   
	public String guardarFactura(@Validated @RequestParam("cantidad") List<Integer> cantidad, @RequestParam("producto") List<Integer> producto, 
			@ModelAttribute ("factura") Factura fact, @ModelAttribute ("facturahasproducto") FacturahasProducto facthasprod, Model model) {
		serviceFactura.guardarFactura(fact); 
		
		for (int i = 0; i < cantidad.size(); i++) {
		FacturahasProducto facturahasproducto = new FacturahasProducto(); 
		//Se debe hacer una nueva instancia en cada ciclo de lo contrario no va a guardar cada el resultado de cada uno. 
		facturahasproducto.setFactura(fact);
		facturahasproducto.setCantidad(cantidad.get(i));
		//Como esta llegando todo el objeto producto, necesitamos consultar solo su ID	
		Producto productoresultado = serviceProducto.productoDetalle(producto.get(i));
		facturahasproducto.setProducto(productoresultado);
		serviceDetalle.guardarFacturahasProducto(facturahasproducto);
		}
		return "redirect:/Factura/listadoFactura";	
	} 
	
	@GetMapping("Factura/actualizarFactura/{id}")
	public String actualizarFactura(@PathVariable int id, Model model) {
		Optional<Factura> factura = serviceFactura.consultarFactura(id); //Consulta la información de la factura
		model.addAttribute("factura", factura); //Asigan la nueva información 
		return "Factura/actualizarFactura";
	}
	
	@GetMapping("Factura/borrarFactura/{id}") 
	public String borrarFactura(@PathVariable int id, Model model) {
		serviceFactura.borrarFactura(id);
		return "redirect:/Factura/listadoFactura"; 
	}
	
	@GetMapping("Factura/imprimirFactura/{id}") 
	public String imprimirFactura (@PathVariable int id, Model model) { 
		Optional<Factura> factura = serviceFactura.consultarFactura(id); 
		List<FacturahasProducto> facturahasproducto = serviceDetalle.listarProductosDetalle(id); 
		model.addAttribute("Factura", factura);
		model.addAttribute("listadoproductos", facturahasproducto);
		int contador = 0;
		model.addAttribute("contador", contador);
		return "Factura/imprimirFactura"; 
	}
}
