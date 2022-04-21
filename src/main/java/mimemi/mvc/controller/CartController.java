package mimemi.mvc.controller;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mimemi.mvc.dto.CartDTO;
import mimemi.mvc.dto.UserDTO;
import mimemi.mvc.service.CartService;
import mimemi.mvc.service.CartServiceImpl;
import net.sf.json.JSONArray;

public class CartController implements Controller {
	private CartService cartService = new CartServiceImpl();

	@Override
	public ModelAndView hendlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * ��ٱ��� �߰�
	 * */
	public void insertCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		UserDTO loginUser = (UserDTO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			out.print("�α��� �� �̿����ּ���.");
			return;
		}
		
		String userId = loginUser.getUserId();
		
		String goodsId = request.getParameter("goodsId");
		String cartQty = request.getParameter("cartQty");
		String cartWeekDay = request.getParameter("cartWeekDay");
		String cartPeriod = request.getParameter("cartPeriod");
		String cartStart = request.getParameter("cartStart");
		String goodsPrice = request.getParameter("goodsPrice");
		
		CartDTO cart = new CartDTO(userId, goodsId, Integer.parseInt(cartQty), cartWeekDay, cartPeriod, cartStart, Integer.parseInt(goodsPrice));
		cartService.insert(cart);
		
		out.print("��ǰ�� ��ٱ��Ͽ� �����ϴ�.");
	}
	
	/**
	 * �������� ��ٱ��Ͽ� ��� ��ǰ �ѷ��ֱ�
	 * */
	public ModelAndView viewOrderForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String mode = request.getParameter("mode");
		List<CartDTO> cartList = null;

		if(mode.equals("C")) { // ��ٱ��� ��ü ����
			UserDTO loginUser = (UserDTO)session.getAttribute("loginUser");
			String userId = loginUser.getUserId();
			
			cartList = cartService.selectCartByUserId(userId);
		} else if(mode.equals("S")) { // ��ٱ��� �κ� ����
			String[] cartIds = request.getParameterValues("cartSelect");
			cartList = new ArrayList<CartDTO>();
			
			for(String id : cartIds) {
				CartDTO cart = cartService.selectCartByCartId(Integer.parseInt(id));
				cartList.add(cart);
			}
		} else if(mode.equals("D")) { // ��ǰ������ �ٷ� ����
			cartList = new ArrayList<CartDTO>();
			UserDTO loginUser = (UserDTO)session.getAttribute("loginUser");
			String userId = loginUser.getUserId();
			String goodsId = request.getParameter("goodsId");
			String cartQty = request.getParameter("cartQty");
			String cartWeekDay = request.getParameter("cartWeekDay");
			String cartPeriod = request.getParameter("cartPeriod");
			String cartStart = request.getParameter("cartStart");
			String goodsPrice = request.getParameter("goodsPrice");
			System.out.println(userId);
			System.out.println(goodsId);
			System.out.println(cartQty);
			System.out.println(cartWeekDay);
			System.out.println(cartPeriod);
			System.out.println(cartStart);
			System.out.println(goodsPrice);
			CartDTO cart = new CartDTO(userId, goodsId, Integer.parseInt(cartQty), cartWeekDay, cartPeriod, cartStart, Integer.parseInt(goodsPrice));
			cartList.add(cart);
		}
		
		session.removeAttribute("cartList");
		session.setAttribute("cartList", cartList);
		
		ModelAndView mv = new ModelAndView("order/order.jsp?mode=" + mode, true);
		return mv;
	}

	/**
	 * ���̵�� ��ٱ��� �˻�
	 * */
	public void selectCartByUserId(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		
		String userId = request.getParameter("userId");
		List<CartDTO> list = cartService.selectCartByUserId(userId);
		
		JSONArray cartArr = JSONArray.fromObject(list);
		
		PrintWriter out = response.getWriter();
		out.print(cartArr);
	}
	
	/**
	 * ��ٱ��� ���� ����
	 * */
	public void updateCartQty(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int cartId = Integer.parseInt(request.getParameter("cartId"));
		int cartQty = Integer.parseInt(request.getParameter("cartQty"));
		
		cartService.updateCartQty(cartId, cartQty);
	}
	
	/**
	 * ��ٱ��� ���� ����
	 * */
	public void updateCartWeekday(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int cartId = Integer.parseInt(request.getParameter("cartId"));
		String cartWeekday = request.getParameter("cartWeekday");
		
		cartService.updateCartWeekday(cartId, cartWeekday);
	}
	
	/**
	 * ��ٱ��� �Ⱓ ����
	 * */
	public void updateCartPeriod(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int cartId = Integer.parseInt(request.getParameter("cartId"));
		String cartPeriod = request.getParameter("cartPeriod");
		
		cartService.updateCartPeriod(cartId, cartPeriod);
	}
	
	/**
	 * ��ٱ��� ù ����� ����
	 * */
	public void updateCartStart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int cartId = Integer.parseInt(request.getParameter("cartId"));
		String cartStart = request.getParameter("cartStart");
		
		cartService.updateCartStart(cartId, cartStart);
	}

	/**
	 * ��ٱ��� �κ� ����
	 */
	public void deleteSelectedCart(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String[] arr = request.getParameterValues("cartId");
		List<Integer> cartId = new ArrayList<Integer>();
		for(String str : arr) {
			cartId.add(Integer.parseInt(str));
		}
		
		cartService.deleteSelectedCart(cartId);
	}

	/**
	 * ��ٱ��� ��ü ����
	 */
	public void deleteAllCart(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String userId = request.getParameter("userId");
		
		cartService.deleteAllCart(userId);
	}
}
