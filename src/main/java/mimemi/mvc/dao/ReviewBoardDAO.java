package mimemi.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.ReviewDTO;

public interface ReviewBoardDAO {
	/**
	 * �ı� ���
	 * */
	int insertReview(ReviewDTO reviewDTO) throws SQLException;
	/**
	 * �ı� ���� 
	 * */
	int updateReview(ReviewDTO reviewDTO) throws SQLException;
	/**
	 * �ı� ����
	 * */
	int deleteReview(String reviewPwd) throws SQLException;
	/**
	 * �ı� ��ü �˻�
	 * */
	List<ReviewDTO> selectAllReview() throws SQLException;
	
	/**
	 * �ı� ��ü �˻�(������ ó��)
	 * */
	List<ReviewDTO> getReviewList(int pageNo) throws SQLException;
	/**
	 * ��ȸ�� ���� ���
	 * */
	int increamentByReadnum(int reviewNo) throws SQLException;

}
