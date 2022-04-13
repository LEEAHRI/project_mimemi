package mimemi.mvc.service;

import java.sql.SQLException;

import mimemi.mvc.dto.ReviewReplyDTO;

public interface AnswerBoardService {
	/**
	 * ��� ���
	 * @param reviewreplyDTO
	 * */
	void insertReviewReply(ReviewReplyDTO reviewreplyDTO) throws SQLException;

	/**
	 * ��� ���� 
	 * @param reviewreplyDTO
	 * */
	void updateReviewReply(ReviewReplyDTO reviewreplyDTO) throws SQLException;
	
	/**
	 * ��� ����
	 * */
	void deleteReviewReply() throws SQLException;
	
}
