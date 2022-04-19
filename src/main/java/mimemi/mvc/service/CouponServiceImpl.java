package mimemi.mvc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dao.CouponDAO;
import mimemi.mvc.dao.CouponDAOImpl;
import mimemi.mvc.dto.CartDTO;
import mimemi.mvc.dto.LiveCouponDTO;
import mimemi.mvc.dto.OrderDTO;
import mimemi.mvc.dto.RgCouponDTO;
import mimemi.mvc.dto.UserCouponDTO;
import mimemi.mvc.util.DbUtil;

public class CouponServiceImpl implements CouponService {
	private CouponDAO couponDAO = new CouponDAOImpl();
	
	/**
	 * �ǽð� ���� ���
	 * @param: LiveCouponDTO(String livecouId, String livecouName, int livecouPrice, int livecouUseperiod)
	 * */
	@Override
	public void insertLiveCp(LiveCouponDTO liveCoupon) throws SQLException {
		int result = couponDAO.insertLiveCp(liveCoupon);
		
		if(result == 0) {
			throw new SQLException();
		}
	}

	/**
	 * �ǽð� ���� ����
	 * @param: LiveCouponDTO(String livecouId, String livecouName, int livecouPrice, int livecouUseperiod)
	 * */
	@Override
	public void updateLiveCp(LiveCouponDTO liveCoupon) throws SQLException {
		int result = couponDAO.updateLiveCp(liveCoupon);
		
		if(result == 0) {
			throw new SQLException();
		}

	}
	
	/**
	 * ���� ���� ���
	 * @param: RgCouponDTO(String rgcouId, String rgcouName, int rgcouPrice, String rgcouPubdate, String rgcouEnddate)
	 * */
	@Override
	public void insertRgCp(RgCouponDTO rgCoupon) throws SQLException {
		int result = couponDAO.insertRgCp(rgCoupon);
		
		if(result == 0) {
			throw new SQLException();
		}

	}
	
	/**
	 * ���� ���� ����
	 * @param: RgCouponDTO(String rgcouId, String rgcouName, int rgcouPrice, String rgcouPubdate, String rgcouEnddate)
	 * */
	@Override
	public void updateRgCp(RgCouponDTO rgCoupon) throws SQLException {
		int result = couponDAO.updateRgCp(rgCoupon);
		
		if(result == 0) {
			throw new SQLException();
		}
	}
	
	/**
	 * �ǽð� ���� ��ȸ
	 * @return: LiveCouponDTO
	 * */
	@Override
	public List<LiveCouponDTO> selectAllLiveCp() throws SQLException {
		List<LiveCouponDTO> list = couponDAO.selectAllLiveCp();
		
		return list;
	}

	/**
	 * ���� ���� ��ȸ
	 * @return: RgCouponDTO
	 * */
	@Override
	public List<RgCouponDTO> selectAllRgCp() throws SQLException {
		List<RgCouponDTO> list = couponDAO.selectAllRgCp();
		
		return list;
	}

	/**
	 * ����ں� ���� ���
	 * @param: UserCouponDTO(String userId, String livecouId | rgcouId, String usercouPubdate, String usercouEnddate)
	 * 			String couponType(�ǽð� ����, ���� �������� ������ if������ ������ ����)
	 * */
	@Override
	public void insertUserCp(UserCouponDTO userCoupon, String couponType) throws SQLException {
		int result = couponDAO.insertUserCp(userCoupon, couponType);
		
		if(result == 0) {
			throw new SQLException();
		}
		
	}

	/**
	 * ����ں� ���� ��뿩�� ����
	 * @param: int usercouId, String state(���� ���̵�� ���� ��� ����)
	 * */
	@Override
	public void updateCpState(int usercouId, String state) throws SQLException {
		int result = couponDAO.updateCpState(usercouId, state);
		
		if(result == 0) {
			throw new SQLException();
		}

	}

	/**
	 * ��ü ����� ���� ��ȸ
	 * �����, ����� ����
	 * @param: String field(���� ������ �μ��� ������ if������ ������ ����)
	 * @return: UserCouponDTO
	 * */
	@Override
	public List<UserCouponDTO> selectAllUserCp(String field) throws SQLException {
		List<UserCouponDTO> userCouponList = couponDAO.selectAllUserCp(field);
		
		return userCouponList;
	}

	/**
	 * ����ں� ���� ��ȸ
	 * @param: String userId
	 * @return: UserCouponDTO(ȸ�� ���̵�� �˻��� ��ü ���ڵ�)
	 * */
	@Override
	public List<UserCouponDTO> selectCpByUserId(String userId) throws SQLException {
		List<UserCouponDTO> list = couponDAO.selectCpByUserId(userId);
		
		return list;
	}
	
	/**
	 * LiveCoupon�� ���� ���̵�� ã��
	 * */
	public LiveCouponDTO selectLvCouByCouId(String livecouId) throws SQLException {
		LiveCouponDTO liveCoupon = couponDAO.selectLvCouByCouId(livecouId);
		
		return liveCoupon;
	}

	/**
	 * RgCoupon�� ���� ���̵�� ã��
	 * */
	@Override
	public RgCouponDTO selectRgCouByCouId(String rgcouId) throws SQLException {
		RgCouponDTO rgCoupon = couponDAO.selectRcCouByCouId(rgcouId);
		
		return rgCoupon;
	}

}
