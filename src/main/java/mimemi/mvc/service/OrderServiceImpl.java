package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dao.OrderDAO;
import mimemi.mvc.dao.OrderDAOImpl;
import mimemi.mvc.dao.OrderDeliDAO;
import mimemi.mvc.dao.OrderDeliDAOImpl;
import mimemi.mvc.dao.OrderLineDAO;
import mimemi.mvc.dao.OrderLineDAOImpl;
//import mimemi.mvc.dao.OrderLineDAOImpl;
import mimemi.mvc.dto.OrderDTO;
import mimemi.mvc.dto.OrderDeliDTO;
import mimemi.mvc.dto.OrderLineDTO;
import mimemi.mvc.dto.OrderStateDTO;

public class OrderServiceImpl implements OrderService {
	private OrderDAO orderDao = new OrderDAOImpl();
	private OrderLineDAO orderLineDao = new OrderLineDAOImpl();
	private OrderDeliDAO orderDeliDao = new OrderDeliDAOImpl();

	/**
	 * �ֹ� ���
	 * @param OrderDTO(String userId, int addrId, String payMethod, int payPoint, String orderMemo,
	 * 			String takeMethod, String doorPwd, String usercouId)
	 */
	@Override
	public void insertOrder(OrderDTO order, String mode) throws Exception {
		int result = orderDao.insertOrder(order, mode);
		if(result == 0) {
			throw new SQLException();
		}
	}

	/**
	 * �ֹ� �� ���
	 * : �ֹ� ��ȣ�� �̿��� �ش� �ֹ� �󼼸� �����
	 * @param int orderLineId
	 */
	@Override
	public void deleteOrderLine(int orderLineId) throws SQLException {
		int result = orderDao.deleteOrderLine(orderLineId);
		if(result == 0) {
			throw new SQLException();
		}
	}

	/**
	 * �ֹ� �� ���
	 * : �ֹ� ��ȣ�� �̿��� �ش� �ֹ� �ǿ� ������ ��� ��� �������� ��� ó����
	 * @param int orderId
	 */
	@Override
	public void deleteOrder(int orderId) throws SQLException {
		int result = orderDao.deleteOrder(orderId);
		if(result == 0) {
			throw new SQLException();
		}
	}

	/**
	 * �ֹ� ��ü ��ȸ
	 * @param String field(���� ����)
	 * @return List<OrderDTO>
	 * */
	@Override
	public List<OrderDTO> selectAll(int pageNum, String field) throws SQLException {
		List<OrderDTO> orderList = orderDao.selectAll(pageNum, field);
			
		return orderList;
	}
	
	/**
	 * ���� ���̵�� �ֹ� ��ȸ
	 * @param int orderId(���� ����)
	 * @return OrderDTO
	 * */
	@Override
	public List<OrderDTO> selectByUserId(String userId) throws SQLException {
		List<OrderDTO> orderList = orderDao.selectByUserId(userId);
		
		return orderList;
	}
	
	/**
	 * ���� ���̵�� �ֹ� ��ȸ
	 * @param int orderId(���� ����)
	 * @return OrderDTO
	 * */
	@Override
	public List<OrderDTO> selectCancelByUserId(String userId) throws SQLException {
		List<OrderDTO> orderList = orderDao.selectCancelByUserId(userId);
		
		return orderList;
	}

	/**
	 * �ֹ� ���̵�� Ư�� �ֹ� ��ȸ
	 * @param int orderId(���� ����)
	 * @return OrderDTO
	 * */
	@Override
	public OrderDTO selectByOrderId(int orderId) throws SQLException {
		OrderDTO order = orderDao.selectByOrderId(orderId);
		
		return order;
	}

	/**
	 * ���� ���̵�� �ֹ� �� ��ȸ
	 * @param int orderId(���� ���̵� �ش��ϴ� �ֹ� �� ��������)
	 * @return List<OrderLineDTO>
	 */
	@Override
	public List<OrderLineDTO> selectLineByOrderId(int orderId) throws SQLException {
		List<OrderLineDTO> orderList = orderLineDao.selectLineByOrderId(orderId);
		
		return orderList;
	}

	/**
	 * �ֹ� �� �ڵ�� ��� ������ ��ȸ
	 * @param: OrderDeliDTO(int orderLineId)
	 * @return: List<OrderDeliDTO>
	 * */
	public List<OrderDeliDTO> selectByOrderLineId(int orderLineId) throws SQLException {
		List<OrderDeliDTO> list = orderDeliDao.selectByOrderLineId(orderLineId);
		
		return list;
	}

	/**
	 * ���� �ֹ� �Ĵ� ��������
	 * @param String goodsId, String userId, String date
	 * @return OrderDeliDTO
	 * */
	@Override
	public List<OrderDeliDTO> selectMlyDeli(String goodsId, String userId, String date) throws SQLException {
		List<OrderDeliDTO> list = orderDao.selectMlyDeli(goodsId, userId, date);
		
		return list;
	}
	
	/**
	 * ��� ���� ����
	 * @param: OrderDeliDTO(int orderDeliId, String orderDeliDate)
	 * @return: int(������ ������ ��)
	 * */
	@Override
	public void updateDeliDate(int orderDeliId, String orderDeliDate) throws SQLException {
		int result = orderDeliDao.updateDeliDate(orderDeliId, orderDeliDate);
		
		if(result == 0) {
			throw new SQLException();
		}
	}

	/**
	 * ��� �ڵ� ����
	 * @param: OrderDeliDTO(int orderDeliId, String orderStateId)
	 * @return: int(������ ������ ��)
	 * */
	@Override
	public void updateStateId(int orderDeliId, String orderStateId) throws SQLException {
		int result = orderDeliDao.updateStateId(orderDeliId, orderStateId);
		
		if(result == 0) {
			throw new SQLException();
		}
	}

	/**
	 * �ֹ� ���� �ڵ� ��������
	 * @return: List<OrderStateDTO>
	 * */
	@Override
	public List<OrderStateDTO> selectOrderState() throws SQLException{
		List<OrderStateDTO> list = orderDeliDao.selectOrderState();
		 
		return list;
	};
}
