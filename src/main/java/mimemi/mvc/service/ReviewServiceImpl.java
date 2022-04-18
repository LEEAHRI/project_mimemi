package mimemi.mvc.service;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dao.ReviewDAO;
import mimemi.mvc.dao.ReviewDAOImpl;
import mimemi.mvc.dto.ReviewDTO;
import mimemi.mvc.dto.ReviewReplyDTO;

public class ReviewServiceImpl implements ReviewService {
	private ReviewDAO reviewDAO = new ReviewDAOImpl();

	@Override
	public void insertReview(ReviewDTO reviewDTO, String path) throws SQLException {
		int result= reviewDAO.insertReview(reviewDTO);
		
		//��Ͽ� ������ ���ٸ�
		if(result==0) {
			//÷�������� �ִٸ� save������ ������ ÷������ �����ϱ�
			if(reviewDTO.getReviewAttach()!=null) {
				new java.io.File(path+"/"+reviewDTO.getReviewAttach()).delete(); //���Ȯ���ϱ�
			}
			throw new SQLException("�ıⰡ ��ϵ��� �ʾҽ��ϴ�.");
		}

	}

	@Override
	public void updateReview(ReviewDTO reviewDTO, String path) throws SQLException {
		ReviewDTO dbreview = reviewDAO.selectByReviewNo(reviewDTO.getReviewNo());
			if(dbreview==null) {
				throw new SQLException("���� ��ȣ�� �ش��ϴ� ���並 ã�� �� �����ϴ�.");
			}else if(!dbreview.getUserId().equals(reviewDTO.getUserId())||dbreview.getUserId()==reviewDTO.getUserId()) {
				throw new SQLException("���̵� ��ġ���� �ʽ��ϴ�.�Խù� ���� ������ �����ϴ�.");
			}
		//db������ ���� ������ ÷�����ϸ��� �̸� ���Ѵ�.
		String dbAttach =dbreview.getReviewAttach();
		
		//dao�� �Խù� �����Ѵ�.
		int result = reviewDAO.updateReview(reviewDTO);
			
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
	public void updateFaqImg(int reviewNo, String reviewAttach) throws SQLException {
		/*ReviewDTO dbreview = reviewDAO.selectByReviewNo(reviewNo);
		if(dbreview==null) {
			throw new SQLException("���� ��ȣ�� �ش��ϴ� ���並 ã�� �� �����ϴ�.");
		}*/

	}

	@Override
	public void deleteReview(ReviewDTO review, String path) throws SQLException {
		//db���� �����Ѵ�.
		int result =reviewDAO.deleteReview(review.getReviewNo());
		if(result==0) {
			throw new SQLException("������ ������ ���� �������� �ʾҽ��ϴ�.");
		}
		//�Խù��� �����ߴٸ� save �������� �����Ѵ�.
		if(review.getReviewAttach()!=null) {
			new java.io.File(path+"/"+review.getReviewAttach()).delete();
		}
		System.out.println("�������� �����Ϸ�");

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
		//�Խù� ���� ��������
		ReviewDTO reviewDetail = reviewDAO.selectByReviewNo(reviewNo);
			if(reviewDetail==null) {
				throw new SQLException("�Խù� �󼼺��⸦ �ҷ��� �� �����ϴ�.");
			}
		
		return reviewDetail;
	}
	
	/**
	 * ������ - �ı� ��ü��ȸ(������ó��)
	 * */
	@Override
	public List<ReviewDTO> selectAllByPagingManager(int pageNo, String field) throws SQLException {
		List<ReviewDTO> list =reviewDAO.selectAllByPagingManager(pageNo, field);
		
		return list;
	}
	
	/**
	 * ������ - �ı� ����ε�ó��
	 * */
	@Override
	public void updateBlind(int reviewNo, String blind) throws SQLException {
		int result =reviewDAO.updateBlind(reviewNo, blind);
		if(result==0) {
			throw new SQLException("����ε� ó���� �ϴ� ���� ������ �߻��߽��ϴ�.");
		}
		

	}

}
