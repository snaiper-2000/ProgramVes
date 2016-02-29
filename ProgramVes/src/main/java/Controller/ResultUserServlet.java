package Controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Result;
import Service.ResultUserService;


@WebServlet("/ResultUserServlet")
public class ResultUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ResultUserService resultUserService = new ResultUserService(); 
    
    public ResultUserServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getParameter("resultDate");
		
		System.out.println("текущая дата "+request.getParameter("resultDate"));
		
		String resultDate = request.getParameter("resultDate");
		
		//получение из базы результатов переключений для текущей даты
		Result result = resultUserService.getResultUser(resultDate);
		
		//передача переключений на страницу result_user.jsp
		request.setAttribute("result", result);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/result_user.jsp");
        dispatcher.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
