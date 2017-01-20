package edu.mum.cs.cs544.exercises;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class AppMain {
    private static final SessionFactory sessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Session session = null;
	     Transaction tx = null;
	     
	     try{
	    	session=sessionFactory.openSession();
	    	tx=session.beginTransaction();
	    	 
	    	Customer customer=new Customer("Abel","Yitayew");
	    	Order order=new Order("A001",new Date());
	    	
	    	session.persist(customer);
	    	
	    	Product product1 =new CD("CD","CD","Bob Marly");
	    	
	    	Product product2 =new DVD("DVD","DVD","Movie");
	    	
	    	Product product3 =new Book("Book","Book","Java");
	    	
	    	OrderLine orderline1=new OrderLine(3,product1);
	    	OrderLine orderline2=new OrderLine(1,product2);
	    	OrderLine orderline3=new OrderLine(5,product3);
	    	
	    	order.addOrderline(orderline1);
	    	order.addOrderline(orderline2);
	    	order.addOrderline(orderline3);
	    	
	    	customer.addOrders(order);

	    	session.persist(customer);
	    	
	 		tx.commit();
	    	 
	     }
	     catch (HibernateException ex){
	    	 if (tx!=null){
	    		 tx.rollback();
	    		 System.out.println("Error: "+ex.getMessage());
	    	 }
	     }
	     finally{
	    	 if (session!=null){
	    		 session.close();
	    	 }
	     }

	}

}
