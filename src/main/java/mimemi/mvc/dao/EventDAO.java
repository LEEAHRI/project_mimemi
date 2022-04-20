package mimemi.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.EventDTO;

public interface EventDAO {
	/**
	 * �̺�Ʈ �Խñ� ���
	 * @param: EventDTO(int eventId, String eventTitle, String eventContent, String eventAttach, String eventImg,
	 * 			String eventStartdate, String eventEnddate)
	 * @return: int(��� ������ ���ڵ� ��)
	 * */
	int insert(EventDTO event) throws SQLException;
	
	/**
	 * �̺�Ʈ �Խñ� ����
	 * @param: EventDTO(int eventId, String eventTitle, String eventContent, String eventStartdate,
	 * 			String eventEnddate)
	 * 			�Խñ� ����� ����, �����ϰ� �����ϸ� ����
	 * @return: int(���� ������ ���ڵ� ��)
	 * */
	int updateEvent(EventDTO event) throws SQLException;
	
	/**
	 * �̺�Ʈ �Խñ� ����� �̹��� ����
	 * @param: int eventId, String eventImg
	 * @return: int(���� ������ ���ڵ� ��)
	 * */
	int updateEventImg(int eventId, String eventImg) throws SQLException;
	
	/**
	 * �̺�Ʈ �Խñ� �� �̹��� ����
	 * @param: int eventId, String eventAttach
	 * @return: int(���� ������ ���ڵ� ��)
	 * */
	int updateEventAttach(int eventId, String eventAttach) throws SQLException;
	
	/**
	 * �̺�Ʈ �Խñ� ��ü ��ȸ
	 * @return: List<EventDTO>
	 * */
	List<EventDTO> selectAll() throws SQLException;
	
	/**
	 * �̺�Ʈ �Խñ� ���� ��Ȳ�� ��ȸ
	 * sysdate�� �������� ���� ����/ ������ / ���� �ϷḦ ������ ��ȸ
	 * @param: String state(���� ����, ������, ���� �Ϸῡ ���� ������ ����)
	 * @return: List<EventDTO>
	 * */
	List<EventDTO> selectByDate(String state) throws SQLException;
	
	/**
	 * �̺�Ʈ �Խñ� �� ��ȸ
	 * �۹�ȣ �������� �Խñ� �� ��ȸ
	 * @param: int eventNo
	 * @return: EventDTO
	 * */
	EventDTO selectByEventNo(int eventNo) throws SQLException;

	/**
	 * �̺�Ʈ ��ü �˻�(������ ó��)
	 * @param int pageNo
	 * Ư�� �������� Ŭ������ �� �� �������� �Ѿ��.
	 * */
	List<EventDTO> getEventList(int pageNo) throws SQLException;

	/**
	 * �̺�Ʈ �Խñ� ��ü ��ȸ
	 * @return: List<EventDTO>
	 * */
	List<EventDTO> selectAll(String state, int pageNo) throws SQLException;

	int delete(int eventNo)throws SQLException;
	
}
