package mimemi.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.LiveCouponDTO;
import mimemi.mvc.dto.RgCouponDTO;
import mimemi.mvc.dto.UserCouponDTO;

public interface CouponDAO {
	/**
	 * �ǽð� ���� ���
	 * */
	int insertLiveCp(LiveCouponDTO liveCoupon) throws SQLException;
	
	/**
	 * �ǽð� ���� ����
	 * */
	int updateLiveCp(LiveCouponDTO liveCoupon) throws SQLException;
	
	/**
	 * ���� ���� ���
	 * */
	int insertRgCp(RgCouponDTO rgCoupon) throws SQLException;

	/**
	 * ���� ���� ����
	 * */
	int updateRgCp(RgCouponDTO rgCoupon) throws SQLException;

	/**
	 * �ǽð� ���� ��ȸ
	 * */
	List<LiveCouponDTO> selectAllLiveCp() throws SQLException;
	
	/**
	 * ���� ���� ��ȸ
	 * */
	List<RgCouponDTO> selectAllRgCp() throws SQLException;
	
	/**
	 * ����ں� ���� ���
	 * */
	int insertUserCp(UserCouponDTO userCoupon, String couponType) throws SQLException;
	
	/**
	 * ����ں� ���� ��뿩�� ����
	 * */
	int updateCpState(int usercouId, String state) throws SQLException;
	
	/**
	 * ��ü ����� ���� ��ȸ
	 * �����, ����� ����
	 * */
	List<UserCouponDTO> selectAllUserCp(String field) throws SQLException;
	
	/**
	 * ����ں� ���� ��ȸ
	 * */
	List<UserCouponDTO> selectCpByUserId(String userId) throws SQLException;
	
}
