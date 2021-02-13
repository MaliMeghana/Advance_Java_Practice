package in.edac.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.edac.dao.ProductDao;
import in.edac.enitity.Product;


/**
 * Servlet implementation class ProductOneAction
 */
@WebServlet("/product-one-action")
public class ProductOneAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			    int id=Integer.parseInt(request.getParameter("cid"));
				
				ProductDao dao=new ProductDao();
				Product prod=new Product();
				prod.setId(id);
				
			    List<Product> list=dao.ProductByCat(prod);
			request.setAttribute("productbycat", list);
			request.getRequestDispatcher("product.jsp").forward(request, response);	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
