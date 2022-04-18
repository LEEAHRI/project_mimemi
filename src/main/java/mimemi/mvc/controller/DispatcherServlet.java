package mimemi.mvc.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("/front")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// application���� �޾ƿ� map�� ������ ��ü ����
	Map<String, Controller> map;
	Map<String, Class<?>> clzMap;
    
	@Override
	public void init() throws ServletException {
		// Ŭ������ ȣ��Ǹ� ���� ���� ȣ��Ǵ� init �޼ҵ忡�� map, clzMap ȣ���� ����
		map = (Map<String, Controller>)super.getServletContext().getAttribute("map");
		clzMap = (Map<String, Class<?>>)super.getServletContext().getAttribute("clzMap");
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request �������� key���� methodName�� ������ ����
		String key = request.getParameter("key");
		String methodName = request.getParameter("methodName");
		
		if(key == null) {
			key = "elec";
		}
		
		if(methodName == null) {
			methodName = "select";
		}
		
		System.out.println("key = " + key + ", methodName = " + methodName);
		try {
			// clzMap���� Ű ���� �ش��ϴ� ���(Ŭ����) ������ ����
			Class<?> clz = clzMap.get(key);
			// ������ ������ Ŭ�������� �޼ҵ� �̸����� �޼ҵ带 ������(������ �� �Ű������� �Բ� �Է�)
			Method method = clz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			
			// Ű ���� �ش��ϴ� ��Ʈ�ѷ��� ������
			Controller controller = map.get(key);
			
			// ��Ʈ�ѷ����� �޼ҵ带 ȣ���� �� ���ϰ��� ModelAndView�� ����
			ModelAndView mv = (ModelAndView)method.invoke(controller, request, response);
			
			// isRedirect ���� ���� �̵� ��� ����
			if(mv.isRedirect()) { // true�� redirect ���
				response.sendRedirect(mv.getViewName());				
			} else { // false�� forward ���
				request.getRequestDispatcher(mv.getViewName()).forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getCause().getMessage());
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}
	}
}
