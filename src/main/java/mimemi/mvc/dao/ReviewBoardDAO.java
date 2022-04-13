package mimemi.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.ReviewDTO;

public interface ReviewBoardDAO {
	/**
	 * �ı� ���
	 * @param ReviewDTO(String goodsId, String userId, String reviewTitle, String reviewAttach, String reviewContent,
			int reviewRate)
	 * */
	int insertReview(ReviewDTO reviewDTO) throws SQLException;
	
	/**
	 * �ı� ���� 
	 * @param ReviewDTO(int reviewNo, String reviewTitle, String reviewContent, int reviewRate)
	 * */
	int updateReview(ReviewDTO reviewDTO) throws SQLException;
	
	/**
	 * �ı� ����
	 * */
	int deleteReview(int reviewNo) throws SQLException;
	
	/**
	 * ����ε� ���� ���� ���
	 * */
	int updateBlind(int reviewNo, String blind) throws SQLException;
	
	/**
	 * �ı� ��ü �˻�
	 * field -> ��ȸ��, ��ϼ�, ��ۼ�, ������(������+������)
	 * */
	List<ReviewDTO> selectAllReview(String field) throws SQLException;
	
	/**
	 * �ı� ��ü �˻�(������ ó��)
	 * field -> ��ȸ��, ��ϼ�, ��ۼ�, ������(������+������)
	 * */
	List<ReviewDTO> selectAllByPaging(int pageNo, String field) throws SQLException;
	
	/**
	 * �ı� Ű���庰 �˻�
	 * ����, ���뿡�� �˻� ������ �� �ְ�
	 * */
	List<ReviewDTO> selectByKeyword(String reviewKeyword, String field) throws SQLException;
	
	/**
	 * ��ȸ�� ���� ���
	 * @param reviewNo
	 * */
	int increamentByReadnum(int reviewNo) throws SQLException;

}
