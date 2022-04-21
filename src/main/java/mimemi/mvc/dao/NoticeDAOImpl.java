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
import mimemi.mvc.dto.ReviewDTO;
import mimemi.mvc.paging.NoticeListPageCnt;
import mimemi.mvc.paging.OrderListPageCnt;
import mimemi.mvc.paging.PageCnt;
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
//		}catch(SQLException e) {
//			e.printStackTrace();
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
					int re = updateNoticeImgCon(con,noticeDTO.getNoticeNo(),noticeDTO.getNoticeAttach());
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
		String sql = proFile.getProperty("notice.updateFaqImgCon");
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
	public List<NoticeDTO> selectAllNotice(int pageNum, String field) throws SQLException {
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql = proFile.getProperty("notice.selectAllNotice");
		List<NoticeDTO> NoticeList = new ArrayList<NoticeDTO>();
		
		if(field !=null) {
			if (field.equals("notice_title")) {
				sql = proFile.getProperty("notice.selectAllTitle");
			} else if (field.equals("notice_content")) { 
				sql = proFile.getProperty("notice.selectAllContent");
			}
		}
			
		try {
			// ��ü ���ڵ� ���� ��ȯ�ϴ� �޼ҵ�� db�� ����� �� ���ڵ� ���� ����
			int totalCount = this.getTotalCount(field);
			
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

	private int getTotalCount(String field) throws SQLException {
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
	public List<NoticeDTO> selectByKeyword(String noticeKeyword, String field, int pageNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql="";
		//String sql = proFile.getProperty("notic.selectByKeyword")
		List<NoticeDTO> list = new ArrayList<NoticeDTO>();
		SimpleDateFormat noticeFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		if(field.equals("title")){
			sql="select * from (select a.*, rownum rn from (select* from NOTICE where NOTICE_TITLE like ? order by notice_no desc) a) where rn>=? and rn<=?";
			//sql=proFile.getProperty("");
		}else if(field.equals("content")) {
			sql="select * from (select a.*, rownum rn from (select* from NOTICE where NOTICE_CONTENT like ? order by notice_no desc) a) where rn>=? and rn<=?";
			//sql=proFile.getProperty("");
		}
		
	try {
		int totalCount = this.getTotalCountByKeyword(noticeKeyword,field);
		
		int totalPage = totalCount % PageCnt.getPagesize()==0 ? totalCount/PageCnt.getPagesize() :  ((totalCount/PageCnt.getPagesize())+1);
		PageCnt pagecnt = new PageCnt();
		pagecnt.setPageCnt(totalPage);
		pagecnt.setPageNo(pageNo);
		
		con = DbUtil.getConnection();
		ps = con.prepareStatement(sql);
		ps.setString(1, "%"+noticeKeyword+"%");
		
		//������ ó�� : ?�� �� �� �����ϱ�
		ps.setInt(2, ((pageNo-1)*PageCnt.pagesize)+1);
		ps.setInt(3, pageNo*PageCnt.pagesize);

		System.out.println("totalPage = " + totalPage);
		System.out.println("pagecnt = " + pagecnt);
		System.out.println("pageNo = " + pageNo);
		System.out.println("((pageNo-1)*PageCnt.pagesize)+1 = " + (((pageNo-1)*PageCnt.pagesize)+1));
		System.out.println("pageNo*PageCnt.pagesize = " + pageNo*PageCnt.pagesize);
		
		rs= ps.executeQuery();
		while(rs.next()) {
			NoticeDTO notice = new NoticeDTO(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5)
			        );
			list.add(notice); 
			//System.out.println(review.getReviewRegdate());
		}
	}finally {
		DbUtil.dbClose(rs, ps, con);
	}
	return list;
    }
	
	/**
	 * ��ü ���ڵ� �� ��������
	 **/
	  
	private int getTotalCountByKeyword(String keyword, String field) throws SQLException{
		Connection con =null;
		PreparedStatement ps=null;
		ResultSet rs =null;
		int totalCount=0;
		String sql="";
		//String sql=proFile.getProperty("noticce.totalCount");
		
		
		if(field.equals("title")){
			sql="select count(*) from notice where NOTICE_TITLE like ?";
			//sql=proFile.getProperty("");
		}else if(field.equals("content")) {
			sql="select count(*) from notice where NOTICE_CONTENT like ?";
			//sql=proFile.getProperty("");
		}
		
		
		try {
			con=DbUtil.getConnection();
			ps =con.prepareStatement(sql);
			ps.setString(1, "%"+keyword+"%");
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
	   *  (��) �������� Ű����� �˻��ϱ�   
	   **/
	@Override
	public List<NoticeDTO> selectByKeywordClient(String noticeKeyword, String field, int pageNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql="";
		//String sql = proFile.getProperty("notic.selectByKeyword")
		List<NoticeDTO> list = new ArrayList<NoticeDTO>();
		SimpleDateFormat noticeFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		if(field.equals("title")){
			sql="select * from (select a.*, rownum rn from (select* from NOTICE where NOTICE_TITLE like ? order by notice_no desc) a) where rn>=? and rn<=?";
			//sql=proFile.getProperty("");
		}else if(field.equals("content")) {
			sql="select * from (select a.*, rownum rn from (select* from NOTICE where NOTICE_CONTENT like ? order by notice_no desc) a) where rn>=? and rn<=?";
			//sql=proFile.getProperty("");
		}
		
	try {
		int totalCount = this.getTotalCountClient(noticeKeyword,field);
		
		int totalPage = totalCount % PageCnt.getPagesize()==0 ? totalCount/PageCnt.getPagesize() :  ((totalCount/PageCnt.getPagesize())+1);
		PageCnt pagecnt = new PageCnt();
		pagecnt.setPageCnt(totalPage);
		pagecnt.setPageNo(pageNo);
		
		con = DbUtil.getConnection();
		ps = con.prepareStatement(sql);
		ps.setString(1, "%"+noticeKeyword+"%");
		
		//������ ó�� : ?�� �� �� �����ϱ�
		ps.setInt(2, ((pageNo-1)*PageCnt.pagesize)+1);
		ps.setInt(3, pageNo*PageCnt.pagesize);

		System.out.println("totalPage = " + totalPage);
		System.out.println("pagecnt = " + pagecnt);
		System.out.println("pageNo = " + pageNo);
		System.out.println("((pageNo-1)*PageCnt.pagesize)+1 = " + (((pageNo-1)*PageCnt.pagesize)+1));
		System.out.println("pageNo*PageCnt.pagesize = " + pageNo*PageCnt.pagesize);
		
		rs= ps.executeQuery();
		while(rs.next()) {
			NoticeDTO notice = new NoticeDTO(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5)
			        );
			list.add(notice); 
			//System.out.println(review.getReviewRegdate());
		}
	}finally {
		DbUtil.dbClose(rs, ps, con);
	}
	return list;
    }
	
	/**
	 * (��)��ü ���ڵ� �� ��������
	 * */
	private int getTotalCountClient(String keyword, String field) throws SQLException{
		Connection con =null;
		PreparedStatement ps=null;
		ResultSet rs =null;
		int totalCount=0;
		String sql="";
		//String sql=proFile.getProperty("noticce.totalCount");
		
		
		if(field.equals("title")){
			sql="select count(*) from notice where NOTICE_TITLE like ?";
			//sql=proFile.getProperty("");
		}else if(field.equals("content")) {
			sql="select count(*) from notice where NOTICE_CONTENT like ?";
			//sql=proFile.getProperty("");
		}
		
		
		try {
			con=DbUtil.getConnection();
			ps =con.prepareStatement(sql);
			ps.setString(1, "%"+keyword+"%");
			rs=ps.executeQuery();
			if(rs.next()) {
				totalCount=rs.getInt(1);
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return totalCount;
	}
	
	
	
	
}
