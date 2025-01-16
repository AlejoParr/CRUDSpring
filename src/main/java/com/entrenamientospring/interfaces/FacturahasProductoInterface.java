package com.entrenamientospring.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.entrenamientospring.models.FacturahasProducto;

@Repository

public interface FacturahasProductoInterface extends JpaRepository < FacturahasProducto, Integer> {
	@Query(value="SELECT fact.factura_id, fact.producto_id, fact.cantidad, prod.nombre, prod.precio, prod.id FROM facturahasproducto fact INNER JOIN producto prod ON fact.producto_id = prod.id WHERE fact.factura_id = :idfactura", nativeQuery=true)
	List<FacturahasProducto>consultarProductosDetalle(@Param("idfactura")int idfactura);
}
