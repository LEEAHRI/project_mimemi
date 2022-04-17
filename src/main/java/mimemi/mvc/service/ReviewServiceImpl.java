package mimemi.mvc.service;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dao.ReviewDAO;
import mimemi.mvc.dao.ReviewDAOImpl;
import mimemi.mvc.dto.ReviewDTO;

public class ReviewServiceImpl implements ReviewService {
	private ReviewDAO reviewDAO = new ReviewDAOImpl();

	@Override
	public void insertReview(ReviewDTO reviewDTO) throws SQLException {
		int result= reviewDAO.insertReview(reviewDTO);
		if(result==0) {
			
			//÷������ �����ϱ�
			File savedfile = new File("/img/save/"+reviewDTO.getReviewAttach());
			if(savedfile.exists()) {
				savedfile.delete();
				
			}
			
			throw new SQLException("�ıⰡ ��ϵ��� �ʾҽ��ϴ�.");
			
		}

	}

	@Override
	public void updateReview(ReviewDTO reviewDTO) throws SQLException {
		ReviewDTO dbreview = reviewDAO.selectByReviewNo(reviewDTO.getReviewNo());
			if(dbreview==null) {
				throw new SQLException("���� ��ȣ�� �ش��ϴ� ���並 ã�� �� �����ϴ�.");
			}else if(!dbreview.getUserId().equals(reviewDTO.getUserId())||dbreview.getUserId()==reviewDTO.getUserId()) {
				throw new SQLException("���̵� ��ġ���� �ʽ��ϴ�.�Խù� ���� ������ �����ϴ�.");
			}
		int result = reviewDAO.updateReview(reviewDTO);
			if(result==0) {
				throw new SQLException("�������� �ʾҽ��ϴ�.");
			}

	}

	@Override
	public void updateFaqImg(int reviewNo, String reviewAttach) throws SQLException {
		/*ReviewDTO dbreview = reviewDAO.selectByReviewNo(reviewNo);
		if(dbreview==null) {
			throw new SQLException("���� ��ȣ�� �ش��ϴ� ���並 ã�� �� �����ϴ�.");
		}*/

	}

	@Override
	public void deleteReview(int reviewNo, String path) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBlind(int reviewNo, String blind) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ReviewDTO> selectAllReview(String field) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReviewDTO> selectAllByPaging(int pageNo, String field) throws SQLException {
		List<ReviewDTO> list =reviewDAO.selectAllByPaging(pageNo, field);
		
		return list;
	}

	@Override
	public List<ReviewDTO> selectByKeyword(String reviewKeyword, String field) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReviewDTO selectByReviewNo(int reviewNo, boolean flag) throws SQLException {
		//��ȸ�� ����
		if(flag) {
			if(reviewDAO.increamentByReadnum(reviewNo)==0) {
				throw new SQLException("��ȸ�� ������ �ϴ� ���� ������ ������ϴ�.");
			}
		}
		ReviewDTO reviewDetail = reviewDAO.selectByReviewNo(reviewNo);
			if(reviewDetail==null) {
				throw new SQLException("�󼼺��⸦ �ҷ��� �� �����ϴ�.");
			}
		//������� ��������
		
		return reviewDetail;
	}

}
