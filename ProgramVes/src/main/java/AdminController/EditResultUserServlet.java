package AdminController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Result;
import Service.ResultUserService;


@WebServlet("/EditResultUserServlet")
public class EditResultUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ResultUserService resultUserService = new ResultUserService();
       
    
    public EditResultUserServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	request.getParameter("resultDate");
		
		System.out.println("текущая дата "+request.getParameter("resultDate"));
		
		String resultDate = request.getParameter("resultDate");
		
		//получение из базы результатов переключений для текущей даты
		Result result = resultUserService.getResultUser(resultDate);
		
		//передача переключений на страницу result_user.jsp
		request.setAttribute("result", result);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/edit_result_user.jsp");
        dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
