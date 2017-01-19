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
	    	 
	    	Employee employee=new Employee("Abel","Ketsela");
	 		Laptop laptop=new Laptop("DELL","D55");
	 		employee.addLaptop(laptop);
	 		session.persist(employee);
	 		
	 		Flight flight1=new Flight("ET123","Addis Ababa","New York",new Date());
	 		Flight flight2=new Flight("ET456","New York","Addis Ababa",new Date());

	 		Passenger passenger =new Passenger("Abel Ketsela");
	 		passenger.addFlights(flight1);
	 		passenger.addFlights(flight2);
	 		session.persist(passenger);
	 		
	 		Student student1=new Student("985440","Abel","Yitayew");
	 		Student student2=new Student("988965","Bob","Alice");
	 		
	 		School school=new School("MUM");
	 		school.addStudents(student1);
	 		school.addStudents(student2);
	 		
	 		session.persist(school);
	 		
	 		
	 		
	 	
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
