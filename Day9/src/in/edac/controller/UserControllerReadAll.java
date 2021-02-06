package in.edac.controller;

import java.io.IOException;
import java.util.List;

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
@WebServlet("/user-read")
public class UserControllerReadAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		
			UserDao dao=new UserDao();
			
			List<User> list=dao.readAllUser();
			
			request.setAttribute("userlist", list);
			
			request.getRequestDispatcher("user_data.jsp").forward(request, response);	
	
			
		}catch (Exception e) {
	         e.printStackTrace();
	     	request.getRequestDispatcher("Error.jsp").forward(request, response);
	    	
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
