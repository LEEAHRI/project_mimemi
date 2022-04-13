package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.EventDTO;

public interface EventBoardService {
	/**
	 * �̺�Ʈ ���
	 * @param EventDTO(int eventId, String eventTitle, String eventContent, String eventAttach, String eventRegdate,
			String eventModidate, String eventStartdate, String eventEnddate)
	 * */
	void insertEvent(EventDTO eventDTO) throws SQLException;

	/**
	 * �̺�Ʈ ����
	 * @param EventDTO(int eventId, String eventTitle, String eventContent, String eventAttach, String eventRegdate,
			String eventModidate, String eventStartdate, String eventEnddate)
	 * */
	void updateEvent(EventDTO eventDTO) throws SQLException;

	/**
	 * �̺�Ʈ ����
	 * */
	void deleteEvent() throws SQLException;
	
	/**
	 * �̺�Ʈ ��ü �˻�
	 * */
	List<EventDTO> selectAllEvent() throws SQLException;

	/**
	 * �̺�Ʈ ��ü �˻�(������ ó��)
	 * */
	List<EventDTO> getEventList(int pageNo) throws SQLException;

}
