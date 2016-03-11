package AdminController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AdminService.EditUserService;

@WebServlet("/EditUser")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EditUserService editUserService = new EditUserService();
       
    
    public EditUser() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String userID = request.getParameter("userID");
		
		List<Object> userDB = editUserService.getUserDB(userID);
		
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("userDB", userDB);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/edit_user.jsp");                                                        
        dispatcher.forward(request, response);
		
	}


}
