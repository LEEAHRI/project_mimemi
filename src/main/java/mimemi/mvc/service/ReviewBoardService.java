package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.ReviewDTO;

public interface ReviewBoardService {
	/**
	 * �ı� ���
	 * */
	void insertReview(ReviewDTO reviewDTO) throws SQLException;
	/**
	 * �ı� ���� 
	 * */
	void updateReview(ReviewDTO reviewDTO) throws SQLException;
	/**
	 * �ı� ����
	 * */
	void deleteReview(String reviewPwd) throws SQLException;
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
	void increamentByReadnum(int reviewNo) throws SQLException;
}
