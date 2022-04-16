package mimemi.mvc.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mimemi.mvc.dto.LiveCouponDTO;
import mimemi.mvc.dto.RgCouponDTO;
import mimemi.mvc.dto.UserCouponDTO;
import mimemi.mvc.service.CouponService;
import mimemi.mvc.service.CouponServiceImpl;
import net.sf.json.JSONArray;

public class CouponController implements Controller {
	private CouponService couponService = new CouponServiceImpl();
	
	@Override
	public ModelAndView hendlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * �ǽð� ���� ��ȸ
	 * @return: LiveCouponDTO
	 * */
	public void selectAllLiveCp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		List<LiveCouponDTO> list = couponService.selectAllLiveCp();
		
		//list�� ������ �� ���� ������ list�� jsonArray ��ȯ�ؼ� ������.
		JSONArray arr = JSONArray.fromObject(list);
		
		PrintWriter out = response.getWriter();
		out.println(arr);
		
	}
	
	/**
	 * ���� ���� ��ȸ
	 * @return: RgCouponDTO
	 * */
	public void selectAllRgCp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		List<RgCouponDTO> list = couponService.selectAllRgCp();
		
		//list�� ������ �� ���� ������ list�� jsonArray ��ȯ�ؼ� ������.
		JSONArray arr = JSONArray.fromObject(list);
		
		PrintWriter out = response.getWriter();
		out.println(arr);
		
	}
	
	/**
	 * ����ں� ���� ��ȸ
	 * @param: String userId
	 * @return: UserCouponDTO(ȸ�� ���̵�� �˻��� ��ü ���ڵ�)
	 * */
	public void selectCpByUserId(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		
		String userId = request.getParameter("userId");
		List<UserCouponDTO> list = couponService.selectCpByUserId(userId);
		
		JSONArray arr = JSONArray.fromObject(list);
		
		PrintWriter out = response.getWriter();
		out.print(arr);
		
	}
	
	/**
	 * �ǽð� ���� ���
	 * @param: LiveCouponDTO(String livecouId, String livecouName, int livecouPrice, int livecouUseperiod)
	 * */
	public ModelAndView insertLiveCp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		
		String livecouId = request.getParameter("id");
		String livecouName = request.getParameter("name");
		String livecouPrice = request.getParameter("price");
		String livecouPubdate = request.getParameter("pubDate");
		String livecouUseperiod = request.getParameter("endDate");
		
		LiveCouponDTO dto = new LiveCouponDTO(livecouId, livecouName, Integer.parseInt(livecouPrice), livecouPubdate, Integer.parseInt(livecouUseperiod) );
		couponService.insertLiveCp(dto);
		
		return new ModelAndView("front?key=coupon&methodName=selectAllLiveCp", true);
		
	}

}
