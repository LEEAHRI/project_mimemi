package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.AskDTO;

public interface AskBoardService {
	/**
	 * 1:1 ���� ���
	 * */
	void insertAsk(AskDTO askDTO) throws SQLException;

	/**
	 * 1:1 ���� ���� 
	 * */
	void updateAsk(AskDTO askDTO) throws SQLException;
	/**
	 * 1:1 ���� ����
	 * */
	void deleteAsk(String askPwd) throws SQLException;
	/**
	 * 1:1 ���� ��ü �˻�
	 * */
	List<AskDTO> selectAllAsk() throws SQLException;
	/**
	 * 1:1 ���� ��ü �˻�(������ ó��)
	 * */
	List<AskDTO> getAskList(int pageNo) throws SQLException;
}
