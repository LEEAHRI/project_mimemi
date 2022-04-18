package mimemi.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mimemi.mvc.dto.AskDTO;
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
	 * 1:1���� �󼼺���
	 * */
	
	public ModelAndView selectByUserId(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		String pageNo = request.getParameter("pageNo");
		
		AskDTO askDto = askService.selectByUserId(userId);
		request.setAttribute("askDto", askDto);
		request.setAttribute("pageNo", pageNo);
		
		
		return new ModelAndView("board/askdetail.jsp");
	}
	
	/**
	 * 1:1 ���� ���
	 * */
	public ModelAndView insertAsk(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
/*		String saveDir= request.getServletContext().getRealPath("/save");
		int maxSize =1024*1024*100;//100M
	    String encoding="UTF-8";
		
	    String errMsg="��ϵ��� �ʾҽ��ϴ�.";
	    
		MultipartRequest m = 
			new MultipartRequest(request, saveDir,maxSize,encoding , new DefaultFileRenamePolicy());
		
		String userId =request.getParameter("userId");
		String askTitle=request.getParameter("askTitle");
		String askContent=request.getParameter("askContent");
		String askAttach=request.getParameter("askAttach");
		String askCategory=request.getParameter("askCategory");
		String askComplete=request.getParameter("askComplete");
		
		AskDTO askDto = new AskDTO(userId, askTitle, askContent,askAttach,askCategory, askComplete);
		
		
		//����÷�ΰ� �Ǿ��ٸ�..
		if(m.getFilesystemName("askAttach") != null) {
			//�����̸�
			askDto.setAskAttach(m.getFilesystemName("askAttach"));
			
			
			//����ũ�� ����
			//m.getFile("file").length();
			
			//askDto.setFsize( (int)m.getFile("askAttach").length() );
			
		}
		if(askTitle==null|| askTitle.equals("") || askContent==null || askContent.equals("") || askAttach==null || askAttach.equals("")) {
			errMsg="�Է°��� ������� �ʽ��ϴ�.\\n�ٽ� Ȯ�����ּ���.";
		}
		
		
		
		
		askService.insertAsk(askDto);
	*/	
		return new ModelAndView("board/ask2.jsp");
	}
	/**
	 * 1:1 ���� ����
	 * */
	public ModelAndView updateAsk(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		String askTitle = request.getParameter("askTitle");
		String askContent = request.getParameter("askContent");
		
		
		//�μ��� ����
		AskDTO askDto=new AskDTO(userId, askTitle, askContent);
		
		askService.updateAsk(askDto);
		
		//�󼼺��� �������� �̵�
		
		
		
		return null;
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
	public void deleAsk(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String askNo=request.getParameter(null);
		
		//askService.deleteAsk(0);
		
		String path=request.getServletContext().getRealPath("/save");
		
		askService.deleteAsk(Integer.parseInt(askNo), path);
		
	}
	
	/**
	 * ���� ��ȣ�� �ҷ�����
	 * */
	public AskDTO selectByAskNo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		
		return null;
	}
	
	/**
	 * 1:1 ���� �亯 ���� ���� ���
	 * */
	public int updateState(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return 0;
	}
}//AskController End

