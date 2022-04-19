package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import mimemi.mvc.dao.OrderDAO;
import mimemi.mvc.dao.OrderDAOImpl;
import mimemi.mvc.dao.OrderLineDAO;
import mimemi.mvc.dao.OrderLineDAOImpl;
//import mimemi.mvc.dao.OrderLineDAOImpl;
import mimemi.mvc.dto.OrderDTO;
import mimemi.mvc.dto.OrderDeliDTO;
import mimemi.mvc.dto.OrderLineDTO;

public class OrderServiceImpl implements OrderService {
	private OrderDAO orderDao = new OrderDAOImpl();
	private OrderLineDAO orderLineDao = new OrderLineDAOImpl();

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
	 * �ֹ� ���
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
	 * �ֹ� �� ���
	 * @param OrderLineDTO(int orderId, String goodsId, int orderQty, int priceQty, String deliWeekday,
			String deliPeriod, String deliStart)
	 * @return int(����� ���ڵ� ��)
	 */
	@Override
	public void insert(OrderLineDTO orderLine) throws SQLException {
		// TODO Auto-generated method stub
	}

	/**
	 * �ֹ� �� ����(���)
	 * @param int orderLineId(���� ���� ���̵� �������� ��� �������� ��� ��� ó����)
	 * @return int(������ ���ڵ� ��)
	 */
	@Override
	public void delete(int orderLineId) throws SQLException {
		// TODO Auto-generated method stub
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
	 * ��� ������ ����
	 * @param: OrderDeliDTO(int orderDeliId, int orderLineCode, int orderStateId, String orderDeliDate)
	 * @return: int(��ϵ� ������ ��)
	 * */
	@Override
	public void insertDeli(OrderDeliDTO orderDeli) throws SQLException {
		// TODO Auto-generated method stub
	}

	/**
	 * ��� ���� ����
	 * @param: OrderDeliDTO(int orderDeliId, String orderDeliDate)
	 * @return: int(������ ������ ��)
	 * */
	@Override
	public void updateDeliDate(OrderDeliDTO orderDeli) throws SQLException {
		// TODO Auto-generated method stub
	}

	/**
	 * �ֹ� �� �ڵ�� ��� ������ ��ȸ
	 * @param: OrderDeliDTO(int orderDeliId, int orderStateId)
	 * @return: int(������ ������ ��)
	 * */
	@Override
	public List<OrderDeliDTO> selectByOrderLineId(int orderLineId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ���� ��� ������ ��ȸ
	 * @param: OrderDeliDTO(int orderDeliId, int orderStateId)
	 * @return: int(������ ������ ��)
	 * */
	@Override
	public OrderDeliDTO selectByOrderDeliId(int orderDeliId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
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

}
