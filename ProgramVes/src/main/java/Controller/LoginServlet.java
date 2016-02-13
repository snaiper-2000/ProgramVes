package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private User user = new User();
       
    public LoginServlet() {
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		//response.setContentType("charset=UTF-8");
		
		//String loginUser = "admin";
		//String passwordUser = "root";
		
		if(user.getLogin().equals(login) && user.getPassword().equals(password)){
			HttpSession session = request.getSession();
			session.setAttribute("user", user.getLogin());
			session.setMaxInactiveInterval(30*60);
			//RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.jsp");
			//rd.include(request, response);
			response.sendRedirect("home.jsp");//óòî÷íèòü?
		}else{
			/*RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
            PrintWriter out= response.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");//çàìåíèòü ñîîáùåíèåì
            rd.include(request, response);*/
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");                  
            request.setAttribute("message", "Имя пользователя или пароль неправильные ");                                       
            dispatcher.forward(request, response);
		}
	}

}

