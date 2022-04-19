package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dao.ReviewReplyDAO;
import mimemi.mvc.dao.ReviewReplyDAOImpl;
import mimemi.mvc.dto.ReviewReplyDTO;

public class ReviewReplyServiceImpl implements ReviewReplyService {
	private ReviewReplyDAO replyDAO = new ReviewReplyDAOImpl();
	
	@Override
	public List<ReviewReplyDTO> selectReplyByReviewNo(int reviewNo) throws SQLException {
		//������� ��������
		List<ReviewReplyDTO> replylist =replyDAO.selectReplyByReviewNo(reviewNo);
		return replylist;
	}

	@Override
	public int insertReviewReply(ReviewReplyDTO reviewreplyDTO) throws SQLException {
		int result=replyDAO.insertReviewReply(reviewreplyDTO);
		if(result==0) {
			throw new SQLException("����� ��ϵ��� �ʾҽ��ϴ�.");
		}
		return result;
	}

	@Override
	public int updateReviewReply(ReviewReplyDTO reviewreplyDTO) throws SQLException {
		// TODO Auto-generated method stub
		int result=0;
		return result;
	}

	@Override
	public int deleteReviewReply(int answerNo) throws SQLException {
		// TODO Auto-generated method stub
		int result=0;
		return result;
	}

}
