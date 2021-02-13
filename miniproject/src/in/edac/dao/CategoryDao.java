package in.edac.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import in.edac.enitity.Category;



public class CategoryDao {
	private static final SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();

	public void addProduct(Category cat) {
       Session session=sessionFactory.openSession();
       session.beginTransaction();
       
       session.save(cat);
       session.getTransaction().commit();
       session.close();
	}
	
	public List<Category> allCategory(){
		Session session=sessionFactory.openSession();
		
		 List<Category> list=session.createQuery("From Category",Category.class).list();
		 session.close();
		 return list;
		 
	}
	
	public void delete(Category cat) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		session.delete(cat);
		
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Category> oneCategory(Category cat) {
		Session session = sessionFactory.openSession();
		String hql = "FROM Category s WHERE s.id=:id";
		List<Category> list = session.createQuery(hql, Category.class)
				.setParameter("id", cat.getId())
				.list();
		 
		session.close();
		return list;
		
	}
	public void updateCategory(Category cat) {
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		
		String sql="UPDATE  Category SET category=:category WHERE id=:id";
		
		session.createNativeQuery(sql)
		       .setParameter("category", cat.getCategory())
		       .setParameter("id", cat.getId())
		       .executeUpdate();
		
		session.getTransaction().commit();
		session.close();
	}
}
