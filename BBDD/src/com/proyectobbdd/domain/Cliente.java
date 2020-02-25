package com.proyectobbdd.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCliente;
	private String entregacliente;
	private Date fhcCliente;
	
	@OneToMany()
	@JoinColumn(name = "Cliente_idCliente")
	private Set<Factura> facturas;
	
	public Set<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(Set<Factura> facturas) {
		this.facturas = facturas;
	}

	public Cliente(String entregacliente, Date fhcCliente) {
		this.entregacliente = entregacliente;
		this.fhcCliente = fhcCliente;
	}
	
	public Cliente(){
		
	}
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getEntregacliente() {
		return entregacliente;
	}
	public void setEntregacliente(String entregacliente) {
		this.entregacliente = entregacliente;
	}
	public Date getFhcCliente() {
		return fhcCliente;
	}
	public void setFhcCliente(Date fhcCliente) {
		this.fhcCliente = fhcCliente;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", entregacliente=" + entregacliente + ", fhcCliente=" + fhcCliente
				+ ", facturas=" + facturas + "]";
	}
	
	
	
}
