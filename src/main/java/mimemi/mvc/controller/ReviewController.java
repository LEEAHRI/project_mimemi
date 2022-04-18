package mimemi.mvc.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mimemi.mvc.dto.ReviewDTO;
import mimemi.mvc.dto.UserDTO;
import mimemi.mvc.service.ReviewService;
import mimemi.mvc.service.ReviewServiceImpl;

public class ReviewController implements Controller {
	private static ReviewService reviewService = new ReviewServiceImpl();
	
	public ReviewController() {}
	
	@Override
	public ModelAndView hendlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return null;
	}
	
	/**
	 * ���� ��ü ��ȸ�ϱ�(+������ó��)
	 * */
	public ModelAndView selectAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String curPageNo = request.getParameter("pageNum");
		if(curPageNo ==null||curPageNo.equals("")) {
			curPageNo="1";
		}
		String field =request.getParameter("field");
		if(field==null||field.equals("")) {
			field="reg";
		}
		
		System.out.println(field+" ������ ��ȣ: "+curPageNo);
		List<ReviewDTO> reviewList = reviewService.selectAllByPaging(Integer.parseInt(curPageNo), field);
		
		request.setAttribute("list", reviewList);
		request.setAttribute("pageNum", curPageNo);
		
		//System.out.println("���񽺿��� ���ƿ� ��.."+curPageNo);
		
		return new ModelAndView("/board/reviewList.jsp");
		
	}
	public ModelAndView selectByKeyword(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * ���� ��ȣ�� ����ȸ�ϱ�
	 * */
	public ModelAndView selectByReviewNo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String curPageNo= request.getParameter("pageNum");
		
		ReviewDTO review = reviewService.selectByReviewNo(Integer.parseInt(request.getParameter("reviewNo")), true);
		request.setAttribute("pageNum", curPageNo);
		request.setAttribute("reviewDetail", review);
		return new ModelAndView("/board/reviewRead.jsp");
	}
	
	/**
	 * ���� �����ϱ�(update�������� �̵��ϱ�)
	 * */
	public ModelAndView updateForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String reviewNo= request.getParameter("reviewNo");
		ReviewDTO review = reviewService.selectByReviewNo(Integer.parseInt(reviewNo), false);
		//String dbUserId=review.getUserId();
		
		//���� �α����� ������ ���̵� ���ǿ��� �����´�.
		//HttpSession session = request.getSession();
		//String UserId =session.getAttribute("loginUser");
		
		//db���� ������ �����Ϳ� ��ġ�ϴ��� Ȯ���Ѵ�.
		/*if(!dbUserId.equals(UserId)||dbUserId==UserId) {
			throw new Exception("���̵� ��ġ���� �ʽ��ϴ�.�Խù� ���� ������ �����ϴ�.");
		}*/
		request.setAttribute("review", review);
		//System.out.println(review.getReviewContent());
		
		return new ModelAndView("board/reviewUpdate2.jsp");
	}
	
	/**
	 * ���� �����ϱ�
	 * */
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String saveDir = request.getServletContext().getRealPath("/img/save");
		int maxSize = 1024*1024*100;
		String encoding= "UTF-8";
		System.out.println(saveDir);
		
		MultipartRequest m = new MultipartRequest(request, saveDir,maxSize, encoding, new DefaultFileRenamePolicy());
		
		String reviewNo= m.getParameter("reviewNo");
		String reviewTitle = m.getParameter("review_title");
		String reviewGoods = m.getParameter("review_select_goods");
		String reviewRate = m.getParameter("rate");
		String reviewContent =m.getParameter("review_contents");
		
		//HttpSession session = request.getSession();
		//String reviewUser = session.getAttribute("loginUser");
		String reviewUser = "happy01";
		
		System.out.println("�����ϴ� �����ȣ: "+reviewNo+"��ǰ�̸�: "+reviewGoods);
		
		ReviewDTO review = new ReviewDTO(reviewUser,reviewGoods,reviewTitle,reviewContent,Integer.parseInt(reviewRate));
		
			//����÷�θ� �ߴٸ�(������ �����ߴٸ�)
			if(m.getFilesystemName("review-image-selector")!=null) {
				String reviewAttach =m.getFilesystemName("review-image-selector");
				//���� �̸��� reviewDTO�� �����Ѵ�.
				review.setReviewAttach(reviewAttach);
				//�����ͺ��̽��� �̹����� �Բ� �����Ѵ�.
				//connection�� �����ϱ� ���� reviewService.updateFaqImg �ۼ����ߴ�. 
				//���߿� �ʿ��ϸ� �����
				//reviewService.updateFaqImg(Integer.parseInt(reviewNo), reviewAttach);
			}
		//������ �Է°��� �����Ѵ�.
		reviewService.updateReview(review);
		
		//�����Ϸ��ϸ� ��ȸ�� ���� ���� �󼼺��� �������� �̵��Ѵ�.
		ReviewDTO dbreview = reviewService.selectByReviewNo(Integer.parseInt(reviewNo), false);
		request.setAttribute("reviewDetail", dbreview);
		return new ModelAndView("front?key=review&methodName=selectAll",true);
		
		//�׽�Ʈ�� �ӽ� ����
		//return new ModelAndView("front?key=review&methodName=selectAll",true);
		
	}
	
	
	/**
	 * ���� �ۼ��ϱ�
	 * */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String saveDir = request.getServletContext().getRealPath("/img/save");
		int maxSize = 1024*1024*100;
		String encoding= "UTF-8";
		//System.out.println(saveDir);
		
		MultipartRequest m = new MultipartRequest(request, saveDir,maxSize, encoding, new DefaultFileRenamePolicy());
		
		String reviewTitle = m.getParameter("review_title");
		String reviewGoods = m.getParameter("review_select_goods");
		String reviewRate = m.getParameter("rate");
		String reviewContent =m.getParameter("review_contents");
		
		//���� �ۼ��� ���̵�� �α����� ���̵� ���ϱ�
		//HttpSession session = request.getSession();
		//String reviewUser = session.getAttribute("loginUser");
		String reviewUser = "happy01";
		
		System.out.println("�ı����Ϸ��� ��ǰ���̵�: "+reviewGoods);
		
		ReviewDTO review = new ReviewDTO(reviewUser,reviewGoods,reviewTitle,reviewContent,Integer.parseInt(reviewRate));
		
			//���� ÷�� �ߴٸ�(�ʼ���Ұ� �ƴϱ⶧���� �����ڿ� �����Ƿ� �߰����ش�)
			if(m.getFilesystemName("review_image")!=null) {
				
				//�����̸� �����Ѵ�.
				review.setReviewAttach(m.getFilesystemName("review_image"));
				
			}
		reviewService.insertReview(review);
		return new ModelAndView("front?key=review&methodName=selectAll",true);
	}
	
	/**
	 * ���� �����ϱ�
	 * */
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String reviewNo = request.getParameter("reviewNo");
		ReviewDTO review = reviewService.selectByReviewNo(Integer.parseInt(reviewNo), false);
		//String dbUserId=review.getUserId();
		
		//���� �α����� ������ ���̵� ���ǿ��� �����´�.
		//HttpSession session = request.getSession();
		//String UserId =session.getAttribute("loginUser");
		
		//db���� ������ �����Ϳ� ��ġ�ϴ��� Ȯ���Ѵ�.
		/*if(!dbUserId.equals(UserId)||dbUserId==UserId) {
			throw new Exception("���̵� ��ġ���� �ʽ��ϴ�.�Խù� ���� ������ �����ϴ�.");
		}*/
		
		//÷�����ϵ� ������ ��θ� ���Ѵ�.
		String path =request.getServletContext().getRealPath("/img/save");
		//������ ÷�������̸��� ���Ѵ�.
		System.out.println("������ �ı� �Խù� ��ȣ: "+review.getReviewNo());
		reviewService.deleteReview(review,path);
		
		//������ ��ġ�� �Խù� list�� ���ư���.
		return new ModelAndView("front?key=review&methodName=selectAll",true);
	}
	
	
	/**
	 * �����ڿ� - �Խñ� ����ε� ó��
	 * */
	public ModelAndView updateBlind(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return null;
	}
	

}
