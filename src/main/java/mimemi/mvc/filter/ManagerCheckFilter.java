package mimemi.mvc.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class SessionCheckFilter
 */
//@WebFilter(urlPatterns = {"/manager/*"})
public class ManagerCheckFilter extends HttpFilter implements Filter {
    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// ���� ó��: ������ ��������� üũ
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		if(session.getAttribute("loginUser") == null) {
			// �������� ���� �����
			req.setAttribute("errorMsg", "�߸��� �����Դϴ�.");
			req.getRequestDispatcher("/error/error.jsp").forward(request, response);
			return; // �޼ҵ带 ���������ÿ�!
		}
		
		chain.doFilter(request, response);
		
		// ���� ó��
	}

}
