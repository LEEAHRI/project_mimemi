package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.LiveCouponDTO;
import mimemi.mvc.dto.RgCouponDTO;
import mimemi.mvc.dto.UserCouponDTO;

public interface CouponService {
	/**
	 * �ǽð� ���� ���
	 * @param: LiveCouponDTO(String livecouId, String livecouName, int livecouPrice, int livecouUseperiod)
	 * */
	void insertLiveCp(LiveCouponDTO liveCoupon) throws SQLException;
	
	/**
	 * �ǽð� ���� ����
	 * @param: LiveCouponDTO(String livecouId, String livecouName, int livecouPrice, int livecouUseperiod)
	 * */
	void updateLiveCp(LiveCouponDTO liveCoupon) throws SQLException;
	
	/**
	 * ���� ���� ���
	 * @param: RgCouponDTO(String rgcouId, String rgcouName, int rgcouPrice, String rgcouPubdate, String rgcouEnddate)
	 * */
	void insertRgCp(RgCouponDTO rgCoupon) throws SQLException;

	/**
	 * ���� ���� ����
	 * @param: RgCouponDTO(String rgcouId, String rgcouName, int rgcouPrice, String rgcouPubdate, String rgcouEnddate)
	 * */
	void updateRgCp(RgCouponDTO rgCoupon) throws SQLException;

	/**
	 * �ǽð� ���� ��ȸ
	 * @return: LiveCouponDTO
	 * */
	List<LiveCouponDTO> selectAllLiveCp() throws SQLException;
	
	/**
	 * ���� ���� ��ȸ
	 * @return: RgCouponDTO
	 * */
	List<RgCouponDTO> selectAllRgCp() throws SQLException;
	
	/**
	 * ����ں� ���� ���
	 * @param: UserCouponDTO(String userId, String livecouId | rgcouId, String usercouPubdate, String usercouEnddate)
	 * 			String couponType(�ǽð� ����, ���� �������� ������ if������ ������ ����)
	 * */
	void insertUserCp(UserCouponDTO userCoupon, String couponType) throws SQLException;
	
	/**
	 * ����ں� ���� ��뿩�� ����
	 * @param: int usercouId, String state(���� ���̵�� ���� ��� ����)
	 * */
	void updateCpState(int usercouId, String state) throws SQLException;
	
	/**
	 * ��ü ����� ���� ��ȸ
	 * �����, ����� ����
	 * @param: String field(���� ������ �μ��� ������ if������ ������ ����)
	 * @return: UserCouponDTO
	 * */
	List<UserCouponDTO> selectAllUserCp(String field) throws SQLException;
	
	/**
	 * ����ں� ���� ��ȸ
	 * @param: String userId
	 * @return: UserCouponDTO(ȸ�� ���̵�� �˻��� ��ü ���ڵ�)
	 * */
	List<UserCouponDTO> selectCpByUserId(String userId) throws SQLException;
	
	/**
	 * livecouId������ LiveCouponDTO ��ü �ϳ� �ҷ�����
	 * */
	LiveCouponDTO selectLvCouByCouId(String livecouId) throws SQLException;
	
	/**
	 * rgcouId������ RgCouponDTO ��ü �ϳ� �ҷ�����
	 * */
	RgCouponDTO selectRgCouByCouId(String rgcouId) throws SQLException;
}
