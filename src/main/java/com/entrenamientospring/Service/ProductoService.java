package com.entrenamientospring.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entrenamientospring.interfaceServices.InterfaceProductoService;
import com.entrenamientospring.interfaces.ProductoInterface;
import com.entrenamientospring.models.Producto;

/*Esta clase va a la base de datos y trae la información,
 sin la necesidad de un PreparedStatement o una sentencia SQL.*/

//Spring cuneta con una función para traer de manera automática los métodos de la interfaz. 

@Service //NO OLVIDAR importar esta librería !!!
public class ProductoService implements InterfaceProductoService {
	@Autowired //La librería permite el manejo de la info que llega de la base de datos. 
	private ProductoInterface datosProducto; 
	
	

	public ProductoService() {
		
	}

	@Override
	public List<Producto> listadoProducto() {
		return (List<Producto>)datosProducto.consultarProductosActivos();
	}
	
	@Override
	public List<Producto> listadoProductosInactivos() {
		return (List<Producto>)datosProducto.consultarProductosInactivos();
	}

	@Override
	public int guardarProducto(Producto prod) {
		int resultado = 0;
		Producto producto = datosProducto.save(prod);
		if (!producto.equals(null)) {
			resultado = 1;
		}
		return resultado;
	}

	@Override
	public void desactivarProducto(int id) {
		//datosProducto.deleteById(id);
		
	}

	@Override
	public Optional<Producto> consultarProducto(int id) {
		
		return datosProducto.findById(id);
	}

	@Override
	public Producto productoDetalle(int id) {
		
		return datosProducto.getReferenceById(id); //Nuevo método, ya que getById está obsoleto. 
	}
 
}

