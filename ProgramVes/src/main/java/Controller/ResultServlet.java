package Controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Result;
import Service.ResultService;


@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Result result = new Result();   
    
    public ResultServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map map = request.getParameterMap();
		Object[] keys = map.keySet().toArray();
		
		
		
	/*	for (int k = 0; k < keys.length; k++) { */
		
		String[] pars = request.getParameterValues((String)keys[0]);
		String[] pars2 = request.getParameterValues((String)keys[1]);
		String[] pars3 = request.getParameterValues((String)keys[2]);
		String[] pars4 = request.getParameterValues((String)keys[3]);
		
		result.setFlag1(pars[0]);
		result.setFlag2(pars2[0]);
		result.setFlag3(pars3[0]);
		result.setFlag4(pars4[0]);
		
		HttpSession session = request.getSession();
		String user =(String)session.getAttribute("user");
		System.out.println("Атрибуты user в ResultServlet "+user); 
		System.out.println("Ïå÷àòü çíà÷åíèå ôëàãîâ "+result.getFlag1()+result.getFlag2()+result.getFlag3()+result.getFlag4());
		
		ResultService resultService = new ResultService();
		resultService.saveResult(user,result);
		
		request.setAttribute("result", result);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
        dispatcher.forward(request, response);
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
