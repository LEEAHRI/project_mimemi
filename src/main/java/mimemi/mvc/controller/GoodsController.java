package mimemi.mvc.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mimemi.mvc.dto.GoodsDTO;
import mimemi.mvc.dto.LiveCouponDTO;
import mimemi.mvc.dto.UserDTO;
import mimemi.mvc.service.GoodsService;
import mimemi.mvc.service.GoodsServiceImpl;
import net.sf.json.JSONArray;

public class GoodsController implements Controller {
	private static GoodsService goodsService = new GoodsServiceImpl();
	
	// VIEW�� ��ȯ�ϴ� Controller (Controller)
	/***
	 * ��ǰ��ȸ
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView goodsSelectAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("manager/goods_Main_Mg.jsp");
		return mv;
	}
	
	/**
	 * ��ǰ�߰�
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView goodsInsert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("manager/goods_Main_Mg.jsp");
		return mv;
	}
	/**
	 * ��ǰ��ȸ(����� ������)
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView goodsList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("goods/goodsList.jsp");
		return mv;
	}
	
	/**
	 * ��ǰ�󼼺���
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView goodsView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String goodsId = request.getParameter("goodsId");
		ModelAndView mv = new ModelAndView("goods/goodsView.jsp");
		request.setAttribute("goodsId", goodsId);
		return mv;
	}
	
	
	// �ܼ��� �����͸� �������ִ� API Controller (RestController)
	public void getGoodsList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		List<GoodsDTO> goodsList = goodsService.goodsSelectAll();
		JSONArray goodsArr = JSONArray.fromObject(goodsList);
		PrintWriter out = response.getWriter();
		out.print(goodsArr);
	}
	// ��ǰ Y���� ��ȸ�ϱ�
	public void getGoodsSelectForSale(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		List<GoodsDTO> goodsList = goodsService.goodsSelectForSale();
		JSONArray goodsArr = JSONArray.fromObject(goodsList);
		PrintWriter out = response.getWriter();
		out.print(goodsArr);
	}
	
	
	// ��ǰ �̸����� ��ȸ�ϱ� (Ư��������ȸ)
	public void getGoodsSelectByKeyword(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		String keyword = request.getParameter("keyword");
		List<GoodsDTO> goodsList = goodsService.goodsSelectByKeyword(keyword);
		JSONArray goodsArr = JSONArray.fromObject(goodsList);
		PrintWriter out = response.getWriter();
		out.print(goodsArr);
	}
	
	
	// ��ǰ�̸����� ��ǰ����ȸ�ϱ�
	public void getSelectByGoodsId(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		String goodsId = request.getParameter("goodsId");
		GoodsDTO goods = goodsService.selectByGoodsId(goodsId);
		JSONArray goodsArr = JSONArray.fromObject(goods);
		PrintWriter out = response.getWriter();
		out.print(goodsArr);
	}
	
	//��ǰ �߰��ϱ�
	public void getGoodsInsert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		String goodsId = request.getParameter("goodsId");
		String goodsName = request.getParameter("goodsName");
		String goodsDetail = request.getParameter("goodsDetail");
		String goodsThumbnail = request.getParameter("goodsThumbnail");
		int goodsPrice = Integer.parseInt(request.getParameter("goodsPrice"));
		String goodsSale = request.getParameter("goodsSale");
		GoodsDTO goods = new GoodsDTO(goodsId, goodsName, goodsDetail, goodsThumbnail, goodsPrice, goodsSale);
		goodsService.goodsInsert(goods);
	}
	
	//��ǰ �����ϱ�
	public ModelAndView getGoodsUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		String goodsId = request.getParameter("goodsId");
		String goodsName = request.getParameter("goodsName");
		String goodsDetail = request.getParameter("goodsDetail");
		String goodsThumbnail = request.getParameter("goodsThumbnail");
		int goodsPrice = Integer.parseInt(request.getParameter("goodsPrice"));
		String goodsSale = request.getParameter("goodsSale");
		
		GoodsDTO dto = new GoodsDTO(goodsId, goodsName, goodsDetail, goodsThumbnail, goodsPrice, goodsSale);
		goodsService.goodsUpdate(dto);

		//return new ModelAndView("front?key=coupon&methodName=selectAllLiveCp", true);
		return new ModelAndView("manager/goodsSelectAll.jsp");
	}
	

	public void selectOrderGoods(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = request.getSession();
		UserDTO loginUser = (UserDTO)session.getAttribute("loginUser");
		String userId = loginUser.getUserId();
		
		List<GoodsDTO> goodsList = goodsService.selectOrderGoods(userId);
		
		JSONArray arr = JSONArray.fromObject(goodsList);
		
		PrintWriter out = response.getWriter();
		out.print(arr);
	}

	@Override
	public ModelAndView hendlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
