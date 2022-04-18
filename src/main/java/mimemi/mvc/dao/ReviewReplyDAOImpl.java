package mimemi.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import mimemi.mvc.dto.ReviewReplyDTO;
import mimemi.mvc.util.DbUtil;

public class ReviewReplyDAOImpl implements ReviewReplyDAO {
	private Properties proFile = new Properties();
	
	/**
	 * �Խñ� ��ȸ�� �� �޸� ��۵� ���� ��ȸ�ϴ� �޼ҵ�
	 * */
	@Override
	public List<ReviewReplyDTO> selectReplyByReviewNo(int reviewNo) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ReviewReplyDTO> replylist = new ArrayList<ReviewReplyDTO>();
		String sql="select * from REVIEW_REPLY where REVIEW_NO=? order by REPLY_REGDATE desc";
		//String sql=proFile.getProperty("");
		SimpleDateFormat replyFormat = new SimpleDateFormat("yyyy-MM-dd HH�� mm��");
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, reviewNo);
			rs =ps.executeQuery();
			
			while(rs.next()) {
				ReviewReplyDTO reply=new ReviewReplyDTO(
						rs.getInt(1),
						rs.getInt(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						replyFormat.format(rs.getDate(6))
						);
				replylist.add(reply);
			}

		}finally {
			DbUtil.dbClose(rs, ps, con);
		}	
		return replylist;
	}
	
	
	/**
	 * ��� ���
	 * */
	@Override
	public int insertReviewReply(ReviewReplyDTO reviewreplyDTO) throws SQLException {
		// TODO Auto-generated method stub
		//���糯¥ java���� ���ؼ� �ֱ�
		return 0;
	}

	/**
	 * ��� ����
	 * */
	@Override
	public int updateReviewReply(ReviewReplyDTO reviewreplyDTO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * ��� ����
	 * */
	@Override
	public int deleteReviewReply(int answerNo) throws SQLException {
		Connection con =null;
		PreparedStatement ps =null;
		String sql="delete from REVIEW_REPLY where REPLY_NO=?";
		//String sql=proFile.getProperty("");
		
		return 0;
	}
	
	/**
	 * �ı� �Խù� �����Ҷ� �ش� ��� �����ϱ�
	 * */
	@Override
	public int deleteReviewReplyByReviewNo(Connection con,int reviewNo) throws SQLException {
		PreparedStatement ps =null;
		String sql="delete from REVIEW_REPLY where REVIEW_NO=?";
		//String sql=proFile.getProperty("");
		int result=0;
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, reviewNo);
			
			result =ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, null);
		}
		
		return result;
	}
	

}
