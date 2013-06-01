
package br.com.sisgpt.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private static Session session;

    static {
    	AnnotationConfiguration configuration = new AnnotationConfiguration().configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }

	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
	
	public static Session getSession(){
		if(session == null){
			session = sessionFactory.openSession();
		}
		return session;
	}
}