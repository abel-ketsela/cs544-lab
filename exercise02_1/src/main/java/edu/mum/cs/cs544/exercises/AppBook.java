package edu.mum.cs.cs544.exercises;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class AppBook {
	public static final SessionFactory sessionFactory;
	public static final ServiceRegistry serviceRegistry;
	
	static {
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }
	public static void main(String[] args) {

		Session session=null;
		Transaction tx=null;
		
		try
		{
			SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");

			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			Book b1=new Book("Book1","123","Author1",12.50,dateformat.parse("01/01/2012"));
			session.persist(b1);
			
			Book b2=new Book("Book2","456","Author2",15.50,dateformat.parse("01/03/2014"));
			session.persist(b2);
			
			Book b3=new Book("Book3","789","Author3",20.50,dateformat.parse("24/05/2016"));
			session.persist(b3);
			
			tx.commit();
			
			
		}
		catch(ParseException | HibernateException ex)
		{
			if (tx != null) {
                System.err.println("Rolling back: " + ex.getMessage());
                tx.rollback();
            }
		}
		finally
		{
			if (session != null)
			{
				session.close();
			}
		}
		
		////////////////////////////////////////////////////////////////
		
		
		 try 
		 {
			 session = sessionFactory.openSession();
	         tx = session.beginTransaction();

	         @SuppressWarnings("unchecked")
	         List<Book> bookList = session.createQuery("from Book").list();
	         for (Book book : bookList) 
	         {
	        	 System.out.println(showBook(book));
	         }
	         tx.commit();

		 } catch (HibernateException e) {
			 if (tx != null) {
			 
				 System.err.println("Rolling back: " + e.getMessage());
	             tx.rollback();
	         }
	        } finally {
	            if (session != null) {
	                session.close();
	            }
	        }
		 
		 //////////////////////////////////////////////////////////////////
		 try{
			 session=sessionFactory.openSession();
			 tx=session.beginTransaction();
			 
			 Book b1=(Book)session.load(Book.class, 1);
			 
			 b1.setTitle("Book1_Modified");
			 b1.setPrice(25.60);
			 
			 Book b2=(Book)session.load(Book.class, 2);
			 session.delete(b2);
			 b2=null;
			 
			 session.flush();
			 tx.commit();
			 
		 }
		 catch(HibernateException ex){
			 if (tx != null) {
	                System.err.println("Rolling back: " + ex.getMessage());
	                tx.rollback();
	            }
		 }
		 finally{
			 if (session!=null){
				 session.close();
			 }
		 }
		 
		 ///////////////////////////////////////////////////////
		 
		 try 
		 {
			 session = sessionFactory.openSession();
	         tx = session.beginTransaction();

	         @SuppressWarnings("unchecked")
	         List<Book> bookList = session.createQuery("from Book").list();
	         for (Book book : bookList) 
	         {
	        	 System.out.println(showBook(book));
	         }
	         tx.commit();

		 } catch (HibernateException e) {
			 if (tx != null) {
			 
				 System.err.println("Rolling back: " + e.getMessage());
	             tx.rollback();
	         }
	        } finally {
	            if (session != null) {
	                session.close();
	            }
	        }
		 

		
		
	}
	
	public static String showBook(Book book) {
		return "Book [title=" + book.getTitle() + ", ISBN=" + book.getISBN() + ", author=" + book.getAuthor() + ", price=" + book.getPrice()
				+ ", publish_date=" + book.getPublish_date() + "]";
	}

}
