package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dao.FaqDAO;
import mimemi.mvc.dao.FaqDAOImpl;
import mimemi.mvc.dto.FaqDTO;
import mimemi.mvc.dto.NoticeDTO;

public class FaqServiceImpl implements FaqService {
	private FaqDAO faqDao = new FaqDAOImpl();

	@Override
	public void insertFaq(FaqDTO faqDTO,String path) throws SQLException {
		int result = faqDao.insertFaq(faqDTO);
		//��Ͽ� ������ ���ٸ�
		if(result==0) {
			//÷�������� �ִٸ� save������ ������ ÷������ �����ϱ�
			if(faqDTO.getFaqAttach()!=null) {
				new java.io.File(path+"/"+faqDTO.getFaqAttach()).delete(); //���Ȯ���ϱ�
			}
			throw new SQLException("�ıⰡ ��ϵ��� �ʾҽ��ϴ�.");
		}

	}

	@Override
	public void updateFaq(FaqDTO faqDTO, String path) throws SQLException {
		FaqDTO dbfaq = faqDao.selectByFaqNo(faqDTO.getFaqNo());
		if(dbfaq==null) {
			throw new SQLException("FAQ�� ã���� �����ϴ�.");
		}
		//db������ ���� ������ ÷�����ϸ��� �̸� ���Ѵ�.
         String dbAttach = dbfaq.getFaqAttach();
       //dao�� �Խù� �����Ѵ�.
         int result = faqDao.updateFaq(faqDTO);
			
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
	public void updateFaqImg(int faqNo, String faqAttach) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteFaq(int faqNo) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<FaqDTO> selectAllFaq(int pageNum, String filed) throws SQLException {
        List<FaqDTO> list = faqDao.selectAllFaq(pageNum, filed);
		
		return list;
	}

	@Override
	public List<FaqDTO> selectAllByPaging(int pageNo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FaqDTO> selectByKeyword(String faqKeyword, String field) throws SQLException {
	
		return null;
	}

	@Override
	public FaqDTO selectByFaqNo(int faqNo) throws SQLException {
		FaqDTO faqDetail = faqDao.selectByFaqNo(faqNo);
		 if(faqDetail==null) {
			 throw new SQLException("�󼼺��⸦ �ҷ��� �� �����ϴ�.");
		 }
		return faqDetail;
	}

	@Override
	public List<FaqDTO> selectByCtg(String faqCategory) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
