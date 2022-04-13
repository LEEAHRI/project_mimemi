package mimemi.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.AskDTO;

public interface AskBoardDAO {
	/**
	 * 1:1 ���� ���
	 * @param AskDTO(String userId, String askTitle, String askContent, String askAttach,
			String askCategory)
	 * */
	int insertAsk(AskDTO askDTO) throws SQLException;

	/**
	 * 1:1 ���� ���� 
	 * @param AskDTO(int askNo, String userId, String askTitle, String askContent, 
			String askCategory)
	 * */
	int updateAsk(AskDTO askDTO) throws SQLException;
	
	/**
	 * 1:1 ���� �Խñ� ÷������ ����
	 * @param: int askNo, String askAttach
	 * @return: int(���� ������ ���ڵ� ��)
	 * */
	int updateAskAttach(int askNo, String askAttach) throws SQLException;
	
	/**
	 * 1:1 ���� ����
	 * @param int askNo
	 * */
	int deleteAsk(int askNo) throws SQLException;
	
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
	 * 1:1 ���� �亯 ���� ���� ���
	 * */
	int updateState(int askNo, String state) throws SQLException;
	
}
