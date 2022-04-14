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
 * ������ ���۵� �� ������ Controller�� ����ü�� �̸� ������ map�� ����
 */
@WebListener
public class AjaxHandlerMappingListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent e)  { 
        // ��Ʈ�ѷ��� Ŭ������ ������ �� ����
    	Map<String, Controller> map = new HashMap<String, Controller>();
        Map<String, Class<?>> clzMap = new HashMap<String, Class<?>>();
        
        // properties ������ �������� ���� resourseBundle ��ü�� ������ properties ��������
        ResourceBundle rb = ResourceBundle.getBundle("ajaxMapping");
        
        try {
			for(String key : rb.keySet()) { // key �迭�� �ϳ��� ������
				String value = rb.getString(key); // key�� �̿��� value�� ��������
				
				// String Ÿ���� value�� �̿��� Controller ��ü ����
				Class<?> className = Class.forName(value);
				Controller controller = (Controller)className.getDeclaredConstructor().newInstance();
				System.out.println("Controller = " + controller);
				
				// map���� Controller�� �ٿ�ĳ������ ��ü��,
				// clzMap�� ���� �޼ҵ带 ���� ����ϱ� ���� Class<?> Ÿ���� ��ü�� ����
				map.put(key, controller);
				clzMap.put(key, className);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
        
        // application ������ map, clzMap ����
        ServletContext application = e.getServletContext();
        application.setAttribute("ajaxMap", map);
        application.setAttribute("ajaxClzMap", clzMap);
        
        // �ΰ� �ɼ�: ���� ������Ʈ�� ��Ʈ ��θ� application�� ������ ��� ������ �� ���
        application.setAttribute("path", application.getContextPath());
        
    }
	
}
