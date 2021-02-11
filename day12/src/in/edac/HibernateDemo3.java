package in.edac;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//DML DEMO
public class HibernateDemo3 {
	public static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Transaction tx=null;
	public static void main(String[] args) {
           
		//create();
		//update();
		//delete();
        updateOne();
	}
	
	
	public static void updateOne() {
		Session session=sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		
		Person p=session.find(Person.class, 0);
		
		p.setFname("INDIA");
		
		session.update(p);
		tx.commit();
		session.close();
	}
	
	
	public static void delete() {
		Session session=sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Person p = new Person();
		p.setId(1);

		session.delete(p);
		tx.commit();
		session.close();
	}
	
	public static void update() {
		Session session=sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Person p = new Person();
		p.setId(0);
		p.setFname("india");
		p.setMname("Maharashtra");
		p.setLname("Khargar");

		session.update(p);
		tx.commit();
		session.close();
	}
	

	public static void create() {
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		Person p = new Person();
		p.setFname("EDAC");
		p.setMname("CDAC");
		p.setLname("Khargar");

		session.save(p);
		tx.commit();
		session.close();
	}
}
