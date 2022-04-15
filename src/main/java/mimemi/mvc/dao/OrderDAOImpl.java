package mimemi.mvc.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.AddrDTO;
import mimemi.mvc.dto.OrderDTO;
import mimemi.mvc.dto.OrderLineDTO;

public class OrderDAOImpl implements OrderDAO {
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
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 2. �� �ּҷ� ������ ��� addr insert
	 * @param AddrDTO(String userId, String addrName, int zipcode, String addrAddr, String addrDetailAddr,
				String receiverName, String receiverPhone)
	 * @return int(��ϵ� ������ ��)
	 * */
	@Override
	public int insertAddr(Connection con, AddrDTO addr) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 3. �������� ����� ��� ȸ�� ���̺��� ������ ����(update)
	 * @param String userId, int usedPoint
	 * @return int(������ ������ ��)
	 * */
	@Override
	public int decreamentUserPoint(Connection con, String userId, int usedPoint) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 4. ȸ�� ���̺� ������ 1% ����(update)
	 * @param String userId, int addedPoint
	 * @return int(������ ������ ��)
	 * */
	@Override
	public int increamentUserPoint(Connection con, String userId, int addedPoint) throws SQLException {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
	public List<OrderDTO> selectAll(String field) throws SQLException {
		// TODO Auto-generated method stub
		return null;
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
