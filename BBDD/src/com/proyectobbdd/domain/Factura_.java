package com.proyectobbdd.domain;


import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Factura.class)
public abstract class Factura_ {

	public static volatile SingularAttribute<Factura, Integer> idFactura;
	public static volatile SingularAttribute<Factura, String> tipoFactura;
	public static volatile SingularAttribute<Factura, Date> fhcFactura;
	public static volatile SingularAttribute<Factura, Cliente> cliente;

}

