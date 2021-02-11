package in.edac;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.edac.entity.Student;


public class HibernateNativeQueryDemo {
	public static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	public static void main(String[] args) {

		demo4();
	}
	

	// Native ==> Sql query ==> that u know

	public static void demo7() {
		Session session = sessionFactory.openSession();
		String sql = "SELECT * FROM student WHERE id=:id";
		Student std = session.createNativeQuery(sql, Student.class)
			     .setParameter("id", 1)
				.getSingleResult();

		System.out.println(std);

		session.close();

	}
	
	public static void demo6() {
		Session session = sessionFactory.openSession();
		String sql = "SELECT * FROM student WHERE id=:id";
		List<Student> list = session.createNativeQuery(sql, Student.class)
			     .setParameter("id", 1)
				.list();

		Student std=list.get(0);
		System.out.println(std);

		session.close();

	}
	
	public static void demo5() {
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		
		String sql="DELETE FROM STUDENT  WHERE id=:id";
		
		session.createNativeQuery(sql)
		       .setParameter("id", 3)
		       .executeUpdate();
		
		session.getTransaction().commit();
		session.close();

	}
	
	
	public static void demo4() {
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		
		String sql="UPDATE  STUDENT SET username=:username, mobile=:mobile WHERE id=:id";
		
		session.createNativeQuery(sql)
		       .setParameter("username", "upme")
		       .setParameter("mobile", "45")
		       .setParameter("id", 3)
		       .executeUpdate();
		
		session.getTransaction().commit();
		session.close();

	}
	
	public static void demo3() {
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		
		String sql="INSERT INTO STUDENT (username, password,email,mobile) VALUES (:username, :password, :email, :mobile)";
		
		session.createNativeQuery(sql)
		       .setParameter("username", "ABC")
		       .setParameter("password", "XYZ")
		       .setParameter("email", "@ABCG")
		       .setParameter("mobile", "76745")
		       .executeUpdate();
		
		session.getTransaction().commit();
		session.close();

	}
	
	
	public static void demo1() {
		Session session = sessionFactory.openSession();
		String sql = "SELECT * FROM STUDENT WHERE id=:id AND username=:username";
		List<Student> list = session.createNativeQuery(sql, Student.class)
				.setParameter("id", 2)
				.setParameter("username", "Manoj")
				.list();

		list.stream().map(Student::getUsername).forEach(System.out::println);

		session.close();

	}
	
	public static void demo2() {
		Session session = sessionFactory.openSession();
		String sql = "SELECT * FROM student";
		List<Student> list = session.createNativeQuery(sql, Student.class).list();

		list.stream().map(Student::getUsername).forEach(System.out::println);

		session.close();

	}
}
