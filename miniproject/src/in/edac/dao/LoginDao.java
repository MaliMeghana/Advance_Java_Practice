package in.edac.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.edac.enitity.User;

public class LoginDao {
	private static final SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();

	public boolean authenticateUser(User user) {
		Session session=sessionFactory.openSession();
		String sql="SELECT * FROM user WHERE email=:email and password=:password";
		
		User dbUser=session.createNativeQuery(sql,User.class)
				.setParameter("email", user.getEmail())
				.setParameter("password", user.getPassword())
				.getSingleResult();
		
		session.close();
		
		if(dbUser!=null){
			return true;
		}else {
			return false;
		}
	}
	public User getUser(User user) {
		Session session=sessionFactory.openSession();
		String sql="SELECT * FROM user WHERE email=:email and password=:password";
		
		User dbUser=session.createNativeQuery(sql,User.class)
				.setParameter("email", user.getEmail())
				.setParameter("password", user.getPassword())
				.getSingleResult();
		
		session.close();
		
		if(dbUser!=null){
			return dbUser;
		}else {
			return null;
		}
		
	}
}
