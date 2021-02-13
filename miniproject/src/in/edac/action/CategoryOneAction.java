package in.edac.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.edac.dao.CategoryDao;
import in.edac.enitity.Category;

/**
 * Servlet implementation class CategoryOneAction
 */
@WebServlet("/category-one-action")
public class CategoryOneAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			    int id=Integer.parseInt(request.getParameter("id"));
				
				CategoryDao dao=new CategoryDao();
				Category cat=new Category();
				cat.setId(id);
				
			    List<Category> list=dao.oneCategory(cat);  
			request.setAttribute("categoryone", list);
			request.getRequestDispatcher("category-all-action").forward(request, response);	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}
