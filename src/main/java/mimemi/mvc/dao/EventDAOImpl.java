package mimemi.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import mimemi.mvc.dto.EventDTO;
import mimemi.mvc.util.DbUtil;

public class EventDAOImpl implements EventDAO {
	private Properties proFile = new Properties();
	
	/**
	 * dbQuery.properties �ε��� Properties ��ü�� ����
	 * */
	public EventDAOImpl() {
		try {
			proFile.load(getClass().getClassLoader().getResourceAsStream("dbQuery.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �̺�Ʈ �Խñ� ���
	 * @param: EventDTO(int eventId, String eventTitle, String eventContent, String eventAttach, String eventImg,
	 * 			String eventStartdate, String eventEnddate)
	 * @return: int(��� ������ ���ڵ� ��)
	 * */
	@Override
	public int insert(EventDTO event) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * �̺�Ʈ �Խñ� ����
	 * @param: EventDTO(int eventId, String eventTitle, String eventContent, String eventStartdate,
	 * 			String eventEnddate)
	 * 			�Խñ� ����� ����, �����ϰ� �����ϸ� ����
	 * @return: int(���� ������ ���ڵ� ��)
	 * */
	@Override
	public int updateEvent(EventDTO event) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * �̺�Ʈ �Խñ� ����� �̹��� ����
	 * @param: int eventId, String eventImg
	 * @return: int(���� ������ ���ڵ� ��)
	 * */
	@Override
	public int updateEventImg(int eventId, String eventImg) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * �̺�Ʈ �Խñ� �� �̹��� ����
	 * @param: int eventId, String eventAttach
	 * @return: int(���� ������ ���ڵ� ��)
	 * */
	@Override
	public int updateEventAttach(int eventId, String eventAttach) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * �̺�Ʈ �Խñ� ��ü ��ȸ
	 * @return: List<EventDTO>
	 * */
	@Override
	public List<EventDTO> selectAll() throws SQLException {
		Connection con =null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		
		List<EventDTO> eventList = new ArrayList<EventDTO>();
		SimpleDateFormat eventFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		//event.selectAll=select * from EVENT order by EVENT_NO desc
		String sql = proFile.getProperty("event.selectAll");
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				EventDTO event = new EventDTO(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						eventFormat.format(rs.getDate(6)),
						eventFormat.format(rs.getDate(7)), 
						eventFormat.format(rs.getDate(8))
						);
				
				eventList.add(event);
			}
			
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
			
	
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
		// TODO Auto-generated method stub
		return null;
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

}
