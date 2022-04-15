package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mimemi.mvc.dao.CartDAO;
import mimemi.mvc.dao.CartDAOImpl;
import mimemi.mvc.dto.CartDTO;

public class CartServiceImpl implements CartService {
	private CartDAO cartDao = new CartDAOImpl();
	
	/**
	 * ��ٱ��� ���
	 * @param CartDTO(String userId, String goodsId, int cartQty, String cartWeekday, String cartPeriod,
			String cartStart)
	 */
	@Override
	public void insert(CartDTO cart) throws SQLException {
		// TODO Auto-generated method stub

	}

	/**
	 * ��ٱ��� ���� ����
	 * @param: int cartId, int cartQty
	 * */
	@Override
	public void updateCartQty(int cartId, int cartQty) throws SQLException {
		// TODO Auto-generated method stub

	}

	/**
	 * ��ٱ��� ���� ����
	 * @param: int cartId, String cartWeekday
	 * */
	@Override
	public void updateCartWeekday(int cartId, String cartWeekday) throws SQLException {
		// TODO Auto-generated method stub

	}

	/**
	 * ��ٱ��� ���� ����
	 * @param: int cartId, String cartPeriod
	 * */
	@Override
	public void updateCartPeriod(int cartId, String cartPeriod) throws SQLException {
		// TODO Auto-generated method stub

	}

	/**
	 * ��ٱ��� �κ� ����
	 * @param int[] cartId
	 */
	@Override
	public void deleteSelectedCart(int[] cartId) throws SQLException {
		// TODO Auto-generated method stub

	}

	/**
	 * ��ٱ��� ��ü ����
	 * @param String userId
	 */
	@Override
	public void deleteAllCart(String userId) throws SQLException {
		// TODO Auto-generated method stub

	}

	/**
	 * ��ٱ��� ��ȸ
	 * @param userId(���� ���̵� �� ��� ��ٱ��� ��������)
	 * @return List<CartDTO>
	 */
	@Override
	public List<CartDTO> selectCartByUserId(String userId) throws SQLException {
		List<CartDTO> list = cartDao.selectCartByUserId(userId);
		
		return list;
	}

}
