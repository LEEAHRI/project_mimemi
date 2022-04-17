package mimemi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import mimemi.mvc.dto.OrderDTO;

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
}
