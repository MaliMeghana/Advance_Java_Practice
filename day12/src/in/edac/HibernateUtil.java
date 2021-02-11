package in.edac;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	//singleton.. once in prgrm
	/*
	 * Connection Factory
	 * Pools of connections
	 * Which helps to get connection realtively faster at runtime
	 */
	public static final	SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
	
	public static void main(String[] args) {
		
		
	}
}
