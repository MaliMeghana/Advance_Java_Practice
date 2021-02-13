package in.edac.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.edac.dao.CategoryDao;
import in.edac.enitity.Category;

/**
 * Servlet implementation class CategoryUpdateAction
 */
@WebServlet("/category-update-action")
public class CategoryUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {

			int  id=Integer.parseInt(request.getParameter("id"));
			String category=request.getParameter("category");
			
			CategoryDao dao=new CategoryDao();
			Category cat=new Category();
			cat.setCategory(category);
			cat.setId(id);
		    dao.updateCategory(cat);
		    request.getRequestDispatcher("category-all-action").forward(request, response);	
			
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("category-all-action").forward(request, response);	
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
