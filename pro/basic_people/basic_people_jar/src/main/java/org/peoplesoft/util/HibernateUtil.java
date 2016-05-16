package org.peoplesoft.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	// Alternatively, you could look up in JNDI here
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	// Close caches and connection pools
	public static void shutdown() {
		getSessionFactory().close();
	}

}
