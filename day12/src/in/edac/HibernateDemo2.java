package in.edac;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateDemo2 {
	public static final	SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
	
	public static void main(String[] args) {
		Transaction tx=null;
		try {
			//ACID
			//DML ==> when there are no. of operations more than one
			Session session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
//			session.save("A");
//			//operations
//			
			tx.commit();
			session.close();
			
		}catch (Exception e) {
			// TODO: handle exception
			
			tx.rollback();
			e.printStackTrace();
		}
	}
}
