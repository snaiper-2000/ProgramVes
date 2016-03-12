package AdminController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AdminService.EditUserUpdateService;
import Model.User;


@WebServlet("/EditUserUpdateServlet")
public class EditUserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EditUserUpdateServlet() {
        
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
		
		User user = new User (surname,name,middleName,login,password,mobileTelephone,email);
		
		EditUserUpdateService editUserUpdateService = new EditUserUpdateService();
		boolean result = editUserUpdateService.updateUser(user);
		
		if(result == true){
			//response.sendRedirect("index.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/edit_user.jsp");                  
            request.setAttribute("message", "Данные пользователя успешно изменены");                                       
            dispatcher.forward(request, response);
		}else{
			//response.sendRedirect("index.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/edit_user.jsp");                  
            request.setAttribute("message", "Пользователь с таким ЛОГИНОМ уже существует! ");                                       
            dispatcher.forward(request, response);
		}
	}

}
