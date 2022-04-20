package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dao.EventDAO;
import mimemi.mvc.dao.EventDAOImpl;
import mimemi.mvc.dto.EventDTO;
import mimemi.mvc.dto.ReviewDTO;

public class EventServiceImpl implements EventService {
	private EventDAO eventDAO = new EventDAOImpl();
	
	/**
	 * �̺�Ʈ �Խñ� ���
	 * @param: EventDTO(int eventId, String eventTitle, String eventContent, String eventAttach, String eventImg,
	 * 			String eventStartdate, String eventEnddate)
	 * */
	@Override
	public void insert(EventDTO event, String saveDir) throws SQLException {
		int result = eventDAO.insert(event);
		if(result==0) {
			//÷�������� �ִٸ� save������ ������ ÷������ �����ϱ�
			if(event.getEventAttach()!=null) {
				new java.io.File(saveDir+"/"+event.getEventAttach()).delete(); //���Ȯ���ϱ�
			}
			
			if(event.getEventImg()!=null) {
				new java.io.File(saveDir+"/"+event.getEventImg()).delete(); //���Ȯ���ϱ�
			}
			throw new SQLException("�̺�Ʈ�� ��ϵ��� �ʾҽ��ϴ�.");
		}

	}
	
	
	
	/**
	 * �̺�Ʈ �Խñ� ����
	 * @param: EventDTO(int eventId, String eventTitle, String eventContent, String eventStartdate,
	 * 			String eventEnddate)
	 * 			�Խñ� ����� ����, �����ϰ� �����ϸ� ����
	 * @return: int(���� ������ ���ڵ� ��)
	 * */
	@Override
	public void updateEvent(EventDTO event, String saveDir ) throws SQLException {
		EventDTO dbEvent = eventDAO.selectByEventNo(event.getEventNo());
		if(dbEvent==null) {
			throw new SQLException("�̺�Ʈ ��ȣ�� �ش��ϴ� �̺�Ʈ�� ã�� �� �����ϴ�.");
		}
	//db������ ���� �̺�Ʈ�� ÷�����ϸ�� ����ϸ��� �̸� ���Ѵ�.
	String dbAttach = dbEvent.getEventAttach();
	String dbImg = dbEvent.getEventImg();
	
	//dao�� �Խù� �����Ѵ�.
	int result = eventDAO.updateEvent(event);
		
		if(result==0) {
			//÷�������� �ִٸ� save������ ������ ÷���� ÷������ �����ϱ�
			if(dbAttach!=null) {
				new java.io.File(saveDir+"/"+dbAttach).delete(); //���Ȯ���ϱ�
			}
			if(dbImg!=null) {
				new java.io.File(saveDir+"/"+dbImg).delete(); //���Ȯ���ϱ�
			}
			throw new SQLException("�������� �ʾҽ��ϴ�.");
		}else {
			//÷�������� �ִٸ� save������ ������ ÷���� ÷������ �����ϱ�
			if(dbAttach!=null) {
				new java.io.File(saveDir+"/"+dbAttach).delete(); //���Ȯ���ϱ�
			}
			System.out.println("�����Ǿ��� ���� �����̸�:"+dbAttach);
			
			if(dbImg!=null) {
				new java.io.File(saveDir+"/"+dbImg).delete(); //���Ȯ���ϱ�
			}
		}

	}
	
	/**
	 * �̺�Ʈ �Խñ� ����� �̹��� ����
	 * @param: int eventId, String eventImg
	 * @return: int(���� ������ ���ڵ� ��)
	 * */
	@Override
	public void updateEventImg(int eventId, String eventImg) throws SQLException {
		// TODO Auto-generated method stub

	}
	
	/**
	 * �̺�Ʈ �Խñ� �� �̹��� ����
	 * @param: int eventId, String eventAttach
	 * @return: int(���� ������ ���ڵ� ��)
	 * */
	@Override
	public void updateEventAttach(int eventId, String eventAttach) throws SQLException {
		// TODO Auto-generated method stub

	}
	
	/**
	 * �̺�Ʈ �Խñ� ��ü ��ȸ
	 * @return: List<EventDTO>
	 * */
	@Override
	public List<EventDTO> selectAll(String state ,int pageNo) throws SQLException {
		List<EventDTO> eventList = eventDAO.selectAll(state, pageNo);

		return eventList;
	}
	
	/**
	 * �̺�Ʈ �Խñ� ���� ��Ȳ�� ��ȸ
	 * sysdate�� �������� ���� ����/ ������ / ���� �ϷḦ ������ ��ȸ
	 * @param: String state(���� ����, ������, ���� �Ϸῡ ���� ������ ����)
	 * @return: List<EventDTO>
	 * */
	@Override
	public List<EventDTO> selectByDate(String state) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * �̺�Ʈ �Խñ� �� ��ȸ
	 * �۹�ȣ �������� �Խñ� �� ��ȸ
	 * @param: int eventNo
	 * @return: EventDTO
	 * */
	@Override
	public EventDTO selectByEventNo(int eventNo) throws SQLException {
		EventDTO event = eventDAO.selectByEventNo(eventNo);
		
		if(event==null) {
			throw new SQLException("�󼼺��⸦ �ҷ��� �� �����ϴ�.");
		}
		return event;
	}
	
	/**
	 * �̺�Ʈ ��ü �˻�(������ ó��)
	 * @param int pageNo
	 * Ư�� �������� Ŭ������ �� �� �������� �Ѿ��.
	 * */
	@Override
	public List<EventDTO> getEventList(int pageNo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EventDTO> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(EventDTO event) throws SQLException {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void updateEvent(EventDTO event) throws SQLException {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void delete(EventDTO event, String path) throws SQLException{
		int result = eventDAO.delete(event.getEventNo());
		
		if(result==0) {
			throw new SQLException("�������� �ʾҽ��ϴ�.");
		}
		if(event.getEventAttach()!=null) {
			new java.io.File(path + "/" + event.getEventAttach()).delete();
		}
		if(event.getEventImg()!=null) {
			new java.io.File(path + "/" + event.getEventImg()).delete();
		}
		
	}

}
