package AdminController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AdminService.EditResultService;


@WebServlet("/EditResultServlet")
public class EditResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EditResultService editResultService = new EditResultService();
       
    public EditResultServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String userID = request.getParameter("userID");
        
        System.out.println("EditResultServlet печатает значение "+userID);
        
        List<Object> resultDate = editResultService.getResultDate(userID);
		
		
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("resultDate", resultDate);
		//request.setAttribute("userID", userID);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/edit_result.jsp");                                                        
        dispatcher.forward(request, response);
	}
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String userID = request.getParameter("userID");
        
        System.out.println("EditResultServlet печатает значение "+userID);
        
        List<Object> resultDate = editResultService.getResultDate(userID);
		
		
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("resultDate", resultDate);
		//request.setAttribute("userID", userID);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/edit_result.jsp");                                                        
        dispatcher.forward(request, response);
	}

}
