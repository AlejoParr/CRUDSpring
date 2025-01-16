package com.entrenamientospring.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entrenamientospring.interfaceServices.InterfaceUsuarioService;
import com.entrenamientospring.interfaces.UsuarioInterface;
import com.entrenamientospring.models.Usuario;

@Service // Muy importante importar esta librería!!!! 
public class UsuarioServices implements InterfaceUsuarioService {
	
	@Autowired 
	private UsuarioInterface datosUsuario; 
	
	public UsuarioServices() {
	}

	@Override
	public List<Usuario> listadoUsuario() {
		return (List<Usuario>)datosUsuario.findAll( );
	}

	@Override
	public int guardarUsuario(Usuario us) {
		int resultado = 0;
		Usuario usu = datosUsuario.save(us);
		if (!usu.equals(null)) { //Verifica si llega información. Si es así, la envía a la BD. 
			resultado=1; 
		}
		return resultado;
	}

	@Override
	public void borrarUsuario(int id) {
		datosUsuario.deleteById(id);
		
	}

	@Override
	public Optional<Usuario> consultarUsuario(int id) {
		/* Spring nos va a permitir ahorrar todo el proceso de construcción
		 * de la conexión, PreparedStatement o resultSet y finalmente recorrer
		 * la base de datos con un Next()*/
		// Va a bastar con enviar el id al método findById()
		
		return datosUsuario.findById(id);
	}
}
