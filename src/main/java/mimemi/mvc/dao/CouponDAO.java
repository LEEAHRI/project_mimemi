package mimemi.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.LiveCouponDTO;
import mimemi.mvc.dto.RgCouponDTO;
import mimemi.mvc.dto.UserCouponDTO;

public interface CouponDAO {
	/**
	 * �ǽð� ���� ���
	 * @param: LiveCouponDTO(String livecouId, String livecouName, int livecouPrice, int livecouUseperiod)
	 * @return: int(��ϵ� ���ڵ� ��)
	 * */
	int insertLiveCp(LiveCouponDTO liveCoupon) throws SQLException;
	
	/**
	 * �ǽð� ���� ����
	 * @param: LiveCouponDTO(String livecouId, String livecouName, int livecouPrice, int livecouUseperiod)
	 * @return: int(������ ���ڵ� ��)
	 * */
	int updateLiveCp(LiveCouponDTO liveCoupon) throws SQLException;
	
	/**
	 * ���� ���� ���
	 * @param: RgCouponDTO(String rgcouId, String rgcouName, int rgcouPrice, String rgcouPubdate, String rgcouEnddate)
	 * @return: int(��ϵ� ���ڵ� ��)
	 * */
	int insertRgCp(RgCouponDTO rgCoupon) throws SQLException;

	/**
	 * ���� ���� ����
	 * @param: RgCouponDTO(String rgcouId, String rgcouName, int rgcouPrice, String rgcouPubdate, String rgcouEnddate)
	 * @return: int(������ ���ڵ� ��)
	 * */
	int updateRgCp(RgCouponDTO rgCoupon) throws SQLException;

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
	 * @return: int(��ϵ� ���ڵ� ��)
	 * */
	int insertUserCp(UserCouponDTO userCoupon, String couponType) throws SQLException;
	
	/**
	 * ����ں� ���� ��뿩�� ����
	 * @param: int usercouId, String state(���� ���̵�� ���� ��� ����)
	 * @return: int(������ ���ڵ� ��)
	 * */
	int updateCpState(int usercouId, String state) throws SQLException;
	
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
	 * LiveCoupon ���� ��ȸ
	 * @param: String userId
	 * @return: UserCouponDTO(ȸ�� ���̵�� �˻��� ��ü ���ڵ�)
	 * */
	LiveCouponDTO selectLvCouByCouId(String livecouId) throws SQLException;
	
	/**
	 * RgCoupon ���� ��ȸ
	 * @param: String userId
	 * @return: UserCouponDTO(ȸ�� ���̵�� �˻��� ��ü ���ڵ�)
	 * */
	RgCouponDTO selectRcCouByCouId(String rgcouId) throws SQLException;
	
}
