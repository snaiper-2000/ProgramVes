package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Result;
import Model.User;
import Service.AdminHomeService;


@WebServlet("/AdminHomeServlet")
public class AdminHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminHomeService adminHomeService = new AdminHomeService();
	User user = new User();
       
    
    public AdminHomeServlet() {   
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<Object[]> users = adminHomeService.usersInBd();
		
		//User array [];
		
        if(users !=null){
        	
        	System.out.println("������ ������������� "+users);
        	
        	for(int i=0; i<users.size(); i++){
        		System.out.println("������ ������������� ������� � "+i+" "+users.get(i));
        		
        		
        		 
        		//User[] odj = (User[]) users.get(i);
        		System.out.println("������ �������������  1223232 ");
        		
        	}
        	
       
        	// users.get(0);
        	
        	//System.out.println("������ �������������  12 "+users.get(0));
        	/*for(int i=0; i<obj.length; i++){
        		
        		System.out.println("������ ������������� "+obj[i]);
        		
        	}*/
        	
        	
        	 
			
			request.setCharacterEncoding("UTF-8");
			request.setAttribute("users", users);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin_home.jsp");                                                        
            dispatcher.forward(request, response);
		}/*else{
			
			request.setCharacterEncoding("UTF-8");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/home_user.jsp"); 
			request.setAttribute("message", "������ ������������ �� �������� ������������ ");
            dispatcher.forward(request, response);
			
		}*/
		
		/*RequestDispatcher dispatcher = request.getRequestDispatcher("/admin_home.jsp");                                                        
        dispatcher.forward(request, response);
		return;*/
	}

}
