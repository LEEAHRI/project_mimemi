package mimemi.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mimemi.mvc.dto.AskDTO;
import mimemi.mvc.dto.UserDTO;
import mimemi.mvc.service.AskService;
import mimemi.mvc.service.AskServiceImpl;

public class AskController implements Controller {

	private AskService askService = new AskServiceImpl();
	
	@Override
	public ModelAndView hendlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 1:1���� ��ü�˻�
	 * */
	public ModelAndView selectAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.setContentType("text/html;charset=UTF-8");
		
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null || pageNum.equals("")) {
			pageNum = "1";
		}
		
		String field = request.getParameter("field");
		
		List<AskDTO> askList = askService.selectAllAsk(Integer.parseInt(pageNum), field);
		
		request.setAttribute("askList", askList);
		request.setAttribute("pageNum", pageNum);
		
		
		return new ModelAndView("board/ask2.jsp");
		
	}
	
	/**
	 * (������) ��ü����
	 * */
	
	public ModelAndView selectAllManager(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.setContentType("text/html;charset=UTF-8");
		
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null || pageNum.equals("")) {
			pageNum = "1";
		}
		
		String field = request.getParameter("field");
		
		List<AskDTO> askList = askService.selectAllAsk(Integer.parseInt(pageNum), field);
		
		request.setAttribute("askList", askList);
		request.setAttribute("pageNum", pageNum);
		
		
		return new ModelAndView("manager/ask_Main_Mg.jsp");
		
		
	}
	
	/**
	 * �˻����
	 * */
	public ModelAndView selectByKeyword(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		String pageNum= request.getParameter("pageNum");
		if(pageNum==null||pageNum.equals("")) {
			pageNum="1";
		}
		String field=request.getParameter("field");//�ɼ�-����,����
		
		System.out.println("field ="+field);
		
		String keyWord= request.getParameter("keyWord");
		
		System.out.println("keyword:"+keyWord);
		List<AskDTO> list=askService.selectByKeyword(keyWord, field, Integer.parseInt(pageNum));
		
		request.setAttribute("list", list);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("filed", field);
		request.setAttribute("keyword", keyWord);
		
		
		return new ModelAndView("board/askSearch.jsp");
	}
	
	/**
	 * �˻����(������)
	 * */
	public ModelAndView selectByKeywordManager(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		String pageNum= request.getParameter("pageNum");
		if(pageNum==null||pageNum.equals("")) {
			pageNum="1";
		}
		String field=request.getParameter("field");//�ɼ�-����,����
		
		System.out.println("field ="+field);
		
		String keyWord= request.getParameter("keyWord");
		
		System.out.println("keyword:"+keyWord);
		List<AskDTO> list=askService.selectByKeyword(keyWord, field, Integer.parseInt(pageNum));
		
		request.setAttribute("list", list);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("filed", field);
		request.setAttribute("keyword", keyWord);
		
		
		return new ModelAndView("manager/ask_Main_Mg.jsp");
	}
	
	/**
	 * 1:1 ���� ���
	 * */
	public ModelAndView insertAsk(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		String saveDir= request.getServletContext().getRealPath("/save");
		int maxSize =1024*1024*100;//100M
	    String encoding="UTF-8";
		System.out.println(saveDir);
	    
		MultipartRequest m = 
			new MultipartRequest(request, saveDir,maxSize,encoding , new DefaultFileRenamePolicy());
		
		
		String askTitle=m.getParameter("ask_title");
		String askContent=m.getParameter("ask_content");
		String askCategory=m.getParameter("ask_category");
		
		HttpSession session = request.getSession();
		UserDTO reviewUser = (UserDTO)session.getAttribute("loginUser");
		String userid = reviewUser.getUserId();
		
		System.out.println("userId-------"+userid);
	
		System.out.println(askTitle);
		AskDTO askDto = new AskDTO(userid, askTitle, askContent,askCategory);
		
		//����÷�ΰ� �Ǿ��ٸ�..
		if(m.getFilesystemName("notice_attach") != null) {
			//�����̸�
			askDto.setAskAttach(m.getFilesystemName("notice_attach"));
			
			
			//����ũ�� ����
			//m.getFile("file").length();
			
			//askDto.setFsize( (int)m.getFile("askAttach").length() );
			
		}
		askService.insertAsk(askDto);
		
		
		//return new ModelAndView("front?key=ask&methodName=selectAll", true);
		return new ModelAndView("front?key=ask&methodName=selectAll", true);
	
	}
	
	/**
	 * ask �����������̵�
	 * */
	public ModelAndView updateAskForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String askNo = request.getParameter("askNo");
		AskDTO ask = askService.selectByAskNo(Integer.parseInt(askNo));
		request.setAttribute("ask", ask);		
	
		//notice update����
				//faq update����
				//������
				//
		
		return new ModelAndView("/board/askupdate.jsp");
	}
	
	/**
	 * 1:1 ���� ����
	 * */
	public ModelAndView updateAsk(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String saveDir = request.getServletContext().getRealPath("/img");
    	int maxSize = 1024*1024*100;
		String encoding= "UTF-8";
		
		 MultipartRequest m = new MultipartRequest(request, saveDir,maxSize, encoding, new DefaultFileRenamePolicy());
			
		
		String askNo=m.getParameter("askNo");
		String askTitle=m.getParameter("askTitle");
		String askContent=m.getParameter("askContent");
		System.out.println(askContent);
		AskDTO ask = new AskDTO(Integer.parseInt(askNo), askTitle, askContent);
		

		if(m.getFilesystemName("askAttach")!=null) {
			String askAttach=m.getFilesystemName("askAttach");
			
			ask.setAskAttach(askAttach);
			System.out.println("�����Ϸ��� ÷�������̸� "+askAttach);
		}
		askService.updateAsk(ask,saveDir);
		
		
	
		return new ModelAndView("front?key=ask&methodName=selectAll",true);
		
	}
	
	/**
	 * 1:1 ���� �Խñ� ÷������ ����
	 * */
	public int updateAskAttach(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return 0;
	}
	
	/**
	 * 1:1���� ����
	 * */
	public ModelAndView deleteAsk(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String askNo=request.getParameter("askNo");
		AskDTO ask = askService.selectByAskNo(Integer.parseInt(askNo));
		
		//askService.deleteAsk(0);
		System.out.println(ask);
		String path=request.getServletContext().getRealPath("/save");
		
		askService.deleteAsk(ask ,path);
		
		return new ModelAndView("front?key=ask&methodName=selectAll",true);
	
	}
	
	/**
	 * ���� ��ȣ�� �ҷ�����(�󼼺���)
	 * */
	public ModelAndView selectByAskNo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.setContentType("text/html;charset=UTF-8"); 
		
		
		String askNo = request.getParameter("askNo");
		String pageNo = request.getParameter("pageNo");
		
		AskDTO askDto = askService.selectByAskNo(Integer.parseInt(askNo));
		request.setAttribute("askDto", askDto);
		request.setAttribute("pageNo", pageNo);
		
		
		return new ModelAndView("/board/askupdate.jsp");
	}
	
	/**
	 * ���� ��ȣ�� �ҷ����� (������)
	 * */
	public ModelAndView selectByAskNoManager(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.setContentType("text/html;charset=UTF-8"); 
		
		
		String askNo = request.getParameter("askNo");
		String pageNo = request.getParameter("pageNo");
		
		AskDTO askDto = askService.selectByAskNo(Integer.parseInt(askNo));
		request.setAttribute("askDto", askDto);
		request.setAttribute("pageNo", pageNo);
		
		
		return new ModelAndView("/board/askdetail.jsp");
	}
	
	/**
	 * 1:1 ���� �亯 ���� ���� ���
	 * */
	public ModelAndView updateState(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		
		String askNo=request.getParameter("askNo");
		String askComplete=request.getParameter("ask_complete");
		
		AskDTO ask = new AskDTO(Integer.parseInt(askNo), askComplete);
		System.out.println("askNo:"+askNo);
		System.out.println("askComplete:"+askComplete);
		askService.updateState(ask);
		
		
		
		return new ModelAndView("front?key=ask&methodName=selectAllManager",true);
	}
}//AskController End

