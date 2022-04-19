package mimemi.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mimemi.mvc.dto.FaqDTO;
import mimemi.mvc.dto.NoticeDTO;
import mimemi.mvc.service.FaqService;
import mimemi.mvc.service.FaqServiceImpl;

public class FaqController implements Controller {
	private FaqService faqService = new FaqServiceImpl();

	@Override
	public ModelAndView hendlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 *  FAQ ���
	 **/
     public ModelAndView insertFaq(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	 response.setContentType("text/html;charset=UTF-8"); 
    	 
    		String saveDir = request.getServletContext().getRealPath("/img");
    		int maxSize = 1024*1024*100;
    		String encoding= "UTF-8";
    		System.out.println(saveDir);
    	 
    		MultipartRequest m = new MultipartRequest(request, saveDir,maxSize, encoding, new DefaultFileRenamePolicy());
    		
    		String faqTitle = m.getParameter("faq_title");
    		String faqContent = m.getParameter("faq_content");
    		String faqCategory = m.getParameter("faq_category");
    		
    		FaqDTO faqDto = new FaqDTO(faqTitle, faqContent, faqCategory);
    		
    		if(m.getFilesystemName("faqAttach") != null) {
    			faqDto. setFaqAttach(m.getFilesystemName("faqAttach"));	
    		}	
    		faqService.insertFaq(faqDto, saveDir);
    		
    		
    		return new ModelAndView("front?key=faq&methodName=selectAllFaq", true);
    		
    		
    	}
    		
    	
	
	
	
	
	
	/**
	 *  FAQ ��ü���� 
	 **/
     
	public ModelAndView selectAllFaq(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8"); 
		
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null || pageNum.equals("")) {
			pageNum = "1";
		}
		
        String field = request.getParameter("field");
		
		List<FaqDTO> faqList = faqService.selectAllFaq(Integer.parseInt(pageNum), field);
		
		request.setAttribute("FaqList", faqList);
		request.setAttribute("pageNum", pageNum); 
		ModelAndView mv = new ModelAndView("manager/selectFaqAll.jsp");
		
		return mv;
	}
	

	/**
	 *  FAQ ����� 
	 **/
		
	public ModelAndView selectAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8"); 
        
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null || pageNum.equals("")) {
			pageNum = "1";
		}
		
		String field = request.getParameter("field");
		
		List<FaqDTO> faqList = faqService.selectAllFaq(Integer.parseInt(pageNum), field);
		
		request.setAttribute("FaqList", faqList);
		request.setAttribute("pageNum", pageNum); 
		ModelAndView mv = new ModelAndView("board/faq.jsp");
		
		return mv;
	}	
	
	
	
	
	
	
	/**
	 *  �󼼺��� 
	 **/
	
	public ModelAndView selectByFaqNo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8"); 
        
        String faqNo = request.getParameter("faqNo");

	/*	String user = request.getParameter("user");
		
		boolean isAdmin = (user.equals("admin")) ? true : false;
		
		if(pageNum == null || pageNum.equals("")) {
			pageNum = "1";
		}*/

	    FaqDTO faq = faqService.selectByFaqNo(Integer.parseInt(faqNo));
		request.setAttribute("faq", faq); 
		
		/*request.setAttribute("isAdmin", isAdmin);*/
		return new ModelAndView("/board/faq.jsp"); 
		
	
	}
	

	/**
	 * FAQ ������������ �̵� 
	 **/
	public ModelAndView updateForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String faqNo = request.getParameter("faqNo");
		FaqDTO faq = faqService.selectByFaqNo(Integer.parseInt(faqNo));
		request.setAttribute("faq", faq);
		return new ModelAndView("manager/faqUpdate.jsp");
	}
	
	/**
	 * FAQ �����ϱ�
	 **/
     public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String saveDir = request.getServletContext().getRealPath("/img");
    	int maxSize = 1024*1024*100;
		String encoding= "UTF-8";
		System.out.println(saveDir);
    	
        MultipartRequest m = new MultipartRequest(request, saveDir,maxSize, encoding, new DefaultFileRenamePolicy());
		
		String faqNo= m.getParameter("faqNo");
		String faqCategory=m.getParameter("faq_category");
		String faqTitle = m.getParameter("faq_title");
		String faqContent = m.getParameter("faq_content");
         
		System.out.println("�����ϴ� FAQ��ȣ: "+faqNo+ "FAQ����: "+faqTitle +"FAQī�װ�" +faqCategory);
		
		FaqDTO faq = new FaqDTO(Integer.parseInt(faqNo), faqTitle, faqContent, faqCategory);
		
		if(m.getFilesystemName("faq_attach")!=null) {
			
			String faqAttach =m.getFilesystemName("faq_attach");
			//���� �̸��� reviewDTO�� �����Ѵ�.
			faq.setFaqAttach(faqAttach);
			//�����ͺ��̽��� �̹����� �Բ� �����Ѵ�.
			//connection�� �����ϱ� ���� reviewService.updateFaqImg �ۼ����ߴ�. 
			//���߿� �ʿ��ϸ� �����
			//reviewService.updateFaqImg(Integer.parseInt(reviewNo), reviewAttach);
			System.out.println("�����Ϸ��� ÷�������̸�: "+faqAttach);
		}
	//������ �Է°��� �����Ѵ�.
	//saveDir: ������ ����ؼ� ÷�������� ������ save ��ε� ������.
	faqService.updateFaq(faq,saveDir);
		
	return new ModelAndView("front?key=faq&methodName=selectAllFaq",true);
	
	
}

 	/**
 	 * FAQ �����ϱ�
 	 **/
 	
      
      public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		String faqNo = request.getParameter("faqNo");
  		FaqDTO faq = faqService.selectByFaqNo(Integer.parseInt(faqNo));
  		 
  		//������ ���
  		String path =request.getServletContext().getRealPath("/img/");
  		//÷������ �̸�
  		System.out.println("������ �ı� �Խù� ��ȣ: "+faq.getFaqNo());
  		faqService.deleteFaq(faq,path);
 		
 		//������ ��ġ�� �Խù� list�� ���ư���.
 		return new ModelAndView("front?key=faq&methodName=selectAllFaq",true);
 	}
	
	
     
     
     
     
		
}
	
	
	
	
	
