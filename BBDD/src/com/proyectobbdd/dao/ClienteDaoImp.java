package com.proyectobbdd.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.proyectobbdd.domain.Cliente;
import com.proyectobbdd.domain.Factura;
import com.proyectobbdd.domain.Cliente_;
import com.proyectobbdd.domain.Factura_;

public class ClienteDaoImp implements ClienteDao{
	
	private Session session;
	
	public ClienteDaoImp(Session session) {
		this.session = session;
	}

	@Override
	public void save(Cliente cliente) {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			session.save(cliente);
			
			tx.commit();
		} 
		catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Factura> findall(Cliente cliente) {
		Transaction tx = null;
		List<Factura> results = new ArrayList<>();
		try {
			tx = session.beginTransaction();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Factura> criteria = builder.createQuery(Factura.class);
			Root<Factura> root = criteria.from(Factura.class);
			
			Join<Factura, Cliente> join = root.join(Factura_.cliente);
			
			criteria.where(
					builder.equal(join.get(Cliente_.idCliente), cliente.getIdCliente())
					);
			
			results = session.createQuery(criteria).getResultList();
			
			tx.commit();
		} 
		catch (Exception e) {
			if(tx != null){
				tx.rollback();
				results = null;
			}
			e.printStackTrace();
		}
		return results;
	}

	@Override
	public Cliente findById(int idCliente) {
		Transaction tx = null;
		Cliente cliente = null;
		try {
			tx = session.beginTransaction();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
			Root<Cliente> root = criteria.from(Cliente.class);
			
			criteria.where(
					builder.equal(root.get(Cliente_.idCliente), idCliente)
					);
			
			cliente = session.createQuery(criteria).getSingleResult();
			
			tx.commit();
		} 
		catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		}
		return cliente;
	}

	public void closeSession() {
		session.close();
		
	}

	

}
