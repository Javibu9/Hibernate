package com.proyectobbdd.dao;

import com.proyectobbdd.domain.Factura;

public interface FacturaDao {

	public void saveFactura (Factura factura);
	//public List<Factura> findall(Cliente cliente);
	public Factura findById(int idFactura);
	public void deleteFactura(Factura factura);
	public void updateFactura(Factura factura);
}
