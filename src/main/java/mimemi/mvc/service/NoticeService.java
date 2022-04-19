package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.NoticeDTO;

public interface NoticeService {
	/**
	 * �������� ���
	 * @param NoticeDTO(String noticeTitle, String noticeContent, String noticeAttach)
	 * */
	void insertNotice(NoticeDTO noticeDTO, String path) throws SQLException;
	
	/**
	 * �������� ���� 
	 * @param NoticeDTO(int noticeNo, String noticeTitle, String noticeContent)
	 * */
	void updateNotice(NoticeDTO noticeDTO, String path) throws SQLException;
	
	/**

	 * �������� �̹��� ����
	 * @param int noticeNo, String noticeAttach
	 * */
	void updateNoticeAttach(int noticeNo, String noticeAttach) throws SQLException;
	
	/**
	 * �������� ���� 
	 * */
	void deleteNotice(NoticeDTO notice, String path) throws SQLException;
	
	/**
	 * �������� ��ü �˻�
	 * */
    List<NoticeDTO> selectAllNotice(int pageNum, String filed) throws SQLException;
	
	
	/**
	 * �������� ��ü �˻�(������ ó��)
	 * */
	List<NoticeDTO> selectAllByPaging(int pageNo) throws SQLException;
	
	/**
	 * �������� ��ȣ�� �˻�
	 * */
	NoticeDTO selectByNoticeNo(int noticeNo) throws SQLException;
	
	/**
	 * �������� Ű���� �˻�
	 * @param String noticeKeyword
	 * 
	 * ����� ���뿡�� Ű���� �˻�
	 * */
	List<NoticeDTO> selectByKeyword(String noticeKeyword, String field) throws SQLException;
}
