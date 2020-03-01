package com.proyectobddd.service;

import org.hibernate.Session;

import com.proyectobbdd.dao.ClienteDaoImp;
import com.proyectobbdd.dao.FacturaDaoImp;
import com.proyectobbdd.domain.Cliente;
import com.proyectobbdd.domain.Factura;

public class FacturaService {
	private FacturaDaoImp facturaDao;

	public FacturaService(Session session) {
		facturaDao = new FacturaDaoImp(session);
	}
	
	public void saveFactura(Factura factura) {

		facturaDao.saveFactura(factura);
	}
	
	public Factura findById(int idFactura){
		return facturaDao.findById(idFactura);
	}

	public void deleteFactura(Factura factura){
		facturaDao.deleteFactura(factura);
	}

	public void updateFactura(Factura factura){
		facturaDao.updateFactura(factura);
	}
	
	public void closeSession(){
		facturaDao.closeSession();
	}
}
