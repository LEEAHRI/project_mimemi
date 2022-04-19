package mimemi.mvc.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.ReviewReplyDTO;


public interface ReviewReplyDAO {
	/**
	 * �� �ı⿡ �ش��ϴ� ��� ���� ��������
	 * */
	List<ReviewReplyDTO> selectReplyByReviewNo(int reviewNo) throws SQLException;
	/**
	 * ��� ���
	 * @param AnswerDTO(int askNo, String userId, String answerContent)
	 * */
	int insertReviewReply(ReviewReplyDTO reviewreplyDTO) throws SQLException;

	/**
	 * ��� ���� 
	 * @param AnswerDTO(int answerNo, String answerContent)
	 * */
	int updateReviewReply(ReviewReplyDTO reviewreplyDTO) throws SQLException;
	
	/**
	 * ��� ����
	 * */
	int deleteReviewReply(int replyNo) throws SQLException;
	
	/**
	 * �ı� �Խù� ������ ��, ��� ����
	 * */
	public int deleteReviewReplyByReviewNo(Connection con,int reviewNo) throws SQLException;
}
