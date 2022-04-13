package mimemi.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.NoticeDTO;

public interface NoticeBoardDAO {
	/**
	 * �������� ���
	 * @param NoticeDTO(int noticeNo, String noticeTitle, String noticeContent, String noticeAttach,
			String noticeRegdate)
	 * */
	int insertNotice(NoticeDTO noticeDTO) throws SQLException;
	
	/**
	 * �������� ���� 
	 * @param NoticeDTO(int noticeNo, String noticeTitle, String noticeContent, String noticeAttach,
			String noticeRegdate)
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
	
	/**
	 * �������� Ű���� �˻�(�޼ҵ� �̸�....)
	 * @param String noticeKeyword
	 * */
	List<NoticeDTO> getNoticeListByKeyword(String noticeKeyword) throws SQLException;
}
