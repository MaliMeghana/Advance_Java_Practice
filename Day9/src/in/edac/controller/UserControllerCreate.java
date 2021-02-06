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
@WebServlet("/user-create")
public class UserControllerCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String email=request.getParameter("email");
			int  mobile=Integer.parseInt(request.getParameter("mobile"));
			
			
			UserDao dao=new UserDao();
			User user=new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			user.setMobile(mobile);
			
			dao.createUser(user);
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
