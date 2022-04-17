package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.OrderDTO;
import mimemi.mvc.dto.OrderDeliDTO;
import mimemi.mvc.dto.OrderLineDTO;

public interface OrderService {
	/**
	 * �ֹ� ���
	 * @param OrderDTO(String userId, int addrId, String payMethod, int payPoint, String orderMemo,
	 * 			String takeMethod, String doorPwd, String usercouId)
	 */
	void insertOrder(OrderDTO order, String mode) throws Exception;
	
	/**
	 * �ֹ� ���
	 * : �ֹ� ��ȣ�� �̿��� �ش� �ֹ� �ǿ� ������ ��� ��� �������� ��� ó����
	 * @param int orderId
	 */
	void deleteOrder(int orderId) throws SQLException;
	
	/**
	 * �ֹ� ��ü ��ȸ
	 * @param String field(���� ����)
	 * @return List<OrderDTO>
	 * */
	List<OrderDTO> selectAll(int pageNum, String field) throws SQLException;
	
	/**
	 * ���� ���̵�� �ֹ� ��ȸ
	 * @param String userId(���� ����)
	 * @return OrderDTO
	 * */
	List<OrderDTO> selectByUserId(String userId) throws SQLException;
	
	/**
	 * �ֹ� ���̵�� Ư�� �ֹ� ��ȸ
	 * @param int orderId(���� ����)
	 * @return OrderDTO
	 * */
	OrderDTO selectByOrderId(int orderId) throws SQLException;
	
	/**
	 * �ֹ� �� ���
	 * @param OrderLineDTO(int orderId, String goodsId, int orderQty, int priceQty, String deliWeekday,
			String deliPeriod, String deliStart)
	 * @return int(����� ���ڵ� ��)
	 */
	void insert(OrderLineDTO orderLine) throws SQLException;

	/**
	 * �ֹ� �� ����(���)
	 * @param int orderLineId(���� ���� ���̵� �������� ��� �������� ��� ��� ó����)
	 * @return int(������ ���ڵ� ��)
	 */
	void delete(int orderLineId) throws SQLException;
	
	/**
	 * ���� ���̵�� �ֹ� �� ��ȸ
	 * @param int orderId(���� ���̵� �ش��ϴ� �ֹ� �� ��������)
	 * @return List<OrderLineDTO>
	 */
	List<OrderLineDTO> selectLineByOrderId(int orderId) throws SQLException;
	
	/**
	 * ��� ������ ����
	 * @param: OrderDeliDTO(int orderDeliId, int orderLineCode, int orderStateId, String orderDeliDate)
	 * @return: int(��ϵ� ������ ��)
	 * */
	void insertDeli(OrderDeliDTO orderDeli) throws SQLException;
	
	/**
	 * ��� ���� ����
	 * @param: OrderDeliDTO(int orderDeliId, String orderDeliDate)
	 * @return: int(������ ������ ��)
	 * */
	void updateDeliDate(OrderDeliDTO orderDeli) throws SQLException;
	
	/**
	 * �ֹ� �� �ڵ�� ��� ������ ��ȸ
	 * @param: OrderDeliDTO(int orderDeliId, int orderStateId)
	 * @return: int(������ ������ ��)
	 * */
	List<OrderDeliDTO> selectByOrderLineId(int orderLineId) throws SQLException;
	
	/**
	 * ���� ��� ������ ��ȸ
	 * @param: OrderDeliDTO(int orderDeliId, int orderStateId)
	 * @return: int(������ ������ ��)
	 * */
	OrderDeliDTO selectByOrderDeliId(int orderDeliId) throws SQLException;
}
