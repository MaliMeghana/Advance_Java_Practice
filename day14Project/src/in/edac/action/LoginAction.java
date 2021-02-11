package in.edac.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.edac.dao.LoginDao;
import in.edac.enitity.User;


@WebServlet("/login-action")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			
			User user=new User(username,password,null,null);
			LoginDao dao=new LoginDao();
			boolean check=dao.authenticateUser(user);
			
			if(check) {
				//session management
				HttpSession session=request.getSession();
				session.setAttribute("auth", 1);
				response.sendRedirect("/day14Project/home.jsp");
			}else {
				throw new Exception("Auth Fails");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.sendRedirect("/day14Project/login.jsp?q=0");
		}
	}

}
