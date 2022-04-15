package mimemi.mvc.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter(urlPatterns = {"/*"}, initParams = {@WebInitParam(name = "encoding", value="UTF-8")})
public class EncodingFilter extends HttpFilter implements Filter {
	private String encoding;
	
	/**
	 * ���� ȣ�� �� ���� ���� ȣ��Ǵ� �޼ҵ忡��
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// initParam���� ���ڵ� ����� ������ String Ÿ������ ����
		encoding = fConfig.getInitParameter("encoding");
	}
    
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// ���� ó��
		request.setCharacterEncoding(encoding);

		chain.doFilter(request, response);
		
		// ���� ó�� ����
	}

}
