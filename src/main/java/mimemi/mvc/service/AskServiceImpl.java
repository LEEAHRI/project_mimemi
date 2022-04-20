package mimemi.mvc.service;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dao.AskDAO;
import mimemi.mvc.dao.AskDAOImpl;
import mimemi.mvc.dto.AskDTO;
import mimemi.mvc.dto.UserDTO;

public class AskServiceImpl implements AskService {

	private AskDAO askDao = new AskDAOImpl();
	
	@Override
	public void insertAsk(AskDTO askDTO) throws SQLException {
		
		int result = askDao.insertAsk(askDTO);
		if(result==0)throw new SQLException("��ϵ��� �ʾҽ��ϴ�");

	}
	


	@Override
	public void updateAsk(AskDTO askDTO,String path) throws SQLException {
		AskDTO askDto = askDao.selectByAskNo(askDTO.getAskNo());
		
		if(askDto==null) throw new SQLException("���Ǹ� ã�� �� �����ϴ�.");
		
		
		String dbAttach=askDto.getAskAttach();
		
		int result = askDao.updateAsk(askDTO);
		
		if(result==0) {
			if(dbAttach!=null) {
				new java.io.File(path+"/"+dbAttach).delete();
			}
			throw new SQLException("�������� �ʾҽ��ϴ�");
		}else {
			if(dbAttach!=null) {
				new java.io.File(path+"/"+dbAttach).delete(); //���Ȯ���ϱ�
			}
		}
	}

	@Override
	public void updateAskAttach(int askNo, String askAttach) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAsk(AskDTO ask, String path) throws SQLException {
		
			int result = askDao.deleteAsk(ask.getAskNo());
			if(result == 0) throw new SQLException("�������� �ʾҽ��ϴ�");
			
			if(ask.getAskAttach()!=null) {
				new java.io.File(path+"/"+ask.getAskAttach()).delete();
			}
			
			
	}

	@Override
	public List<AskDTO> selectAllAsk(int pageNum, String field) throws SQLException {
		
		List<AskDTO> list = askDao.selectAllAsk(pageNum, field);
		
		return list;
	}
	
	

	@Override
	public List<AskDTO> selectAllByPaging(int pageNo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AskDTO selectByAskNo(int askNo) throws SQLException {
		
		AskDTO askDto = askDao.selectByAskNo(askNo);
		
		if(askDto==null)throw new SQLException("�󼼺��⿡ ������ �߻��߽��ϴ�");
		
		
		return askDto;
		
	}

	@Override
	public void updateState(AskDTO askDto) throws SQLException {
		
		/*
		 * String dbAttach=askDTO.getAskAttach();
		
		int result = askDao.updateAsk(askDTO);
		
		if(result==0) {
			if(dbAttach!=null) {
				new java.io.File(path+"/"+dbAttach).delete();
			}
			throw new SQLException("�������� �ʾҽ��ϴ�");
		}else {
			if(dbAttach!=null) {
				new java.io.File(path+"/"+dbAttach).delete(); //���Ȯ���ϱ�
			}
		}
		 * */	
		int result=askDao.updateState(askDto);
		if(result==0)throw new SQLException("�������� �ʾҽ��ϴ�.");
		
	}


	

}
