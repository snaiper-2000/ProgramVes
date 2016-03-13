package AdminController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AdminService.EditResultDeleteService;


@WebServlet("/EditResultDeleteServlet")
public class EditResultDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EditResultDeleteService editResultDeleteService = new EditResultDeleteService();
	int id;
       
    
    public EditResultDeleteServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String Date = request.getParameter("Date");
        
        //List<Object> resultDate = editResultService.getResultDate(userID);
        
        List<Object> IDUser = editResultDeleteService.getDeteteDateResult(Date);
		
        for(int i=0; i<IDUser.size(); i++){
        	
       id =(Integer) IDUser.get(i);
        	
        	System.out.println("ID при удалении переключений "+ IDUser.get(0));
        	
        }
        
        //System.out.println("ID при удалении переключений "+ IDUser.get(0));
		
		request.setCharacterEncoding("UTF-8");
		//request.setAttribute("IDUser", IDUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/EditResultServlet?userID="+id);
		request.setAttribute("message", "Переключения выбранной даты удалены.");
        dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
