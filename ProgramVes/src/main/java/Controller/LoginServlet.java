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
import Service.AuthService;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private User user = new User();
	private AuthService authService = new AuthService();
       
    public LoginServlet() {
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		if(login.equals("") || password.equals("")){
			
			System.out.println("Условие сработало");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");                  
            request.setAttribute("message", "не введены имя пользователя или пароль");                                       
            dispatcher.forward(request, response);
			
            
		}else{
		
		//response.setContentType("charset=UTF-8");
		
		//String loginUser = "admin";
		//String passwordUser = "root";
		//AuthService authService = new AuthService();
		boolean auth = authService.authUser(login, password);
		//if(user.getLogin().equals(login) && user.getPassword().equals(password)){
		if(auth == true){
			HttpSession session = request.getSession();
			session.setAttribute("user", login);
			session.setMaxInactiveInterval(30*60);
			
			User userDB = authService.getUserDB(login);
			session.setAttribute("userBD", userDB);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");                  
            //request.setAttribute("message", "Имя пользователя или пароль неправильные ");                                       
            dispatcher.forward(request, response);
            System.out.println(session.getAttribute("user"));
		}else{ 
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");                  
            request.setAttribute("message", "Имя пользователя или пароль неправильные ");                                       
            dispatcher.forward(request, response);
		}
		}
	}

}

