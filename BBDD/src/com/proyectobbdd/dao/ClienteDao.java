package com.proyectobbdd.dao;

import java.util.List;
import com.proyectobbdd.domain.Cliente;
import com.proyectobbdd.domain.Factura;

public interface ClienteDao {

	//hola
	public void save (Cliente cliente);
	public List<Factura> findall(Cliente cliente);
	public Cliente findById(int idCliente);
	public void delete(Cliente cliente);
	public void update(Cliente cliente);
}
