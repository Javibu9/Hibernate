package com.proyectobbdd.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Factura")
public class Factura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFactura;
	private String tipoFactura;
	private Date fhcFactura;
	
	@ManyToOne()
	@JoinColumn(name = "Cliente_idCliente")
	private Cliente cliente;
	
	public Factura(String tipoFactura, Date fhcFactura) {
		super();
		this.tipoFactura = tipoFactura;
		this.fhcFactura = fhcFactura;
	}

	public Factura() {
		
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public String getTipoFactura() {
		return tipoFactura;
	}

	public void setTipoFactura(String tipoFactura) {
		this.tipoFactura = tipoFactura;
	}

	public Date getFhcFactura() {
		return fhcFactura;
	}

	public void setFhcFactura(Date fhcFactura) {
		this.fhcFactura = fhcFactura;
	}
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Factura [idFactura=" + idFactura + ", tipoFactura=" + tipoFactura + ", fhcFactura=" + fhcFactura
				+ ", cliente=" + cliente.getIdCliente() + "]";
	}


	


	
	
}
