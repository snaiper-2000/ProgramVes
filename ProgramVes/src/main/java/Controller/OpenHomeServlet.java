package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/OpenHomeServlet")
public class OpenHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public OpenHomeServlet() {
    }

	//перенаправляет запросы на страницу home.jsp если создана сессия
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("user") !=null){
    		
			RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");                  
           // request.setAttribute("message", "Имя пользователя или пароль неправильные ");                                       
            dispatcher.forward(request, response);
        
			//response.sendRedirect("home.jsp");
		}
	}

}
