package edu.mum.coffee.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Order.class)
public abstract class Order_ {

	public static volatile ListAttribute<Order, Orderline> orderLines;
	public static volatile SingularAttribute<Order, Person> person;
	public static volatile SingularAttribute<Order, Integer> id;
	public static volatile SingularAttribute<Order, Date> orderDate;

}

