package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.MealDTO;
import mimemi.mvc.dto.OrderDTO;
import mimemi.mvc.dto.OrderDeliDTO;
import mimemi.mvc.dto.OrderLineDTO;
import mimemi.mvc.dto.MealDTO;

public interface OrderService {
	/**
	 * �ֹ� ���
	 * 
	 * 0. OrderDTO ���� OrderLineDTO�� ���� ��ǰ�� �� ���� �ݾ� ���ϱ�
	 * 1. �� �ּҷ� ������ ��� addr insert
	 * 2. �ֹ� ���̺� insert
	 * 3. �������� ����� ��� ȸ�� ���̺��� ������ ����(update)
	 * 4. ȸ�� ���̺� ������ 1% ����(update)
	 * 5. �ֹ� �� insert
	 * 6. ���� ����� ��� ���� ��� ���� ����(update)
	 * 
	 * ���� ��� �� 
	 * 
	 * @param OrderDTO(String userId, int addrId, String payMethod, int payPoint, String orderMemo,
	 * 			String takeMethod, String doorPwd, String usercouId)
	 */
	void insertOrder(OrderDTO order) throws SQLException;
	
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
	List<OrderDTO> selectAll(String field) throws SQLException;
	
	/**
	 * ���̵�� Ư�� �ֹ� ��ȸ
	 * @param int orderId(���� ����)
	 * @return OrderDTO
	 * */
	OrderDTO selectById(int orderId) throws SQLException;
	
	/**
	 * �ֹ� �� ����(���)
	 * @param int orderLineId(���� ���� ���̵� �������� ��� �������� ��� ��� ó����)
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
	 * */
	void insertDeli(OrderDeliDTO orderDeli) throws SQLException;
	
	/**
	 * ��� ���� ����
	 * @param: OrderDeliDTO(int orderDeliId, String orderDeliDate)
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
