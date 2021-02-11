package in.edac;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateDemo5 {
	public static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	public static void main(String[] args) {
		create();
	}
	
	public static void create() {
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		Users u= new Users();
		
		for(int i=0;i<3;i++)
		{
			u.setUsername("EDAC"+i);
			u.setEmail("CDAC"+i);
			u.setMobile("Khargar" +i);
			session.save(u);
		}
		tx.commit();
		session.close();
	}
}
//go to hibernatedemo 6