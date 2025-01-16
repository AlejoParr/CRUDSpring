package com.entrenamientospring.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entrenamientospring.interfaceServices.InterfaceFacturahasProductoService;
import com.entrenamientospring.interfaces.FacturahasProductoInterface;
import com.entrenamientospring.models.FacturahasProducto;

@Service
public class FacturahasProductoServices implements InterfaceFacturahasProductoService {
	
	@Autowired 
	private FacturahasProductoInterface datosFacturahasProducto;
	

	@Override
	public List<FacturahasProducto> listadoFacturahasProducto() {
		return (List<FacturahasProducto>)datosFacturahasProducto.findAll();
	}

	@Override
	public List<FacturahasProducto> listarProductosDetalle(int id) {
		return (List<FacturahasProducto>)datosFacturahasProducto.consultarProductosDetalle(id);
	}
	
	@Override
	public int guardarFacturahasProducto(FacturahasProducto fact) {
		int resultado = 0;
		FacturahasProducto factura = datosFacturahasProducto.save(fact);
		if (!factura.equals(null)) { //Verifica si llega información. Si es así, la envía a la BD. 
			resultado=1; 
		}
		return resultado;
	}

	@Override
	public void borrarFacturahasProducto() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<FacturahasProducto> consultarFacturahasProducto(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
