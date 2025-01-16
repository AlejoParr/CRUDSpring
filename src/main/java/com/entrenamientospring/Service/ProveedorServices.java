package com.entrenamientospring.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entrenamientospring.interfaceServices.InterfaceProveedorService;
import com.entrenamientospring.interfaces.ProveedorInterface;
import com.entrenamientospring.models.Proveedor;

/*Esta clase va a la base de datos y trae la información,
sin la necesidad de un PreparedStatement o una sentencia SQL.*/

//Spring cuneta con una función para traer de manera automática los métodos de la interfaz.

@Service
public class ProveedorServices implements InterfaceProveedorService{
	
	@Autowired
	private ProveedorInterface datosProveedor; //Instancia de la Interface 
	
	@Override
	public List<Proveedor> listadoProveedor() { // Itera la base datos y trae todos los registros,reemplazando...
		  										// ...el ciclo while que se hubiera tenido que hacer en JSP.
		return (List<Proveedor>)datosProveedor.findAll();
	}

	@Override
	public int guardarProveedor(Proveedor pro) {
		int resultado = 0;
		Proveedor prove = datosProveedor.save(pro);
		if (!prove.equals(null)) { // La condición verifica si llega información. Si es así, la envía a la BD.
			resultado = 1;
		}
		return resultado;
	}

	@Override
	public void borrarProveedor(int id) {
		datosProveedor.deleteById(id); //El método busca la información para ese id y la elimina. 
	}

	@Override
	public Optional<Proveedor> consultarProveedor(int id ) {
		return datosProveedor.findById(id); //El método trae la información relacionada con el Id. 
	}

}

