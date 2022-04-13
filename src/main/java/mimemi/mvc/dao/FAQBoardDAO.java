package mimemi.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.FaqDTO;

public interface FAQBoardDAO {
	/**
	 * FAQ ���
	 * */
	int insertFaq(FaqDTO faqDTO) throws SQLException;
	/**
	 * FAQ ���� 
	 * */
	int updateFaq(FaqDTO faqDTO) throws SQLException;
	/**
	 * FAQ ���� -> �Է°� ����
	 * */
	int deleteFaq() throws SQLException;

	/**
	 * FAQ ��ü �˻�
	 * */
	List<FaqDTO> selectAllFaq() throws SQLException;
	/**
	 * FAQ ��ü �˻�(������ ó��)
	 * */
	List<FaqDTO> getFaqList(int pageNo) throws SQLException;

	
}
