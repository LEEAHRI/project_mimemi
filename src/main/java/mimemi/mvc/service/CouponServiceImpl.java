package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dao.CouponDAO;
import mimemi.mvc.dao.CouponDAOImpl;
import mimemi.mvc.dto.CartDTO;
import mimemi.mvc.dto.LiveCouponDTO;
import mimemi.mvc.dto.RgCouponDTO;
import mimemi.mvc.dto.UserCouponDTO;

public class CouponServiceImpl implements CouponService {
	private CouponDAO couponDAO = new CouponDAOImpl();
	
	/**
	 * �ǽð� ���� ���
	 * @param: LiveCouponDTO(String livecouId, String livecouName, int livecouPrice, int livecouUseperiod)
	 * */
	@Override
	public void insertLiveCp(LiveCouponDTO liveCoupon) throws SQLException {
		// TODO Auto-generated method stub

	}

	/**
	 * �ǽð� ���� ����
	 * @param: LiveCouponDTO(String livecouId, String livecouName, int livecouPrice, int livecouUseperiod)
	 * */
	@Override
	public void updateLiveCp(LiveCouponDTO liveCoupon) throws SQLException {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ���� ���� ���
	 * @param: RgCouponDTO(String rgcouId, String rgcouName, int rgcouPrice, String rgcouPubdate, String rgcouEnddate)
	 * */
	@Override
	public void insertRgCp(RgCouponDTO rgCoupon) throws SQLException {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ���� ���� ����
	 * @param: RgCouponDTO(String rgcouId, String rgcouName, int rgcouPrice, String rgcouPubdate, String rgcouEnddate)
	 * */
	@Override
	public void updateRgCp(RgCouponDTO rgCoupon) throws SQLException {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

	}

	/**
	 * ����ں� ���� ��뿩�� ����
	 * @param: int usercouId, String state(���� ���̵�� ���� ��� ����)
	 * */
	@Override
	public void updateCpState(int usercouId, String state) throws SQLException {
		// TODO Auto-generated method stub

	}

	/**
	 * ��ü ����� ���� ��ȸ
	 * �����, ����� ����
	 * @param: String field(���� ������ �μ��� ������ if������ ������ ����)
	 * @return: UserCouponDTO
	 * */
	@Override
	public List<UserCouponDTO> selectAllUserCp(String field) throws SQLException {
		// TODO Auto-generated method stub
		return null;
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

}
