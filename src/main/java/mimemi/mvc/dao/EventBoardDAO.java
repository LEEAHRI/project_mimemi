package mimemi.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.EventDTO;

public interface EventBoardDAO {
	/**
	 * �̺�Ʈ ���
	 * */
	int insertEvent(EventDTO eventDTO) throws SQLException;

	/**
	 * �̺�Ʈ ���� 
	 * */
	int updateEvent(EventDTO eventDTO) throws SQLException;

	/**
	 * �̺�Ʈ ����
	 * */
	int deleteEvent() throws SQLException;
	/**
	 * �̺�Ʈ ��ü �˻�
	 * */
	List<EventDTO> selectAllEvent() throws SQLException;

	/**
	 * �̺�Ʈ ��ü �˻�(������ ó��)
	 * */
	List<EventDTO> getEventList(int pageNo) throws SQLException;

	
}
