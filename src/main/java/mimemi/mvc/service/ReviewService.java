package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.ReviewDTO;

public interface ReviewService {
	/**
	 * �ı� ���
	 * @param ReviewDTO(String goodsId, String userId, String reviewTitle, String reviewAttach, String reviewContent,
			int reviewRate)
	 * */
	void insertReview(ReviewDTO reviewDTO) throws SQLException;
	
	/**
	 * �ı� ���� 
	 * @param ReviewDTO(int reviewNo, String reviewTitle, String reviewContent, int reviewRate)
	 * */
	void updateReview(ReviewDTO reviewDTO) throws SQLException;
	
	/**
	 * �ı� �̹��� ����
	 * @param int reviewNo, String reviewAttach
	 * */
	void updateFaqImg(int reviewNo, String reviewAttach) throws SQLException;
	
	/**
	 * �ı� ����
	 * */
	void deleteReview(ReviewDTO review,String path) throws SQLException;
	
	/**
	 * ����ε� ���� ���� ���
	 * */
	void updateBlind(int reviewNo, String blind) throws SQLException;
	
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
	 * �ı��ȣ�� �˻��ϱ�(����Ŭ���ϸ� ���� �󼼺���� �̵�)
	 * @param int reviewNo, int flag(��ȸ�� ���� ���θ� �Ǻ��ϴ� �Ű�����. true�� ��ȸ�� ����, false�� ��ȸ�� �״��)
	 * @return ReviewDTO
	 * */
	ReviewDTO selectByReviewNo(int reviewNo, boolean flag) throws SQLException;
	
}
