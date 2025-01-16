package com.entrenamientospring.interfaces;

import org.springframework.data.repository.CrudRepository;
import com.entrenamientospring.models.Proveedor;

public interface ProveedorInterface extends CrudRepository<Proveedor, Integer> {
	

}
