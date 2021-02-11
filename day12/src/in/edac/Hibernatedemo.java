package in.edac;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernatedemo {

	public static void main(String[] args) {
	
		//only with this line ddl will run and performs ddl operation
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		
		//Open and close session is required for dml operations
	}
	
}
