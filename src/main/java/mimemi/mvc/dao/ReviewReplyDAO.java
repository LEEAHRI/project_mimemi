package mimemi.mvc.dao;

import java.sql.SQLException;

import mimemi.mvc.dto.ReviewReplyDTO;


public interface ReviewReplyDAO {
	/**
	 * ��� ���
	 * @param AnswerDTO(int answerNo, int askNo, String answerContent, String answerRegdate)
	 * */
	int insertReviewReply(ReviewReplyDTO reviewreplyDTO) throws SQLException;

	/**
	 * ��� ���� 
	 * @param AnswerDTO(int answerNo, int askNo, String answerContent, String answerRegdate)
	 * */
	int updateReviewReply(ReviewReplyDTO reviewreplyDTO) throws SQLException;
	
	/**
	 * ��� ����
	 * */
	int deleteReviewReply() throws SQLException;
}
