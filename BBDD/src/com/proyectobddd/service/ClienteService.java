package com.proyectobddd.service;
import java.util.List;
import org.hibernate.Session;
import com.proyectobbdd.dao.ClienteDaoImp;
import com.proyectobbdd.domain.Factura;
import com.proyectobbdd.domain.Cliente;

public class ClienteService {
	private ClienteDaoImp clienteDao;

	public ClienteService(Session session) {
		clienteDao = new ClienteDaoImp(session);
	}
	
	public Cliente findById(int idCliente){
		return clienteDao.findById(idCliente);
	}
	
	public void save(Cliente cliente, List<Factura> facturas) {
		if(facturas != null){
			for(Factura factura : facturas){
				cliente.getFacturas().add(factura);
			}
		}
		clienteDao.save(cliente);
	}

	public Cliente delete(int idCliente){
		return clienteDao.findById(idCliente);
	}

	public void closeSession(){
		clienteDao.closeSession();
	}
}






	
	
