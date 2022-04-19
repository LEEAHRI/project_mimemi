package mimemi.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import mimemi.mvc.dto.AnswerDTO;
import mimemi.mvc.util.DbUtil;

public class AnswerDAOImpl implements AnswerDAO {
	private Properties proFile = new Properties();
	
	/**
	 * dbQuery.properties �ε��� Properties ��ü�� ����
	 * */
	public AnswerDAOImpl() {
		try {
			proFile.load(getClass().getClassLoader().getResourceAsStream("dbQuery.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//������ 1:1���� ��� ���
	@Override
	public int insertAnswerReply(AnswerDTO answerDTO) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql = proFile.getProperty("answer.insert");
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);

			ps.setInt(1, answerDTO.getAskNo());
			ps.setString(2, answerDTO.getAnswerContent());
			result=ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		
		return result;
	}
	
	/**
	 * ��ۺ��� 
	 * */

	@Override
	public AnswerDTO selectByAskNo(int askNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		AnswerDTO answerDto=null;
		String sql=proFile.getProperty("answer.select");
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, askNo);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				answerDto = new AnswerDTO(
						rs.getInt(1),
						rs.getInt(2),
						rs.getString(3),
						rs.getString(4));
			}
	
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		
		
		return answerDto;
	}

	@Override
	public int updateAnswerReply(AnswerDTO answerDTO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * ��� �����ϱ�
	 * */
	@Override
	public int deleteAnswerReply(int askNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		
		String sql= proFile.getProperty("answer.delete");
		int result=0;
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, askNo);
			result=ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

}
