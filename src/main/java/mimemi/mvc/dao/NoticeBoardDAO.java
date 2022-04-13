package mimemi.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.NoticeDTO;

public interface NoticeBoardDAO {
	/**
	 * �������� ���
	 * */
	int insertNotice(NoticeDTO noticeDTO) throws SQLException;
	
	/**
	 * �������� ���� 
	 * */
	int updateNotice(NoticeDTO noticeDTO) throws SQLException;
	
	/**
	 * �������� ���� -> �Է°� ����(����Ʈ�ܿ��� ó��)
	 * */
	int deleteNotice() throws SQLException;
	/**
	 * �������� ��ü �˻�
	 * */
	List<NoticeDTO> selectAllNotice() throws SQLException;
	
	/**
	 * �������� ��ü �˻�(������ ó��)
	 * */
	List<NoticeDTO> getNoticeList(int pageNo) throws SQLException;

}
