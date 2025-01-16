package com.entrenamientospring.interfaceServices;

import java.util.List;
import java.util.Optional;
import com.entrenamientospring.models.Producto;

public interface InterfaceProductoService {
	
	//Aquí van a estar los métodos del CRUD.
	//Sería el equivalente al DAO en JSP.
	
	public List<Producto>listadoProducto();
	
	public List<Producto>listadoProductosInactivos ();
	
	public int guardarProducto(Producto prod);
	
	public void desactivarProducto(int id);
	
	public Optional<Producto>consultarProducto(int id); 
	//Editar o actualizar.
	
	public Producto productoDetalle(int id);
}
 