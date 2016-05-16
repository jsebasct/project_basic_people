package org.peoplesoft;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.peoplesoft.model.entities.Person;
import org.peoplesoft.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Person person = new Person("Rodriguez", "Marcelo");
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        Transaction tx = null;
        try {
        	tx = session.beginTransaction();
            session.save(person);
            tx.commit();
        } catch(Exception e) {
        	System.out.println("Error");
        	e.printStackTrace();
        	
        } finally {
        	session.close();
        	sessionFactory.close();
            System.out.println("Sayonara !");
        }
        
        
    }
}
