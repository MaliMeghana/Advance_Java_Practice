package in.edac;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


//DQL DEMO
//No need of tx
//We can use HQL or SQL

public class HibernateDemo4 {
	public static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public static void main(String[] args) {
		Session session=sessionFactory.openSession();
		
	    List<Person> list=session.createQuery("From Person",Person.class).list();
		
	    //list.stream().map(p->p.getFname()).forEach(System.out::println);
	    
	    for (Person person : list) {
			System.out.println(person.getFname());
		}
	    
		session.close();
	}
}
