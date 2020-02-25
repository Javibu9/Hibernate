package com.proyectobbdd.test;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.proyectobbdd.domain.Cliente;
import com.proyectobbdd.domain.Factura;
import com.proyectobbdd.util.HibernateUtil;
import com.proyectobddd.service.ClienteService;

public class Test {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ClienteService clienteService = new ClienteService(session);

		clienteService.save(new Cliente("aaa", new Date(2020, 2, 24)), null);
	}

}

