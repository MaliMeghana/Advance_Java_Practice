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
import in.edac.dao.LoginDao;
import in.edac.enitity.Category;
import in.edac.enitity.User;


@WebServlet("/login-action")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			
			User user=new User(null,null,email,null,password,null,null,null);
			LoginDao dao=new LoginDao();
			boolean check=dao.authenticateUser(user);
			
			CategoryDao dao1=new CategoryDao();
			List<Category> list=dao1.allCategory();
			
			//User user1=dao.getUser(user);
			if(check) {
				
				//session management
				HttpSession session=request.getSession();
				session.setAttribute("auth", 1);
				session.setAttribute("category", list);
				if("me@gmail.com".equals(email)){
					session.setAttribute("user", 1);
				}
				else {
					session.setAttribute("user", 2);
				}
				response.sendRedirect("/miniproject/home.jsp");
			}else {
				throw new Exception("Auth Fails");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.sendRedirect("/miniproject/login.jsp?q=0");
		}
	}

}
