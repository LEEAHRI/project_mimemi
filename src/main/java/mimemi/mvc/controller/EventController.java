package mimemi.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mimemi.mvc.dao.EventDAO;
import mimemi.mvc.dto.EventDTO;
import mimemi.mvc.dto.ReviewDTO;
import mimemi.mvc.dto.RgCouponDTO;
import mimemi.mvc.service.EventService;
import mimemi.mvc.service.EventServiceImpl;

public class EventController implements Controller {
	private EventService eventService = new EventServiceImpl();
	
	@Override
	public ModelAndView hendlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public ModelAndView selectAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String curPageNo = request.getParameter("pageNum");
		if(curPageNo ==null||curPageNo.equals("")) {
			curPageNo="1";
		}
		String field =request.getParameter("field");
		if(field==null||field.equals("")) {
			field="reg";
		}
		
		System.out.println(field+" ������ ��ȣ: "+curPageNo);
		
		List<EventDTO> eventList = eventService.selectAll(field, Integer.parseInt(curPageNo));
		
		request.setAttribute("eventList", eventList);
		request.setAttribute("pageNum", curPageNo);
		request.setAttribute("field", field);
		
		return new ModelAndView("board/eventAllList.jsp");
	}
	
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String saveDir = request.getServletContext().getRealPath("/img/save");
		int maxSize = 1024*1024*100;
		String encoding= "UTF-8";
		//System.out.println(saveDir);
		
		MultipartRequest m = new MultipartRequest(request, saveDir,maxSize, encoding, new DefaultFileRenamePolicy());
		
		String eventTitle = m.getParameter("eventTitle");
		String eventContent = m.getParameter("eventContent");
		String eventStartdate = m.getParameter("eventStartdate");
		String eventEnddate =m.getParameter("eventEnddate");

		
		System.out.println("�̺�Ʈ����Ϸ��� ����: "+ eventTitle);
		
		EventDTO event = new EventDTO(eventTitle, eventContent, eventStartdate, eventEnddate);
		
			//���� ÷�� �ߴٸ�(�ʼ���Ұ� �ƴϱ⶧���� �����ڿ� �����Ƿ� �߰����ش�)
			if(m.getFilesystemName("eventAttach")!=null) {
				
				//�����̸� �����Ѵ�.
				event.setEventAttach(m.getFilesystemName("eventAttach"));
				
			}
			
			if(m.getFilesystemName("eventImg")!=null) {
				//�����̸� �����Ѵ�.
				event.setEventImg(m.getFilesystemName("eventImg"));
			}
			
		//saveDir: ������ ����ؼ� ÷�������� ������ save ��ε� ������.
		eventService.insert(event,saveDir);
		return new ModelAndView("front?key=event&methodName=selectAll",true);
	}
	
}
