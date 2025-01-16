package com.entrenamientospring.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query; 
import org.springframework.stereotype.Repository;

import com.entrenamientospring.models.Producto;

@Repository
public interface ProductoInterface extends JpaRepository<Producto, Integer> {
	
	@Query(value="SELECT * FROM PRODUCTO WHERE estado='ACTIVO'", nativeQuery=true)
	List<Producto>consultarProductosActivos();
	
	@Query(value="SELECT * FROM PRODUCTO WHERE estado='INACTIVO'", nativeQuery=true)
	List<Producto>consultarProductosInactivos();
}
