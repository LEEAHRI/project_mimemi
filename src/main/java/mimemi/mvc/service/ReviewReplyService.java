package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.ReviewReplyDTO;

public interface ReviewReplyService {
	/**
	 * �ı� �����ȸ�ϱ�
	 * */
	List<ReviewReplyDTO> selectReplyByReviewNo (int reviewNo) throws SQLException;
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
	int deleteReviewReply(int answerNo) throws SQLException;
}
