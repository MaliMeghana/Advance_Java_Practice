package in.edac.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.edac.dao.CategoryDao;
import in.edac.enitity.Category;

@WebServlet("/category-add-action")
public class CategoryAddAction extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   try {
			
			   String category=request.getParameter("category");
			   
			   Category cat=new Category(category);
			   
			   CategoryDao dao=new CategoryDao();
			   
			   dao.addProduct(cat);
			   
			   response.sendRedirect("category-all-action");
			   
		} catch (Exception e) {
			 e.printStackTrace();
			 response.sendRedirect("/miniproject/acategory.jsp?q=0");
		}
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   doGet(request, response);
	}

}
