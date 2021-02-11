package in.edac;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateDemo6 {
	public static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	public static void main(String[] args) {
		//sqlDemo();
		dqlSqlDemo();
		//dqlSqlDemo2();
	}
	
	//DQL::SELECT
	
	public static void sqlDemo() {
		Session session=sessionFactory.openSession();
		
		String sql="SELECT * FROM Users";
		
		List<Users> list =session.createNativeQuery(sql,Users.class).getResultList();
		
		list.stream().map(p->p.getUsername()).forEach(System.out::println);
		
		session.close();
	}
	
	public static void dqlSqlDemo() {
		Session session=sessionFactory.openSession();
		//postional param==?
		//?==:
		String sql="SELECT * FROM Users WHERE id=:id";
		
		List<Users> list =session.createNativeQuery(sql,Users.class).setParameter("id",0).list();
		
		list.stream().map(p->p.getUsername()).forEach(System.out::println);
		
		session.close();
	}
	
	public static void dqlSqlDemo2() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		//postional param==?
		//?==:
		String sql="INSERT INTO Users (id,username,email) VALUES(:id,:username, :email)";
		
	    session.createNativeQuery(sql,Users.class).setParameter("id","1").setParameter("username","Meghana").setParameter("email","gmail").executeUpdate();
		
		tx.commit();
		
		session.close();
	}
	
}
