package mimemi.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.AskDTO;

public interface AskBoardDAO {
	/**
	 * 1:1 ���� ���
	 * */
	int insertAsk(AskDTO askDTO) throws SQLException;

	/**
	 * 1:1 ���� ���� 
	 * */
	int updateAsk(AskDTO askDTO) throws SQLException;
	/**
	 * 1:1 ���� ����
	 * */
	int deleteAsk(String askPwd) throws SQLException;
	/**
	 * 1:1 ���� ��ü �˻�
	 * */
	List<AskDTO> selectAllAsk() throws SQLException;
	/**
	 * 1:1 ���� ��ü �˻�(������ ó��)
	 * */
	List<AskDTO> getAskList(int pageNo) throws SQLException;
	
}
