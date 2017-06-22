package edu.mum.coffee.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Orderline.class)
public abstract class Orderline_ {

	public static volatile SingularAttribute<Orderline, Product> product;
	public static volatile SingularAttribute<Orderline, Integer> quantity;
	public static volatile SingularAttribute<Orderline, Integer> id;
	public static volatile SingularAttribute<Orderline, Order> order;

}

