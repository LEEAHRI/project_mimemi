package mimemi.mvc.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import mimemi.mvc.dto.NoticeDTO;
import mimemi.mvc.paging.NoticeListPageCnt;
import mimemi.mvc.paging.OrderListPageCnt;
import mimemi.mvc.util.DbUtil;

public class NoticeDAOImpl implements NoticeDAO {
	private Properties proFile = new Properties();
	
	public NoticeDAOImpl( ) { 
		try {
			proFile.load(getClass().getClassLoader().getResourceAsStream("dbQuery.properties"));
			String value = proFile.getProperty("notice.selectAllNotice");
			System.out.println("value = " + value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

/**
 * 	 �������� ���
 **/
		
	@Override 
	public int insertNotice(NoticeDTO noticeDTO) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		String sql = proFile.getProperty("notice.insertNotice"); 
		int result = 0;
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, noticeDTO.getNoticeTitle());
			ps.setString(2, noticeDTO.getNoticeContent());
			ps.setString(3, noticeDTO.getNoticeAttach());

			result = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}
    /**
     *  �������� ������Ʈ 
     **/
	
	@Override
	public int updateNotice(NoticeDTO noticeDTO) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		String sql = proFile.getProperty("notice.updateNotice"); 
		int  result = 0;
		
		try { 
			con= DbUtil.getConnection();
			con.setAutoCommit(false);
			
			ps =con.prepareStatement(sql);
			ps.setString(1, noticeDTO.getNoticeTitle());
			ps.setString(2, noticeDTO.getNoticeContent());
			ps.setInt(3, noticeDTO.getNoticeNo());
			
			result = ps.executeUpdate();
			if(result==0) {
				con.rollback();
				throw new SQLException("�������� ������ �����߽��ϴ�.");
			}else {
				//������ ������ ���� �ִٸ�, ���� �����Ѵ�.
				if(noticeDTO.getNoticeAttach()!=null) {
					int re = updateFaqImgCon(con,noticeDTO.getNoticeNo(),noticeDTO.getNoticeAttach());
						if(re!=1) {
							con.rollback();
							throw new SQLException("�ı� ���� ������ �����߽��ϴ�.");
						}
				}
				con.commit();
			}
		}finally {
			con.commit();
			DbUtil.dbClose(ps, con);
		}
		return result;
	}
    

	/*�������� �Խñ� ������ ��, �̹����� �����ϴ� �޼ҵ�*/
	public int updateNoticeImgCon(Connection con,int noticeNo, String noticeAttach) throws SQLException {
		PreparedStatement ps =null;
		String sql = proFile.getProperty("notice.updateNoticeImgCon");
		int result =0;
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, noticeAttach);
			ps.setInt(2, noticeNo);
			
			result=ps.executeUpdate();
			System.out.println("�̹������� ...dao");
		}finally {
			DbUtil.dbClose(ps, null);
		}
		return result;
	} 
	
	
	@Override
	public int updateNoticeAttach(int noticeNo, String noticeAttach) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 *  �������� �����ϱ�
	 **/
	
	@Override
	public int deleteNotice(int noticeNo) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		String sql= proFile.getProperty("notice.deleteNotice");
		int result=0;
		
		try {
			con =DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, noticeNo);
			
			result= ps.executeUpdate();
			System.out.println("dao: ������ �����ȣ "+noticeNo);
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}
	
	
	
	
	
	
    /**
     *  �������� ��ü ��ȸ 
     **/
	@Override
	public List<NoticeDTO> selectAllNotice(int pageNum, String filed) throws SQLException {
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql = proFile.getProperty("notice.selectAllNotice");
		List<NoticeDTO> NoticeList = new ArrayList<NoticeDTO>();
		
		if(filed !=null) {
			if (filed.equals("notice_title")) {
				sql = proFile.getProperty("notice.selectAllTitle");
			} else if (filed.equals("notice_content")) { 
				sql = proFile.getProperty("notice.selectAllContent");
			}
		}
			
		try {
			// ��ü ���ڵ� ���� ��ȯ�ϴ� �޼ҵ�� db�� ����� �� ���ڵ� ���� ����
			int totalCount = this.getTotalCount();
			
			// ���� ��ü ���ڵ� ���� ��ü ������ ���� ����
			int totalPage = totalCount % NoticeListPageCnt.getPagesize() == 0 ? totalCount / NoticeListPageCnt.getPagesize() : (totalCount / NoticeListPageCnt.getPagesize()) + 1;
			
			NoticeListPageCnt NoticeListPageCnt = new NoticeListPageCnt();
			NoticeListPageCnt.setPageCnt(totalPage); 
			NoticeListPageCnt.setPageNo(pageNum);  
					
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, (pageNum - 1) * NoticeListPageCnt.pagesize + 1); 
			ps.setInt(2, pageNum * NoticeListPageCnt.pagesize); 
            
			rs = ps.executeQuery();
			while(rs.next()) {
				NoticeList.add(new NoticeDTO(rs.getInt(1), rs.getString(2), rs.getString(3),
						               rs.getString(4), rs.getString(5)));
				
			}
		
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return NoticeList;
	}
	
	/**
	 * ��ü ���ڵ� �� ��ȯ
	 * */

	private int getTotalCount() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = proFile.getProperty("notice.getTotalCount");
		int totalCount = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				totalCount = rs.getInt(1);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		
		return totalCount;
	}


	@Override
	public List<NoticeDTO> selectAllByPaging(int pageNo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

/**
 * �������� �󼼺��� 
 **/
	
	@Override
	public NoticeDTO selectByNoticeNo(int noticeNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = proFile.getProperty("notice.selectByNoticeNo");
		NoticeDTO noticeDetail = null;
	/*	SimpleDateFormat noticeFormat = new SimpleDateFormat("yyyy-MM-DD"); ���ؾȰ� ���߿� ����*/
		
		try { 
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, noticeNo);
			rs=ps.executeQuery();
			
			if(rs.next()) { 
				noticeDetail = new NoticeDTO(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5)
								);	 
		    }
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		
		return noticeDetail;
	}
  /**
   *  �������� Ű����� �˻��ϱ�   
   **/
	
	@Override
	public List<NoticeDTO> selectByKeyword(String noticeKeyword, String field) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<NoticeDTO> noticList = new ArrayList<NoticeDTO>();
		String sql = proFile.getProperty("notic.selectByKeyword")
		
		return null;
	}

}
