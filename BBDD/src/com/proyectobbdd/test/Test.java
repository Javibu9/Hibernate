package com.proyectobbdd.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.proyectobbdd.domain.Cliente;
import com.proyectobbdd.domain.Cliente_;
import com.proyectobbdd.domain.Factura;
import com.proyectobbdd.util.HibernateUtil;
import com.proyectobddd.service.ClienteService;
import com.proyectobddd.service.FacturaService;


public class Test {

	public static void main(String[] args) throws ParseException {

		Session session = HibernateUtil.getSessionFactory().openSession();
		ClienteService clienteService = new ClienteService(session);
		FacturaService facturaService = new FacturaService(session);

		Date date1 = getDate("31/12/1998");

		//crea una factura y un cliente y los guarda en la bbdd
	    Factura f1 = new Factura("tipo", date1);
	    Cliente c1 = new Cliente("aaa", date1);
	    System.out.println("INSERTAMOS VALORES:");
		clienteService.save(c1);
		f1.setCliente(c1);
	    facturaService.saveFactura(f1);
	    
	    //creo una lista de facturas y la añado a clientes
	    List<Factura> facturas = new ArrayList<>();
	    facturas.add(f1);
	    c1.setFacturas(facturas);
	    
	    //busca por id una factura y un cliente
	    System.out.println("\nBUSCAMOS POR ID:");
		System.out.println(clienteService.findById(c1.getIdCliente()));
		System.out.println(facturaService.findById(f1.getIdFactura()));
		
		//actualizamos un parametro en cliente/factura y lo actualizamos
		System.out.println("\nACTUALIZAMOS:");
		c1.setEntregacliente("Se actualiza");
		clienteService.update(c1);
		System.out.println(clienteService.findById(c1.getIdCliente()));
		f1.setTipoFactura("Este tambien");
		facturaService.updateFactura(f1);
		System.out.println(facturaService.findById(f1.getIdFactura()));

		
		//borra el cliente y factura que le pases
		System.out.println("\nBORRAMOS:");
		facturaService.deleteFactura(f1);
		System.out.println("Factura borrada");
		clienteService.delete(c1);
		System.out.println("Cliente borrado");
		
		clienteService.closeSession();
	}

	private static Date getDate(String fecha) throws ParseException {
		String sDate1=fecha;  
	    Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
		return date1;
	}

}


