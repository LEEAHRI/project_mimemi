package mimemi.mvc.dao;

import java.sql.SQLException;

import mimemi.mvc.dto.ReviewReplyDTO;

public interface AnswerBoardDAO {
	/**
	 * ��� ���
	 * */
	int insertReviewReply(ReviewReplyDTO reviewreplyDTO) throws SQLException;

	/**
	 * ��� ���� 
	 * */
	int updateReviewReply(ReviewReplyDTO reviewreplyDTO) throws SQLException;
	
	/**
	 * ��� ����
	 * */
	int deleteReviewReply() throws SQLException;
	
}
