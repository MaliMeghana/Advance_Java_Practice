package in.edac;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.edac.entity.Student;

public class HibernateCriteriaDemo {
	public static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public static void main(String[] args) {
		
		demo1();
	}
	
	public static void demo1() {
		Session session = sessionFactory.openSession();
		
		CriteriaQuery<Student> cq=session.getCriteriaBuilder().createQuery(Student.class);
		
	//	List<Student> list=cq.list();
		
		session.close();

	}
}
