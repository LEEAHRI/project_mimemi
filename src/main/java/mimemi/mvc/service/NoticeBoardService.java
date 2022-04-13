package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.NoticeDTO;

public interface NoticeBoardService {
	/**
	 * �������� ���
	 * 
	 * */
	void insertNotice(NoticeDTO noticeDTO) throws SQLException;
	
	/**
	 * �������� ���� 
	 * */
	void updateNotice(NoticeDTO noticeDTO) throws SQLException;
	
	/**
	 * �������� ���� -> �Է°� ����(����Ʈ�ܿ��� ó��)
	 * */
	void deleteNotice() throws SQLException;
	
	/**
	 * �������� ��ü �˻�
	 * */
	List<NoticeDTO> selectAllNotice() throws SQLException;
	
	/**
	 * �������� ��ü �˻�(������ ó��)
	 * */
	List<NoticeDTO> getNoticeList(int pageNo) throws SQLException;
}
