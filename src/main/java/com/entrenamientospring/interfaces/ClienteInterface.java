package com.entrenamientospring.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.entrenamientospring.models.Cliente;

/*El segundo parámetro de CrudRepo debe ser definido. En este caso, el ID es un entero.
 La librería CrudRepository ya incluye todas las métodos del CRUD y los ejecuta sin tener
 que realizar la sentencia para cada uno de ellos.*/

@Repository
public interface ClienteInterface extends CrudRepository < Cliente, Integer> {

}
