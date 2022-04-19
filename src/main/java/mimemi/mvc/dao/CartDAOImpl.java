package mimemi.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import mimemi.mvc.dto.CartDTO;
import mimemi.mvc.util.DbUtil;

public class CartDAOImpl implements CartDAO {
	private Properties proFile = new Properties();
	
	/**
	 * dbQuery.properties �ε��� Properties ��ü�� ����
	 * */
	public CartDAOImpl() {
		try {
			proFile.load(getClass().getClassLoader().getResourceAsStream("dbQuery.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ٱ��� ���
	 * @param CartDTO(String userId, String goodsId, int cartQty, String cartWeekday, String cartPeriod,
			String cartStart)
	 * @return int(����� ���ڵ� ��)
	 */
	@Override
	public int insert(CartDTO cart) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = proFile.getProperty("cart.insert");
		// insert into cart values(CART_ID_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?);
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, cart.getUserId());
			ps.setString(2, cart.getUserId());
			ps.setString(3, cart.getUserId());
			ps.setString(4, cart.getUserId());
			ps.setString(5, cart.getUserId());
			ps.setString(6, cart.getUserId());
			
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	/**
	 * ��ٱ��� ���� ����
	 * @param: int cartId, int cartQty
	 * @return: int(������ ���ڵ� ��)
	 * */
	@Override
	public int updateCartQty(int cartId, int cartQty) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = proFile.getProperty("cart.updateCartQty");
		// update cart set cart_qty = ? where cart_id = ?
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, cartQty);
			ps.setInt(2, cartId);
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}

	/**
	 * ��ٱ��� ���� ����
	 * @param: int cartId, String cartWeekday
	 * @return: int(������ ���ڵ� ��)
	 * */
	@Override
	public int updateCartWeekday(int cartId, String cartWeekday) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = proFile.getProperty("cart.updateCartWeekday");
		// update cart set cart_weekday=? where cart_id=?
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, cartWeekday);
			ps.setInt(2, cartId);
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}

	/**
	 * ��ٱ��� �Ⱓ ����
	 * @param: int cartId, String cartPeriod
	 * @return: int(������ ���ڵ� ��)
	 * */
	@Override
	public int updateCartPeriod(int cartId, String cartPeriod) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = proFile.getProperty("cart.updateCartPeriod");
		// update cart set cart_period = ? where cart_id = ?
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, cartPeriod);
			ps.setInt(2, cartId);
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}

	/**
	 * ��ٱ��� ù ����� ����
	 * @param: int cartId, String cartStart
	 * @return: int(������ ���ڵ� ��)
	 * */
	@Override
	public int updateCartStart(int cartId, String cartStart) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = proFile.getProperty("cart.updateCartStart");
		// update cart set cart_period = ? where cart_id = ?
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, cartStart);
			ps.setInt(2, cartId);
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}

	/**
	 * ��ٱ��� �κ� ����
	 * @param int[] cartId
	 * @return int(������ ���ڵ� ��)
	 */
	@Override
	public int deleteSelectedCart(List<Integer> cartId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = proFile.getProperty("cart.deleteSelectedCart");
		// delete cart where cart_id=?
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			for(int i : cartId) {
				ps.setInt(1, i);
				result += ps.executeUpdate();
			}
		} finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}

	/**
	 * ��ٱ��� ��ü ����
	 * @param String userId
	 * @return int(������ ���ڵ� ��)
	 */
	@Override
	public int deleteAllCart(String userId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = proFile.getProperty("cart.deleteAllCart");
		// delete cart where user_id=?
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}

	/**
	 * ��ٱ��� ��ȸ
	 * @param userId(���� ���̵� �� ��� ��ٱ��� ��������)
	 * @return List<CartDTO>
	 */
	@Override
	public List<CartDTO> selectCartByUserId(String userId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = proFile.getProperty("cart.selectCartByUserId");
		// select * from cart where user_id = ? order by cart_id desc
		
		List<CartDTO> list = new ArrayList<CartDTO>();
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				CartDTO cart = new CartDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
				list.add(cart);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	/**
	 * ��ٱ��� ��ȸ
	 * @param cartId
	 * @return CartDTO
	 */
	@Override
	public CartDTO selectCartByCartId(int cartId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = proFile.getProperty("cart.selectCartByCartId");
		// select * from cart where cart_id = ?
		
		CartDTO cart = null;
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, cartId);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				cart = new CartDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return cart;
	}

}
