package mimemi.mvc.controller;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mimemi.mvc.dto.CartDTO;
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
