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
		
		
		User user = new User (surname,name,middleName,login,password,mobileTelephone,email);
		
		//������ �� �������������� ������� ������ ��������������
		if(login.equals("admin")){
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminHomeServlet");                  
            request.setAttribute("message", "�������������� ������� ������ �������������� ���������!");                                       
            dispatcher.forward(request, response);
			
			return;
		}
		
        if(surname.equals("") || name.equals("") || middleName.equals("") || login.equals("") || password.equals("") || mobileTelephone.equals("") || email.equals("")){
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminHomeServlet");                  
            request.setAttribute("message", "�� ��������� ��� ����!");                                       
            dispatcher.forward(request, response);
			return;
            
		}
		
		//User user = new User (surname,name,middleName,login,password,mobileTelephone,email);
		
		EditUserUpdateService editUserUpdateService = new EditUserUpdateService();
		boolean result = editUserUpdateService.updateUser(user,id);
		
		if(result == true){
			//response.sendRedirect("index.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminHomeServlet");                  
            request.setAttribute("message", "������ ������������ ������� ��������");                                       
            dispatcher.forward(request, response);
		}else{
			//response.sendRedirect("index.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminHomeServlet");                  
            request.setAttribute("message", "������������ � ����� ������� ��� ����������! ");                                       
            dispatcher.forward(request, response);
		}
	}

}
