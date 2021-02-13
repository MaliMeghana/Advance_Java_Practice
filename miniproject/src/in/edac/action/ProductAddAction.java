package in.edac.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import in.edac.dao.ProductDao;
import in.edac.enitity.Product;

/**
 * Servlet implementation class ProductAddAction
 */
@WebServlet("/product-add-action")
public class ProductAddAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			String name=request.getParameter("pname");
			String price=request.getParameter("price");
			//String path=request.getParameter("path");
		     int cid=Integer.parseInt(request.getParameter("cid"));
			Product pro=new Product();
			pro.setPname(name);
			pro.setPrice(price);
			//pro.setPath(path);
			pro.setCid(cid);
			
			ProductDao dao=new ProductDao();
			dao.addProduct(pro);
			response.sendRedirect("product-all-action");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
