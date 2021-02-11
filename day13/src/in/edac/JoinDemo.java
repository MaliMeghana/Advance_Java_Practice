package in.edac;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class JoinDemo {
	 public static final SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
	 
	public static void main(String[] args) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		
		
		session.close();
	}
}
