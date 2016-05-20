package org.peoplesoft.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.peoplesoft.model.entities.BankAccount;
import org.peoplesoft.util.HibernateUtil;

public class BankAccountDAO {

	public BankAccount getAccount(Long id) {
		return null;
	}
	
	public void save(BankAccount account) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(account);
		
		tx.commit();
		session.close();
	}
	
	public void update(BankAccount account) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		session.update(account);
		
		tx.commit();
		session.close();
	}
	
	public void delete(BankAccount account) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		session.delete(account);
		
		tx.commit();
		session.close();
	}
	
	public List<BankAccount> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from BankAccount");
		List<BankAccount> res = query.list();
		tx.commit();
		session.close();
		return res;
	}
	
}
