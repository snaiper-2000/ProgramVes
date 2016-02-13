package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "AuthFilter",
urlPatterns = {"/*"})
public class AuthFilter implements Filter {

	@Override
	public void destroy() {
			
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
       String uri = req.getRequestURI();
        //System.out.println("печать uri "+uri);
        
        String uriPath = req.getRequestURI().substring(req.getContextPath().length()); //Получаем путь до страницы
        //System.out.println("печать uriPath "+uriPath);
        //this.context.log("Requested Resource::"+uri);
         
        HttpSession session = req.getSession();
        //String perem = (String) session.getAttribute("user");
        System.out.println("печать uriPath перед reg.jsp "+uriPath);
        if ("reg.jsp".equals(uriPath)) {
        	
        	res.sendRedirect("reg.jsp");
        	
        	filterChain.doFilter(request, response);	
        }
        System.out.println("печать uriPath перед /home.jsp "+uriPath);
        if ("/home.jsp".equals(uriPath)) {
        	
        	if(session.getAttribute("user") == null){
        		
        		res.sendRedirect("index.jsp");
        		
        		filterChain.doFilter(request, response);
        		
        	}else{res.sendRedirect("home.jsp");
        	
        	filterChain.doFilter(request, response);
        	}	
        }
        
        if(session == null /*|| session.getAttribute("user") == null*/ && (uri.endsWith("html") || uri.endsWith("LoginServlet"))){
        	
        	//if ("/reg.jsp".equals(uriPath) ||  "logout.jsp".equals(uriPath)) {
           //filterChain.doFilter(request, response);  // вызываем следующий фильтр.
            
            //this.context.log("Unauthorized access request");
            res.sendRedirect("index.jsp");
           
            }else{
            	//System.out.println("Сессия 1 "+ session.getId());
            // pass the request along the filter chain
        	filterChain.doFilter(request, response);
            }
        }
	

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		//this.context = fConfig.getServletContext();
        //this.context.log("AuthenticationFilter initialized");
		
	}

}
