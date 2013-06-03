
package br.com.sisgpt.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
    	AnnotationConfiguration configuration = new AnnotationConfiguration().configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }

	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
}