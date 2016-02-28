package Controller;

import java.io.IOException;
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
	private HomeUserService homeUserService = null;
    private User user = null;   
    
    public HomeUserServlet() {
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		user =(User)session.getAttribute("userBD");
		//System.out.println("НomeUserServlet вывод id usera = "+user+" или "+user.getDateUserReg());
		//String id = user.getLogin();
		System.out.println("НomeUserServlet вывод id usera = "+user.getLogin()+" или ");
		
		try{
		homeUserService.getHomeUserDate(user);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("Дата переключений "/*+result.getDateResult()*/);
	}

}
