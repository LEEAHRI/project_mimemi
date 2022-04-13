package mimemi.mvc.service;

import java.sql.SQLException;

import mimemi.mvc.dto.ReviewReplyDTO;

public interface AnswerBoardService {
	/**
	 * ��� ���
	 * */
	void insertReviewReply(ReviewReplyDTO reviewreplyDTO) throws SQLException;

	/**
	 * ��� ���� 
	 * */
	void updateReviewReply(ReviewReplyDTO reviewreplyDTO) throws SQLException;
	
	/**
	 * ��� ����
	 * */
	void deleteReviewReply() throws SQLException;
	
}
