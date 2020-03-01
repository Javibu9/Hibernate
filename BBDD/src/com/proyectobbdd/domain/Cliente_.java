package com.proyectobbdd.domain;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cliente.class)
public abstract class Cliente_ {

	public static volatile SingularAttribute<Cliente, Integer> idCliente;
	public static volatile SingularAttribute<Cliente, String> entregaCliente;
	public static volatile SingularAttribute<Cliente, Date> fhcCliente;
	public static volatile ListAttribute<Cliente, Factura> facturas;

}

