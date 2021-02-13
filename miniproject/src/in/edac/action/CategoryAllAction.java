package in.edac.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.edac.dao.CategoryDao;
import in.edac.enitity.Category;

/**
 * Servlet implementation class CategoryAllAction
 */
@WebServlet("/category-all-action")
public class CategoryAllAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			CategoryDao dao=new CategoryDao();
			
			List<Category> list=dao.allCategory();
			
			HttpSession session=request.getSession();
			
			session.setAttribute("category", list);
			request.getRequestDispatcher("acategory.jsp").forward(request, response);	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}
