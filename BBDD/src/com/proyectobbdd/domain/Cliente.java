package com.proyectobbdd.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
	private String entregaCliente;
	private Date fhcCliente;
	
	@OneToMany()
	@JoinColumn(name = "Cliente_idCliente")
	private List<Factura> facturas = new ArrayList<>();
	
	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Cliente(String entregacliente, Date fhcCliente) {
		this.entregaCliente = entregacliente;
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
		return entregaCliente;
	}
	public void setEntregacliente(String entregacliente) {
		this.entregaCliente = entregacliente;
	}
	public Date getFhcCliente() {
		return fhcCliente;
	}
	public void setFhcCliente(Date fhcCliente) {
		this.fhcCliente = fhcCliente;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", entregacliente=" + entregaCliente + ", fhcCliente=" + fhcCliente
				+ ", facturas=" + facturas + "]";
	}
	
	
	
}
