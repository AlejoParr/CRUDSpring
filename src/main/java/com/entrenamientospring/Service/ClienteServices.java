package com.entrenamientospring.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entrenamientospring.interfaceServices.InterfaceClienteService;
import com.entrenamientospring.interfaces.ClienteInterface;
import com.entrenamientospring.models.Cliente;

/*Esta clase va a la base de datos y trae la información,
 sin la necesidad de un PreparedStatement o una sentencia SQL.*/

//Spring cuneta con una función para traer de manera automática los métodos de la interfaz. 

@Service //NO OLVIDAR importar esta librería !!!
public class ClienteServices implements InterfaceClienteService {
	@Autowired //La librería permite el manejo de la info que llega de la base de datos. 
	private ClienteInterface datosCliente;
 

	@Override
	// Los métodos pueden implementarse con el asistente. 
	public List<Cliente> listadoCliente() { 
		return (List<Cliente>)datosCliente.findAll(); // Itera la base datos y trae todos los registros,reemplazando...
													  // ...el ciclo while que se hubiera tenido que hacer en JSP.
	}


	@Override
	public int guardarCliente(Cliente c) {
		int resultado = 0;
		Cliente clien = datosCliente.save(c);
		if (!clien.equals(null)) { //Verifica si llega información. Si es así, la envía a la BD. 
			resultado=1; 
		}
		return resultado;
	}


	@Override
	public void borrarCliente(int id) {
		datosCliente.deleteById(id);
	}

	@Override
	public Optional<Cliente> consultarCliente(int id) { 
		/*Spring nos va a permitir ahorrar todo el proceso de construcción
		  de la conexión, PreparedStatement o resultSet y finalmente recorrer
		  la base de datos con un Next()*/
		// Va a bastar con enviar el id al método findById()
		return datosCliente.findById(id);
	}
}
