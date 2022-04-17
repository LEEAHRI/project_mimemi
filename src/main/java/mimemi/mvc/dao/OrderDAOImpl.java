package mimemi.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import mimemi.mvc.dto.AddrDTO;
import mimemi.mvc.dto.OrderDTO;
import mimemi.mvc.dto.OrderLineDTO;
import mimemi.mvc.paging.OrderListPageCnt;
import mimemi.mvc.util.DbUtil;

public class OrderDAOImpl implements OrderDAO {
	private Properties proFile = new Properties();
	
	/**
	 * dbQuery.properties �ε��� Properties ��ü�� ����
	 * */
	public OrderDAOImpl() {
		try {
			proFile.load(getClass().getClassLoader().getResourceAsStream("dbQuery.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �ֹ� ���
	 * 0. OrderDTO ���� OrderLineDTO�� ���� ��ǰ�� �� ���� �ݾ� ���ϱ�
	 * 1. �ֹ� ���̺� insert
	 * 2. �� �ּҷ� ������ ��� addr insert
	 * 3. �������� ����� ��� ȸ�� ���̺��� ������ ����(update)
	 * 4. ȸ�� ���̺� ������ 1% ����(update)
	 * 5. �ֹ� �� insert
	 * 6. ���� ����� ��� ���� ��� ���� ����(update)
	 * 7. ��ٱ��Ͽ� ����־��� ��� ��ٱ��� �κ� ����
	 * 
	 * ���� ��� �� Ʈ��������� ó��
	 * 
	 * @param OrderDTO(String userId, int addrId, String payMethod, int payPoint, String orderMemo,
	 * 			String takeMethod, String doorPwd, String usercouId)
	 * @return int(��ϵ� ������ ��)
	 * @throws ParseException 
	 */
	@Override
	public int insertOrder(OrderDTO order, String mode) throws SQLException, ParseException {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = proFile.getProperty("order.insertOrder");
		// insert into orders values(ORDERS_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?)
		// userId, addId, payMethod, payPoint, totalPrice, orderMemo, takeMethod, enderPwd,
		// usercouId
		int result = 0;
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false); // �ڵ� Ŀ�� ����
			
			// �ֹ� ���
			ps = con.prepareStatement(sql);
			ps.setString(1, order.getUserId());
			ps.setInt(2, order.getAddrId());
			ps.setString(3, order.getPayMethod());
			ps.setInt(3, order.getPayPoint());
			
			int totalPrice = calTotalPrice(order.getOrderLineList());
			ps.setInt(5, totalPrice);
			ps.setString(6, order.getOrderMemo());
			ps.setString(7, order.getTakeMethod());
			ps.setString(8, order.getEnterPwd());
			ps.setInt(9, order.getUsercouId());
			
			result = ps.executeUpdate();
			
			// �ּ� ����: ���߿� �ּ� üũ �޼ҵ�� ��~~
			if(this.insertAddr(con, order.getAddr()) == 0) {
				throw new SQLException("�ֹ��� ���������� �Ϸ���� �ʾҽ��ϴ�.\\n��� �� �ٽ� �õ����ּ���.");
			}
			
			// ������ ����
			if(order.getPayPoint() > 0) {
				if(this.decreamentUserPoint(con, order.getUserId(), order.getPayPoint()) == 0) {
					throw new SQLException("�ֹ��� ���������� �Ϸ���� �ʾҽ��ϴ�.\\n��� �� �ٽ� �õ����ּ���.");
				}
			}
			
			// ������ ����
			int pointPlus = totalPrice / 100;
			if(this.increamentUserPoint(con, order.getUserId(), pointPlus) == 0) {
				throw new SQLException("�ֹ��� ���������� �Ϸ���� �ʾҽ��ϴ�.\\n��� �� �ٽ� �õ����ּ���.");
			}
			
			// �ֹ� �� �μ�Ʈ
			int[] re = this.insertOrderLine(con, order.getOrderLineList());
			for(int r : re) {
				if(r == 0) {
					throw new SQLException("�ֹ��� ���������� �Ϸ���� �ʾҽ��ϴ�.\\n��� �� �ٽ� �õ����ּ���.");
				}
			}
			
			// ���� ��� ���� ����
			if(order.getUsercouId() != 0) {
				if(this.updateUserCoupon(con, order.getUsercouId()) == 0) {
					throw new SQLException("�ֹ��� ���������� �Ϸ���� �ʾҽ��ϴ�.\\n��� �� �ٽ� �õ����ּ���.");
				}
			}
			
			// �ش� ��ٱ��� ����
			if(mode.equals("C") || mode.equals("S")) {
				for(OrderLineDTO ol : order.getOrderLineList()) {
					if(this.deleteSelectedCart(con, order.getUserId(), ol.getGoodsId()) == 0) {
						throw new SQLException("�ֹ��� ���������� �Ϸ���� �ʾҽ��ϴ�.\\n��� �� �ٽ� �õ����ּ���.");
					}
				}
			}
			
			con.commit();
		} finally {
			con.rollback();
			DbUtil.dbClose(ps, con);
		}
		return result;
	}
	
	/**
	 * �� �ݾ� ���
	 * */
	private int calTotalPrice(List<OrderLineDTO> list) {
		int totalPrice = 0;
		for(OrderLineDTO ol : list) {
			totalPrice += ol.getPriceQty();
		}
		return totalPrice;
	}

	/**
	 * 2. �� �ּҷ� ������ ��� addr insert
	 * @param Connection con, AddrDTO addr
	 * @return int(��ϵ� ������ ��)
	 * */
	@Override
	public int insertAddr(Connection con, AddrDTO addr) throws SQLException {
		PreparedStatement ps = null;
		
		String sql = proFile.getProperty("order.insertOrder");
		// insert into orders values(ORDERS_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
		int result = 0;
		return 0;
	}

	/**
	 * 3. �������� ����� ��� ȸ�� ���̺��� ������ ����(update)
	 * @param String userId, int usedPoint
	 * @return int(������ ������ ��)
	 * */
	@Override
	public int decreamentUserPoint(Connection con, String userId, int usedPoint) throws SQLException {
		PreparedStatement ps = null;
		
		String sql = proFile.getProperty("order.decreamentUserPoint");
		// update users set user_point = user_point - ? where USER_ID = ?
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, usedPoint);
			ps.setString(2, userId);
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, null);
		}
		return result;
	}

	/**
	 * 4. ȸ�� ���̺� ������ 1% ����(update)
	 * @param String userId, int addedPoint
	 * @return int(������ ������ ��)
	 * */
	@Override
	public int increamentUserPoint(Connection con, String userId, int addedPoint) throws SQLException {
		PreparedStatement ps = null;
		
		String sql = proFile.getProperty("order.insertOrder");
		// update users set user_point = user_point + ? where USER_ID = ?
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, addedPoint);
			ps.setString(2, userId);
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, null);
		}
		return result;
	}

	/**
	 * 5. �ֹ� �� insert
	 * @param Connection con, OrderLineDTO orderLine
	 * @return int(��ϵ� ������ ��)
	 * @throws ParseException 
	 * */
	@Override
	public int[] insertOrderLine(Connection con, List<OrderLineDTO> list) throws SQLException, ParseException {
		PreparedStatement ps = null;
		
		String sql = proFile.getProperty("order.insertOrder");
		// insert into order values(ORDER_LINE_ID_SEQ.NEXTVAL, orders_seq.currval, ?, ?, ?, ?, ?, ?)
		int[] result = null;
		try {
			ps = con.prepareStatement(sql);
			for(OrderLineDTO ol : list) {
				ps.setString(1, ol.getGoodsId());
				ps.setInt(2, ol.getOrderQty());
				ps.setInt(3, ol.getPriceQty());
				ps.setString(4, ol.getDeliWeekday());
				ps.setString(5, ol.getDeliPeriod());
				ps.setString(6, ol.getDeliStart());
				
				ps.addBatch();
				ps.clearParameters();
				
				int weekday = 0;
				if(ol.getDeliWeekday().equals("T")) {
					weekday = 3;
				} else {
					weekday = 5;
				}
				int totalDeli = Integer.parseInt(ol.getDeliPeriod().substring(0, 1)) * weekday;

				Calendar cal = Calendar.getInstance();
		        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		        cal.setTime(df.parse(ol.getDeliStart()));
		        int wd = 0;
				while(totalDeli > 0){
					wd = cal.get(Calendar.DAY_OF_WEEK);
					if(wd == 2 || wd == 4 || wd == 6) {
						if(this.insertOrderDeli(con, df.format(cal.getTime())) == 0) {
							throw new SQLException("�ֹ��� ���������� �Ϸ���� �ʾҽ��ϴ�.\\n��� �� �ٽ� �õ����ּ���.");
						}
						if(ol.getDeliWeekday().equals("F") && (wd == 3 || wd == 5)) {
							if(this.insertOrderDeli(con, df.format(cal.getTime())) == 0) {
								throw new SQLException("�ֹ��� ���������� �Ϸ���� �ʾҽ��ϴ�.\\n��� �� �ٽ� �õ����ּ���.");
							}
						}
					}
					cal.add(Calendar.DATE, 1);
					totalDeli--;
				}
			}
			
			result = ps.executeBatch();
		} finally {
			DbUtil.dbClose(ps, null);
		}
		return result;
	}
	
	/**
	 * �ֹ� �� ��� ���
	 * */
	private int insertOrderDeli(Connection con, String orderDeliDate) throws SQLException {
		PreparedStatement ps = null;
		
		String sql = proFile.getProperty("order.insertOrder");
		// insert into order values(ORDER_LINE_ID_SEQ.NEXTVAL, orders_seq.currval, ?, ?, ?, ?, ?, ?)
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, orderDeliDate);
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, null);
		}
		return result;
	}

	/**
	 * 6. ���� ����� ��� ���� ��� ���� ����(update)
	 * @param Connection con, int userCouId
	 * @return int(������ ������ ��)
	 * */
	@Override
	public int updateUserCoupon(Connection con, int userCouId) throws SQLException {
		PreparedStatement ps = null;
		
		String sql = proFile.getProperty("order.updateUserCoupon");
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, userCouId);
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, null);
		}
		return result;
	}

	/**
	 * 7. ��ٱ��Ͽ� ����־��� ��� �ش� ��ٱ��� ����
	 * @param int userId, String goodsId
	 * @return int(������ ���ڵ� ��)
	 * */
	@Override
	public int deleteSelectedCart(Connection con, String userId, String goodsId) throws SQLException {
		PreparedStatement ps = null;
		
		String sql = proFile.getProperty("order.deleteSelectedCart");
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, goodsId);
			ps.setString(2, userId);
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, null);
		}
		return result;
	}

	/**
	 * �ֹ� ���
	 * : �ֹ� ��ȣ�� �̿��� �ش� �ֹ� �ǿ� ������ ��� ��� �������� ��� ó����
	 * @param int orderId
	 * @return int(������ ���ڵ� ��)
	 */
	@Override
	public int deleteOrder(int orderId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = proFile.getProperty("order.deleteOrder");
		int result = 0;
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, orderId);
			result = ps.executeUpdate();
			
			int[] re = deleteOrderLine(con, orderId);
			for(int r : re) {
				if(r == 0) {
					throw new SQLException();
				}
			}
			
			re = deleteOrderDeil(con, orderId);
			for(int r : re) {
				if(r == 0) {
					throw new SQLException();
				}
			}
			con.commit();
		} finally {
			con.rollback();
			DbUtil.dbClose(ps, con);
		}
		return result;
	}
	
	/**
	 * �ֹ��� ������� �� �ֹ� �󼼱��� ���� ���
	 * */
	public int[] deleteOrderLine(Connection con, int orderId) throws SQLException {
		PreparedStatement ps = null;
		
		String sql = proFile.getProperty("order.deleteOrderLine");
		int[] result = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, orderId);
			
			result = ps.executeBatch();
		} finally {
			DbUtil.dbClose(ps, null);
		}
		
		return result;
	}
	
	/**
	 * ��� �������� ���
	 * */
	public int[] deleteOrderDeil(Connection con, int orderId) throws SQLException {
		PreparedStatement ps = null;
		
		String sql = proFile.getProperty("order.deleteOrderDeil");
		int[] result = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, orderId);
			
			result = ps.executeBatch();
		} finally {
			DbUtil.dbClose(ps, null);
		}
		
		return result;
	}

	/**
	 * �ֹ� ��ü ��ȸ
	 * @param String field(���� ����)
	 * @return List<OrderDTO>
	 * */
	@Override
	public List<OrderDTO> selectAll(int pageNum, String field) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = proFile.getProperty("order.selectAll");
		List<OrderDTO> orderList = new ArrayList<OrderDTO>();
		
		String orderBy = "order_id";
		if(field != null) {
			if (field.equals("user_id")) {
				sql = proFile.getProperty("order.selectAllUserId");
			} else if (field.equals("highprice")){
				sql = proFile.getProperty("order.selectAllHighPrice");
			} else if (field.equals("rowprice")){
				sql = proFile.getProperty("order.selectAllRowPrice");
			}
		}
		
		try {
			// ��ü ���ڵ� ���� ��ȯ�ϴ� �޼ҵ�� db�� ����� �� ���ڵ� ���� ����
			int totalCount = this.getTotalCount();
			System.out.println(totalCount);
			// ���� ��ü ���ڵ� ���� ��ü ������ ���� ����
			int totalPage = totalCount % OrderListPageCnt.getPagesize() == 0 ? totalCount / OrderListPageCnt.getPagesize() : (totalCount / OrderListPageCnt.getPagesize()) + 1;
			
			OrderListPageCnt OrderListPageCnt = new OrderListPageCnt();
			OrderListPageCnt.setPageCnt(totalPage); // ���� ��ü ������ ���� ������
			OrderListPageCnt.setPageNo(pageNum); // ������ Ŭ���� ������ ��ȣ�� ����
			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, (pageNum - 1) * OrderListPageCnt.pagesize + 1); // ������(�ش� �������� ù ��) ��ȣ
			ps.setInt(2, pageNum * OrderListPageCnt.pagesize); // ����(�ش� �������� ������ ��) ��ȣ

			rs = ps.executeQuery();
			while(rs.next()) {
				orderList.add(new OrderDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9),rs.getString(10), rs.getInt(11),
						rs.getString(12)));
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return orderList;
	}
	
	/**
	 * ��ü ���ڵ� �� ��ȯ
	 * @return int(��ü ���ڵ� ����)
	 * */
	private int getTotalCount() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = proFile.getProperty("order.getTotalCount");
		int totalCount = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				totalCount = rs.getInt(1);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		
		return totalCount;
	}

	/**
	 * ���� ���̵�� �ֹ� ��ȸ
	 * @param int orderId(���� ����)
	 * @return OrderDTO
	 * */
	@Override
	public List<OrderDTO> selectByUserId(String userId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = proFile.getProperty("order.selectByUserId");
		List<OrderDTO> list = new ArrayList<OrderDTO>();
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			rs = ps.executeQuery();
			while(rs.next()) {
				OrderDTO order = new OrderDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9),rs.getString(10), rs.getInt(11),
						rs.getString(12));
				list.add(order);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		
		return list;
	}

	/**
	 * �ֹ� ���̵�� Ư�� �ֹ� ��ȸ
	 * @param int orderId(���� ����)
	 * @return OrderDTO
	 * */
	@Override
	public OrderDTO selectByOrderId(int orderId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = proFile.getProperty("order.selectByOrderId");
		OrderDTO order = null;
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, orderId);
			rs = ps.executeQuery();
			while(rs.next()) {
				order = new OrderDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9),rs.getString(10), rs.getInt(11),
						rs.getString(12));
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		
		return order;
	}
}
