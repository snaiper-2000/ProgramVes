package Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
//import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	/*	private static SessionFactory sessionFactory = null;

		static {
			Configuration cfg = new Configuration().configure();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());

			sessionFactory = cfg.buildSessionFactory(builder.build());
		}

		public static SessionFactory getSessionFactory() {
			return sessionFactory;
		}
		*/
	private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session openSession() {
        return sessionFactory.openSession();
    }
		
	}