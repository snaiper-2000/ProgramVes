package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Result;
import Model.User;
import Service.HomeUserService;


@WebServlet("/HomeUserServlet")
public class HomeUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HomeUserService homeUserService = new HomeUserService();
    private User user;
  
    
    public HomeUserServlet() {
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		user =(User)session.getAttribute("userBD");
		//System.out.println("�omeUserServlet ����� id usera = "+user+" ��� "+user.getDateUserReg());
		//String id = user.getLogin();
		System.out.println("�omeUserServlet ����� id usera = "+user.getLogin()+" ��� "+user);
		
		Long userId = user.getId();
		
		System.out.println("��� ��� ��� "+userId);
		
		List<Object[]> resultDate = homeUserService.getHomeUserDate(userId);
		
		
		if(resultDate !=null){
			
			request.setCharacterEncoding("UTF-8");
			request.setAttribute("resultDate", resultDate);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/home_user.jsp");                                                        
            dispatcher.forward(request, response);
		}else{
			
			request.setCharacterEncoding("UTF-8");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/home_user.jsp"); 
			request.setAttribute("message", "������ ������������ �� �������� ������������ ");
            dispatcher.forward(request, response);
			
		}
		/*for(Object[] obj :resultDate ){
			System.out.println("HomeUserServlet ������� ������ ����� ���� "+obj[0].toString());
		}*/
		
		System.out.println("���� ������������ "+resultDate);
	}

}
