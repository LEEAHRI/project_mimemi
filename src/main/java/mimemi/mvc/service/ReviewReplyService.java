package mimemi.mvc.service;

import java.sql.SQLException;

import mimemi.mvc.dto.ReviewReplyDTO;

public interface ReviewReplyService {
	/**
	 * ��� ���
	 * @param AnswerDTO(int askNo, String userId, String answerContent)
	 * */
	void insertReviewReply(ReviewReplyDTO reviewreplyDTO) throws SQLException;

	/**
	 * ��� ���� 
	 * @param AnswerDTO(int answerNo, String answerContent)
	 * */
	void updateReviewReply(ReviewReplyDTO reviewreplyDTO) throws SQLException;
	
	/**
	 * ��� ����
	 * */
	void deleteReviewReply(int answerNo) throws SQLException;
}
