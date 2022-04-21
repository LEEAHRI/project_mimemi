package mimemi.mvc.service;

import java.sql.SQLException;
import java.io.File;
import java.util.List;

import mimemi.mvc.dao.NoticeDAO;
import mimemi.mvc.dao.NoticeDAOImpl;
import mimemi.mvc.dto.NoticeDTO;

public class NoticeServiceImpl implements NoticeService {
	private NoticeDAO noticeDao = new NoticeDAOImpl();

	@Override
	public void insertNotice(NoticeDTO noticeDTO, String path) throws SQLException {
		int result = noticeDao.insertNotice(noticeDTO);
		//��Ͽ� ������ ���ٸ�
		if(result==0) {
			//÷�������� �ִٸ� save������ ������ ÷������ �����ϱ�
			if(noticeDTO.getNoticeAttach()!=null) {
				new java.io.File(path+"/"+noticeDTO.getNoticeAttach()).delete(); //���Ȯ���ϱ�
			}
			throw new SQLException("���������� ��ϵ��� �ʾҽ��ϴ�.");
		}

	}

	@Override
	public void updateNotice(NoticeDTO noticeDTO, String path) throws SQLException {
		NoticeDTO dbnotice = noticeDao.selectByNoticeNo(noticeDTO.getNoticeNo());
		if(dbnotice==null) {
			throw new SQLException("���������� ã�� �� �����ϴ�.");
		}
		//db������ ���� ������ ÷�����ϸ��� �̸� ���Ѵ�.
         String dbAttach = dbnotice.getNoticeAttach();
       //dao�� �Խù� �����Ѵ�.
         int result = noticeDao.updateNotice(noticeDTO);
			
			if(result==0) {
				//÷�������� �ִٸ� save������ ������ ÷���� ÷������ �����ϱ�
				if(dbAttach!=null) {
					new java.io.File(path+"/"+dbAttach).delete(); //���Ȯ���ϱ�
				}
				throw new SQLException("�������� �ʾҽ��ϴ�.");
			}else {
				//÷�������� �ִٸ� save������ ������ ÷���� ÷������ �����ϱ�
				if(dbAttach!=null) {
					new java.io.File(path+"/"+dbAttach).delete(); //���Ȯ���ϱ�
				}
				System.out.println("�����Ǿ��� ���� �����̸�:"+dbAttach);
			}
			

	}


	@Override
	public void updateNoticeAttach(int noticeNo, String noticeAttach) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteNotice(NoticeDTO notice, String path) throws SQLException {
		//db���� �����Ѵ�.
		int result =noticeDao.deleteNotice(notice.getNoticeNo());
		if(result==0) {
			throw new SQLException("������ ������ ���� �������� �ʾҽ��ϴ�.");
		}
		//�Խù��� �����ߴٸ� save �������� �����Ѵ�.
		if(notice.getNoticeAttach()!=null) {
			new java.io.File(path+"/"+notice.getNoticeAttach()).delete();
		}
		System.out.println("�������� �����Ϸ�");

	}

	@Override
	public List<NoticeDTO> selectAllNotice(int pageNum, String field) throws SQLException {
		List<NoticeDTO> list = noticeDao.selectAllNotice(pageNum, field);
		
		return list;
	}
    

	@Override
	public List<NoticeDTO> selectAllByPaging(int pageNo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoticeDTO selectByNoticeNo(int noticeNo) throws SQLException {
			NoticeDTO noticeDetail = noticeDao.selectByNoticeNo(noticeNo);
			 if(noticeDetail==null) {
				 throw new SQLException("�󼼺��⸦ �ҷ��� �� �����ϴ�.");
			 }
			return noticeDetail;
		}
		
    /**
     * Ű���� ��ü ��ȸ
     **/
	@Override
	public List<NoticeDTO> selectByKeyword(String noticeKeyword, String field, int pageNo) throws SQLException {
		List<NoticeDTO> list = noticeDao.selectByKeyword(noticeKeyword, field ,pageNo);
	    return list;
	}

	@Override
	public List<NoticeDTO> selectByKeywordClient(String noticeKeyword, String field, int pageNo) throws SQLException {
		List<NoticeDTO> list = noticeDao.selectByKeywordClient(noticeKeyword, field ,pageNo);
	    return list;
	}

	
	
}
