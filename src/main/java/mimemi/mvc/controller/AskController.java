import javax.servlet.http.HttpServletResponse;

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
	
	public ModelAndView selectAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<AskDTO> askList = askService.selectAllAsk();
		
		request.setAttribute("askList", askList);
		
		return new ModelAndView("board/ask.jsp");
		
	}
	
	/**
	 * 1:1 ���� ���
	 * */
	public ModelAndView insertAsk(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		String saveDir= request.getServletContext().getRealPath("/save");
		int maxSize =1024*1024*100;//100M
	    String encoding="UTF-8";
		
		MultipartRequest m = 
			new MultipartRequest(request, saveDir,maxSize,encoding , new DefaultFileRenamePolicy());

		String askTitle = request.getParameter("askTitle");
		String askContent = request.getParameter("askContent");
		String askAttach = request.getParameter("askAttach");
		
		AskDTO askDto = new AskDTO(askTitle, askContent, askAttach);
		
		if(m.getFilesystemName("askAttach") != null) {
			//�����̸�
			askDto.setAskAttach(m.getFilesystemName("askAttach"));
			
			
			//����ũ�� ����
			//m.getFile("file").length();
			
			//askDto.setFsize( (int)m.getFile("askAttach").length() );
			
		}
		
		askService.insertAsk(askDto);
		
		return new ModelAndView("front",true);
	}
	/**
	 * 1:1 ���� ����
	 * */
	public int updateAsk(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return 0;
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
	public int deleAsk(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return 0;
	}
	
	/**
	 * 1:1 ���� ��ü �˻�
	 * */
	public ModelAndView selectAllAsk(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//List<AskDTO> list = askService.selectAllAsk();
		
		
		
		return null;
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

