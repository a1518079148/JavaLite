package fliters;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 跨域过滤器
 */
public class CORSFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
		httpResponse.setHeader("Access-Control-Allow-Origin", "*");
		
		httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
		
		httpResponse.setHeader("Access-Control-Allow-Methods", "*");
		
		//token是自定义header，携带多个时逐一添加
		httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type,token");
		
		httpResponse.setHeader("Access-Control-Max-Age", "3600");
		httpResponse.setHeader("XDomainRequestAllowed","1");

		if("OPTIONS".equals(request.getMethod())) {
			return;
		}
		filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}