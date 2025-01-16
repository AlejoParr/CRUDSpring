package com.entrenamientospring.interfaceServices;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.entrenamientospring.models.Factura;

@Service
public interface InterfaceFacturaService {
	
	public List<Factura>listadoFactura();
	
	public int guardarFactura(Factura fact);
	
	public void borrarFactura(int id);
	
	public Optional<Factura>consultarFactura(int id); 
	
	public int consultarUltimaFactura();

}

