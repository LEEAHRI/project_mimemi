package mimemi.mvc.listener;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import mimemi.mvc.controller.Controller;

/**
 * ������ start�� �� ������ Controller�� ����ü�� �̸� �����ؼ� map�� ����
 * 
 */
@WebListener
public class HandlerMappingListener implements ServletContextListener {
	
	public void contextInitialized(ServletContextEvent e)  { 
		Map<String, Controller> map = new HashMap<String, Controller>();
		Map<String, Class<?>> clzMap = new HashMap<String, Class<?>>();
		
		ServletContext application = e.getServletContext();
		String fileName = application.getInitParameter("fileName");
		
		// properties ���� �ε�
//		ResourceBundle rb = ResourceBundle.getBundle(yuda/mvc/listener/actionMapping);
		ResourceBundle rb = ResourceBundle.getBundle(fileName);
		
		try {
			for(String key : rb.keySet()) {
				String value = rb.getString(key);
				 
				// String ���ڿ��� Controller ��ü�� �����ؾ� ��
				 
				Class<?> className = Class.forName(value);
				Controller controller = (Controller)className.getDeclaredConstructor().newInstance();
				System.out.println("Controller = " + controller);
				   	 
				map.put(key, controller);
				clzMap.put(key, className);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		application.setAttribute("map", map);
		application.setAttribute("clzMap", clzMap);
		application.setAttribute("path", application.getContextPath());
	}

}
