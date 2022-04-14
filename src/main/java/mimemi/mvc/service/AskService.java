package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.AnswerDTO;
import mimemi.mvc.dto.AskDTO;

public interface AskService {
	/**
	 * 1:1 ���� ���
	 * @param AskDTO(String userId, String askTitle, String askContent, String askAttach,
			String askCategory)
	 * */
	void insertAsk(AskDTO askDTO) throws SQLException;

	/**
	 * 1:1 ���� ���� 
	 * @param AskDTO(int askNo, String userId, String askTitle, String askContent, 
			String askCategory)
	 * */
	void updateAsk(AskDTO askDTO) throws SQLException;
	
	/**
	 * 1:1 ���� �Խñ� ÷������ ����
	 * @param: int askNo, String askAttach
	 * @return: int(���� ������ ���ڵ� ��)
	 * */
	void updateAskAttach(int askNo, String askAttach) throws SQLException;
	
	/**
	 * 1:1 ���� ����
	 * @param int askNo
	 * */
	void deleteAsk(int askNo) throws SQLException;
	
	/**
	 * 1:1 ���� ��ü �˻�
	 * */
	List<AskDTO> selectAllAsk() throws SQLException;
	
	/**
	 * 1:1 ���� ��ü �˻�(������ ó��)
	 * @param int pageNo
	 * */
	List<AskDTO> selectAllByPaging(int pageNo) throws SQLException;
	
	/**
	 * ���� ��ȣ�� �ҷ�����
	 * @param int askNo
	 * */
	AskDTO selectByAskNo(int askNo) throws SQLException;
	
	/**
	 * 1:1 ���� �亯 ���� ���� ���
	 * */
	void updateState(int askNo, String state) throws SQLException;
	
}
