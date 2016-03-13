package AdminController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import AdminService.DeleteUserService;


@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DeleteUserService deleteUserService = new DeleteUserService();
	//int id;
       
    
    public DeleteUserServlet() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userID = request.getParameter("userID");
		
		HttpSession session = request.getSession();
		String loginAdmin = (String)session.getAttribute("user");
		
		System.out.println("Вывод объекта из сессии = "+loginAdmin);
		
		if(loginAdmin.equals("admin")){
			
			request.setCharacterEncoding("UTF-8");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminHomeServlet");
			request.setAttribute("message", "Ошибка! Не возможно удалить администратора!");
	        dispatcher.forward(request, response);
			
			return;
		}
		
        deleteUserService.getDeteteUser(userID);
		
       /* for(int i=0; i<IDUser.size(); i++){
        	
        id =(Integer) IDUser.get(i);
        	
        	System.out.println("ID при удалении переключений "+ IDUser.get(0));
        	
        }*/
        
        //System.out.println("ID при удалении переключений "+ IDUser.get(0));
		
		request.setCharacterEncoding("UTF-8");
		//request.setAttribute("IDUser", IDUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminHomeServlet");
		request.setAttribute("message", "Пользователь удален.");
        dispatcher.forward(request, response);
	}

}
