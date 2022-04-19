package mimemi.mvc.service;

import java.sql.SQLException;

import mimemi.mvc.dao.AnswerDAO;
import mimemi.mvc.dao.AnswerDAOImpl;
import mimemi.mvc.dto.AnswerDTO;

public class AnswerServiceImpl implements AnswerService {

	private AnswerDAO answerDao= new AnswerDAOImpl();
	
	@Override
	public void insertAnswerReply(AnswerDTO answerDTO) throws SQLException {
		int result = answerDao.insertAnswerReply(answerDTO);
		if( result == 0) throw new SQLException("��ϵ��� �ʾҽ��ϴ�");

	}

	/**
	 * ��ۺ���
	 * */
	@Override
	public AnswerDTO selectByAskNo(int askNo) throws SQLException {
		
		AnswerDTO answerDto = answerDao.selectByAskNo(askNo);
		if(answerDto==null)throw new SQLException("��ۺ��⿡ ������ �߻��߽��ϴ�");
		
		return answerDto;
	}
	
	@Override
	public void updateAnswerReply(AnswerDTO answerDTO) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAnswerReply(int askNo) throws SQLException {
		int result = answerDao.deleteAnswerReply(askNo);
		if(result==0)throw new SQLException("�������� �ʾҽ��ϴ�");
		
	}


	

}
