package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "ModelFilter",
urlPatterns = {"/model/*"})
public class ModelFilter implements Filter {

	@Override
	public void destroy() {
			
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
       String uri = req.getRequestURI();
        System.out.println("Работает Модел Фильтр uri "+uri);
        
        String uriPath = req.getRequestURI().substring(req.getContextPath().length()); //Получаем путь до страницы
        System.out.println("Работает Модел Фильтр uriPath "+uriPath);
        //this.context.log("Requested Resource::"+uri);
          
        HttpSession session = req.getSession();
        
        System.out.println("Перед ИФ "+session.getAttribute("user"));
        
       /* if(session.getAttribute("user") == null){
    		
        	/*RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");                                                        
            dispatcher.forward(request, response);*/
    		
        	//res.sendRedirect("index.jsp");
        	/*RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");                                                        
            dispatcher.forward(request, response);
        	
    		
    		//filterChain.doFilter(request, response);
        }/*else{
        
        filterChain.doFilter(request, response);
        	
        	/*res.sendRedirect("uriPath");
        	filterChain.doFilter(request, response);*/
        

       
        //filterChain.doFilter(req, res);
        if(session.getAttribute("user") == null){
    		
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");                                                        
            dispatcher.forward(request, response);
    		
        	//res.sendRedirect("index.jsp");
        	
    		
    		filterChain.doFilter(request, response);
        }else{
        	
        	//res.sendRedirect("home.jsp");
        	filterChain.doFilter(request, response);
        }
	}     
	

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		//this.context = fConfig.getServletContext();
        //this.context.log("AuthenticationFilter initialized");
		
	}

}
