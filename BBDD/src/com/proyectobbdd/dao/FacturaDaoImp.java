package com.proyectobbdd.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.hql.ast.origin.hql.resolve.GeneratedHQLResolver.searchCondition_return;

import com.proyectobbdd.domain.Cliente;
import com.proyectobbdd.domain.Cliente_;
import com.proyectobbdd.domain.Factura;
import com.proyectobbdd.domain.Factura_;

public class FacturaDaoImp implements FacturaDao{
	
	private Session session;
	
	public FacturaDaoImp(Session session) {
		this.session = session;
	}

	@Override
	public void saveFactura(Factura factura) {

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			session.save(factura);
			
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
	public Factura findById(int idFactura) {

		Transaction tx = null;
		Factura factura = null;
		try {
			tx = session.beginTransaction();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Factura> criteria = builder.createQuery(Factura.class);
			Root<Factura> root = criteria.from(Factura.class);
			
			criteria.where(
					builder.equal(root.get(Factura_.idFactura), idFactura)
					);
			
			factura = session.createQuery(criteria).getSingleResult();
			
			tx.commit();
		} 
		catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		}
		return factura;
	
	}

	@Override
	public void deleteFactura(Factura factura) {

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			session.delete(factura);
			
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
	public void updateFactura(Factura factura) {

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			session.saveOrUpdate(factura);
			
			tx.commit();
		} 
		catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		}

		
	}		
	public void closeSession() {
		session.close();
		
	}

}
