package in.edac.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.edac.dao.User;
import in.edac.dao.UserDao;

/**
 * Business LOGIC
 * Servlet implementation class UserControllerCreate
 */
@WebServlet("/user-update")
public class UserControllerUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			int  id=Integer.parseInt(request.getParameter("id"));
			
			
			UserDao dao=new UserDao();
			User user=new User();
			
			user.setId(id);
			user.setUsername(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));
			user.setEmail(request.getParameter("email"));
			user.setMobile(Integer.parseInt(request.getParameter("mobile")));
			
			dao.updateUser(user);
			request.getRequestDispatcher("user-read").forward(request, response);	
	
			
		}catch (Exception e) {
	         e.printStackTrace();
	     	request.getRequestDispatcher("Error.jsp").forward(request, response);
	    	
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
