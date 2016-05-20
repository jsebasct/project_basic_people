package org.peoplesoft.dao;

import java.util.List;

import javax.persistence.CascadeType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.peoplesoft.model.entities.Person;
import org.peoplesoft.util.HibernateUtil;

public class PersonDAO {
	
	public Person getById(Long id) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Person person = session.load(Person.class, id);
		
		tx.commit();
		session.close();
		
		return person;
	}
	
	public void save(Person person) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
		//Session session = sessionFactory.getCurrentSession();
        
        try {
        	Transaction tx = session.beginTransaction();
            session.save(person);
            
            // this is needed if the association is not  CascadeType.ALL
//            for (BankAccount acc : person.getAccounts()) {
//            	session.save(acc);
//            }
            
            tx.commit();
        } catch(Exception e) {
        	System.out.println("Error");
        	e.printStackTrace();
        	
        } finally {
        	session.close();
        }
	}
	
	public void update(Person person) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(person);
		tx.commit();
		session.close();
	}
	
	public void delete(Person person) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(person);
		tx.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Person> getAllPersons() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
//		Query query = session.createQuery("from Person");
//		List<Person> persons = query.list();
		
		List<Person> persons = session.createCriteria(Person.class).list();
		
		tx.commit();
		session.close();
		
		return persons;
	}
}
