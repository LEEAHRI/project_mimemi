package mimemi.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.FaqDTO;

public interface FAQBoardDAO {
	/**
	 * FAQ ���
	 * @param FaqDTO(String faqTitle, String faqContent, String faqAttach)
	 * */
	int insertFaq(FaqDTO faqDTO) throws SQLException;
	
	/**
	 * FAQ ���� 
	 * @param FaqDTO(int faqNo, String faqTitle, String faqContent, String faqAttach, String faqModidate)
	 * */
	int updateFaq(FaqDTO faqDTO) throws SQLException;
	
	/**
	 * FAQ �̹��� ����
	 * @param int faqNo, String faqImg
	 * */
	int updateFaqImg(int faqNo, String faqImg) throws SQLException;
	
	/**
	 * FAQ ���� -> �Է°� ����
	 * */
	int deleteFaq(int faqNo) throws SQLException;

	/**
	 * FAQ ��ü �˻�
	 * */
	List<FaqDTO> selectAllFaq() throws SQLException;
	
	/**
	 * FAQ ��ü �˻�(������ ó��)
	 * @param int pageNo
	 * */
	List<FaqDTO> getFaqList(int pageNo) throws SQLException;

	/**
	 * FAQ Ű����� �˻� (�޼ҵ� �̸�....)
	 * @param String faqKeyword
	 * */
	List<FaqDTO> getList(String faqKeyword) throws SQLException;
}
