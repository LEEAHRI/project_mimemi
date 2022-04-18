package mimemi.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.FaqDTO;

public interface FaqDAO {
	/**
	 * FAQ ���
	 * @param FaqDTO(String faqTitle, String faqContent, String faqAttach)
	 * */
	int insertFaq(FaqDTO faqDTO) throws SQLException;
	
	/**
	 * FAQ ���� 
	 * @param FaqDTO(int faqNo, String faqTitle, String faqContent)
	 * ������¥�� �ڵ����� sysdate
	 * */
	int updateFaq(FaqDTO faqDTO) throws SQLException;
	
	/**
	 * FAQ �̹��� ����
	 * @param int faqNo, String faqAttach
	 * */
	int updateFaqImg(int faqNo, String faqAttach) throws SQLException;
	
	/**
	 * FAQ ����
	 * @param int faqNo
	 * �����ϸ� ������ ����
	 * */
	int deleteFaq(int faqNo) throws SQLException;

	/**
	 * FAQ ��ü �˻�
	 * */
	List<FaqDTO> selectAllFaq(int pageNum, String filed) throws SQLException;
	
	/**
	 * FAQ ��ü �˻�(������ ó��)
	 * @param int pageNo
	 * */
	List<FaqDTO> selectAllByPaging(int pageNo) throws SQLException;

	/**
	 * FAQ Ű����� �˻�
	 * @param String faqKeyword
	 * 
	 * ����� ���뿡�� �˻��Ѵ�.
	 * */
	List<FaqDTO> selectByKeyword(String faqKeyword, String field) throws SQLException;
	
	/**
	 * FAQ ��ȣ�� �˻�
	 * @param int faqNo
	 * */
	FaqDTO selectByFaqNo(int faqNo) throws SQLException;
	
	/**
	 * FAQ ī�װ��� �˻� (ī�װ�)
	 * @param String faqCategory
	 * 
	 * ī�װ����� ����Ʈ�� ������.(�ֹ�/����/��ǰ ���)
	 * */
	List<FaqDTO> selectByCtg(String faqCategory) throws SQLException;
}
