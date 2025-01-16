package com.entrenamientospring.interfaceServices;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.entrenamientospring.models.Cliente;

@Service
public interface InterfaceClienteService {
	//Aquí van a estar los métodos del CRUD.
	//Sería el equivalente al DAO en JSP.
	
	public List<Cliente>listadoCliente();
	
	public int guardarCliente(Cliente c);
	
	public void borrarCliente(int id);
	
	public Optional<Cliente>consultarCliente(int id); 
	//Editar o actualizar cliente.
}
