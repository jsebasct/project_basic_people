package org.peoplesoft.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	static {
		try {
			//sessionFactory = new Configuration().configure().buildSessionFactory();
			sessionFactory = new MetadataSources(
					new StandardServiceRegistryBuilder()
					.configure("hibernate.cfg.xml").build()
					).buildMetadata().buildSessionFactory();
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
