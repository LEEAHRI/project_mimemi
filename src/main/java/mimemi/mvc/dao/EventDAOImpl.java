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
import mimemi.mvc.paging.PageCnt;
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
		//INSERT INTO EVENT(EVENT_NO,EVENT_TITLE,EVENT_CONTENT,EVENT_ATTACH,EVENT_IMG,EVENT_REGDATE,EVENT_STARTDATE,EVENT_ENDDATE) values(EVENT_NO_SEQ.NEXTVAL,?,?,?,?,sysdate,?,?)
		Connection con =null;
		PreparedStatement ps = null;
		String sql ="INSERT INTO EVENT(EVENT_NO,EVENT_TITLE,EVENT_CONTENT,EVENT_ATTACH,EVENT_IMG,EVENT_REGDATE,EVENT_STARTDATE,EVENT_ENDDATE) values(EVENT_NO_SEQ.NEXTVAL,?,?,?,?,sysdate,?,?)";
		//String sql=proFile.getProperty("");
		int result =0;
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, event.getEventTitle());
			ps.setString(2, event.getEventContent());
			ps.setString(3, event.getEventAttach());
			ps.setString(4, event.getEventImg());
			ps.setString(5, event.getEventStartdate());
			ps.setString(6, event.getEventEnddate());
			
			result=ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
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
	public List<EventDTO> selectAll(String field ,int pageNo) throws SQLException {
		Connection con =null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		
		List<EventDTO> eventList = new ArrayList<EventDTO>();
		SimpleDateFormat eventFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		//event.selectAll=select * from EVENT order by EVENT_NO desc
		String sql = null;
		
		if(field != null) {
			if (field.equals("reg")) {
				sql = "SELECT*FROM (select a.* ,rownum from (select * from EVENT order by event_startdate desc ) a) where rownum >=? and rownum <=?"; //��ü
				//sql = proFile.getProperty("");
			} else if (field.equals("preEvent")) {
				sql = "SELECT*FROM (select a.* ,rownum from (SELECT*FROM EVENT where EVENT_STARTDATE > sysdate order by EVENT_STARTDATE desc ) a) where rownum >=? and rownum <=?"; //������
				//sql = proFile.getProperty("");
			} else if (field.equals("Eventing")) {
				sql = "SELECT*FROM (select a.* ,rownum from (SELECT*FROM EVENT where EVENT_ENDDATE >= sysdate and EVENT_STARTDATE <= sysdate  order by EVENT_STARTDATE desc ) a) where rownum >=? and rownum <=?"; //������
				//sql = proFile.getProperty("");
			}else if (field.equals("afterEvent")) {
				sql = "SELECT*FROM (select a.* ,rownum from ( SELECT*FROM EVENT where EVENT_ENDDATE< sysdate order by EVENT_STARTDATE desc ) a) where rownum >=? and rownum <=?";//����Ϸ�
				//sql = proFile.getProperty("");
			}  
		}
		
		
		try {
			int totalCount =this.getTotalCount(field);
			int totalPage =totalCount%PageCnt.getPagesize()==0 ? totalCount/PageCnt.getPagesize() :  totalCount/PageCnt.getPagesize()+1;
			PageCnt pagecnt = new PageCnt();
			pagecnt.setPageCnt(totalPage);
			pagecnt.setPageNo(pageNo);
			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			//������ ó�� : ?�� �� �� �����ϱ�
			ps.setInt(1, ((pageNo-1)*PageCnt.pagesize)+1);
			ps.setInt(2, pageNo*PageCnt.pagesize);
			
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
	 * ��ü ���ڵ� �� ��������
	 * */
	private int getTotalCount(String field) throws SQLException{
		Connection con =null;
		PreparedStatement ps=null;
		ResultSet rs =null;
		int totalCount=0;
		String sql=null;
		//String sql=proFile.getProperty("review.totalCount");
		if(field != null) {
			if (field.equals("reg")) {
				sql = "SELECT*FROM EVENT order by EVENT_REGDATE desc"; //��ü
				//sql = proFile.getProperty("review.selectAllReg");
			} else if (field.equals("preEvent")) {
				sql = "SELECT*FROM EVENT where EVENT_STARTDATE > sysdate order by EVENT_STARTDATE desc"; //������
				//sql = proFile.getProperty("review.selectAllHigirate");
			} else if (field.equals("Eventing")) {
				sql = "SELECT*FROM EVENT where EVENT_ENDDATE >= sysdate and EVENT_STARTDATE <= sysdate  order by EVENT_STARTDATE desc"; //������
				//sql = proFile.getProperty("review.selectAllRowrate");
			}else if (field.equals("afterEvent")) {
				sql = " SELECT*FROM EVENT where EVENT_ENDDATE< sysdate order by EVENT_STARTDATE desc ";//����Ϸ�
				//sql = proFile.getProperty("review.selectAllView");
			}  
		}
		
		try {
			con=DbUtil.getConnection();
			ps =con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {
				totalCount=rs.getInt(1);
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return totalCount;
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

	@Override
	public List<EventDTO> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
