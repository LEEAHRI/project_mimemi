package mimemi.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.ReviewDTO;

public interface ReviewBoardDAO {
	/**
	 * �ı� ���
	 * @param ReviewDTO(int reviewNo, String userId, String reviewTitle, String reviewAttach, String reviewContent,
			String reviewRegdate, int reviewRate, boolean reviewBlind, int reviewViews)
	 * */
	int insertReview(ReviewDTO reviewDTO) throws SQLException;
	
	/**
	 * �ı� ���� 
	 * @param ReviewDTO(int reviewNo, String userId, String reviewTitle, String reviewAttach, String reviewContent,
			String reviewRegdate, int reviewRate, boolean reviewBlind, int reviewViews)
	 * */
	int updateReview(ReviewDTO reviewDTO) throws SQLException;
	
	/**
	 * �ı� �̹��� ����
	 * @param int reviewNo, String reviewAttach
	 * */
	int updateFaqImg(int reviewNo, String reviewAttach) throws SQLException;
	
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
	 * @param reviewNo
	 * */
	int increamentByReadnum(int reviewNo) throws SQLException;

}
