package in.edac;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.edac.entity.Student;

public class HibernateHQLDemo {
	public static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public static void main(String[] args) {
		demo3();
	}
	
	public static void demo3() {
		Session session = sessionFactory.openSession();
		String hql = "FROM Student s WHERE s.id=:id";
		List<Student> list = session.createQuery(hql, Student.class)
				.setParameter("id", 1)
				.list();

		list.stream().map(Student::getUsername).forEach(System.out::println);

		session.close();

	}
	
	public static void demo2() {
		Session session = sessionFactory.openSession();
		String hql = "SELECT s FROM Student s";
		List<Student> list = session.createQuery(hql, Student.class).list();

		list.stream().map(Student::getUsername).forEach(System.out::println);

		session.close();

	}
	
	public static void demo1() {
		Session session = sessionFactory.openSession();
		String hql = "FROM Student";
		List<Student> list = session.createQuery(hql, Student.class).list();

		list.stream().map(Student::getUsername).forEach(System.out::println);

		session.close();

	}
}

