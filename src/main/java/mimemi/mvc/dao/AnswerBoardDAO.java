package mimemi.mvc.dao;

import java.sql.SQLException;

import mimemi.mvc.dto.AnswerDTO;

public interface AnswerBoardDAO {
	/**
	 * ��� ���
	 * @param AnswerDTO(int askNo, String answerContent)
	 * */
	int insertAnswerReply(AnswerDTO answerDTO) throws SQLException;

	/**
	 * ��� ���� 
	 * @param AnswerDTO(int answerNo, String answerContent)
	 * */
	int updateAnswerReply(AnswerDTO answerDTO) throws SQLException;
	
	/**
	 * ��� ����
	 * */
	int deleteAnswerReply(int answerNo) throws SQLException;
	
}
