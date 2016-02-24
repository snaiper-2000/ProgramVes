package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.User;
import Service.RegService;
//import Service.RegService1;


@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegServlet() {
        
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		String surname = request.getParameter("surname");
		String name = request.getParameter("name");
		String middleName = request.getParameter("middleName");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String mobileTelephone = request.getParameter("mobileTelephone");
		String email = request.getParameter("email");
		
		/*if(surname ^ name | middleName | login | password | mobileTelephone | email == null){
			
		}*/
		
		User user = new User (surname,name,middleName,login,password,mobileTelephone,email);
		
		try{
			RegService regService = new RegService();
			boolean result = regService.regUser(user);
			
			if(result == true){
				response.sendRedirect("index.jsp");
			}else{
				response.sendRedirect("index.jsp");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/reg.jsp");                  
	            request.setAttribute("message", "Пользователь с таким ЛОГИНОМ или EMAIL уже существует! ");                                       
	            dispatcher.forward(request, response);
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}

}
