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
        
        //фильтрация страницы регистрации
        if ("reg.jsp".equals(uriPath)) {
        	
        	res.sendRedirect("reg.jsp");
        	
        	filterChain.doFilter(request, response);	
        }
        System.out.println("печать uriPath перед /home.jsp "+uriPath);
        
        //фильтрация домашней страницы
        if ("/home.jsp".equals(uriPath)) {
        	
        	if(session.getAttribute("user") == null){
        		
        		res.sendRedirect("index.jsp");
        		
        		filterChain.doFilter(request, response);
        		
        	}else{res.sendRedirect("home.jsp");
        	
        	filterChain.doFilter(request, response);
        	}	
        }
        
        //фильтрция отчет по переключениям пользователя(home_user.jsp)
        if ("/home_user.jsp".equals(uriPath)) {
        	
        	if(session.getAttribute("user") == null){
        		
        		res.sendRedirect("index.jsp");
        		
        		filterChain.doFilter(request, response);
        		
        	}else{res.sendRedirect("home_user.jsp");
        	
        	filterChain.doFilter(request, response);
        	}	
        }
        
        //фильтрция Результаты переключений пользователя(result_user.jsp)
        if ("/result_user.jsp".equals(uriPath)) {
        	
        	if(session.getAttribute("user") == null){
        		
        		res.sendRedirect("index.jsp");
        		
        		filterChain.doFilter(request, response);
        		
        	}else{res.sendRedirect("result_user.jsp");
        	
        	filterChain.doFilter(request, response);
        	}	
        }
        
        //фильтрция Результаты переключений (result.jsp)
        if ("/result.jsp".equals(uriPath)) {
        	
        	if(session.getAttribute("user") == null){
        		
        		res.sendRedirect("index.jsp");
        		
        		filterChain.doFilter(request, response);
        		
        	}else{res.sendRedirect("result.jsp");
        	
        	filterChain.doFilter(request, response);
        	}	
        }
        
        //Панель администратора (admin_home.jsp)
        if ("/admin_home.jsp".equals(uriPath)) {
        	
        	if(session.getAttribute("user") == null){
        		
        		res.sendRedirect("index.jsp");
        		
        		filterChain.doFilter(request, response);
        		
        	}else{res.sendRedirect("admin_home.jsp");
        	
        	filterChain.doFilter(request, response);
        	}	
        }
        
        //администратор редактировать отчет переключений (edit_result.jsp)
        if ("/edit_result.jsp".equals(uriPath)) {
        	
        	if(session.getAttribute("user") == null){
        		
        		res.sendRedirect("index.jsp");
        		
        		filterChain.doFilter(request, response);
        		
        	}else{res.sendRedirect("edit_result.jsp");
        	
        	filterChain.doFilter(request, response);
        	}	
        }
        
        //администратор просмотр результата переключений (edit_result_user.jsp)
        if ("/edit_result_user.jsp".equals(uriPath)) {
        	
        	if(session.getAttribute("user") == null){
        		
        		res.sendRedirect("index.jsp");
        		
        		filterChain.doFilter(request, response);
        		
        	}else{res.sendRedirect("edit_result_user.jsp");
        	
        	filterChain.doFilter(request, response);
        	}	
        }
        
        //администратор редактировать пользователя (edit_user.jsp)
        if ("/edit_user.jsp".equals(uriPath)) {
        	
        	if(session.getAttribute("user") == null){
        		
        		res.sendRedirect("index.jsp");
        		
        		filterChain.doFilter(request, response);
        		
        	}else{res.sendRedirect("edit_user.jsp");
        	
        	filterChain.doFilter(request, response);
        	}	
        }
        
        //тест модель фильтр
        if ("/HomeUserServlet".equals(uriPath)) {
        	
        	if(session.getAttribute("user") == null){
        		
        		res.sendRedirect("error.jsp");
        		
        		filterChain.doFilter(request, response);
        		        	
        	filterChain.doFilter(request, response);
        	}	
        }
        
        if(session == null && (uri.endsWith("html") || uri.endsWith("LoginServlet"))){
        	
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
