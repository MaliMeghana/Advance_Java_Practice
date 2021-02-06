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
@WebServlet("/user-read1")
public class UserControllerReadOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		
			int  id=Integer.parseInt(request.getParameter("id"));
			
			
			UserDao dao=new UserDao();
			User user=new User();
			user.setId(id);
			
			User user1=dao.readUser(user);
			request.setAttribute("user", user1);
			
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
