package mimemi.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	 * 
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
	 */
	@Override
	public int insertOrder(OrderDTO order) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = proFile.getProperty("order.insertOrder");
		// insert into orders values(ORDERS_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
		int result = 0;
		return result;
	}

	/**
	 * 2. �� �ּҷ� ������ ��� addr insert
	 * @param AddrDTO(String userId, String addrName, int zipcode, String addrAddr, String addrDetailAddr,
				String receiverName, String receiverPhone)
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
		
		String sql = proFile.getProperty("order.insertOrder");
		// insert into orders values(ORDERS_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
		int result = 0;
		return 0;
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
		// insert into orders values(ORDERS_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
		int result = 0;
		return 0;
	}

	/**
	 * 5. �ֹ� �� insert
	 * @param OrderLineDTO(int orderId, String goodsId, int orderQty, int priceQty, String deliWeekday,
	 *			String deliPeriod, String deliStart)
	 * @return int(��ϵ� ������ ��)
	 * */
	@Override
	public int insertOrderLine(Connection con, OrderLineDTO orderLine) throws SQLException {
		PreparedStatement ps = null;
		
		String sql = proFile.getProperty("order.insertOrder");
		// insert into orders values(ORDERS_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
		int result = 0;
		return 0;
	}

	/**
	 * 6. ���� ����� ��� ���� ��� ���� ����(update)
	 * @param OrderDTO(String userId, int addrId, String payMethod, int payPoint, String orderMemo,
	 * 			String takeMethod, String doorPwd, String usercouId)
	 * @return int(������ ������ ��)
	 * */
	@Override
	public int updateUserCoupon(Connection con, int userCouId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 7. ��ٱ��Ͽ� ����־��� ��� �ش� ��ٱ��� ����
	 * @param int userId, String goodsId
	 * @return int(������ ���ڵ� ��)
	 * */
	@Override
	public int deleteSelectedCart(Connection con, int userId, String goodsId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * �ֹ� ���
	 * : �ֹ� ��ȣ�� �̿��� �ش� �ֹ� �ǿ� ������ ��� ��� �������� ��� ó����
	 * @param int orderId
	 * @return int(������ ���ڵ� ��)
	 */
	@Override
	public int deleteOrder(int orderId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
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
						rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9),rs.getString(10), rs.getInt(11)));
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
	 * ���̵�� Ư�� �ֹ� ��ȸ
	 * @param int orderId(���� ����)
	 * @return OrderDTO
	 * */
	@Override
	public OrderDTO selectById(int orderId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
