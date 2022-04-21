package mimemi.mvc.controller;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mimemi.mvc.dao.UserDAO;
import mimemi.mvc.dao.UserDAOImpl;
import mimemi.mvc.dto.AddrDTO;

import mimemi.mvc.dto.UserDTO;
import mimemi.mvc.service.AddrService;
import mimemi.mvc.service.AddrServiceImpl;
import mimemi.mvc.service.UserService;
import mimemi.mvc.service.UserServiceImpl;
import net.sf.json.JSONArray;

public class UserController implements Controller {
	private UserService userService = new UserServiceImpl();
	private AddrService addrService = new AddrServiceImpl();
	private UserDAO userDAO = new UserDAOImpl();
	
	@Override
	public ModelAndView hendlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}
	
	/**
	 * ȸ������
	 * */
	public ModelAndView insertUser(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String userPhone = request.getParameter("userPhone");
		String userBirth = request.getParameter("userBirth");

		String addrName = userId;
		String zipcode = request.getParameter("zipcode");
		System.out.println(userId);
		
		String addrAddr = request.getParameter("addrAddr");
		String addrDetailAddr = request.getParameter("addrDetailAddr");
		String addrRefAddr = request.getParameter("addrRefAddr");
		
		UserDTO user = new UserDTO(userId, userName, userPwd, userPhone, 0, userId, "F", userBirth);
		AddrDTO addr = new AddrDTO(userId, addrName, Integer.parseInt(zipcode) , addrAddr, addrDetailAddr, addrRefAddr, userName, userPhone);
		
		userService.insertUser(user, addr);
		
		return new ModelAndView("user/join04.jsp");
	}
	
	/**
	 * �α��� ���
	 * */
	public ModelAndView loginUser(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//userId, userPwd �ޱ�
		String userId= request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		UserDTO dbDTO = userService.loginUser(userId,userPwd);
//		System.out.println(dbDTO.getUserName());
		System.out.println(dbDTO.getUserId());
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", dbDTO);
		session.setAttribute("loginName", dbDTO.getUserName());
		
		return new ModelAndView("index.jsp", true);
	}
	
	/**
	 * ȸ������ ���� ��й�ȣ üũ
	 * */
	public ModelAndView pwdCheckForEdit(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		
		//userId, userPwd �ޱ�
		HttpSession session = request.getSession();
		UserDTO user= (UserDTO)session.getAttribute("loginUser");
		
		String userId= user.getUserId();
		String userPwd = request.getParameter("inputPwd");
//		System.out.println(userId);
		
		userService.loginUser(userId,userPwd);
		
		return new ModelAndView("mypage/userEdit02.jsp", true);

	}
	
	/**
	 * ȸ��Ż�� ��й�ȣ üũ
	 * */
	public ModelAndView pwdCheckForLeave(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		
		//userId, userPwd �ޱ�
		HttpSession session = request.getSession();
		UserDTO user= (UserDTO)session.getAttribute("loginUser");
		
		String userId= user.getUserId();
		String userPwd = request.getParameter("inputPwd");
//		System.out.println(userId);
		
		userService.loginUser(userId,userPwd);
		
		return new ModelAndView("mypage/userLeave02.jsp", true);
//		JSONArray arr = JSONArray.fromObject(dbDTO);
//		
//		PrintWriter out = response.getWriter();
//		out.print(arr);
	}
	/**
	 * �α׾ƿ� ���
	 * */
	public ModelAndView logoutUser(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		
		session.invalidate();
		
		return new ModelAndView("index.jsp", true);
	}
	
	/**
	 * ȸ������ ������ ����
	 * */
	public ModelAndView updateForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		UserDTO userDTO = userService.selectByID(userId);
		
		request.setAttribute("userDTO", userDTO);
		
		return new ModelAndView("mypage/userEdit.jsp");
	}
	/**
	 * ȸ������ ���� ���
	 * */
	public ModelAndView updateUser(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String userPhone = request.getParameter("userPhone");
		
		String zipcode = request.getParameter("zipcode");
		String addrAddr = request.getParameter("addrAddr");
		String addrDetailAddr = request.getParameter("addrDetailAddr");
		String addrRefAddr = request.getParameter("addrRefAddr");
		String receiverPhone = userPhone;
		
		UserDTO userDTO = new UserDTO(userPhone);
		AddrDTO addrDTO = new AddrDTO(zipcode, Integer.parseInt(zipcode), addrAddr, addrDetailAddr, addrRefAddr, receiverPhone);
		
		userService.updateUser(userDTO, addrDTO);
		
		return new ModelAndView("mypage/mypageMain.jsp");
	}
	
	/**
	 * ��к�ȣ ���� ���
	 * */
	public void updatePwd(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		HttpSession session = request.getSession();
		
		userService.updateUserPwd(userId, userPwd);
		
//		if(session.getAttribute("loginUser") != null) {
//			logoutUser(request, response); 
//		}
		
		PrintWriter out = response.getWriter();
		out.print("��й�ȣ ������ �Ϸ�Ǿ����ϴ�.");
		
	}
	/**
	 * idã��
	 * */
	public ModelAndView selectId(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String userName=request.getParameter("userName");
		String userPhone=request.getParameter("userPhone");
		
		
		
		String userId = userService.selectUserId(userName, userPhone);
		
		request.setAttribute("userId", userId);
		request.setAttribute("userName", userName);
		
		return new ModelAndView("user/find_id_Ok.jsp");
		
	}
	/**
	 * ��й�ȣã��
	 * */
	public ModelAndView selectPwd(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String userId=request.getParameter("userId");
		String userName = request.getParameter("userName");
		String userPhone = request.getParameter("userPhone");
		
		userService.selectUserPwd(userId, userName, userPhone);
		
		request.setAttribute("userId", userId);
		
		return new ModelAndView("user/editPwd.jsp");
	}
	/**
	 * id�� ���� ã��
	 * */
	public void selectById(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String userId=request.getParameter("userId");
		
		userService.selectByID(userId);		
	}
	
	/**
	 * phone���� ���� ã��
	 * */
	public void selectByPhone(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String userPhone=request.getParameter("userPhone");
		
		userService.selectByPhone(userPhone);		
	}
	
	/**
	 * Ż���ϱ� ��� 
	 * */
	public ModelAndView deleteUser(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		UserDTO user= (UserDTO)session.getAttribute("loginUser");
		
		String userId = user.getUserId();
		
		System.out.println(userId);
		System.out.println(user);
		
		userService.deleteUser(userId);
		
		return logoutUser(request, response); //return�� ���ְ� logoutUser ȣ�⸸�ϸ� 
	}


	/**
	 * ���̵� �ߺ� üũ
	 * */
	public void idCheck(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String userId = request.getParameter("userId");
		boolean result = userDAO.idCheck(userId);
		
		PrintWriter out = response.getWriter();
		
		if(result) {out.print("true");
		}else {out.print("false");
		}
	}
	
	/**
	 * �ڵ�����ȣ �ߺ� üũ
	 * */
	public void phoneCheck(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String userPhone = request.getParameter("userPhone");
		boolean result = userDAO.idCheck(userPhone);
		
		PrintWriter out = response.getWriter();
		
		if(result) {out.print("true");
		}else {out.print("false");
		}
	}
}
