package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.OrderDTO;
import mimemi.mvc.dto.OrderDeliDTO;
import mimemi.mvc.dto.OrderLineDTO;
import mimemi.mvc.dto.OrderStateDTO;

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
	 * ���� ���̵�� �ֹ� �� ��ȸ
	 * @param int orderId(���� ���̵� �ش��ϴ� �ֹ� �� ��������)
	 * @return List<OrderLineDTO>
	 */
	List<OrderLineDTO> selectLineByOrderId(int orderId) throws SQLException;
	
	/**
	 * �ֹ� �� �ڵ�� ��� ������ ��ȸ
	 * @param: OrderDeliDTO(int orderLineId)
	 * @return: List<OrderDeliDTO>
	 * */
	List<OrderDeliDTO> selectByOrderLineId(int orderLineId) throws SQLException;

	/**
	 * ���� �ֹ� �Ĵ� ��������
	 * @param String goodsId, String userId, String date
	 * @return OrderDeliDTO
	 * */
	List<OrderDeliDTO> selectMlyDeli(String goodsId, String userId, String date) throws SQLException;

	/**
	 * ���� ���̵�� �ֹ� ��ȸ
	 * @param int orderId(���� ����)
	 * @return OrderDTO
	 * */
	List<OrderDTO> selectCancelByUserId(String userId) throws SQLException;

	/**
	 * �ֹ� �� ���
	 * : �ֹ� ��ȣ�� �̿��� �ش� �ֹ� �󼼸� �����
	 * @param int orderLineId
	 */
	void deleteOrderLine(int orderLineId) throws SQLException;
	
	/**
	 * ��� ���� ����
	 * @param: OrderDeliDTO(int orderDeliId, String orderDeliDate)
	 * @return: int(������ ������ ��)
	 * */
	void updateDeliDate(int orderDeliId, String orderDeliDate) throws SQLException;
	
	/**
	 * ��� �ڵ� ����
	 * @param: OrderDeliDTO(int orderDeliId, String orderStateId)
	 * @return: int(������ ������ ��)
	 * */
	void updateStateId(int orderDeliId, String orderStateId) throws SQLException;

	/**
	 * �ֹ� ���� �ڵ� ��������
	 * @return: List<OrderStateDTO>
	 * */
	List<OrderStateDTO> selectOrderState() throws SQLException;
}
