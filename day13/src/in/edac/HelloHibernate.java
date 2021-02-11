package in.edac;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.edac.entity.Employee;
import in.edac.entity.Student;

public class HelloHibernate {
 public static final SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
 
 public static void main(String[] args) {
	
	 addStudent();
	 addEmployee();
}
 
 
 public static void addStudent(){
	 Session session=sessionFactory.openSession();
	 session.beginTransaction();
	 
	 Student std1=new Student("Manoj","bhoye","@mail","323");
	 Student std2=new Student("saurabh","kumar","@mssil","454");
	 Student std3=new Student("Milan","Mm","@Mmail","55");
	
	 
	 session.save(std1);
	 session.save(std2);
	 session.save(std3);
	
	 session.getTransaction().commit();
	 
	 session.close();
 }
 
 public static void addEmployee() {
	 Session session=sessionFactory.openSession();
	 session.beginTransaction();

	 
	 Employee e1=new Employee("Manoj","bhoye","EDAC","Tanuja");
	 Employee e2=new Employee("Meghana","Mali","CDAC","Saurabh");
	 Employee e3=new Employee("Milan","Mm","PGDAC","Meghana");
	 
	 session.save(e1);
	 session.save(e2);
	 session.save(e3);
	 
	 session.getTransaction().commit();
	 
	 session.close();
 }
 
}
