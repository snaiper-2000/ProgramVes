package AdminController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import AdminService.AdminHomeService;
import Model.Result;
import Model.User;


@WebServlet("/AdminHomeServlet")
public class AdminHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminHomeService adminHomeService = new AdminHomeService();
	User user = null;
	
	List<User> use = new ArrayList<User>();
       
    
    public AdminHomeServlet() {   
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		List<Object> users = adminHomeService.usersInBd();
		session.setMaxInactiveInterval(30*60);
		
			request.setCharacterEncoding("UTF-8");
			request.setAttribute("users", users);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin_home.jsp");                                                        
            dispatcher.forward(request, response);
		
	}
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		List<Object> users = adminHomeService.usersInBd();
		session.setMaxInactiveInterval(30*60);
		
			request.setCharacterEncoding("UTF-8");
			request.setAttribute("users", users);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin_home.jsp");                                                        
            dispatcher.forward(request, response);
		
	}

}
