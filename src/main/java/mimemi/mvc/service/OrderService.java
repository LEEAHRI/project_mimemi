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
	 * @return int(��ϵ� ������ ��)
	 */
	int insertOrder(OrderDTO order) throws SQLException;
	
	/**
	 * �ֹ� ���
	 * : �ֹ� ��ȣ�� �̿��� �ش� �ֹ� �ǿ� ������ ��� ��� �������� ��� ó����
	 * @param int orderId
	 * @return int(������ ���ڵ� ��)
	 */
	int deleteOrder(int orderId) throws SQLException;
	
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
}
