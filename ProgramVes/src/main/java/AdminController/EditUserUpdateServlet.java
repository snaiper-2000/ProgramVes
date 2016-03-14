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
		String id = request.getParameter("id");
		String surname = request.getParameter("surname");
		String name = request.getParameter("name");
		String middleName = request.getParameter("middleName");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String mobileTelephone = request.getParameter("mobileTelephone");
		String email = request.getParameter("email");
		
		//запрет на редактирование учетной записи администратора
		if(login.equals("admin")){
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminHomeServlet");                  
            request.setAttribute("message", "Редактирование учетной записи администратора запрещено!");                                       
            dispatcher.forward(request, response);
			
			return;
		}
		
		User user = new User (surname,name,middleName,login,password,mobileTelephone,email);
		
		EditUserUpdateService editUserUpdateService = new EditUserUpdateService();
		boolean result = editUserUpdateService.updateUser(user,id);
		
		if(result == false){
			//response.sendRedirect("index.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminHomeServlet");                  
            request.setAttribute("message", "Данные пользователя успешно изменены");                                       
            dispatcher.forward(request, response);
		}else{
			//response.sendRedirect("index.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminHomeServlet");                  
            request.setAttribute("message", "Пользователь с таким ЛОГИНОМ уже существует! ");                                       
            dispatcher.forward(request, response);
		}
	}

}
