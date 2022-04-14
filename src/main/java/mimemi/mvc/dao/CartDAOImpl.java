package mimemi.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import mimemi.mvc.dto.CartDTO;
import mimemi.mvc.util.DbUtil;

public class CartDAOImpl implements CartDAO {
	private Properties proFile = new Properties();
	
	/**
	 * dbQuery.properties 로딩해 Properties 객체에 저장
	 * */
	public CartDAOImpl() {
		try {
			proFile.load(getClass().getClassLoader().getResourceAsStream("dbQuery.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 장바구니 등록
	 * @param CartDTO(String userId, String goodsId, int cartQty, String cartWeekday, String cartPeriod,
			String cartStart)
	 * @return int(등록한 레코드 수)
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
	 * 장바구니 수량 변경
	 * @param: int cartId, int cartQty
	 * @return: int(수정한 레코드 수)
	 * */
	@Override
	public int updateCartQty(int cartId, int cartQty) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = proFile.getProperty("");
		return 0;
	}

	/**
	 * 장바구니 수량 변경
	 * @param: int cartId, String cartWeekday
	 * @return: int(수정한 레코드 수)
	 * */
	@Override
	public int updateCartWeekday(int cartId, String cartWeekday) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 장바구니 수량 변경
	 * @param: int cartId, String cartPeriod
	 * @return: int(수정한 레코드 수)
	 * */
	@Override
	public int updateCartPeriod(int cartId, String cartPeriod) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 장바구니 부분 삭제
	 * @param int[] cartId
	 * @return int(삭제한 레코드 수)
	 */
	@Override
	public int deleteSelectedCart(int[] cartId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 장바구니 전체 삭제
	 * @param String userId
	 * @return int(삭제한 레코드 수)
	 */
	@Override
	public int deleteAllCart(String userId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 장바구니 조회
	 * @param userId(유저 아이디가 들어간 모든 장바구니 가져오기)
	 * @return List<CartDTO>
	 */
	@Override
	public List<CartDTO> selectCartByUserId(String userId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
