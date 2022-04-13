package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.FaqDTO;

public interface FAQBoardService {
	/**
	 * FAQ ���
	 * */
	void insertFaq(FaqDTO faqDTO) throws SQLException;
	/**
	 * FAQ ���� 
	 * */
	void updateFaq(FaqDTO faqDTO) throws SQLException;
	/**
	 * FAQ ���� -> �Է°� ����
	 * */
	void deleteFaq() throws SQLException;

	/**
	 * FAQ ��ü �˻�
	 * */
	List<FaqDTO> selectAllFaq() throws SQLException;
	/**
	 * FAQ ��ü �˻�(������ ó��)
	 * */
	List<FaqDTO> getFaqList(int pageNo) throws SQLException;

}
