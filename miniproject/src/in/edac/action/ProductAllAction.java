package in.edac.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.edac.dao.ProductDao;

import in.edac.enitity.Product;

/**
 * Servlet implementation class ProductAllAction
 */
@WebServlet("/product-all-action")
public class ProductAllAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ProductDao dao=new ProductDao();
			
			List<Product> list=dao.allProduct();
			
			HttpSession session=request.getSession();
			
			session.setAttribute("product", list);
			request.getRequestDispatcher("aproduct.jsp").forward(request, response);	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}


}
