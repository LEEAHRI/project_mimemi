package mimemi.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mimemi.mvc.dto.AnswerDTO;
import mimemi.mvc.service.AnswerService;
import mimemi.mvc.service.AnswerServiceImpl;

public class AnswerController implements Controller {

	private AnswerService answerService = new AnswerServiceImpl();
	
	@Override
	public ModelAndView hendlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return null;
	}
	
	/**
	 * ��� ���
	 * */
	public ModelAndView insertAnswerReply(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String saveDir = request.getServletContext().getRealPath("/img");
		int maxSize = 1024*1024*100;
		String encoding= "UTF-8";
		
		MultipartRequest m = new MultipartRequest(request, saveDir,maxSize, encoding, new DefaultFileRenamePolicy());
		
		String answerContent=m.getParameter("answer_content");
		
		AnswerDTO answerDto= new AnswerDTO(answerContent);
		
		answerService.insertAnswerReply(answerDto);
		
		return new ModelAndView("front?key=ask&methodName=selectAll.jsp", true);
	}
	
	/**
	 * ��� ����
	 * */
	public ModelAndView updateAnswerReply(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return null;
	}
	
	/**
	 * ��� ����
	 * */
	
	public ModelAndView deleteAnswerReply(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return null;
	}
	
}
