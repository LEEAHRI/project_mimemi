package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.ReviewDTO;

public interface ReviewBoardService {
	/**
	 * �ı� ���
	 * @param ReviewDTO
	 * */
	void insertReview(ReviewDTO reviewDTO) throws SQLException;
	/**
	 * �ı� ����
	 * @param ReviewDTO
	 * */
	void updateReview(ReviewDTO reviewDTO) throws SQLException;
	/**
	 * �ı� ����
	 * @param reviewPwd
	 * */
	void deleteReview(String reviewPwd) throws SQLException;
	/**
	 * �ı� ��ü �˻�
	 * :�ı� ���� �̾ƿ���
	 * */
	List<ReviewDTO> selectAllReview() throws SQLException;
	
	/**
	 * �ı� ��ü �˻�(������ ó��) -> �� ��� �ʿ�����
	 * @param int pageNo
	 * */
	List<ReviewDTO> getReviewList(int pageNo) throws SQLException;
	/**
	 * ��ȸ�� ���� ���
	 * @param int reviewNo
	 * */
	void increamentByReadnum(int reviewNo) throws SQLException;
}
