package com.entrenamientospring.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entrenamientospring.interfaceServices.InterfaceFacturaService;
import com.entrenamientospring.interfaces.FacturaInterface;
import com.entrenamientospring.models.Factura;

@Service 
public class FacturaServices implements InterfaceFacturaService{

	@Autowired 
	private FacturaInterface datosFactura;
	
	public FacturaServices() {
		
	}
 

	@Override
	// Los métodos pueden implementarse con el asistente. 
	public List<Factura> listadoFactura() { 
		return (List<Factura>)datosFactura.findAll(); 
													 
	}
	
	@Override
	public int consultarUltimaFactura() {
		int resultado = datosFactura.consultarUltimaFactura();
		return resultado;
	}


	@Override
	public int guardarFactura(Factura fact) {
		int resultado = 0;
		Factura factura = datosFactura.save(fact);
		if (!factura.equals(null)) { //Verifica si llega información. Si es así, la envía a la BD. 
			resultado=1; 
		}
		return resultado;
	}


	@Override
	public void borrarFactura(int id) {
		datosFactura.deleteById(id);
	}

	@Override
	public Optional<Factura> consultarFactura(int id) { 
		return datosFactura.findById(id);
	}
}



