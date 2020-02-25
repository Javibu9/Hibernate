package com.proyectobbdd.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


public class Test {

	public static void main(String[] args) throws ParseException {

		Session session = HibernateUtil.getSessionFactory().openSession();
		ClienteService clienteService = new ClienteService(session);

		Date date1 = getDate("31/12/1998");
	    
	    List<Factura> facturas = new ArrayList<>();
	    //facturas.add("Tipo", date1);

	    clienteService.delete();
		clienteService.save(new Cliente("aaa", date1), facturas);
		clienteService.closeSession();
	}

	private static Date getDate(String fecha) throws ParseException {
		String sDate1=fecha;  
	    Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
		return date1;
	}

}


