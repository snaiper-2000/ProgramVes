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
		
		Map map = request.getParameterMap();// ??? нужно ли
		Object[] keys = map.keySet().toArray();
		
		
		
	/*	for (int k = 0; k < keys.length; k++) { */
		
		String[] pars = request.getParameterValues((String)keys[0]);
		String[] pars2 = request.getParameterValues((String)keys[1]);
		String[] pars3 = request.getParameterValues((String)keys[2]);
		String[] pars5 = request.getParameterValues((String)keys[3]);
		String[] pars6 = request.getParameterValues((String)keys[4]);
		String[] pars7 = request.getParameterValues((String)keys[5]);
		String[] pars8 = request.getParameterValues((String)keys[6]);
		String[] pars9 = request.getParameterValues((String)keys[7]);
		String[] pars10 = request.getParameterValues((String)keys[8]);
		String[] pars11 = request.getParameterValues((String)keys[9]);
		String[] pars12 = request.getParameterValues((String)keys[10]);
		String[] pars13 = request.getParameterValues((String)keys[11]);
		String[] pars14 = request.getParameterValues((String)keys[12]);
		String[] pars15 = request.getParameterValues((String)keys[13]);
		String[] pars16 = request.getParameterValues((String)keys[14]);
		String[] pars17 = request.getParameterValues((String)keys[15]);
		String[] pars18 = request.getParameterValues((String)keys[16]);
		String[] pars19 = request.getParameterValues((String)keys[17]);
		String[] pars20 = request.getParameterValues((String)keys[18]);
		String[] pars21 = request.getParameterValues((String)keys[19]);
		String[] pars22 = request.getParameterValues((String)keys[20]);
		String[] pars23 = request.getParameterValues((String)keys[21]);
		String[] pars24 = request.getParameterValues((String)keys[22]);
		String[] pars25 = request.getParameterValues((String)keys[23]);
		String[] pars26 = request.getParameterValues((String)keys[24]);
		String[] pars27 = request.getParameterValues((String)keys[25]);
		String[] pars28 = request.getParameterValues((String)keys[26]);
		String[] pars29 = request.getParameterValues((String)keys[27]);
		String[] pars30 = request.getParameterValues((String)keys[28]);
		String[] pars31 = request.getParameterValues((String)keys[29]);
		String[] pars32 = request.getParameterValues((String)keys[30]);
		
		result.setFlag1(pars[0]);
		result.setFlag2(pars2[0]);
		result.setFlag3(pars3[0]);
		result.setFlag5(pars5[0]);
		result.setFlag6(pars6[0]);
		result.setFlag7(pars7[0]);
		result.setFlag8(pars8[0]);
		result.setFlag9(pars9[0]);
		result.setFlag10(pars10[0]);
		result.setFlag11(pars11[0]);
		result.setFlag12(pars12[0]);
		result.setFlag13(pars13[0]);
		result.setFlag14(pars14[0]);
		result.setFlag15(pars15[0]);
		result.setFlag16(pars16[0]);
		result.setFlag17(pars17[0]);
		result.setFlag18(pars18[0]);
		result.setFlag19(pars19[0]);
		result.setFlag20(pars20[0]);
		result.setFlag21(pars21[0]);
		result.setFlag22(pars22[0]);
		result.setFlag23(pars23[0]);
		result.setFlag24(pars24[0]);
		result.setFlag25(pars25[0]);
		result.setFlag26(pars26[0]);
		result.setFlag27(pars27[0]);
		result.setFlag28(pars28[0]);
		result.setFlag29(pars29[0]);
		result.setFlag30(pars30[0]);
		result.setFlag31(pars31[0]);
		result.setFlag32(pars32[0]);
		
		HttpSession session = request.getSession();
		String user =(String)session.getAttribute("user");
		System.out.println("Атрибуты user в ResultServlet "+user); 
		System.out.println("Ïå÷àòü çíà÷åíèå ôëàãîâ "+result.getFlag1()+result.getFlag2()+result.getFlag3());
		
		ResultService resultService = new ResultService();
		resultService.saveResult(user,result);
		
		request.setAttribute("result", result);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
        dispatcher.forward(request, response);
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
