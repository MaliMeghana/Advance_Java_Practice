package in.edac.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.edac.enitity.Category;
import in.edac.enitity.Product;


public class ProductDao {
	private static final SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
	
	public void addProduct(Product prod) {
	       Session session=sessionFactory.openSession();
	       session.beginTransaction();
	       
	       session.save(prod);
	       session.getTransaction().commit();
	       session.close();
		}
	
	public List<Product> allProduct(){
		Session session=sessionFactory.openSession();
		
		 List<Product> list=session.createQuery("From Product",Product.class).list();
		 session.close();
		 return list;
		 
	}
	public List<Product> ProductByCat(Product prod) {
		Session session = sessionFactory.openSession();
		String hql = "FROM Product s WHERE s.cid=:cid";
		List<Product> list = session.createQuery(hql, Product.class)
				.setParameter("cid", prod.getId())
				.list();
		 
		session.close();
		return list;
		
	}
	
}
